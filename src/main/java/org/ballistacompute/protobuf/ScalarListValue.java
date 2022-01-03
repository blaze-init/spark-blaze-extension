// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.ScalarListValue}
 */
public final class ScalarListValue extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.ScalarListValue)
    ScalarListValueOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ScalarListValue.newBuilder() to construct.
  private ScalarListValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ScalarListValue() {
    values_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ScalarListValue();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ScalarListValue(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            org.ballistacompute.protobuf.ScalarType.Builder subBuilder = null;
            if (datatype_ != null) {
              subBuilder = datatype_.toBuilder();
            }
            datatype_ = input.readMessage(org.ballistacompute.protobuf.ScalarType.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(datatype_);
              datatype_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              values_ = new java.util.ArrayList<org.ballistacompute.protobuf.ScalarValue>();
              mutable_bitField0_ |= 0x00000001;
            }
            values_.add(
                input.readMessage(org.ballistacompute.protobuf.ScalarValue.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        values_ = java.util.Collections.unmodifiableList(values_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ScalarListValue_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ScalarListValue_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.ScalarListValue.class, org.ballistacompute.protobuf.ScalarListValue.Builder.class);
  }

  public static final int DATATYPE_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.ScalarType datatype_;
  /**
   * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
   * @return Whether the datatype field is set.
   */
  @java.lang.Override
  public boolean hasDatatype() {
    return datatype_ != null;
  }
  /**
   * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
   * @return The datatype.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ScalarType getDatatype() {
    return datatype_ == null ? org.ballistacompute.protobuf.ScalarType.getDefaultInstance() : datatype_;
  }
  /**
   * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ScalarTypeOrBuilder getDatatypeOrBuilder() {
    return getDatatype();
  }

  public static final int VALUES_FIELD_NUMBER = 2;
  private java.util.List<org.ballistacompute.protobuf.ScalarValue> values_;
  /**
   * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
   */
  @java.lang.Override
  public java.util.List<org.ballistacompute.protobuf.ScalarValue> getValuesList() {
    return values_;
  }
  /**
   * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.ballistacompute.protobuf.ScalarValueOrBuilder> 
      getValuesOrBuilderList() {
    return values_;
  }
  /**
   * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
   */
  @java.lang.Override
  public int getValuesCount() {
    return values_.size();
  }
  /**
   * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ScalarValue getValues(int index) {
    return values_.get(index);
  }
  /**
   * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ScalarValueOrBuilder getValuesOrBuilder(
      int index) {
    return values_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (datatype_ != null) {
      output.writeMessage(1, getDatatype());
    }
    for (int i = 0; i < values_.size(); i++) {
      output.writeMessage(2, values_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (datatype_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDatatype());
    }
    for (int i = 0; i < values_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, values_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.ballistacompute.protobuf.ScalarListValue)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.ScalarListValue other = (org.ballistacompute.protobuf.ScalarListValue) obj;

    if (hasDatatype() != other.hasDatatype()) return false;
    if (hasDatatype()) {
      if (!getDatatype()
          .equals(other.getDatatype())) return false;
    }
    if (!getValuesList()
        .equals(other.getValuesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasDatatype()) {
      hash = (37 * hash) + DATATYPE_FIELD_NUMBER;
      hash = (53 * hash) + getDatatype().hashCode();
    }
    if (getValuesCount() > 0) {
      hash = (37 * hash) + VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getValuesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ScalarListValue parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.ballistacompute.protobuf.ScalarListValue prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ballista.protobuf.ScalarListValue}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.ScalarListValue)
      org.ballistacompute.protobuf.ScalarListValueOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ScalarListValue_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ScalarListValue_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.ScalarListValue.class, org.ballistacompute.protobuf.ScalarListValue.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.ScalarListValue.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getValuesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (datatypeBuilder_ == null) {
        datatype_ = null;
      } else {
        datatype_ = null;
        datatypeBuilder_ = null;
      }
      if (valuesBuilder_ == null) {
        values_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        valuesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ScalarListValue_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ScalarListValue getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.ScalarListValue.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ScalarListValue build() {
      org.ballistacompute.protobuf.ScalarListValue result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ScalarListValue buildPartial() {
      org.ballistacompute.protobuf.ScalarListValue result = new org.ballistacompute.protobuf.ScalarListValue(this);
      int from_bitField0_ = bitField0_;
      if (datatypeBuilder_ == null) {
        result.datatype_ = datatype_;
      } else {
        result.datatype_ = datatypeBuilder_.build();
      }
      if (valuesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          values_ = java.util.Collections.unmodifiableList(values_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.values_ = values_;
      } else {
        result.values_ = valuesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.ballistacompute.protobuf.ScalarListValue) {
        return mergeFrom((org.ballistacompute.protobuf.ScalarListValue)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.ScalarListValue other) {
      if (other == org.ballistacompute.protobuf.ScalarListValue.getDefaultInstance()) return this;
      if (other.hasDatatype()) {
        mergeDatatype(other.getDatatype());
      }
      if (valuesBuilder_ == null) {
        if (!other.values_.isEmpty()) {
          if (values_.isEmpty()) {
            values_ = other.values_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureValuesIsMutable();
            values_.addAll(other.values_);
          }
          onChanged();
        }
      } else {
        if (!other.values_.isEmpty()) {
          if (valuesBuilder_.isEmpty()) {
            valuesBuilder_.dispose();
            valuesBuilder_ = null;
            values_ = other.values_;
            bitField0_ = (bitField0_ & ~0x00000001);
            valuesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getValuesFieldBuilder() : null;
          } else {
            valuesBuilder_.addAllMessages(other.values_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.ballistacompute.protobuf.ScalarListValue parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.ScalarListValue) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private org.ballistacompute.protobuf.ScalarType datatype_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ScalarType, org.ballistacompute.protobuf.ScalarType.Builder, org.ballistacompute.protobuf.ScalarTypeOrBuilder> datatypeBuilder_;
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     * @return Whether the datatype field is set.
     */
    public boolean hasDatatype() {
      return datatypeBuilder_ != null || datatype_ != null;
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     * @return The datatype.
     */
    public org.ballistacompute.protobuf.ScalarType getDatatype() {
      if (datatypeBuilder_ == null) {
        return datatype_ == null ? org.ballistacompute.protobuf.ScalarType.getDefaultInstance() : datatype_;
      } else {
        return datatypeBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public Builder setDatatype(org.ballistacompute.protobuf.ScalarType value) {
      if (datatypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        datatype_ = value;
        onChanged();
      } else {
        datatypeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public Builder setDatatype(
        org.ballistacompute.protobuf.ScalarType.Builder builderForValue) {
      if (datatypeBuilder_ == null) {
        datatype_ = builderForValue.build();
        onChanged();
      } else {
        datatypeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public Builder mergeDatatype(org.ballistacompute.protobuf.ScalarType value) {
      if (datatypeBuilder_ == null) {
        if (datatype_ != null) {
          datatype_ =
            org.ballistacompute.protobuf.ScalarType.newBuilder(datatype_).mergeFrom(value).buildPartial();
        } else {
          datatype_ = value;
        }
        onChanged();
      } else {
        datatypeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public Builder clearDatatype() {
      if (datatypeBuilder_ == null) {
        datatype_ = null;
        onChanged();
      } else {
        datatype_ = null;
        datatypeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public org.ballistacompute.protobuf.ScalarType.Builder getDatatypeBuilder() {
      
      onChanged();
      return getDatatypeFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    public org.ballistacompute.protobuf.ScalarTypeOrBuilder getDatatypeOrBuilder() {
      if (datatypeBuilder_ != null) {
        return datatypeBuilder_.getMessageOrBuilder();
      } else {
        return datatype_ == null ?
            org.ballistacompute.protobuf.ScalarType.getDefaultInstance() : datatype_;
      }
    }
    /**
     * <code>.ballista.protobuf.ScalarType datatype = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ScalarType, org.ballistacompute.protobuf.ScalarType.Builder, org.ballistacompute.protobuf.ScalarTypeOrBuilder> 
        getDatatypeFieldBuilder() {
      if (datatypeBuilder_ == null) {
        datatypeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.ScalarType, org.ballistacompute.protobuf.ScalarType.Builder, org.ballistacompute.protobuf.ScalarTypeOrBuilder>(
                getDatatype(),
                getParentForChildren(),
                isClean());
        datatype_ = null;
      }
      return datatypeBuilder_;
    }

    private java.util.List<org.ballistacompute.protobuf.ScalarValue> values_ =
      java.util.Collections.emptyList();
    private void ensureValuesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        values_ = new java.util.ArrayList<org.ballistacompute.protobuf.ScalarValue>(values_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.ScalarValue, org.ballistacompute.protobuf.ScalarValue.Builder, org.ballistacompute.protobuf.ScalarValueOrBuilder> valuesBuilder_;

    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.ScalarValue> getValuesList() {
      if (valuesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(values_);
      } else {
        return valuesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public int getValuesCount() {
      if (valuesBuilder_ == null) {
        return values_.size();
      } else {
        return valuesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public org.ballistacompute.protobuf.ScalarValue getValues(int index) {
      if (valuesBuilder_ == null) {
        return values_.get(index);
      } else {
        return valuesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder setValues(
        int index, org.ballistacompute.protobuf.ScalarValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.set(index, value);
        onChanged();
      } else {
        valuesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder setValues(
        int index, org.ballistacompute.protobuf.ScalarValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.set(index, builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder addValues(org.ballistacompute.protobuf.ScalarValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.add(value);
        onChanged();
      } else {
        valuesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder addValues(
        int index, org.ballistacompute.protobuf.ScalarValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.add(index, value);
        onChanged();
      } else {
        valuesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder addValues(
        org.ballistacompute.protobuf.ScalarValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.add(builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder addValues(
        int index, org.ballistacompute.protobuf.ScalarValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.add(index, builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder addAllValues(
        java.lang.Iterable<? extends org.ballistacompute.protobuf.ScalarValue> values) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, values_);
        onChanged();
      } else {
        valuesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder clearValues() {
      if (valuesBuilder_ == null) {
        values_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        valuesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public Builder removeValues(int index) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.remove(index);
        onChanged();
      } else {
        valuesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public org.ballistacompute.protobuf.ScalarValue.Builder getValuesBuilder(
        int index) {
      return getValuesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public org.ballistacompute.protobuf.ScalarValueOrBuilder getValuesOrBuilder(
        int index) {
      if (valuesBuilder_ == null) {
        return values_.get(index);  } else {
        return valuesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public java.util.List<? extends org.ballistacompute.protobuf.ScalarValueOrBuilder> 
         getValuesOrBuilderList() {
      if (valuesBuilder_ != null) {
        return valuesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(values_);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public org.ballistacompute.protobuf.ScalarValue.Builder addValuesBuilder() {
      return getValuesFieldBuilder().addBuilder(
          org.ballistacompute.protobuf.ScalarValue.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public org.ballistacompute.protobuf.ScalarValue.Builder addValuesBuilder(
        int index) {
      return getValuesFieldBuilder().addBuilder(
          index, org.ballistacompute.protobuf.ScalarValue.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.ScalarValue values = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.ScalarValue.Builder> 
         getValuesBuilderList() {
      return getValuesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.ScalarValue, org.ballistacompute.protobuf.ScalarValue.Builder, org.ballistacompute.protobuf.ScalarValueOrBuilder> 
        getValuesFieldBuilder() {
      if (valuesBuilder_ == null) {
        valuesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.ballistacompute.protobuf.ScalarValue, org.ballistacompute.protobuf.ScalarValue.Builder, org.ballistacompute.protobuf.ScalarValueOrBuilder>(
                values_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        values_ = null;
      }
      return valuesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.ScalarListValue)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.ScalarListValue)
  private static final org.ballistacompute.protobuf.ScalarListValue DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.ScalarListValue();
  }

  public static org.ballistacompute.protobuf.ScalarListValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ScalarListValue>
      PARSER = new com.google.protobuf.AbstractParser<ScalarListValue>() {
    @java.lang.Override
    public ScalarListValue parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ScalarListValue(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ScalarListValue> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScalarListValue> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.ScalarListValue getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

