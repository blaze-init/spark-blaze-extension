// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface ProjectionExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.ProjectionExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 1;</code>
   * @return Whether the input field is set.
   */
  boolean hasInput();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 1;</code>
   * @return The input.
   */
  org.ballistacompute.protobuf.PhysicalPlanNode getInput();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 1;</code>
   */
  org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder();

  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode expr = 2;</code>
   */
  java.util.List<org.ballistacompute.protobuf.PhysicalExprNode> 
      getExprList();
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode expr = 2;</code>
   */
  org.ballistacompute.protobuf.PhysicalExprNode getExpr(int index);
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode expr = 2;</code>
   */
  int getExprCount();
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode expr = 2;</code>
   */
  java.util.List<? extends org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
      getExprOrBuilderList();
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode expr = 2;</code>
   */
  org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder(
      int index);

  /**
   * <code>repeated string expr_name = 3;</code>
   * @return A list containing the exprName.
   */
  java.util.List<java.lang.String>
      getExprNameList();
  /**
   * <code>repeated string expr_name = 3;</code>
   * @return The count of exprName.
   */
  int getExprNameCount();
  /**
   * <code>repeated string expr_name = 3;</code>
   * @param index The index of the element to return.
   * @return The exprName at the given index.
   */
  java.lang.String getExprName(int index);
  /**
   * <code>repeated string expr_name = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the exprName at the given index.
   */
  com.google.protobuf.ByteString
      getExprNameBytes(int index);
}
