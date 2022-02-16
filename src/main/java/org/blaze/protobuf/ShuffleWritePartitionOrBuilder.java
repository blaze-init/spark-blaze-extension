// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface ShuffleWritePartitionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.ShuffleWritePartition)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 partition_id = 1;</code>
   * @return The partitionId.
   */
  long getPartitionId();

  /**
   * <code>string path = 2;</code>
   * @return The path.
   */
  java.lang.String getPath();
  /**
   * <code>string path = 2;</code>
   * @return The bytes for path.
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>uint64 num_batches = 3;</code>
   * @return The numBatches.
   */
  long getNumBatches();

  /**
   * <code>uint64 num_rows = 4;</code>
   * @return The numRows.
   */
  long getNumRows();

  /**
   * <code>uint64 num_bytes = 5;</code>
   * @return The numBytes.
   */
  long getNumBytes();
}