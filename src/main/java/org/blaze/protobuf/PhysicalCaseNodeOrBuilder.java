// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface PhysicalCaseNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.PhysicalCaseNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 1;</code>
   * @return Whether the expr field is set.
   */
  boolean hasExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 1;</code>
   * @return The expr.
   */
  org.blaze.protobuf.PhysicalExprNode getExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode expr = 1;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder();

  /**
   * <code>repeated .plan.protobuf.PhysicalWhenThen when_then_expr = 2;</code>
   */
  java.util.List<org.blaze.protobuf.PhysicalWhenThen> 
      getWhenThenExprList();
  /**
   * <code>repeated .plan.protobuf.PhysicalWhenThen when_then_expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalWhenThen getWhenThenExpr(int index);
  /**
   * <code>repeated .plan.protobuf.PhysicalWhenThen when_then_expr = 2;</code>
   */
  int getWhenThenExprCount();
  /**
   * <code>repeated .plan.protobuf.PhysicalWhenThen when_then_expr = 2;</code>
   */
  java.util.List<? extends org.blaze.protobuf.PhysicalWhenThenOrBuilder> 
      getWhenThenExprOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.PhysicalWhenThen when_then_expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalWhenThenOrBuilder getWhenThenExprOrBuilder(
      int index);

  /**
   * <code>.plan.protobuf.PhysicalExprNode else_expr = 3;</code>
   * @return Whether the elseExpr field is set.
   */
  boolean hasElseExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode else_expr = 3;</code>
   * @return The elseExpr.
   */
  org.blaze.protobuf.PhysicalExprNode getElseExpr();
  /**
   * <code>.plan.protobuf.PhysicalExprNode else_expr = 3;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getElseExprOrBuilder();
}
