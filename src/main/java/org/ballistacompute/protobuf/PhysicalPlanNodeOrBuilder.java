// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

public interface PhysicalPlanNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ballista.protobuf.PhysicalPlanNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ballista.protobuf.ParquetScanExecNode parquet_scan = 1;</code>
   * @return Whether the parquetScan field is set.
   */
  boolean hasParquetScan();
  /**
   * <code>.ballista.protobuf.ParquetScanExecNode parquet_scan = 1;</code>
   * @return The parquetScan.
   */
  org.ballistacompute.protobuf.ParquetScanExecNode getParquetScan();
  /**
   * <code>.ballista.protobuf.ParquetScanExecNode parquet_scan = 1;</code>
   */
  org.ballistacompute.protobuf.ParquetScanExecNodeOrBuilder getParquetScanOrBuilder();

  /**
   * <code>.ballista.protobuf.CsvScanExecNode csv_scan = 2;</code>
   * @return Whether the csvScan field is set.
   */
  boolean hasCsvScan();
  /**
   * <code>.ballista.protobuf.CsvScanExecNode csv_scan = 2;</code>
   * @return The csvScan.
   */
  org.ballistacompute.protobuf.CsvScanExecNode getCsvScan();
  /**
   * <code>.ballista.protobuf.CsvScanExecNode csv_scan = 2;</code>
   */
  org.ballistacompute.protobuf.CsvScanExecNodeOrBuilder getCsvScanOrBuilder();

  /**
   * <code>.ballista.protobuf.EmptyExecNode empty = 3;</code>
   * @return Whether the empty field is set.
   */
  boolean hasEmpty();
  /**
   * <code>.ballista.protobuf.EmptyExecNode empty = 3;</code>
   * @return The empty.
   */
  org.ballistacompute.protobuf.EmptyExecNode getEmpty();
  /**
   * <code>.ballista.protobuf.EmptyExecNode empty = 3;</code>
   */
  org.ballistacompute.protobuf.EmptyExecNodeOrBuilder getEmptyOrBuilder();

  /**
   * <code>.ballista.protobuf.ProjectionExecNode projection = 4;</code>
   * @return Whether the projection field is set.
   */
  boolean hasProjection();
  /**
   * <code>.ballista.protobuf.ProjectionExecNode projection = 4;</code>
   * @return The projection.
   */
  org.ballistacompute.protobuf.ProjectionExecNode getProjection();
  /**
   * <code>.ballista.protobuf.ProjectionExecNode projection = 4;</code>
   */
  org.ballistacompute.protobuf.ProjectionExecNodeOrBuilder getProjectionOrBuilder();

  /**
   * <code>.ballista.protobuf.GlobalLimitExecNode global_limit = 6;</code>
   * @return Whether the globalLimit field is set.
   */
  boolean hasGlobalLimit();
  /**
   * <code>.ballista.protobuf.GlobalLimitExecNode global_limit = 6;</code>
   * @return The globalLimit.
   */
  org.ballistacompute.protobuf.GlobalLimitExecNode getGlobalLimit();
  /**
   * <code>.ballista.protobuf.GlobalLimitExecNode global_limit = 6;</code>
   */
  org.ballistacompute.protobuf.GlobalLimitExecNodeOrBuilder getGlobalLimitOrBuilder();

  /**
   * <code>.ballista.protobuf.LocalLimitExecNode local_limit = 7;</code>
   * @return Whether the localLimit field is set.
   */
  boolean hasLocalLimit();
  /**
   * <code>.ballista.protobuf.LocalLimitExecNode local_limit = 7;</code>
   * @return The localLimit.
   */
  org.ballistacompute.protobuf.LocalLimitExecNode getLocalLimit();
  /**
   * <code>.ballista.protobuf.LocalLimitExecNode local_limit = 7;</code>
   */
  org.ballistacompute.protobuf.LocalLimitExecNodeOrBuilder getLocalLimitOrBuilder();

  /**
   * <code>.ballista.protobuf.HashAggregateExecNode hash_aggregate = 8;</code>
   * @return Whether the hashAggregate field is set.
   */
  boolean hasHashAggregate();
  /**
   * <code>.ballista.protobuf.HashAggregateExecNode hash_aggregate = 8;</code>
   * @return The hashAggregate.
   */
  org.ballistacompute.protobuf.HashAggregateExecNode getHashAggregate();
  /**
   * <code>.ballista.protobuf.HashAggregateExecNode hash_aggregate = 8;</code>
   */
  org.ballistacompute.protobuf.HashAggregateExecNodeOrBuilder getHashAggregateOrBuilder();

  /**
   * <code>.ballista.protobuf.HashJoinExecNode hash_join = 9;</code>
   * @return Whether the hashJoin field is set.
   */
  boolean hasHashJoin();
  /**
   * <code>.ballista.protobuf.HashJoinExecNode hash_join = 9;</code>
   * @return The hashJoin.
   */
  org.ballistacompute.protobuf.HashJoinExecNode getHashJoin();
  /**
   * <code>.ballista.protobuf.HashJoinExecNode hash_join = 9;</code>
   */
  org.ballistacompute.protobuf.HashJoinExecNodeOrBuilder getHashJoinOrBuilder();

  /**
   * <code>.ballista.protobuf.ShuffleReaderExecNode shuffle_reader = 10;</code>
   * @return Whether the shuffleReader field is set.
   */
  boolean hasShuffleReader();
  /**
   * <code>.ballista.protobuf.ShuffleReaderExecNode shuffle_reader = 10;</code>
   * @return The shuffleReader.
   */
  org.ballistacompute.protobuf.ShuffleReaderExecNode getShuffleReader();
  /**
   * <code>.ballista.protobuf.ShuffleReaderExecNode shuffle_reader = 10;</code>
   */
  org.ballistacompute.protobuf.ShuffleReaderExecNodeOrBuilder getShuffleReaderOrBuilder();

  /**
   * <code>.ballista.protobuf.SortExecNode sort = 11;</code>
   * @return Whether the sort field is set.
   */
  boolean hasSort();
  /**
   * <code>.ballista.protobuf.SortExecNode sort = 11;</code>
   * @return The sort.
   */
  org.ballistacompute.protobuf.SortExecNode getSort();
  /**
   * <code>.ballista.protobuf.SortExecNode sort = 11;</code>
   */
  org.ballistacompute.protobuf.SortExecNodeOrBuilder getSortOrBuilder();

  /**
   * <code>.ballista.protobuf.CoalesceBatchesExecNode coalesce_batches = 12;</code>
   * @return Whether the coalesceBatches field is set.
   */
  boolean hasCoalesceBatches();
  /**
   * <code>.ballista.protobuf.CoalesceBatchesExecNode coalesce_batches = 12;</code>
   * @return The coalesceBatches.
   */
  org.ballistacompute.protobuf.CoalesceBatchesExecNode getCoalesceBatches();
  /**
   * <code>.ballista.protobuf.CoalesceBatchesExecNode coalesce_batches = 12;</code>
   */
  org.ballistacompute.protobuf.CoalesceBatchesExecNodeOrBuilder getCoalesceBatchesOrBuilder();

  /**
   * <code>.ballista.protobuf.FilterExecNode filter = 13;</code>
   * @return Whether the filter field is set.
   */
  boolean hasFilter();
  /**
   * <code>.ballista.protobuf.FilterExecNode filter = 13;</code>
   * @return The filter.
   */
  org.ballistacompute.protobuf.FilterExecNode getFilter();
  /**
   * <code>.ballista.protobuf.FilterExecNode filter = 13;</code>
   */
  org.ballistacompute.protobuf.FilterExecNodeOrBuilder getFilterOrBuilder();

  /**
   * <code>.ballista.protobuf.CoalescePartitionsExecNode merge = 14;</code>
   * @return Whether the merge field is set.
   */
  boolean hasMerge();
  /**
   * <code>.ballista.protobuf.CoalescePartitionsExecNode merge = 14;</code>
   * @return The merge.
   */
  org.ballistacompute.protobuf.CoalescePartitionsExecNode getMerge();
  /**
   * <code>.ballista.protobuf.CoalescePartitionsExecNode merge = 14;</code>
   */
  org.ballistacompute.protobuf.CoalescePartitionsExecNodeOrBuilder getMergeOrBuilder();

  /**
   * <code>.ballista.protobuf.UnresolvedShuffleExecNode unresolved = 15;</code>
   * @return Whether the unresolved field is set.
   */
  boolean hasUnresolved();
  /**
   * <code>.ballista.protobuf.UnresolvedShuffleExecNode unresolved = 15;</code>
   * @return The unresolved.
   */
  org.ballistacompute.protobuf.UnresolvedShuffleExecNode getUnresolved();
  /**
   * <code>.ballista.protobuf.UnresolvedShuffleExecNode unresolved = 15;</code>
   */
  org.ballistacompute.protobuf.UnresolvedShuffleExecNodeOrBuilder getUnresolvedOrBuilder();

  /**
   * <code>.ballista.protobuf.RepartitionExecNode repartition = 16;</code>
   * @return Whether the repartition field is set.
   */
  boolean hasRepartition();
  /**
   * <code>.ballista.protobuf.RepartitionExecNode repartition = 16;</code>
   * @return The repartition.
   */
  org.ballistacompute.protobuf.RepartitionExecNode getRepartition();
  /**
   * <code>.ballista.protobuf.RepartitionExecNode repartition = 16;</code>
   */
  org.ballistacompute.protobuf.RepartitionExecNodeOrBuilder getRepartitionOrBuilder();

  /**
   * <code>.ballista.protobuf.WindowAggExecNode window = 17;</code>
   * @return Whether the window field is set.
   */
  boolean hasWindow();
  /**
   * <code>.ballista.protobuf.WindowAggExecNode window = 17;</code>
   * @return The window.
   */
  org.ballistacompute.protobuf.WindowAggExecNode getWindow();
  /**
   * <code>.ballista.protobuf.WindowAggExecNode window = 17;</code>
   */
  org.ballistacompute.protobuf.WindowAggExecNodeOrBuilder getWindowOrBuilder();

  /**
   * <code>.ballista.protobuf.ShuffleWriterExecNode shuffle_writer = 18;</code>
   * @return Whether the shuffleWriter field is set.
   */
  boolean hasShuffleWriter();
  /**
   * <code>.ballista.protobuf.ShuffleWriterExecNode shuffle_writer = 18;</code>
   * @return The shuffleWriter.
   */
  org.ballistacompute.protobuf.ShuffleWriterExecNode getShuffleWriter();
  /**
   * <code>.ballista.protobuf.ShuffleWriterExecNode shuffle_writer = 18;</code>
   */
  org.ballistacompute.protobuf.ShuffleWriterExecNodeOrBuilder getShuffleWriterOrBuilder();

  /**
   * <code>.ballista.protobuf.CrossJoinExecNode cross_join = 19;</code>
   * @return Whether the crossJoin field is set.
   */
  boolean hasCrossJoin();
  /**
   * <code>.ballista.protobuf.CrossJoinExecNode cross_join = 19;</code>
   * @return The crossJoin.
   */
  org.ballistacompute.protobuf.CrossJoinExecNode getCrossJoin();
  /**
   * <code>.ballista.protobuf.CrossJoinExecNode cross_join = 19;</code>
   */
  org.ballistacompute.protobuf.CrossJoinExecNodeOrBuilder getCrossJoinOrBuilder();

  /**
   * <code>.ballista.protobuf.AvroScanExecNode avro_scan = 20;</code>
   * @return Whether the avroScan field is set.
   */
  boolean hasAvroScan();
  /**
   * <code>.ballista.protobuf.AvroScanExecNode avro_scan = 20;</code>
   * @return The avroScan.
   */
  org.ballistacompute.protobuf.AvroScanExecNode getAvroScan();
  /**
   * <code>.ballista.protobuf.AvroScanExecNode avro_scan = 20;</code>
   */
  org.ballistacompute.protobuf.AvroScanExecNodeOrBuilder getAvroScanOrBuilder();

  public org.ballistacompute.protobuf.PhysicalPlanNode.PhysicalPlanTypeCase getPhysicalPlanTypeCase();
}
