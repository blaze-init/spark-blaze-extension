package org.apache.spark.sql.blaze

import scala.collection.JavaConverters.asJavaIterableConverter

import org.apache.spark.sql.types.BinaryType
import org.apache.spark.sql.types.BooleanType
import org.apache.spark.sql.types.ByteType
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.FloatType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.types.ShortType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.TimestampType
import org.ballistacompute.protobuf.ArrowType
import org.ballistacompute.protobuf.EmptyMessage
import org.ballistacompute.protobuf.Field
import org.ballistacompute.protobuf.Schema
import org.ballistacompute.protobuf.Timestamp

object NativeConverters {
  def convertDataType(sparkDataType: DataType): ArrowType = {
    val arrowTypeBuilder = ArrowType.newBuilder()
    sparkDataType match {
      case BooleanType => arrowTypeBuilder.setBOOL(EmptyMessage.getDefaultInstance)
      case ByteType => arrowTypeBuilder.setINT8(EmptyMessage.getDefaultInstance)
      case ShortType => arrowTypeBuilder.setINT16(EmptyMessage.getDefaultInstance)
      case IntegerType => arrowTypeBuilder.setINT32(EmptyMessage.getDefaultInstance)
      case LongType => arrowTypeBuilder.setINT64(EmptyMessage.getDefaultInstance)
      case FloatType => arrowTypeBuilder.setFLOAT32(EmptyMessage.getDefaultInstance)
      case DoubleType => arrowTypeBuilder.setFLOAT64(EmptyMessage.getDefaultInstance)
      case StringType => arrowTypeBuilder.setUTF8(EmptyMessage.getDefaultInstance)
      case BinaryType => arrowTypeBuilder.setBINARY(EmptyMessage.getDefaultInstance)
      case DateType => arrowTypeBuilder.setDATE32(EmptyMessage.getDefaultInstance)
      case TimestampType => arrowTypeBuilder.setTIMESTAMP(Timestamp.getDefaultInstance) // NOTE: microsecond => millisecond

      // TODO: support complex data types
      case _ => throw new NotImplementedError(s"Data type conversion not implemented ${sparkDataType}")
    }
    arrowTypeBuilder.build()
  }

  def convertField(sparkField: StructField): Field = {
    Field.newBuilder()
      .setName(sparkField.name)
      .setNullable(sparkField.nullable)
      .setArrowType(convertDataType(sparkField.dataType))
      .build()
  }

  def convertSchema(sparkSchema: StructType): Schema = {
    val schemaBuilder = Schema.newBuilder()
    sparkSchema.foreach(sparkField => schemaBuilder.addColumns(convertField(sparkField)))
    schemaBuilder.build()
  }
}
