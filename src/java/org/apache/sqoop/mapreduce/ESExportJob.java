package org.apache.sqoop.mapreduce;

import com.cloudera.sqoop.manager.ExportJobContext;
import com.cloudera.sqoop.mapreduce.*;

/**
 * Created by root on 17/6/1.
 */
public class ESExportJob  extends com.cloudera.sqoop.mapreduce.ExportJobBase{
    public ESExportJob(ExportJobContext ctxt) {
        super(ctxt);
    }
}
