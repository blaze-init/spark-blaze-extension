// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface CastNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.CastNode)
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
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   * @return Whether the arrowType field is set.
   */
  boolean hasArrowType();
  /**
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   * @return The arrowType.
   */
  org.blaze.protobuf.ArrowType getArrowType();
  /**
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   */
  org.blaze.protobuf.ArrowTypeOrBuilder getArrowTypeOrBuilder();
}
