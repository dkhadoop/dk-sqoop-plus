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

import com.cloudera.sqoop.lib.SqoopRecord;
import com.cloudera.sqoop.mapreduce.AutoProgressMapper;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts an input record from a string representation to a parsed Sqoop
 * record and emits that DBWritable to the OutputFormat for writeback to the
 * database.
 */
public class ESExportMapper
    extends AutoProgressMapper<LongWritable, Text, NullWritable, Text> {
  private Gson gson;
  public static final Log LOG =
    LogFactory.getLog(ESExportMapper.class.getName());
  Configuration conf;
  private SqoopRecord recordImpl;
  String outputFieldDelim;
  public ESExportMapper() {
  }

  protected void setup(Context context)
      throws IOException, InterruptedException {
    super.setup(context);
    conf = context.getConfiguration();
    gson = new Gson();
    outputFieldDelim = conf.get("outputFieldDelim");
    if(outputFieldDelim.equals("|")){
      outputFieldDelim = "\\|";
    }
  }


  public void map(LongWritable key, Text val, Context context)
      throws IOException, InterruptedException {
    try {
      Map<String,String> beanMap = new HashMap<String,String>();

      String[] split = val.toString().split(outputFieldDelim);
      for(int i = 0; i < split.length; i++){
        beanMap.put("c" + (i+1),split[i]);
      }
      String toJson = gson.toJson(beanMap) + "\n";
      context.write(NullWritable.get(), new Text(toJson));

//      context.write(NullWritable.get(), new BytesWritable(val.toString().getBytes()));
    } catch (Exception e) {
      // Something bad has happened
      LOG.error("");
      LOG.error("Exception raised during data export");
      LOG.error("");

      LOG.error("Exception: ", e);
      LOG.error("On input: " + val);

      InputSplit is = context.getInputSplit();
      if (is instanceof FileSplit) {
        LOG.error("On input file: " + ((FileSplit)is).getPath());
      } else if (is instanceof CombineFileSplit) {
        LOG.error("On input file: "
          + context.getConfiguration().get("map.input.file"));
      }
      LOG.error("At position " + key);

      LOG.error("");
      LOG.error("Currently processing split:");
      LOG.error(is);

      LOG.error("");
      LOG.error("This issue might not necessarily be caused by current input");
      LOG.error("due to the batching nature of export.");
      LOG.error("");

      throw new IOException("Can't export data, please check failed map task logs", e);
    }
  }
}
