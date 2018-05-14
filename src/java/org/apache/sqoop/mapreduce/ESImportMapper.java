package org.apache.sqoop.mapreduce;

import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import com.cloudera.sqoop.mapreduce.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by root on 17/5/10.
 */
public class ESImportMapper
        extends com.cloudera.sqoop.mapreduce.AutoProgressMapper<LongWritable, SqoopRecord, NullWritable, Text> {
    private LargeObjectLoader lobLoader;
    private Gson gson;
    @Override
    protected void setup(Context context)
            throws IOException, InterruptedException {
//        gson = new Gson();
        gson = new GsonBuilder().serializeNulls().create();
//        Path workOutputPath = FileOutputFormat.getWorkOutputPath(context);
        this.lobLoader = new LargeObjectLoader(context.getConfiguration(),
                new Path("/tmp/sqoop-es-" + context.getTaskAttemptID()));
    }

    @Override
    public void map(LongWritable key, SqoopRecord val, Context context)
            throws IOException, InterruptedException {

        try {
            // Loading of LOBs was delayed until we have a Context.
            val.loadLargeObjects(lobLoader);
        } catch (SQLException sqlE) {
            throw new IOException(sqlE);
        }
        Map<String, Object> fields = val.getFieldMap();
        String s = val.getFieldMap().toString();
        String toJson = gson.toJson(fields) + "\n";
 //       String valStr = val.toString();
//        outkey.set(toJson);

        context.write(NullWritable.get(),new Text(toJson));
//        context.write(NullWritable.get(),new BytesWritable(s.getBytes()));
    }

    @Override
    protected void cleanup(Context context) throws IOException {
        if (null != lobLoader) {
            lobLoader.close();
        }
    }
}
