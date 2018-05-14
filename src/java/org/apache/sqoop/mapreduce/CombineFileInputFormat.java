/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sqoop.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.net.NodeBase;
import org.apache.hadoop.net.NetworkTopology;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This file was ported from Hadoop 2.0.2-alpha
 */
// CHECKSTYLE:OFF

/**
 * An abstract {@link InputFormat} that returns {@link CombineFileSplit}'s in
 * {@link InputFormat#getSplits(JobContext)} method.
 *
 * Splits are constructed from the files under the input paths.
 * A split cannot have files from different pools.
 * Each split returned may contain blocks from different files.
 * If a maxSplitSize is specified, then blocks on the same node are
 * combined to form a single split. Blocks that are left over are
 * then combined with other blocks in the same rack.
 * If maxSplitSize is not specified, then blocks from the same rack
 * are combined in a single split; no attempt is made to create
 * node-local splits.
 * If the maxSplitSize is equal to the block size, then this class
 * is similar to the default splitting behavior in Hadoop: each
 * block is a locally processed split.
 * Subclasses implement
 * {@link InputFormat#createRecordReader(InputSplit, TaskAttemptContext)}
 * to construct <code>RecordReader</code>'s for
 * <code>CombineFileSplit</code>'s.
 *
 * @see CombineFileSplit
 */
