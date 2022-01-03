// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface ShuffleWriterExecNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.ShuffleWriterExecNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *TODO it seems redundant to provide job and stage id here since we also have them
   * in the TaskDefinition that wraps this plan
   * </pre>
   *
   * <code>string job_id = 1;</code>
   * @return The jobId.
   */
  java.lang.String getJobId();
  /**
   * <pre>
   *TODO it seems redundant to provide job and stage id here since we also have them
   * in the TaskDefinition that wraps this plan
   * </pre>
   *
   * <code>string job_id = 1;</code>
   * @return The bytes for jobId.
   */
  com.google.protobuf.ByteString
      getJobIdBytes();

  /**
   * <code>uint32 stage_id = 2;</code>
   * @return The stageId.
   */
  int getStageId();

  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 3;</code>
   * @return Whether the input field is set.
   */
  boolean hasInput();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 3;</code>
   * @return The input.
   */
  org.ballistacompute.protobuf.PhysicalPlanNode getInput();
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode input = 3;</code>
   */
  org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder();

  /**
   * <code>.ballista.protobuf.PhysicalHashRepartition output_partitioning = 4;</code>
   * @return Whether the outputPartitioning field is set.
   */
  boolean hasOutputPartitioning();
  /**
   * <code>.ballista.protobuf.PhysicalHashRepartition output_partitioning = 4;</code>
   * @return The outputPartitioning.
   */
  org.ballistacompute.protobuf.PhysicalHashRepartition getOutputPartitioning();
  /**
   * <code>.ballista.protobuf.PhysicalHashRepartition output_partitioning = 4;</code>
   */
  org.ballistacompute.protobuf.PhysicalHashRepartitionOrBuilder getOutputPartitioningOrBuilder();
}
