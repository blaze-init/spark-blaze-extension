// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface CrossJoinExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.CrossJoinExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   * @return Whether the left field is set.
   */
  boolean hasLeft();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   * @return The left.
   */
  org.ballistacompute.protobuf.PhysicalPlanNode getLeft();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   */
  org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getLeftOrBuilder();

  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   * @return Whether the right field is set.
   */
  boolean hasRight();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   * @return The right.
   */
  org.ballistacompute.protobuf.PhysicalPlanNode getRight();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   */
  org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getRightOrBuilder();
}