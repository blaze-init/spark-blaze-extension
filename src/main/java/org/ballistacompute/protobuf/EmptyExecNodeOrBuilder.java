// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface EmptyExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.EmptyExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool produce_one_row = 1;</code>
   * @return The produceOneRow.
   */
  boolean getProduceOneRow();

  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   * @return Whether the schema field is set.
   */
  boolean hasSchema();
  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   * @return The schema.
   */
  org.ballistacompute.protobuf.Schema getSchema();
  /**
   * <code>.ballista.protobuf.Schema schema = 2;</code>
   */
  org.ballistacompute.protobuf.SchemaOrBuilder getSchemaOrBuilder();
}