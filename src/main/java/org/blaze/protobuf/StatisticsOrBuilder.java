// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface StatisticsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.Statistics)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 num_rows = 1;</code>
   * @return The numRows.
   */
  long getNumRows();

  /**
   * <code>int64 total_byte_size = 2;</code>
   * @return The totalByteSize.
   */
  long getTotalByteSize();

  /**
   * <code>repeated .plan.protobuf.ColumnStats column_stats = 3;</code>
   */
  java.util.List<org.blaze.protobuf.ColumnStats> 
      getColumnStatsList();
  /**
   * <code>repeated .plan.protobuf.ColumnStats column_stats = 3;</code>
   */
  org.blaze.protobuf.ColumnStats getColumnStats(int index);
  /**
   * <code>repeated .plan.protobuf.ColumnStats column_stats = 3;</code>
   */
  int getColumnStatsCount();
  /**
   * <code>repeated .plan.protobuf.ColumnStats column_stats = 3;</code>
   */
  java.util.List<? extends org.blaze.protobuf.ColumnStatsOrBuilder> 
      getColumnStatsOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.ColumnStats column_stats = 3;</code>
   */
  org.blaze.protobuf.ColumnStatsOrBuilder getColumnStatsOrBuilder(
      int index);

  /**
   * <code>bool is_exact = 4;</code>
   * @return The isExact.
   */
  boolean getIsExact();
}
