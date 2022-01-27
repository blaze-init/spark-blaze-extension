// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * Protobuf enum {@code plan.protobuf.UnionMode}
 */
public enum UnionMode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>sparse = 0;</code>
   */
  sparse(0),
  /**
   * <code>dense = 1;</code>
   */
  dense(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>sparse = 0;</code>
   */
  public static final int sparse_VALUE = 0;
  /**
   * <code>dense = 1;</code>
   */
  public static final int dense_VALUE = 1;


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
  public static UnionMode valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static UnionMode forNumber(int value) {
    switch (value) {
      case 0: return sparse;
      case 1: return dense;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<UnionMode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      UnionMode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<UnionMode>() {
          public UnionMode findValueByNumber(int number) {
            return UnionMode.forNumber(number);
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
    return org.blaze.protobuf.BlazeProto.getDescriptor().getEnumTypes().get(10);
  }

  private static final UnionMode[] VALUES = values();

  public static UnionMode valueOf(
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

  private UnionMode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:plan.protobuf.UnionMode)
}

