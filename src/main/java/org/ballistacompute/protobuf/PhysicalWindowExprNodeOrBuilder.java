// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface PhysicalWindowExprNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.PhysicalWindowExprNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.AggregateFunction aggr_function = 1;</code>
   * @return Whether the aggrFunction field is set.
   */
  boolean hasAggrFunction();
  /**
   * <code>.ballista.protobuf.AggregateFunction aggr_function = 1;</code>
   * @return The enum numeric value on the wire for aggrFunction.
   */
  int getAggrFunctionValue();
  /**
   * <code>.ballista.protobuf.AggregateFunction aggr_function = 1;</code>
   * @return The aggrFunction.
   */
  org.ballistacompute.protobuf.AggregateFunction getAggrFunction();

  /**
   * <pre>
   * udaf = 3
   * </pre>
   *
   * <code>.ballista.protobuf.BuiltInWindowFunction built_in_function = 2;</code>
   * @return Whether the builtInFunction field is set.
   */
  boolean hasBuiltInFunction();
  /**
   * <pre>
   * udaf = 3
   * </pre>
   *
   * <code>.ballista.protobuf.BuiltInWindowFunction built_in_function = 2;</code>
   * @return The enum numeric value on the wire for builtInFunction.
   */
  int getBuiltInFunctionValue();
  /**
   * <pre>
   * udaf = 3
   * </pre>
   *
   * <code>.ballista.protobuf.BuiltInWindowFunction built_in_function = 2;</code>
   * @return The builtInFunction.
   */
  org.ballistacompute.protobuf.BuiltInWindowFunction getBuiltInFunction();

  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 4;</code>
   * @return Whether the expr field is set.
   */
  boolean hasExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 4;</code>
   * @return The expr.
   */
  org.ballistacompute.protobuf.PhysicalExprNode getExpr();
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 4;</code>
   */
  org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder();

  public org.ballistacompute.protobuf.PhysicalWindowExprNode.WindowFunctionCase getWindowFunctionCase();
}
