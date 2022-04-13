package org.blaze

import org.apache.arrow.c.{ArrowArray, ArrowSchema, CDataDictionaryProvider, Data}
import org.apache.arrow.vector.VectorSchemaRoot
import org.apache.spark.TaskContext
import org.apache.spark.sql.blaze.JniBridge
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.util2.ArrowUtils2
import org.apache.spark.sql.vectorized.{ArrowColumnVector, ColumnVector, ColumnarBatch}

import scala.collection.JavaConverters._

object FFIHelper {
  def tryWithResource[R <: AutoCloseable, T](createResource: => R)(f: R => T): T = {
    val resource = createResource
    try f.apply(resource)
    finally resource.close()
  }

  def fromBlazeIter(iterPtr: Long, context: TaskContext): Iterator[InternalRow] = {
    val allocator =
      ArrowUtils2.rootAllocator.newChildAllocator("fromBLZIterator", 0, Long.MaxValue)
    val provider = new CDataDictionaryProvider()

    var finished = false
    val root = tryWithResource(ArrowSchema.allocateNew(allocator)) { consumerSchema =>
      tryWithResource(ArrowArray.allocateNew(allocator)) { consumerArray =>
        val schemaPtr: Long = consumerSchema.memoryAddress
        val arrayPtr: Long = consumerArray.memoryAddress
        val rt = JniBridge.loadNext(iterPtr, schemaPtr, arrayPtr)
        val root: VectorSchemaRoot =
          Data.importVectorSchemaRoot(allocator, consumerSchema, provider)

        if (rt < 0) {
          return Iterator.empty
        }
        Data.importIntoVectorSchemaRoot(allocator, consumerArray, root, provider)
        root
      }
    }

    def rootAsRowIter(): Iterator[InternalRow] = {
      val columns = root.getFieldVectors.asScala.map { vector =>
        new ArrowColumnVector(vector).asInstanceOf[ColumnVector]
      }.toArray
      val batch = new ColumnarBatch(columns)
      batch.setNumRows(root.getRowCount)
      batch.rowIterator().asScala
    }

    val firstIter = rootAsRowIter()

    new Iterator[InternalRow] {
      private var rowIter = firstIter

      context.addTaskCompletionListener[Unit] { _ =>
        root.close()
        allocator.close()
      }

      override def hasNext: Boolean = rowIter.hasNext || {
        if (!finished) {
          rowIter = nextBatch()
          !rowIter.isEmpty
        } else {
          root.close()
          allocator.close()
          false
        }
      }

      override def next(): InternalRow = rowIter.next()

      private def nextBatch(): Iterator[InternalRow] = {
        tryWithResource(ArrowSchema.allocateNew(allocator)) { consumerSchema =>
          tryWithResource(ArrowArray.allocateNew(allocator)) { consumerArray =>
            val schemaPtr: Long = consumerSchema.memoryAddress
            val arrayPtr: Long = consumerArray.memoryAddress
            val rt = JniBridge.loadNext(iterPtr, schemaPtr, arrayPtr)
            if (rt < 0) {
              finished = true
              return Iterator.empty
            }

            Data.importIntoVectorSchemaRoot(allocator, consumerArray, root, provider)
            rootAsRowIter()
          }
        }
      }
    }
  }
}
