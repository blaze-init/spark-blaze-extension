// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface LocalLimitExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.LocalLimitExecNode)
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
   * <code>uint32 limit = 2;</code>
   * @return The limit.
   */
  int getLimit();
}