public abstract class CombineFileInputFormat<K, V>
  extends FileInputFormat<K, V> {

  public static final Log LOG =
    LogFactory.getLog(CombineFileInputFormat.class.getName());


  public static final String SPLIT_MINSIZE_PERNODE =
    "mapreduce.input.fileinputformat.split.minsize.per.node";
  public static final String SPLIT_MINSIZE_PERRACK =
    "mapreduce.input.fileinputformat.split.minsize.per.rack";
  // ability to limit the size of a single split
  private long maxSplitSize = 0;
  private long minSplitSizeNode = 0;
  private long minSplitSizeRack = 0;

  // A pool of input paths filters. A split cannot have blocks from files
  // across multiple pools.
  private ArrayList<MultiPathFilter> pools = new  ArrayList<MultiPathFilter>();

  // mapping from a rack name to the set of Nodes in the rack
  private HashMap<String, Set<String>> rackToNodes =
                            new HashMap<String, Set<String>>();
  /**
   * Specify the maximum size (in bytes) of each split. Each split is
   * approximately equal to the specified size.
   */
  protected void setMaxSplitSize(long maxSplitSize) {
    this.maxSplitSize = maxSplitSize;
  }

  /**
   * Specify the minimum size (in bytes) of each split per node.
   * This applies to data that is left over after combining data on a single
   * node into splits that are of maximum size specified by maxSplitSize.
   * This leftover data will be combined into its own split if its size
   * exceeds minSplitSizeNode.
   */
  protected void setMinSplitSizeNode(long minSplitSizeNode) {
    this.minSplitSizeNode = minSplitSizeNode;
  }

  /**
   * Specify the minimum size (in bytes) of each split per rack.
   * This applies to data that is left over after combining data on a single
   * rack into splits that are of maximum size specified by maxSplitSize.
   * This leftover data will be combined into its own split if its size
   * exceeds minSplitSizeRack.
   */
  protected void setMinSplitSizeRack(long minSplitSizeRack) {
    this.minSplitSizeRack = minSplitSizeRack;
  }

  /**
   * Create a new pool and add the filters to it.
   * A split cannot have files from different pools.
   */
  protected void createPool(List<PathFilter> filters) {
    pools.add(new MultiPathFilter(filters));
  }

  /**
   * Create a new pool and add the filters to it.
   * A pathname can satisfy any one of the specified filters.
   * A split cannot have files from different pools.
   */
  protected void createPool(PathFilter... filters) {
    MultiPathFilter multi = new MultiPathFilter();
    for (PathFilter f: filters) {
      multi.add(f);
    }
    pools.add(multi);
  }

  @Override
  protected boolean isSplitable(JobContext context, Path file) {
    final CompressionCodec codec =
      new CompressionCodecFactory(context.getConfiguration()).getCodec(file);
    if (null == codec) {
      return true;
    }

    // Once we remove support for Hadoop < 2.0
    //return codec instanceof SplittableCompressionCodec;
    return false;
  }

  /**
   * default constructor
   */
  public CombineFileInputFormat() {
  }

  @Override
  public List<InputSplit> getSplits(JobContext job)
    throws IOException {

    long minSizeNode = 0;
    long minSizeRack = 0;
    long maxSize = 0;
    Configuration conf = job.getConfiguration();

    // the values specified by setxxxSplitSize() takes precedence over the
    // values that might have been specified in the config
    if (minSplitSizeNode != 0) {
      minSizeNode = minSplitSizeNode;
    } else {
      minSizeNode = conf.getLong(SPLIT_MINSIZE_PERNODE, 0);
    }
    if (minSplitSizeRack != 0) {
      minSizeRack = minSplitSizeRack;
    } else {
      minSizeRack = conf.getLong(SPLIT_MINSIZE_PERRACK, 0);
    }
    if (maxSplitSize != 0) {
      maxSize = maxSplitSize;
    } else {
      maxSize = conf.getLong("mapred.max.split.size", 0);
    }
    if (minSizeNode != 0 && maxSize != 0 && minSizeNode > maxSize) {
      throw new IOException("Minimum split size pernode " + minSizeNode +
                            " cannot be larger than maximum split size " +
                            maxSize);
    }
    if (minSizeRack != 0 && maxSize != 0 && minSizeRack > maxSize) {
      throw new IOException("Minimum split size per rack" + minSizeRack +
                            " cannot be larger than maximum split size " +
                            maxSize);
    }
    if (minSizeRack != 0 && minSizeNode > minSizeRack) {
      throw new IOException("Minimum split size per node" + minSizeNode +
                            " cannot be smaller than minimum split " +
                            "size per rack " + minSizeRack);
    }

    // all the files in input set
    Path[] paths = FileUtil.stat2Paths(
                     listStatus(job).toArray(new FileStatus[0]));
    List<InputSplit> splits = new ArrayList<InputSplit>();
    if (paths.length == 0) {
      return splits;
    }

    // Convert them to Paths first. This is a costly operation and
    // we should do it first, otherwise we will incur doing it multiple
    // times, one time each for each pool in the next loop.
    List<Path> newpaths = new LinkedList<Path>();
    for (int i = 0; i < paths.length; i++) {
      FileSystem fs = paths[i].getFileSystem(conf);

      //the scheme and authority will be kept if the path is
      //a valid path for a non-default file system
      Path p = fs.makeQualified(paths[i]);
      newpaths.add(p);
    }
    paths = null;

    // In one single iteration, process all the paths in a single pool.
    // Processing one pool at a time ensures that a split contains paths
    // from a single pool only.
    for (MultiPathFilter onepool : pools) {
      ArrayList<Path> myPaths = new ArrayList<Path>();

      // pick one input path. If it matches all the filters in a pool,
      // add it to the output set
      for (Iterator<Path> iter = newpaths.iterator(); iter.hasNext();) {
        Path p = iter.next();
        if (onepool.accept(p)) {
          myPaths.add(p); // add it to my output set
          iter.remove();
        }
      }
      // create splits for all files in this pool.
      getMoreSplits(job, myPaths.toArray(new Path[myPaths.size()]),
                    maxSize, minSizeNode, minSizeRack, splits);
    }

    // create splits for all files that are not in any pool.
    getMoreSplits(job, newpaths.toArray(new Path[newpaths.size()]),
                  maxSize, minSizeNode, minSizeRack, splits);

    // free up rackToNodes map
    rackToNodes.clear();
    return splits;
  }

  /**
   * Return all the splits in the specified set of paths
   */
  private void getMoreSplits(JobContext job, Path[] paths,
                             long maxSize, long minSizeNode, long minSizeRack,
                             List<InputSplit> splits)
    throws IOException {
    Configuration conf = job.getConfiguration();

    // all blocks for all the files in input set
    OneFileInfo[] files;

    // mapping from a rack name to the list of blocks it has
    HashMap<String, List<OneBlockInfo>> rackToBlocks =
                              new HashMap<String, List<OneBlockInfo>>();

    // mapping from a block to the nodes on which it has replicas
    HashMap<OneBlockInfo, String[]> blockToNodes =
                              new HashMap<OneBlockInfo, String[]>();

    // mapping from a node to the list of blocks that it contains
    HashMap<String, List<OneBlockInfo>> nodeToBlocks =
                              new HashMap<String, List<OneBlockInfo>>();

    files = new OneFileInfo[paths.length];
    if (paths.length == 0) {
      return;
    }

    // populate all the blocks for all files
    long totLength = 0;
    for (int i = 0; i < paths.length; i++) {
      files[i] = new OneFileInfo(paths[i], conf, isSplitable(job, paths[i]),
                                 rackToBlocks, blockToNodes, nodeToBlocks,
                                 rackToNodes, maxSize);
      totLength += files[i].getLength();
    }

    ArrayList<OneBlockInfo> validBlocks = new ArrayList<OneBlockInfo>();
    Set<String> nodes = new HashSet<String>();
    long curSplitSize = 0;

    // process all nodes and create splits that are local
    // to a node.
    for (Iterator<Map.Entry<String,
         List<OneBlockInfo>>> iter = nodeToBlocks.entrySet().iterator();
         iter.hasNext();) {

      Map.Entry<String, List<OneBlockInfo>> one = iter.next();
      nodes.add(one.getKey());
      List<OneBlockInfo> blocksInNode = one.getValue();

      // for each block, copy it into validBlocks. Delete it from
      // blockToNodes so that the same block does not appear in
      // two different splits.
      for (OneBlockInfo oneblock : blocksInNode) {
        if (blockToNodes.containsKey(oneblock)) {
          validBlocks.add(oneblock);
          blockToNodes.remove(oneblock);
          curSplitSize += oneblock.length;

          // if the accumulated split size exceeds the maximum, then
          // create this split.
          if (maxSize != 0 && curSplitSize >= maxSize) {
            // create an input split and add it to the splits array
            addCreatedSplit(splits, nodes, validBlocks);
            curSplitSize = 0;
            validBlocks.clear();
          }
        }
      }
      // if there were any blocks left over and their combined size is
      // larger than minSplitNode, then combine them into one split.
      // Otherwise add them back to the unprocessed pool. It is likely
      // that they will be combined with other blocks from the
      // same rack later on.
      if (minSizeNode != 0 && curSplitSize >= minSizeNode) {
        // create an input split and add it to the splits array
        addCreatedSplit(splits, nodes, validBlocks);
      } else {
        for (OneBlockInfo oneblock : validBlocks) {
          blockToNodes.put(oneblock, oneblock.hosts);
        }
      }
      validBlocks.clear();
      nodes.clear();
      curSplitSize = 0;
    }

    // if blocks in a rack are below the specified minimum size, then keep them
    // in 'overflow'. After the processing of all racks is complete, these
    // overflow blocks will be combined into splits.
    ArrayList<OneBlockInfo> overflowBlocks = new ArrayList<OneBlockInfo>();
    Set<String> racks = new HashSet<String>();

    // Process all racks over and over again until there is no more work to do.
    while (blockToNodes.size() > 0) {

      // Create one split for this rack before moving over to the next rack.
      // Come back to this rack after creating a single split for each of the
      // remaining racks.
      // Process one rack location at a time, Combine all possible blocks that
      // reside on this rack as one split. (constrained by minimum and maximum
      // split size).

      // iterate over all racks
      for (Iterator<Map.Entry<String, List<OneBlockInfo>>> iter =
           rackToBlocks.entrySet().iterator(); iter.hasNext();) {

        Map.Entry<String, List<OneBlockInfo>> one = iter.next();
        racks.add(one.getKey());
        List<OneBlockInfo> blocks = one.getValue();

        // for each block, copy it into validBlocks. Delete it from
        // blockToNodes so that the same block does not appear in
        // two different splits.
        boolean createdSplit = false;
        for (OneBlockInfo oneblock : blocks) {
          if (blockToNodes.containsKey(oneblock)) {
            validBlocks.add(oneblock);
            blockToNodes.remove(oneblock);
            curSplitSize += oneblock.length;

            // if the accumulated split size exceeds the maximum, then
            // create this split.
            if (maxSize != 0 && curSplitSize >= maxSize) {
              // create an input split and add it to the splits array
              addCreatedSplit(splits, getHosts(racks), validBlocks);
              createdSplit = true;
              break;
            }
          }
        }

        // if we created a split, then just go to the next rack
        if (createdSplit) {
          curSplitSize = 0;
          validBlocks.clear();
          racks.clear();
          continue;
        }

        if (!validBlocks.isEmpty()) {
          if (minSizeRack != 0 && curSplitSize >= minSizeRack) {
            // if there is a minimum size specified, then create a single split
            // otherwise, store these blocks into overflow data structure
            addCreatedSplit(splits, getHosts(racks), validBlocks);
          } else {
            // There were a few blocks in this rack that
        	// remained to be processed. Keep them in 'overflow' block list.
        	// These will be combined later.
            overflowBlocks.addAll(validBlocks);
          }
        }
        curSplitSize = 0;
        validBlocks.clear();
        racks.clear();
      }
    }

    assert blockToNodes.isEmpty();
    assert curSplitSize == 0;
    assert validBlocks.isEmpty();
    assert racks.isEmpty();

    // Process all overflow blocks
    for (OneBlockInfo oneblock : overflowBlocks) {
      validBlocks.add(oneblock);
      curSplitSize += oneblock.length;

      // This might cause an exiting rack location to be re-added,
      // but it should be ok.
      for (int i = 0; i < oneblock.racks.length; i++) {
        racks.add(oneblock.racks[i]);
      }

      // if the accumulated split size exceeds the maximum, then
      // create this split.
      if (maxSize != 0 && curSplitSize >= maxSize) {
        // create an input split and add it to the splits array
        addCreatedSplit(splits, getHosts(racks), validBlocks);
        curSplitSize = 0;
        validBlocks.clear();
        racks.clear();
      }
    }

    // Process any remaining blocks, if any.
    if (!validBlocks.isEmpty()) {
      addCreatedSplit(splits, getHosts(racks), validBlocks);
    }
  }

  /**
   * Create a single split from the list of blocks specified in validBlocks
   * Add this new split into splitList.
   */
  private void addCreatedSplit(List<InputSplit> splitList,
                               Collection<String> locations,
                               ArrayList<OneBlockInfo> validBlocks) {
    // create an input split
    Path[] fl = new Path[validBlocks.size()];
    long[] offset = new long[validBlocks.size()];
    long[] length = new long[validBlocks.size()];
    for (int i = 0; i < validBlocks.size(); i++) {
      fl[i] = validBlocks.get(i).onepath;
      offset[i] = validBlocks.get(i).offset;
      length[i] = validBlocks.get(i).length;
    }

     // add this split to the list that is returned
    CombineFileSplit thissplit = new CombineFileSplit(fl, offset,
                                   length, locations.toArray(new String[0]));
    splitList.add(thissplit);
  }

  /**
   * This is not implemented yet.
   */
  public abstract RecordReader<K, V> createRecordReader(InputSplit split,
      TaskAttemptContext context) throws IOException;

  /**
   * information about one file from the File System
   */
  private static class OneFileInfo {
    private long fileSize;               // size of the file
    private OneBlockInfo[] blocks;       // all blocks in this file

    OneFileInfo(Path path, Configuration conf,
                boolean isSplitable,
                HashMap<String, List<OneBlockInfo>> rackToBlocks,
                HashMap<OneBlockInfo, String[]> blockToNodes,
                HashMap<String, List<OneBlockInfo>> nodeToBlocks,
                HashMap<String, Set<String>> rackToNodes,
                long maxSize)
                throws IOException {
      this.fileSize = 0;

      // get block locations from file system
      FileSystem fs = path.getFileSystem(conf);
      FileStatus stat = fs.getFileStatus(path);
      BlockLocation[] locations = fs.getFileBlockLocations(stat, 0,
                                                           stat.getLen());
      // create a list of all block and their locations
      if (locations == null) {
        blocks = new OneBlockInfo[0];
      } else {

        if(locations.length == 0) {
          locations = new BlockLocation[] { new BlockLocation() };
        }

        if (!isSplitable) {
          // if the file is not splitable, just create the one block with
          // full file length
          blocks = new OneBlockInfo[1];
          fileSize = stat.getLen();
          blocks[0] = new OneBlockInfo(path, 0, fileSize, locations[0]
              .getHosts(), locations[0].getTopologyPaths());
        } else {
          ArrayList<OneBlockInfo> blocksList = new ArrayList<OneBlockInfo>(
              locations.length);
          for (int i = 0; i < locations.length; i++) {
            fileSize += locations[i].getLength();

            // each split can be a maximum of maxSize
            long left = locations[i].getLength();
            long myOffset = locations[i].getOffset();
            long myLength = 0;
            do {
              if (maxSize == 0) {
                myLength = left;
              } else {
                if (left > maxSize && left < 2 * maxSize) {
                  // if remainder is between max and 2*max - then
                  // instead of creating splits of size max, left-max we
                  // create splits of size left/2 and left/2. This is
                  // a heuristic to avoid creating really really small
                  // splits.
                  myLength = left / 2;
                } else {
                  myLength = Math.min(maxSize, left);
                }
              }
              OneBlockInfo oneblock = new OneBlockInfo(path, myOffset,
                  myLength, locations[i].getHosts(), locations[i]
                      .getTopologyPaths());
              left -= myLength;
              myOffset += myLength;

              blocksList.add(oneblock);
            } while (left > 0);
          }
          blocks = blocksList.toArray(new OneBlockInfo[blocksList.size()]);
        }

        for (OneBlockInfo oneblock : blocks) {
          // add this block to the block --> node locations map
          blockToNodes.put(oneblock, oneblock.hosts);

          // For blocks that do not have host/rack information,
          // assign to default  rack.
          String[] racks = null;
          if (oneblock.hosts.length == 0) {
            racks = new String[]{NetworkTopology.DEFAULT_RACK};
          } else {
            racks = oneblock.racks;
          }

          // add this block to the rack --> block map
          for (int j = 0; j < racks.length; j++) {
            String rack = racks[j];
            List<OneBlockInfo> blklist = rackToBlocks.get(rack);
            if (blklist == null) {
              blklist = new ArrayList<OneBlockInfo>();
              rackToBlocks.put(rack, blklist);
            }
            blklist.add(oneblock);
            if (!racks[j].equals(NetworkTopology.DEFAULT_RACK)) {
              // Add this host to rackToNodes map
              addHostToRack(rackToNodes, racks[j], oneblock.hosts[j]);
            }
          }

          // add this block to the node --> block map
          for (int j = 0; j < oneblock.hosts.length; j++) {
            String node = oneblock.hosts[j];
            List<OneBlockInfo> blklist = nodeToBlocks.get(node);
            if (blklist == null) {
              blklist = new ArrayList<OneBlockInfo>();
              nodeToBlocks.put(node, blklist);
            }
            blklist.add(oneblock);
          }
        }
      }
    }

    long getLength() {
      return fileSize;
    }

    OneBlockInfo[] getBlocks() {
      return blocks;
    }
  }

  /**
   * information about one block from the File System
   */
  private static class OneBlockInfo {
    Path onepath;                // name of this file
    long offset;                 // offset in file
    long length;                 // length of this block
    String[] hosts;              // nodes on which this block resides
    String[] racks;              // network topology of hosts

    OneBlockInfo(Path path, long offset, long len,
                 String[] hosts, String[] topologyPaths) {
      this.onepath = path;
      this.offset = offset;
      this.hosts = hosts;
      this.length = len;
      assert (hosts.length == topologyPaths.length ||
              topologyPaths.length == 0);

      // if the file system does not have any rack information, then
      // use dummy rack location.
      if (topologyPaths.length == 0) {
        topologyPaths = new String[hosts.length];
        for (int i = 0; i < topologyPaths.length; i++) {
          topologyPaths[i] = (new NodeBase(hosts[i],
                              NetworkTopology.DEFAULT_RACK)).toString();
        }
      }

      // The topology paths have the host name included as the last
      // component. Strip it.
      this.racks = new String[topologyPaths.length];
      for (int i = 0; i < topologyPaths.length; i++) {
        this.racks[i] = (new NodeBase(topologyPaths[i])).getNetworkLocation();
      }
    }
  }

  protected BlockLocation[] getFileBlockLocations(
    FileSystem fs, FileStatus stat) throws IOException {
    return fs.getFileBlockLocations(stat, 0, stat.getLen());
  }

  private static void addHostToRack(HashMap<String, Set<String>> rackToNodes,
                                    String rack, String host) {
    Set<String> hosts = rackToNodes.get(rack);
    if (hosts == null) {
      hosts = new HashSet<String>();
      rackToNodes.put(rack, hosts);
    }
    hosts.add(host);
  }

  private Set<String> getHosts(Set<String> racks) {
    Set<String> hosts = new HashSet<String>();
    for (String rack : racks) {
      if (rackToNodes.containsKey(rack)) {
        hosts.addAll(rackToNodes.get(rack));
      }
    }
    return hosts;
  }

  /**
   * Accept a path only if any one of filters given in the
   * constructor do.
   */
  private static class MultiPathFilter implements PathFilter {
    private List<PathFilter> filters;

    public MultiPathFilter() {
      this.filters = new ArrayList<PathFilter>();
    }

    public MultiPathFilter(List<PathFilter> filters) {
      this.filters = filters;
    }

    public void add(PathFilter one) {
      filters.add(one);
    }

    public boolean accept(Path path) {
      for (PathFilter filter : filters) {
        if (filter.accept(path)) {
          return true;
        }
      }
      return false;
    }

    public String toString() {
      StringBuffer buf = new StringBuffer();
      buf.append("[");
      for (PathFilter f: filters) {
        buf.append(f);
        buf.append(",");
      }
      buf.append("]");
      return buf.toString();
    }
  }
}

// CHECKSTYLE:ON
