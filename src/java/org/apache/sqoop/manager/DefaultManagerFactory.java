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

package org.apache.sqoop.manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.metastore.JobData;
import com.cloudera.sqoop.manager.ConnManager;

/**
 * Contains instantiation code for all ConnManager implementations
 * shipped and enabled by default in Sqoop.
 */
public class DefaultManagerFactory
    extends com.cloudera.sqoop.manager.ManagerFactory {

  public static final Log LOG = LogFactory.getLog(
      DefaultManagerFactory.class.getName());

  public ConnManager accept(JobData data) {
    SqoopOptions options = data.getSqoopOptions();

    String scheme = extractScheme(options);
    if (null == scheme) {
      // We don't know if this is a mysql://, hsql://, etc.
      // Can't do anything with this.
      LOG.warn("Null scheme associated with connect string.");
      return null;
    }

    LOG.debug("Trying with scheme: " + scheme);

    if (scheme.contains("es@")) {
      return new ESManager("ES",options);
    }else if (scheme.equals("jdbc:mysql:")) {
      if (options.isDirect()) {
        return new DirectMySQLManager(options);
      } else {
        return new MySQLManager(options);
      }
    } else if (scheme.equals("jdbc:postgresql:")) {
      if (options.isDirect()) {
        return new DirectPostgresqlManager(options);
      } else {
        return new PostgresqlManager(options);
      }
    } else if (scheme.startsWith("jdbc:hsqldb:")) {
      return new HsqldbManager(options);
    } else if (scheme.startsWith("jdbc:oracle:")) {
      return new OracleManager(options);
    } else if (scheme.startsWith("jdbc:sqlserver:")) {
      return new SQLServerManager(options);
    } else if (scheme.startsWith("jdbc:jtds:sqlserver:")) {
      return new SQLServerManager(
        "net.sourceforge.jtds.jdbc.Driver",
        options);
    } else if (scheme.startsWith("jdbc:db2:")) {
      return new Db2Manager(options);
    } else if (scheme.startsWith("jdbc:netezza:")) {
      if (options.isDirect()) {
        return new DirectNetezzaManager(options);
      } else {
        return new NetezzaManager(options);
      }
    } else if (scheme.startsWith("jdbc:cubrid:")) {
      return new CubridManager(options);
    } else {
      return null;
    }
  }

  protected String extractScheme(SqoopOptions options) {
    String connectStr = options.getConnectString();

    // java.net.URL follows RFC-2396 literally, which does not allow a ':'
    // character in the scheme component (section 3.1). JDBC connect strings,
    // however, commonly have a multi-scheme addressing system. e.g.,
    // jdbc:mysql://...; so we cannot parse the scheme component via URL
    // objects. Instead, attempt to pull out the scheme as best as we can.

    // First, see if this is of the form [scheme://hostname-and-etc..]
    int schemeStopIdx = connectStr.indexOf("//");
    if (-1 == schemeStopIdx) {
      // If no hostname start marker ("//"), then look for the right-most ':'
      // character.
      schemeStopIdx = connectStr.lastIndexOf(':');
      if (-1 == schemeStopIdx) {
        // Warn that this is nonstandard. But we should be as permissive
        // as possible here and let the ConnectionManagers themselves throw
        // out the connect string if it doesn't make sense to them.
        LOG.warn("Could not determine scheme component of connect string");

        // Use the whole string.
        schemeStopIdx = connectStr.length();
      }
    }

    return connectStr.substring(0, schemeStopIdx);
  }
}

