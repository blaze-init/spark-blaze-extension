// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface CompletedJobOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.CompletedJob)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ballista.protobuf.PartitionLocation partition_location = 1;</code>
   */
  java.util.List<org.ballistacompute.protobuf.PartitionLocation> 
      getPartitionLocationList();
  /**
   * <code>repeated .ballista.protobuf.PartitionLocation partition_location = 1;</code>
   */
  org.ballistacompute.protobuf.PartitionLocation getPartitionLocation(int index);
  /**
   * <code>repeated .ballista.protobuf.PartitionLocation partition_location = 1;</code>
   */
  int getPartitionLocationCount();
  /**
   * <code>repeated .ballista.protobuf.PartitionLocation partition_location = 1;</code>
   */
  java.util.List<? extends org.ballistacompute.protobuf.PartitionLocationOrBuilder> 
      getPartitionLocationOrBuilderList();
  /**
   * <code>repeated .ballista.protobuf.PartitionLocation partition_location = 1;</code>
   */
  org.ballistacompute.protobuf.PartitionLocationOrBuilder getPartitionLocationOrBuilder(
      int index);
}