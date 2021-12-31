package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.LeafExecNode
import org.apache.spark.sql.types.StructType

case class NativeParquetFileSourceScanExec(
  override val output: Seq[Attribute],
  inputFiles: Seq[String],
  requiredSchema: StructType,
) extends LeafExecNode {

  override protected def doExecute(): RDD[InternalRow] = {
    throw new RuntimeException()
  }
}
