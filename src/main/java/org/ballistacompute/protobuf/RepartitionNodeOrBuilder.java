// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface RepartitionNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.RepartitionNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.LogicalPlanNode input = 1;</code>
   * @return Whether the input field is set.
   */
  boolean hasInput();
  /**
   * <code>.ballista.protobuf.LogicalPlanNode input = 1;</code>
   * @return The input.
   */
  org.ballistacompute.protobuf.LogicalPlanNode getInput();
  /**
   * <code>.ballista.protobuf.LogicalPlanNode input = 1;</code>
   */
  org.ballistacompute.protobuf.LogicalPlanNodeOrBuilder getInputOrBuilder();

  /**
   * <code>uint64 round_robin = 2;</code>
   * @return Whether the roundRobin field is set.
   */
  boolean hasRoundRobin();
  /**
   * <code>uint64 round_robin = 2;</code>
   * @return The roundRobin.
   */
  long getRoundRobin();

  /**
   * <code>.ballista.protobuf.HashRepartition hash = 3;</code>
   * @return Whether the hash field is set.
   */
  boolean hasHash();
  /**
   * <code>.ballista.protobuf.HashRepartition hash = 3;</code>
   * @return The hash.
   */
  org.ballistacompute.protobuf.HashRepartition getHash();
  /**
   * <code>.ballista.protobuf.HashRepartition hash = 3;</code>
   */
  org.ballistacompute.protobuf.HashRepartitionOrBuilder getHashOrBuilder();

  public org.ballistacompute.protobuf.RepartitionNode.PartitionMethodCase getPartitionMethodCase();
}