// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface ScalarListValueOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.ScalarListValue)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.plan.protobuf.ScalarType datatype = 1;</code>
   * @return Whether the datatype field is set.
   */
  boolean hasDatatype();
  /**
   * <code>.plan.protobuf.ScalarType datatype = 1;</code>
   * @return The datatype.
   */
  org.blaze.protobuf.ScalarType getDatatype();
  /**
   * <code>.plan.protobuf.ScalarType datatype = 1;</code>
   */
  org.blaze.protobuf.ScalarTypeOrBuilder getDatatypeOrBuilder();

  /**
   * <code>repeated .plan.protobuf.ScalarValue values = 2;</code>
   */
  java.util.List<org.blaze.protobuf.ScalarValue> 
      getValuesList();
  /**
   * <code>repeated .plan.protobuf.ScalarValue values = 2;</code>
   */
  org.blaze.protobuf.ScalarValue getValues(int index);
  /**
   * <code>repeated .plan.protobuf.ScalarValue values = 2;</code>
   */
  int getValuesCount();
  /**
   * <code>repeated .plan.protobuf.ScalarValue values = 2;</code>
   */
  java.util.List<? extends org.blaze.protobuf.ScalarValueOrBuilder> 
      getValuesOrBuilderList();
  /**
   * <code>repeated .plan.protobuf.ScalarValue values = 2;</code>
   */
  org.blaze.protobuf.ScalarValueOrBuilder getValuesOrBuilder(
      int index);
}
