// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface ValuesNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.ValuesNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 n_cols = 1;</code>
   * @return The nCols.
   */
  long getNCols();

  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  java.util.List<org.ballistacompute.protobuf.LogicalExprNode> 
      getValuesListList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNode getValuesList(int index);
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  int getValuesListCount();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  java.util.List<? extends org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
      getValuesListOrBuilderList();
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getValuesListOrBuilder(
      int index);
}