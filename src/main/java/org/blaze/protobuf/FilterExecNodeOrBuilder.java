// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface FilterExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.FilterExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   * @return Whether the input field is set.
   */
  boolean hasInput();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   * @return The input.
   */
  org.blaze.protobuf.PhysicalPlanNode getInput();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   */
  org.blaze.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder();

  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 2;</code>
   * @return Whether the expr field is set.
   */
  boolean hasExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 2;</code>
   * @return The expr.
   */
  org.blaze.protobuf.PhysicalExprNode getExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder();
}
