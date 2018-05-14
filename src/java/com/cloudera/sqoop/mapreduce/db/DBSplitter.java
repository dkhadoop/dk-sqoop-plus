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
package com.cloudera.sqoop.mapreduce.db;


/**
 * DBSplitter will generate DBInputSplits to use with DataDrivenDBInputFormat.
 * DataDrivenDBInputFormat needs to interpolate between two values that
 * represent the lowest and highest valued records to import. Depending
 * on the data-type of the column, this requires different behavior.
 * DBSplitter implementations should perform this for a data type or family
 * of data types.
 *
 * @deprecated use org.apache.sqoop.mapreduce.db.DBSplitter instead.
 * @see org.apache.sqoop.mapreduce.db.DBSplitter
 */
public interface DBSplitter extends org.apache.sqoop.mapreduce.db.DBSplitter {

}
