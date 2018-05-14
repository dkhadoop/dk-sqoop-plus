package org.apache.sqoop.manager;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.mapreduce.ExportBatchOutputFormat;
import com.cloudera.sqoop.mapreduce.JdbcExportJob;
import com.cloudera.sqoop.util.ExportException;

import java.io.IOException;

/**
 * Created by root on 17/6/1.
 */
public class ESManager extends com.cloudera.sqoop.manager.GenericJdbcManager{

    public ESManager(String driverClass, SqoopOptions opts) {
        super(driverClass, opts);
    }
    @Override
    public void exportTable(com.cloudera.sqoop.manager.ExportJobContext context)
            throws IOException, ExportException {
        context.setConnManager(this);
        JdbcExportJob exportJob = new JdbcExportJob(context, null, null,
                ExportBatchOutputFormat.class);
        exportJob.runExport();
    }
}
