// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface WindowNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.WindowNode)
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
   * <code>repeated .ballista.protobuf.LogicalExprNode window_expr = 2;</code>
   */
  java.util.List<org.ballistacompute.protobuf.LogicalExprNode> 
      getWindowExprList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode window_expr = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNode getWindowExpr(int index);
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode window_expr = 2;</code>
   */
  int getWindowExprCount();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode window_expr = 2;</code>
   */
  java.util.List<? extends org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
      getWindowExprOrBuilderList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode window_expr = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getWindowExprOrBuilder(
      int index);
}