// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface InListNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.InListNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   * @return Whether the expr field is set.
   */
  boolean hasExpr();
  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   * @return The expr.
   */
  org.blaze.protobuf.LogicalExprNode getExpr();
  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   */
  org.blaze.protobuf.LogicalExprNodeOrBuilder getExprOrBuilder();

  /**
   * <code>repeated .plan.protobuf.LogicalExprNode list = 2;</code>
   */
  java.util.List<org.blaze.protobuf.LogicalExprNode> 
      getListList();
  /**
   * <code>repeated .plan.protobuf.LogicalExprNode list = 2;</code>
   */
  org.blaze.protobuf.LogicalExprNode getList(int index);
  /**
   * <code>repeated .plan.protobuf.LogicalExprNode list = 2;</code>
   */
  int getListCount();
  /**
   * <code>repeated .plan.protobuf.LogicalExprNode list = 2;</code>
   */
  java.util.List<? extends org.blaze.protobuf.LogicalExprNodeOrBuilder> 
      getListOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.LogicalExprNode list = 2;</code>
   */
  org.blaze.protobuf.LogicalExprNodeOrBuilder getListOrBuilder(
      int index);

  /**
   * <code>bool negated = 3;</code>
   * @return The negated.
   */
  boolean getNegated();
}
