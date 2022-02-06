// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * <pre>
 * Contains all valid datafusion scalar type except for
 * List
 * </pre>
 *
 * Protobuf enum {@code plan.protobuf.PrimitiveScalarType}
 */
public enum PrimitiveScalarType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * arrow::Type::BOOL
   * </pre>
   *
   * <code>BOOL = 0;</code>
   */
  BOOL(0),
  /**
   * <pre>
   * arrow::Type::UINT8
   * </pre>
   *
   * <code>UINT8 = 1;</code>
   */
  UINT8(1),
  /**
   * <pre>
   * arrow::Type::INT8
   * </pre>
   *
   * <code>INT8 = 2;</code>
   */
  INT8(2),
  /**
   * <pre>
   * represents arrow::Type fields in src/arrow/type.h
   * </pre>
   *
   * <code>UINT16 = 3;</code>
   */
  UINT16(3),
  /**
   * <code>INT16 = 4;</code>
   */
  INT16(4),
  /**
   * <code>UINT32 = 5;</code>
   */
  UINT32(5),
  /**
   * <code>INT32 = 6;</code>
   */
  INT32(6),
  /**
   * <code>UINT64 = 7;</code>
   */
  UINT64(7),
  /**
   * <code>INT64 = 8;</code>
   */
  INT64(8),
  /**
   * <code>FLOAT32 = 9;</code>
   */
  FLOAT32(9),
  /**
   * <code>FLOAT64 = 10;</code>
   */
  FLOAT64(10),
  /**
   * <code>UTF8 = 11;</code>
   */
  UTF8(11),
  /**
   * <code>LARGE_UTF8 = 12;</code>
   */
  LARGE_UTF8(12),
  /**
   * <code>DATE32 = 13;</code>
   */
  DATE32(13),
  /**
   * <code>TIME_MICROSECOND = 14;</code>
   */
  TIME_MICROSECOND(14),
  /**
   * <code>TIME_NANOSECOND = 15;</code>
   */
  TIME_NANOSECOND(15),
  /**
   * <code>NULL = 16;</code>
   */
  NULL(16),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * arrow::Type::BOOL
   * </pre>
   *
   * <code>BOOL = 0;</code>
   */
  public static final int BOOL_VALUE = 0;
  /**
   * <pre>
   * arrow::Type::UINT8
   * </pre>
   *
   * <code>UINT8 = 1;</code>
   */
  public static final int UINT8_VALUE = 1;
  /**
   * <pre>
   * arrow::Type::INT8
   * </pre>
   *
   * <code>INT8 = 2;</code>
   */
  public static final int INT8_VALUE = 2;
  /**
   * <pre>
   * represents arrow::Type fields in src/arrow/type.h
   * </pre>
   *
   * <code>UINT16 = 3;</code>
   */
  public static final int UINT16_VALUE = 3;
  /**
   * <code>INT16 = 4;</code>
   */
  public static final int INT16_VALUE = 4;
  /**
   * <code>UINT32 = 5;</code>
   */
  public static final int UINT32_VALUE = 5;
  /**
   * <code>INT32 = 6;</code>
   */
  public static final int INT32_VALUE = 6;
  /**
   * <code>UINT64 = 7;</code>
   */
  public static final int UINT64_VALUE = 7;
  /**
   * <code>INT64 = 8;</code>
   */
  public static final int INT64_VALUE = 8;
  /**
   * <code>FLOAT32 = 9;</code>
   */
  public static final int FLOAT32_VALUE = 9;
  /**
   * <code>FLOAT64 = 10;</code>
   */
  public static final int FLOAT64_VALUE = 10;
  /**
   * <code>UTF8 = 11;</code>
   */
  public static final int UTF8_VALUE = 11;
  /**
   * <code>LARGE_UTF8 = 12;</code>
   */
  public static final int LARGE_UTF8_VALUE = 12;
  /**
   * <code>DATE32 = 13;</code>
   */
  public static final int DATE32_VALUE = 13;
  /**
   * <code>TIME_MICROSECOND = 14;</code>
   */
  public static final int TIME_MICROSECOND_VALUE = 14;
  /**
   * <code>TIME_NANOSECOND = 15;</code>
   */
  public static final int TIME_NANOSECOND_VALUE = 15;
  /**
   * <code>NULL = 16;</code>
   */
  public static final int NULL_VALUE = 16;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static PrimitiveScalarType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PrimitiveScalarType forNumber(int value) {
    switch (value) {
      case 0: return BOOL;
      case 1: return UINT8;
      case 2: return INT8;
      case 3: return UINT16;
      case 4: return INT16;
      case 5: return UINT32;
      case 6: return INT32;
      case 7: return UINT64;
      case 8: return INT64;
      case 9: return FLOAT32;
      case 10: return FLOAT64;
      case 11: return UTF8;
      case 12: return LARGE_UTF8;
      case 13: return DATE32;
      case 14: return TIME_MICROSECOND;
      case 15: return TIME_NANOSECOND;
      case 16: return NULL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PrimitiveScalarType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PrimitiveScalarType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PrimitiveScalarType>() {
          public PrimitiveScalarType findValueByNumber(int number) {
            return PrimitiveScalarType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.blaze.protobuf.BlazeProto.getDescriptor().getEnumTypes().get(11);
  }

  private static final PrimitiveScalarType[] VALUES = values();

  public static PrimitiveScalarType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PrimitiveScalarType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:plan.protobuf.PrimitiveScalarType)
}

