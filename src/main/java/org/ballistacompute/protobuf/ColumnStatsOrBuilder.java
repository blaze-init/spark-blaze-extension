// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface ColumnStatsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.ColumnStats)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.ScalarValue min_value = 1;</code>
   * @return Whether the minValue field is set.
   */
  boolean hasMinValue();
  /**
   * <code>.ballista.protobuf.ScalarValue min_value = 1;</code>
   * @return The minValue.
   */
  org.ballistacompute.protobuf.ScalarValue getMinValue();
  /**
   * <code>.ballista.protobuf.ScalarValue min_value = 1;</code>
   */
  org.ballistacompute.protobuf.ScalarValueOrBuilder getMinValueOrBuilder();

  /**
   * <code>.ballista.protobuf.ScalarValue max_value = 2;</code>
   * @return Whether the maxValue field is set.
   */
  boolean hasMaxValue();
  /**
   * <code>.ballista.protobuf.ScalarValue max_value = 2;</code>
   * @return The maxValue.
   */
  org.ballistacompute.protobuf.ScalarValue getMaxValue();
  /**
   * <code>.ballista.protobuf.ScalarValue max_value = 2;</code>
   */
  org.ballistacompute.protobuf.ScalarValueOrBuilder getMaxValueOrBuilder();

  /**
   * <code>uint32 null_count = 3;</code>
   * @return The nullCount.
   */
  int getNullCount();

  /**
   * <code>uint32 distinct_count = 4;</code>
   * @return The distinctCount.
   */
  int getDistinctCount();
}