// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface PhysicalWhenThenOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.PhysicalWhenThen)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.PhysicalExprNode when_expr = 1;</code>
   * @return Whether the whenExpr field is set.
   */
  boolean hasWhenExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode when_expr = 1;</code>
   * @return The whenExpr.
   */
  org.ballistacompute.protobuf.PhysicalExprNode getWhenExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode when_expr = 1;</code>
   */
  org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getWhenExprOrBuilder();

  /**
   * <code>.ballista.protobuf.PhysicalExprNode then_expr = 2;</code>
   * @return Whether the thenExpr field is set.
   */
  boolean hasThenExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode then_expr = 2;</code>
   * @return The thenExpr.
   */
  org.ballistacompute.protobuf.PhysicalExprNode getThenExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode then_expr = 2;</code>
   */
  org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getThenExprOrBuilder();
}