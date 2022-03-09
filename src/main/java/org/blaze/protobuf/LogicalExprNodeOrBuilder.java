// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface LogicalExprNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.LogicalExprNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * column references
   * </pre>
   *
   * <code>.plan.protobuf.Column column = 1;</code>
   * @return Whether the column field is set.
   */
  boolean hasColumn();
  /**
   * <pre>
   * column references
   * </pre>
   *
   * <code>.plan.protobuf.Column column = 1;</code>
   * @return The column.
   */
  org.blaze.protobuf.Column getColumn();
  /**
   * <pre>
   * column references
   * </pre>
   *
   * <code>.plan.protobuf.Column column = 1;</code>
   */
  org.blaze.protobuf.ColumnOrBuilder getColumnOrBuilder();

  /**
   * <pre>
   * alias
   * </pre>
   *
   * <code>.plan.protobuf.AliasNode alias = 2;</code>
   * @return Whether the alias field is set.
   */
  boolean hasAlias();
  /**
   * <pre>
   * alias
   * </pre>
   *
   * <code>.plan.protobuf.AliasNode alias = 2;</code>
   * @return The alias.
   */
  org.blaze.protobuf.AliasNode getAlias();
  /**
   * <pre>
   * alias
   * </pre>
   *
   * <code>.plan.protobuf.AliasNode alias = 2;</code>
   */
  org.blaze.protobuf.AliasNodeOrBuilder getAliasOrBuilder();

  /**
   * <code>.plan.protobuf.ScalarValue literal = 3;</code>
   * @return Whether the literal field is set.
   */
  boolean hasLiteral();
  /**
   * <code>.plan.protobuf.ScalarValue literal = 3;</code>
   * @return The literal.
   */
  org.blaze.protobuf.ScalarValue getLiteral();
  /**
   * <code>.plan.protobuf.ScalarValue literal = 3;</code>
   */
  org.blaze.protobuf.ScalarValueOrBuilder getLiteralOrBuilder();

  /**
   * <pre>
   * binary expressions
   * </pre>
   *
   * <code>.plan.protobuf.BinaryExprNode binary_expr = 4;</code>
   * @return Whether the binaryExpr field is set.
   */
  boolean hasBinaryExpr();
  /**
   * <pre>
   * binary expressions
   * </pre>
   *
   * <code>.plan.protobuf.BinaryExprNode binary_expr = 4;</code>
   * @return The binaryExpr.
   */
  org.blaze.protobuf.BinaryExprNode getBinaryExpr();
  /**
   * <pre>
   * binary expressions
   * </pre>
   *
   * <code>.plan.protobuf.BinaryExprNode binary_expr = 4;</code>
   */
  org.blaze.protobuf.BinaryExprNodeOrBuilder getBinaryExprOrBuilder();

  /**
   * <pre>
   * null checks
   * </pre>
   *
   * <code>.plan.protobuf.IsNull is_null_expr = 5;</code>
   * @return Whether the isNullExpr field is set.
   */
  boolean hasIsNullExpr();
  /**
   * <pre>
   * null checks
   * </pre>
   *
   * <code>.plan.protobuf.IsNull is_null_expr = 5;</code>
   * @return The isNullExpr.
   */
  org.blaze.protobuf.IsNull getIsNullExpr();
  /**
   * <pre>
   * null checks
   * </pre>
   *
   * <code>.plan.protobuf.IsNull is_null_expr = 5;</code>
   */
  org.blaze.protobuf.IsNullOrBuilder getIsNullExprOrBuilder();

  /**
   * <code>.plan.protobuf.IsNotNull is_not_null_expr = 6;</code>
   * @return Whether the isNotNullExpr field is set.
   */
  boolean hasIsNotNullExpr();
  /**
   * <code>.plan.protobuf.IsNotNull is_not_null_expr = 6;</code>
   * @return The isNotNullExpr.
   */
  org.blaze.protobuf.IsNotNull getIsNotNullExpr();
  /**
   * <code>.plan.protobuf.IsNotNull is_not_null_expr = 6;</code>
   */
  org.blaze.protobuf.IsNotNullOrBuilder getIsNotNullExprOrBuilder();

  /**
   * <code>.plan.protobuf.Not not_expr = 7;</code>
   * @return Whether the notExpr field is set.
   */
  boolean hasNotExpr();
  /**
   * <code>.plan.protobuf.Not not_expr = 7;</code>
   * @return The notExpr.
   */
  org.blaze.protobuf.Not getNotExpr();
  /**
   * <code>.plan.protobuf.Not not_expr = 7;</code>
   */
  org.blaze.protobuf.NotOrBuilder getNotExprOrBuilder();

  /**
   * <code>.plan.protobuf.BetweenNode between = 8;</code>
   * @return Whether the between field is set.
   */
  boolean hasBetween();
  /**
   * <code>.plan.protobuf.BetweenNode between = 8;</code>
   * @return The between.
   */
  org.blaze.protobuf.BetweenNode getBetween();
  /**
   * <code>.plan.protobuf.BetweenNode between = 8;</code>
   */
  org.blaze.protobuf.BetweenNodeOrBuilder getBetweenOrBuilder();

  /**
   * <code>.plan.protobuf.CaseNode case_ = 9;</code>
   * @return Whether the case field is set.
   */
  boolean hasCase();
  /**
   * <code>.plan.protobuf.CaseNode case_ = 9;</code>
   * @return The case.
   */
  org.blaze.protobuf.CaseNode getCase();
  /**
   * <code>.plan.protobuf.CaseNode case_ = 9;</code>
   */
  org.blaze.protobuf.CaseNodeOrBuilder getCaseOrBuilder();

  /**
   * <code>.plan.protobuf.CastNode cast = 10;</code>
   * @return Whether the cast field is set.
   */
  boolean hasCast();
  /**
   * <code>.plan.protobuf.CastNode cast = 10;</code>
   * @return The cast.
   */
  org.blaze.protobuf.CastNode getCast();
  /**
   * <code>.plan.protobuf.CastNode cast = 10;</code>
   */
  org.blaze.protobuf.CastNodeOrBuilder getCastOrBuilder();

  /**
   * <code>.plan.protobuf.NegativeNode negative = 11;</code>
   * @return Whether the negative field is set.
   */
  boolean hasNegative();
  /**
   * <code>.plan.protobuf.NegativeNode negative = 11;</code>
   * @return The negative.
   */
  org.blaze.protobuf.NegativeNode getNegative();
  /**
   * <code>.plan.protobuf.NegativeNode negative = 11;</code>
   */
  org.blaze.protobuf.NegativeNodeOrBuilder getNegativeOrBuilder();

  /**
   * <code>.plan.protobuf.InListNode in_list = 12;</code>
   * @return Whether the inList field is set.
   */
  boolean hasInList();
  /**
   * <code>.plan.protobuf.InListNode in_list = 12;</code>
   * @return The inList.
   */
  org.blaze.protobuf.InListNode getInList();
  /**
   * <code>.plan.protobuf.InListNode in_list = 12;</code>
   */
  org.blaze.protobuf.InListNodeOrBuilder getInListOrBuilder();

  /**
   * <code>bool wildcard = 13;</code>
   * @return Whether the wildcard field is set.
   */
  boolean hasWildcard();
  /**
   * <code>bool wildcard = 13;</code>
   * @return The wildcard.
   */
  boolean getWildcard();

  /**
   * <code>.plan.protobuf.ScalarFunctionNode scalar_function = 14;</code>
   * @return Whether the scalarFunction field is set.
   */
  boolean hasScalarFunction();
  /**
   * <code>.plan.protobuf.ScalarFunctionNode scalar_function = 14;</code>
   * @return The scalarFunction.
   */
  org.blaze.protobuf.ScalarFunctionNode getScalarFunction();
  /**
   * <code>.plan.protobuf.ScalarFunctionNode scalar_function = 14;</code>
   */
  org.blaze.protobuf.ScalarFunctionNodeOrBuilder getScalarFunctionOrBuilder();

  /**
   * <code>.plan.protobuf.TryCastNode try_cast = 15;</code>
   * @return Whether the tryCast field is set.
   */
  boolean hasTryCast();
  /**
   * <code>.plan.protobuf.TryCastNode try_cast = 15;</code>
   * @return The tryCast.
   */
  org.blaze.protobuf.TryCastNode getTryCast();
  /**
   * <code>.plan.protobuf.TryCastNode try_cast = 15;</code>
   */
  org.blaze.protobuf.TryCastNodeOrBuilder getTryCastOrBuilder();

  public org.blaze.protobuf.LogicalExprNode.ExprTypeCase getExprTypeCase();
}
