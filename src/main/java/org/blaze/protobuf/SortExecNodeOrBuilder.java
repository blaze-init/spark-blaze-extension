// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface SortExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.SortExecNode)
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
   * <code>repeated .plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  java.util.List<org.blaze.protobuf.PhysicalExprNode> 
      getExprList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNode getExpr(int index);
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  int getExprCount();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  java.util.List<? extends org.blaze.protobuf.PhysicalExprNodeOrBuilder> 
      getExprOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder(
      int index);
}