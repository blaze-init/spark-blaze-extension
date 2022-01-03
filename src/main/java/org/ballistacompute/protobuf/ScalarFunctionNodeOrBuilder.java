// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface ScalarFunctionNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.ScalarFunctionNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.ScalarFunction fun = 1;</code>
   * @return The enum numeric value on the wire for fun.
   */
  int getFunValue();
  /**
   * <code>.ballista.protobuf.ScalarFunction fun = 1;</code>
   * @return The fun.
   */
  org.ballistacompute.protobuf.ScalarFunction getFun();

  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode args = 2;</code>
   */
  java.util.List<org.ballistacompute.protobuf.LogicalExprNode> 
      getArgsList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode args = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNode getArgs(int index);
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode args = 2;</code>
   */
  int getArgsCount();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode args = 2;</code>
   */
  java.util.List<? extends org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
      getArgsOrBuilderList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode args = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getArgsOrBuilder(
      int index);
}
