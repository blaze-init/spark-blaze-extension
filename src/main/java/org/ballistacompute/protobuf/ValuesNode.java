// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * <pre>
 * a node containing data for defining values list. unlike in SQL where it's two dimensional, here
 * the list is flattened, and with the field n_cols it can be parsed and partitioned into rows
 * </pre>
 *
 * Protobuf type {@code ballista.protobuf.ValuesNode}
 */
public final class ValuesNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.ValuesNode)
    ValuesNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ValuesNode.newBuilder() to construct.
  private ValuesNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ValuesNode() {
    valuesList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ValuesNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ValuesNode(
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
          case 8: {

            nCols_ = input.readUInt64();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              valuesList_ = new java.util.ArrayList<org.ballistacompute.protobuf.LogicalExprNode>();
              mutable_bitField0_ |= 0x00000001;
            }
            valuesList_.add(
                input.readMessage(org.ballistacompute.protobuf.LogicalExprNode.parser(), extensionRegistry));
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
        valuesList_ = java.util.Collections.unmodifiableList(valuesList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ValuesNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ValuesNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.ValuesNode.class, org.ballistacompute.protobuf.ValuesNode.Builder.class);
  }

  public static final int N_COLS_FIELD_NUMBER = 1;
  private long nCols_;
  /**
   * <code>uint64 n_cols = 1;</code>
   * @return The nCols.
   */
  @java.lang.Override
  public long getNCols() {
    return nCols_;
  }

  public static final int VALUES_LIST_FIELD_NUMBER = 2;
  private java.util.List<org.ballistacompute.protobuf.LogicalExprNode> valuesList_;
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  @java.lang.Override
  public java.util.List<org.ballistacompute.protobuf.LogicalExprNode> getValuesListList() {
    return valuesList_;
  }
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
      getValuesListOrBuilderList() {
    return valuesList_;
  }
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  @java.lang.Override
  public int getValuesListCount() {
    return valuesList_.size();
  }
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNode getValuesList(int index) {
    return valuesList_.get(index);
  }
  /**
   * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getValuesListOrBuilder(
      int index) {
    return valuesList_.get(index);
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
    if (nCols_ != 0L) {
      output.writeUInt64(1, nCols_);
    }
    for (int i = 0; i < valuesList_.size(); i++) {
      output.writeMessage(2, valuesList_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (nCols_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, nCols_);
    }
    for (int i = 0; i < valuesList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, valuesList_.get(i));
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
    if (!(obj instanceof org.ballistacompute.protobuf.ValuesNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.ValuesNode other = (org.ballistacompute.protobuf.ValuesNode) obj;

    if (getNCols()
        != other.getNCols()) return false;
    if (!getValuesListList()
        .equals(other.getValuesListList())) return false;
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
    hash = (37 * hash) + N_COLS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getNCols());
    if (getValuesListCount() > 0) {
      hash = (37 * hash) + VALUES_LIST_FIELD_NUMBER;
      hash = (53 * hash) + getValuesListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ValuesNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.ValuesNode prototype) {
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
   * <pre>
   * a node containing data for defining values list. unlike in SQL where it's two dimensional, here
   * the list is flattened, and with the field n_cols it can be parsed and partitioned into rows
   * </pre>
   *
   * Protobuf type {@code ballista.protobuf.ValuesNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.ValuesNode)
      org.ballistacompute.protobuf.ValuesNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ValuesNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ValuesNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.ValuesNode.class, org.ballistacompute.protobuf.ValuesNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.ValuesNode.newBuilder()
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
        getValuesListFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      nCols_ = 0L;

      if (valuesListBuilder_ == null) {
        valuesList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        valuesListBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ValuesNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ValuesNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.ValuesNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ValuesNode build() {
      org.ballistacompute.protobuf.ValuesNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ValuesNode buildPartial() {
      org.ballistacompute.protobuf.ValuesNode result = new org.ballistacompute.protobuf.ValuesNode(this);
      int from_bitField0_ = bitField0_;
      result.nCols_ = nCols_;
      if (valuesListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          valuesList_ = java.util.Collections.unmodifiableList(valuesList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.valuesList_ = valuesList_;
      } else {
        result.valuesList_ = valuesListBuilder_.build();
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
      if (other instanceof org.ballistacompute.protobuf.ValuesNode) {
        return mergeFrom((org.ballistacompute.protobuf.ValuesNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.ValuesNode other) {
      if (other == org.ballistacompute.protobuf.ValuesNode.getDefaultInstance()) return this;
      if (other.getNCols() != 0L) {
        setNCols(other.getNCols());
      }
      if (valuesListBuilder_ == null) {
        if (!other.valuesList_.isEmpty()) {
          if (valuesList_.isEmpty()) {
            valuesList_ = other.valuesList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureValuesListIsMutable();
            valuesList_.addAll(other.valuesList_);
          }
          onChanged();
        }
      } else {
        if (!other.valuesList_.isEmpty()) {
          if (valuesListBuilder_.isEmpty()) {
            valuesListBuilder_.dispose();
            valuesListBuilder_ = null;
            valuesList_ = other.valuesList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            valuesListBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getValuesListFieldBuilder() : null;
          } else {
            valuesListBuilder_.addAllMessages(other.valuesList_);
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
      org.ballistacompute.protobuf.ValuesNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.ValuesNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long nCols_ ;
    /**
     * <code>uint64 n_cols = 1;</code>
     * @return The nCols.
     */
    @java.lang.Override
    public long getNCols() {
      return nCols_;
    }
    /**
     * <code>uint64 n_cols = 1;</code>
     * @param value The nCols to set.
     * @return This builder for chaining.
     */
    public Builder setNCols(long value) {
      
      nCols_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 n_cols = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNCols() {
      
      nCols_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<org.ballistacompute.protobuf.LogicalExprNode> valuesList_ =
      java.util.Collections.emptyList();
    private void ensureValuesListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        valuesList_ = new java.util.ArrayList<org.ballistacompute.protobuf.LogicalExprNode>(valuesList_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> valuesListBuilder_;

    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.LogicalExprNode> getValuesListList() {
      if (valuesListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(valuesList_);
      } else {
        return valuesListBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public int getValuesListCount() {
      if (valuesListBuilder_ == null) {
        return valuesList_.size();
      } else {
        return valuesListBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode getValuesList(int index) {
      if (valuesListBuilder_ == null) {
        return valuesList_.get(index);
      } else {
        return valuesListBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder setValuesList(
        int index, org.ballistacompute.protobuf.LogicalExprNode value) {
      if (valuesListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesListIsMutable();
        valuesList_.set(index, value);
        onChanged();
      } else {
        valuesListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder setValuesList(
        int index, org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (valuesListBuilder_ == null) {
        ensureValuesListIsMutable();
        valuesList_.set(index, builderForValue.build());
        onChanged();
      } else {
        valuesListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder addValuesList(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (valuesListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesListIsMutable();
        valuesList_.add(value);
        onChanged();
      } else {
        valuesListBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder addValuesList(
        int index, org.ballistacompute.protobuf.LogicalExprNode value) {
      if (valuesListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesListIsMutable();
        valuesList_.add(index, value);
        onChanged();
      } else {
        valuesListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder addValuesList(
        org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (valuesListBuilder_ == null) {
        ensureValuesListIsMutable();
        valuesList_.add(builderForValue.build());
        onChanged();
      } else {
        valuesListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder addValuesList(
        int index, org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (valuesListBuilder_ == null) {
        ensureValuesListIsMutable();
        valuesList_.add(index, builderForValue.build());
        onChanged();
      } else {
        valuesListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder addAllValuesList(
        java.lang.Iterable<? extends org.ballistacompute.protobuf.LogicalExprNode> values) {
      if (valuesListBuilder_ == null) {
        ensureValuesListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, valuesList_);
        onChanged();
      } else {
        valuesListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder clearValuesList() {
      if (valuesListBuilder_ == null) {
        valuesList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        valuesListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public Builder removeValuesList(int index) {
      if (valuesListBuilder_ == null) {
        ensureValuesListIsMutable();
        valuesList_.remove(index);
        onChanged();
      } else {
        valuesListBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder getValuesListBuilder(
        int index) {
      return getValuesListFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getValuesListOrBuilder(
        int index) {
      if (valuesListBuilder_ == null) {
        return valuesList_.get(index);  } else {
        return valuesListBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public java.util.List<? extends org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
         getValuesListOrBuilderList() {
      if (valuesListBuilder_ != null) {
        return valuesListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(valuesList_);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder addValuesListBuilder() {
      return getValuesListFieldBuilder().addBuilder(
          org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder addValuesListBuilder(
        int index) {
      return getValuesListFieldBuilder().addBuilder(
          index, org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.LogicalExprNode values_list = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.LogicalExprNode.Builder> 
         getValuesListBuilderList() {
      return getValuesListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
        getValuesListFieldBuilder() {
      if (valuesListBuilder_ == null) {
        valuesListBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder>(
                valuesList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        valuesList_ = null;
      }
      return valuesListBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.ValuesNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.ValuesNode)
  private static final org.ballistacompute.protobuf.ValuesNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.ValuesNode();
  }

  public static org.ballistacompute.protobuf.ValuesNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ValuesNode>
      PARSER = new com.google.protobuf.AbstractParser<ValuesNode>() {
    @java.lang.Override
    public ValuesNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ValuesNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ValuesNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ValuesNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.ValuesNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
