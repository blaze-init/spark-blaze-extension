// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

public interface ScalarListTypeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:plan.protobuf.ScalarListType)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string field_names = 3;</code>
   * @return A list containing the fieldNames.
   */
  java.util.List<java.lang.String>
      getFieldNamesList();
  /**
   * <code>repeated string field_names = 3;</code>
   * @return The count of fieldNames.
   */
  int getFieldNamesCount();
  /**
   * <code>repeated string field_names = 3;</code>
   * @param index The index of the element to return.
   * @return The fieldNames at the given index.
   */
  java.lang.String getFieldNames(int index);
  /**
   * <code>repeated string field_names = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the fieldNames at the given index.
   */
  com.google.protobuf.ByteString
      getFieldNamesBytes(int index);

  /**
   * <code>.plan.protobuf.PrimitiveScalarType deepest_type = 2;</code>
   * @return The enum numeric value on the wire for deepestType.
   */
  int getDeepestTypeValue();
  /**
   * <code>.plan.protobuf.PrimitiveScalarType deepest_type = 2;</code>
   * @return The deepestType.
   */
  org.blaze.protobuf.PrimitiveScalarType getDeepestType();
}
