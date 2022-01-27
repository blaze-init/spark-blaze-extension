// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface HashAggregateExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.HashAggregateExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode group_expr = 1;</code>
   */
  java.util.List<org.blaze.protobuf.PhysicalExprNode> 
      getGroupExprList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode group_expr = 1;</code>
   */
  org.blaze.protobuf.PhysicalExprNode getGroupExpr(int index);
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode group_expr = 1;</code>
   */
  int getGroupExprCount();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode group_expr = 1;</code>
   */
  java.util.List<? extends org.blaze.protobuf.PhysicalExprNodeOrBuilder> 
      getGroupExprOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode group_expr = 1;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getGroupExprOrBuilder(
      int index);

  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode aggr_expr = 2;</code>
   */
  java.util.List<org.blaze.protobuf.PhysicalExprNode> 
      getAggrExprList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode aggr_expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNode getAggrExpr(int index);
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode aggr_expr = 2;</code>
   */
  int getAggrExprCount();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode aggr_expr = 2;</code>
   */
  java.util.List<? extends org.blaze.protobuf.PhysicalExprNodeOrBuilder> 
      getAggrExprOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.PhysicalExprNode aggr_expr = 2;</code>
   */
  org.blaze.protobuf.PhysicalExprNodeOrBuilder getAggrExprOrBuilder(
      int index);

  /**
   * <code>.plan.protobuf.AggregateMode mode = 3;</code>
   * @return The enum numeric value on the wire for mode.
   */
  int getModeValue();
  /**
   * <code>.plan.protobuf.AggregateMode mode = 3;</code>
   * @return The mode.
   */
  org.blaze.protobuf.AggregateMode getMode();

  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 4;</code>
   * @return Whether the input field is set.
   */
  boolean hasInput();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 4;</code>
   * @return The input.
   */
  org.blaze.protobuf.PhysicalPlanNode getInput();
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 4;</code>
   */
  org.blaze.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder();

  /**
   * <code>repeated string group_expr_name = 5;</code>
   * @return A list containing the groupExprName.
   */
  java.util.List<java.lang.String>
      getGroupExprNameList();
  /**
   * <code>repeated string group_expr_name = 5;</code>
   * @return The count of groupExprName.
   */
  int getGroupExprNameCount();
  /**
   * <code>repeated string group_expr_name = 5;</code>
   * @param index The index of the element to return.
   * @return The groupExprName at the given index.
   */
  java.lang.String getGroupExprName(int index);
  /**
   * <code>repeated string group_expr_name = 5;</code>
   * @param index The index of the value to return.
   * @return The bytes of the groupExprName at the given index.
   */
  com.google.protobuf.ByteString
      getGroupExprNameBytes(int index);

  /**
   * <code>repeated string aggr_expr_name = 6;</code>
   * @return A list containing the aggrExprName.
   */
  java.util.List<java.lang.String>
      getAggrExprNameList();
  /**
   * <code>repeated string aggr_expr_name = 6;</code>
   * @return The count of aggrExprName.
   */
  int getAggrExprNameCount();
  /**
   * <code>repeated string aggr_expr_name = 6;</code>
   * @param index The index of the element to return.
   * @return The aggrExprName at the given index.
   */
  java.lang.String getAggrExprName(int index);
  /**
   * <code>repeated string aggr_expr_name = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the aggrExprName at the given index.
   */
  com.google.protobuf.ByteString
      getAggrExprNameBytes(int index);

  /**
   * <pre>
   * we need the input schema to the partial aggregate to pass to the final aggregate
   * </pre>
   *
   * <code>.plan.protobuf.Schema input_schema = 7;</code>
   * @return Whether the inputSchema field is set.
   */
  boolean hasInputSchema();
  /**
   * <pre>
   * we need the input schema to the partial aggregate to pass to the final aggregate
   * </pre>
   *
   * <code>.plan.protobuf.Schema input_schema = 7;</code>
   * @return The inputSchema.
   */
  org.blaze.protobuf.Schema getInputSchema();
  /**
   * <pre>
   * we need the input schema to the partial aggregate to pass to the final aggregate
   * </pre>
   *
   * <code>.plan.protobuf.Schema input_schema = 7;</code>
   */
  org.blaze.protobuf.SchemaOrBuilder getInputSchemaOrBuilder();
}
