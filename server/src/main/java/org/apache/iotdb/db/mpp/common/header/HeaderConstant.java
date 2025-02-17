/*
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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.db.mpp.common.header;

import org.apache.iotdb.tsfile.file.metadata.enums.TSDataType;

import java.util.Arrays;
import java.util.Collections;

public class HeaderConstant {

  // column names for query statement
  public static final String COLUMN_TIME = "Time";
  public static final String COLUMN_VALUE = "value";
  public static final String COLUMN_DEVICE = "Device";

  // column names for schema statement
  public static final String COLUMN_STORAGE_GROUP = "storage group";
  public static final String COLUMN_TIMESERIES = "timeseries";
  public static final String COLUMN_TIMESERIES_ALIAS = "alias";
  public static final String COLUMN_TIMESERIES_DATATYPE = "dataType";
  public static final String COLUMN_TIMESERIES_ENCODING = "encoding";
  public static final String COLUMN_TIMESERIES_COMPRESSION = "compression";
  public static final String COLUMN_DEVICES = "devices";
  public static final String COLUMN_TAGS = "tags";
  public static final String COLUMN_ATTRIBUTES = "attributes";
  public static final String COLUMN_IS_ALIGNED = "isAligned";
  public static final String COLUMN_COUNT = "count";
  public static final String COLUMN_TTL = "ttl";
  public static final String COLUMN_SCHEMA_REPLICATION_FACTOR = "schema_replication_factor";
  public static final String COLUMN_DATA_REPLICATION_FACTOR = "data_replication_factor";
  public static final String COLUMN_TIME_PARTITION_INTERVAL = "time_partition_interval";
  public static final String COLUMN_CHILDPATHS = "child paths";
  public static final String COLUMN_NODETYPES = "node types";
  public static final String COLUMN_CHILDNODES = "child nodes";
  public static final String COLUMN_VERSION = "version";
  public static final String COLUMN_PATHS = "paths";

  // column names for count statement
  public static final String COLUMN_COLUMN = "column";
  public static final String COLUMN_COUNT_DEVICES = "count(devices)";
  public static final String COLUMN_COUNT_NODES = "count(nodes)";
  public static final String COLUMN_COUNT_TIMESERIES = "count(timeseries)";
  public static final String COLUMN_COUNT_STORAGE_GROUP = "count(storage group)";

  // column names for show cluster statement
  public static final String COLUMN_NODE_ID = "NodeID";
  public static final String COLUMN_NODE_TYPE = "NodeType";
  public static final String COLUMN_STATUS = "Status";
  public static final String COLUMN_HOST = "Host";
  public static final String COLUMN_PORT = "Port";

  // column names for show functions statement
  public static final String COLUMN_FUNCTION_NAME = "function name";
  public static final String COLUMN_FUNCTION_TYPE = "function type";
  public static final String COLUMN_FUNCTION_CLASS = "class name (UDF)";

  // column names for show region statement
  public static final String COLUMN_REGION_ID = "RegionId";
  public static final String COLUMN_TYPE = "Type";
  public static final String COLUMN_DATANODE_ID = "DataNodeId";
  public static final String COLUMN_SERIES_SLOTS = "Series Slots";
  public static final String COLUMN_TIME_SLOTS = "Time Slots";
  public static final String COLUMN_ROLE = "Role";

  // column names for show datanodes
  public static final String COLUMN_DATA_REGION_NUM = "DataRegionNum";
  public static final String COLUMN_SCHEMA_REGION_NUM = "SchemaRegionNum";

  // column names for show schema template statement
  public static final String COLUMN_TEMPLATE_NAME = "template name";

  // dataset header for schema statement
  public static final DatasetHeader showTimeSeriesHeader;
  public static final DatasetHeader showDevicesHeader;
  public static final DatasetHeader showDevicesWithSgHeader;
  public static final DatasetHeader showStorageGroupHeader;
  public static final DatasetHeader showTTLHeader;
  public static final DatasetHeader showChildPathsHeader;
  public static final DatasetHeader showChildNodesHeader;
  public static final DatasetHeader showVersionHeader;

  // dataset header for count statement
  public static final DatasetHeader countStorageGroupHeader;
  public static final DatasetHeader countNodesHeader;
  public static final DatasetHeader countDevicesHeader;
  public static final DatasetHeader countTimeSeriesHeader;
  public static final DatasetHeader countLevelTimeSeriesHeader;

  // dataset header for show cluster statement
  public static final DatasetHeader showClusterHeader;

  // dataset header for last query
  public static final DatasetHeader LAST_QUERY_HEADER;

  // dataset header for show functions
  public static final DatasetHeader SHOW_FUNCTIONS_HEADER;

  // dataset header for show region
  public static final DatasetHeader showRegionHeader;

  // dataset header for show datanodes
  public static final DatasetHeader showDataNodesHeader;

  // dataset header for show nodes in schema template
  public static final DatasetHeader showNodesInSchemaTemplate;

  // dataset header for show schma template
  public static final DatasetHeader showSchemaTemplate;

  // dataset header for show path set template
  public static final DatasetHeader showPathSetTemplate;

  // dataset header for show paths using template
  public static final DatasetHeader showPathsUsingTemplate;

  // dataset header for show confignodes
  public static final DatasetHeader showConfigNodesHeader;

  static {
    countStorageGroupHeader =
        new DatasetHeader(
            Collections.singletonList(
                new ColumnHeader(COLUMN_COUNT_STORAGE_GROUP, TSDataType.INT32)),
            true);
    countNodesHeader =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_COUNT_NODES, TSDataType.INT32)),
            true);
    countDevicesHeader =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_COUNT_DEVICES, TSDataType.INT32)),
            true);
    countTimeSeriesHeader =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_COUNT_TIMESERIES, TSDataType.INT32)),
            true);
    countLevelTimeSeriesHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_COLUMN, TSDataType.TEXT),
                new ColumnHeader(COLUMN_COUNT_TIMESERIES, TSDataType.INT32)),
            true);
  }

  static {
    showTimeSeriesHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_TIMESERIES, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_ALIAS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_STORAGE_GROUP, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_DATATYPE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_ENCODING, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_COMPRESSION, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TAGS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_ATTRIBUTES, TSDataType.TEXT)),
            true);
    showDevicesHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_DEVICES, TSDataType.TEXT),
                new ColumnHeader(COLUMN_IS_ALIGNED, TSDataType.TEXT)),
            true);
    showDevicesWithSgHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_DEVICES, TSDataType.TEXT),
                new ColumnHeader(COLUMN_STORAGE_GROUP, TSDataType.TEXT),
                new ColumnHeader(COLUMN_IS_ALIGNED, TSDataType.TEXT)),
            true);
    showStorageGroupHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_STORAGE_GROUP, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TTL, TSDataType.INT64),
                new ColumnHeader(COLUMN_SCHEMA_REPLICATION_FACTOR, TSDataType.INT32),
                new ColumnHeader(COLUMN_DATA_REPLICATION_FACTOR, TSDataType.INT32),
                new ColumnHeader(COLUMN_TIME_PARTITION_INTERVAL, TSDataType.INT64)),
            true);
    showTTLHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_STORAGE_GROUP, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TTL, TSDataType.INT64)),
            true);
    showChildPathsHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_CHILDPATHS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_NODETYPES, TSDataType.TEXT)),
            true);
    showChildNodesHeader =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_CHILDNODES, TSDataType.TEXT)), true);
    showVersionHeader =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_VERSION, TSDataType.TEXT)), true);
  }

  static {
    LAST_QUERY_HEADER =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_TIMESERIES, TSDataType.TEXT),
                new ColumnHeader(COLUMN_VALUE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_DATATYPE, TSDataType.TEXT)),
            false);
  }

  static {
    showClusterHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_NODE_ID, TSDataType.INT32),
                new ColumnHeader(COLUMN_NODE_TYPE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_STATUS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_HOST, TSDataType.TEXT),
                new ColumnHeader(COLUMN_PORT, TSDataType.INT32)),
            true);
  }

  static {
    SHOW_FUNCTIONS_HEADER =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_FUNCTION_NAME, TSDataType.TEXT),
                new ColumnHeader(COLUMN_FUNCTION_TYPE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_FUNCTION_CLASS, TSDataType.TEXT)),
            true);
  }

  static {
    showRegionHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_REGION_ID, TSDataType.INT32),
                new ColumnHeader(COLUMN_TYPE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_STATUS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_STORAGE_GROUP, TSDataType.TEXT),
                new ColumnHeader(COLUMN_SERIES_SLOTS, TSDataType.INT64),
                new ColumnHeader(COLUMN_TIME_SLOTS, TSDataType.INT64),
                new ColumnHeader(COLUMN_DATANODE_ID, TSDataType.INT32),
                new ColumnHeader(COLUMN_HOST, TSDataType.TEXT),
                new ColumnHeader(COLUMN_PORT, TSDataType.INT32),
                new ColumnHeader(COLUMN_ROLE, TSDataType.TEXT)),
            true);
  }

  static {
    showDataNodesHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_NODE_ID, TSDataType.INT32),
                new ColumnHeader(COLUMN_STATUS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_HOST, TSDataType.TEXT),
                new ColumnHeader(COLUMN_PORT, TSDataType.INT32),
                new ColumnHeader(COLUMN_DATA_REGION_NUM, TSDataType.INT32),
                new ColumnHeader(COLUMN_SCHEMA_REGION_NUM, TSDataType.INT32)),
            true);
  }

  static {
    showConfigNodesHeader =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_NODE_ID, TSDataType.INT32),
                new ColumnHeader(COLUMN_STATUS, TSDataType.TEXT),
                new ColumnHeader(COLUMN_HOST, TSDataType.TEXT),
                new ColumnHeader(COLUMN_PORT, TSDataType.INT32)),
            true);
  }

  static {
    showSchemaTemplate =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_TEMPLATE_NAME, TSDataType.TEXT)),
            true);
    showNodesInSchemaTemplate =
        new DatasetHeader(
            Arrays.asList(
                new ColumnHeader(COLUMN_CHILDNODES, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_DATATYPE, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_ENCODING, TSDataType.TEXT),
                new ColumnHeader(COLUMN_TIMESERIES_COMPRESSION, TSDataType.TEXT)),
            true);
    showPathSetTemplate =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_PATHS, TSDataType.TEXT)), true);
    showPathsUsingTemplate =
        new DatasetHeader(
            Collections.singletonList(new ColumnHeader(COLUMN_PATHS, TSDataType.TEXT)), true);
  }
}
