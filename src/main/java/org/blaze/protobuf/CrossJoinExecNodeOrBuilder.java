// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface CrossJoinExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.CrossJoinExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.PhysicalPlanNode left = 1;</code>
   * @return Whether the left field is set.
   */
  boolean hasLeft();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode left = 1;</code>
   * @return The left.
   */
  org.blaze.protobuf.PhysicalPlanNode getLeft();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode left = 1;</code>
   */
  org.blaze.protobuf.PhysicalPlanNodeOrBuilder getLeftOrBuilder();

  /**
   * <code>.plan.protobuf.PhysicalPlanNode right = 2;</code>
   * @return Whether the right field is set.
   */
  boolean hasRight();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode right = 2;</code>
   * @return The right.
   */
  org.blaze.protobuf.PhysicalPlanNode getRight();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode right = 2;</code>
   */
  org.blaze.protobuf.PhysicalPlanNodeOrBuilder getRightOrBuilder();
}
