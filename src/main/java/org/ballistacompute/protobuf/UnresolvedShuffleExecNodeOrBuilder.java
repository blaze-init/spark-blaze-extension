// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface UnresolvedShuffleExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.UnresolvedShuffleExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 stage_id = 1;</code>
   * @return The stageId.
   */
  int getStageId();

  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   * @return Whether the schema field is set.
   */
  boolean hasSchema();
  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   * @return The schema.
   */
  org.ballistacompute.protobuf.Schema getSchema();
  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   */
  org.ballistacompute.protobuf.SchemaOrBuilder getSchemaOrBuilder();

  /**
   * <code>uint32 input_partition_count = 3;</code>
   * @return The inputPartitionCount.
   */
  int getInputPartitionCount();

  /**
   * <code>uint32 output_partition_count = 4;</code>
   * @return The outputPartitionCount.
   */
  int getOutputPartitionCount();
}