// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface JobStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.JobStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.QueuedJob queued = 1;</code>
   * @return Whether the queued field is set.
   */
  boolean hasQueued();
  /**
   * <code>.ballista.protobuf.QueuedJob queued = 1;</code>
   * @return The queued.
   */
  org.ballistacompute.protobuf.QueuedJob getQueued();
  /**
   * <code>.ballista.protobuf.QueuedJob queued = 1;</code>
   */
  org.ballistacompute.protobuf.QueuedJobOrBuilder getQueuedOrBuilder();

  /**
   * <code>.ballista.protobuf.RunningJob running = 2;</code>
   * @return Whether the running field is set.
   */
  boolean hasRunning();
  /**
   * <code>.ballista.protobuf.RunningJob running = 2;</code>
   * @return The running.
   */
  org.ballistacompute.protobuf.RunningJob getRunning();
  /**
   * <code>.ballista.protobuf.RunningJob running = 2;</code>
   */
  org.ballistacompute.protobuf.RunningJobOrBuilder getRunningOrBuilder();

  /**
   * <code>.ballista.protobuf.FailedJob failed = 3;</code>
   * @return Whether the failed field is set.
   */
  boolean hasFailed();
  /**
   * <code>.ballista.protobuf.FailedJob failed = 3;</code>
   * @return The failed.
   */
  org.ballistacompute.protobuf.FailedJob getFailed();
  /**
   * <code>.ballista.protobuf.FailedJob failed = 3;</code>
   */
  org.ballistacompute.protobuf.FailedJobOrBuilder getFailedOrBuilder();

  /**
   * <code>.ballista.protobuf.CompletedJob completed = 4;</code>
   * @return Whether the completed field is set.
   */
  boolean hasCompleted();
  /**
   * <code>.ballista.protobuf.CompletedJob completed = 4;</code>
   * @return The completed.
   */
  org.ballistacompute.protobuf.CompletedJob getCompleted();
  /**
   * <code>.ballista.protobuf.CompletedJob completed = 4;</code>
   */
  org.ballistacompute.protobuf.CompletedJobOrBuilder getCompletedOrBuilder();

  public org.ballistacompute.protobuf.JobStatus.StatusCase getStatusCase();
}