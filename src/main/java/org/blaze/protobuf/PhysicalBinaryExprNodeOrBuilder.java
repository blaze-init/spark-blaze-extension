// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface PhysicalBinaryExprNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.PhysicalBinaryExprNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.PhysicalExprNode l = 1;</code>
   * @return Whether the l field is set.
   */
  boolean hasL();
  /**
   * <code>.plan.protobuf.PhysicalExprNode l = 1;</code>
   * @return The l.
   */
  org.blaze.protobuf.PhysicalExprNode getL();
  /**
   * <code>.plan.protobuf.PhysicalExprNode l = 1;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getLOrBuilder();

  /**
   * <code>.plan.protobuf.PhysicalExprNode r = 2;</code>
   * @return Whether the r field is set.
   */
  boolean hasR();
  /**
   * <code>.plan.protobuf.PhysicalExprNode r = 2;</code>
   * @return The r.
   */
  org.blaze.protobuf.PhysicalExprNode getR();
  /**
   * <code>.plan.protobuf.PhysicalExprNode r = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getROrBuilder();

  /**
   * <code>string op = 3;</code>
   * @return The op.
   */
  java.lang.String getOp();
  /**
   * <code>string op = 3;</code>
   * @return The bytes for op.
   */
  com.google.protobuf.ByteString
      getOpBytes();
}
