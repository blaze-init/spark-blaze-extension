// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.PhysicalInListNode}
 */
public final class PhysicalInListNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.PhysicalInListNode)
    PhysicalInListNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PhysicalInListNode.newBuilder() to construct.
  private PhysicalInListNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PhysicalInListNode() {
    list_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PhysicalInListNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PhysicalInListNode(
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
            org.ballistacompute.protobuf.PhysicalExprNode.Builder subBuilder = null;
            if (expr_ != null) {
              subBuilder = expr_.toBuilder();
            }
            expr_ = input.readMessage(org.ballistacompute.protobuf.PhysicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(expr_);
              expr_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              list_ = new java.util.ArrayList<org.ballistacompute.protobuf.PhysicalExprNode>();
              mutable_bitField0_ |= 0x00000001;
            }
            list_.add(
                input.readMessage(org.ballistacompute.protobuf.PhysicalExprNode.parser(), extensionRegistry));
            break;
          }
          case 24: {

            negated_ = input.readBool();
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
        list_ = java.util.Collections.unmodifiableList(list_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalInListNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalInListNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.PhysicalInListNode.class, org.ballistacompute.protobuf.PhysicalInListNode.Builder.class);
  }

  public static final int EXPR_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.PhysicalExprNode expr_;
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   * @return Whether the expr field is set.
   */
  @java.lang.Override
  public boolean hasExpr() {
    return expr_ != null;
  }
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   * @return The expr.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNode getExpr() {
    return expr_ == null ? org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
  }
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder() {
    return getExpr();
  }

  public static final int LIST_FIELD_NUMBER = 2;
  private java.util.List<org.ballistacompute.protobuf.PhysicalExprNode> list_;
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
   */
  @java.lang.Override
  public java.util.List<org.ballistacompute.protobuf.PhysicalExprNode> getListList() {
    return list_;
  }
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
      getListOrBuilderList() {
    return list_;
  }
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
   */
  @java.lang.Override
  public int getListCount() {
    return list_.size();
  }
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNode getList(int index) {
    return list_.get(index);
  }
  /**
   * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getListOrBuilder(
      int index) {
    return list_.get(index);
  }

  public static final int NEGATED_FIELD_NUMBER = 3;
  private boolean negated_;
  /**
   * <code>bool negated = 3;</code>
   * @return The negated.
   */
  @java.lang.Override
  public boolean getNegated() {
    return negated_;
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
    if (expr_ != null) {
      output.writeMessage(1, getExpr());
    }
    for (int i = 0; i < list_.size(); i++) {
      output.writeMessage(2, list_.get(i));
    }
    if (negated_ != false) {
      output.writeBool(3, negated_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (expr_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getExpr());
    }
    for (int i = 0; i < list_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, list_.get(i));
    }
    if (negated_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, negated_);
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
    if (!(obj instanceof org.ballistacompute.protobuf.PhysicalInListNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.PhysicalInListNode other = (org.ballistacompute.protobuf.PhysicalInListNode) obj;

    if (hasExpr() != other.hasExpr()) return false;
    if (hasExpr()) {
      if (!getExpr()
          .equals(other.getExpr())) return false;
    }
    if (!getListList()
        .equals(other.getListList())) return false;
    if (getNegated()
        != other.getNegated()) return false;
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
    if (hasExpr()) {
      hash = (37 * hash) + EXPR_FIELD_NUMBER;
      hash = (53 * hash) + getExpr().hashCode();
    }
    if (getListCount() > 0) {
      hash = (37 * hash) + LIST_FIELD_NUMBER;
      hash = (53 * hash) + getListList().hashCode();
    }
    hash = (37 * hash) + NEGATED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getNegated());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalInListNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.PhysicalInListNode prototype) {
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
   * Protobuf type {@code ballista.protobuf.PhysicalInListNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.PhysicalInListNode)
      org.ballistacompute.protobuf.PhysicalInListNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalInListNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalInListNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.PhysicalInListNode.class, org.ballistacompute.protobuf.PhysicalInListNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.PhysicalInListNode.newBuilder()
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
        getListFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (exprBuilder_ == null) {
        expr_ = null;
      } else {
        expr_ = null;
        exprBuilder_ = null;
      }
      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        listBuilder_.clear();
      }
      negated_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalInListNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalInListNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.PhysicalInListNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalInListNode build() {
      org.ballistacompute.protobuf.PhysicalInListNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalInListNode buildPartial() {
      org.ballistacompute.protobuf.PhysicalInListNode result = new org.ballistacompute.protobuf.PhysicalInListNode(this);
      int from_bitField0_ = bitField0_;
      if (exprBuilder_ == null) {
        result.expr_ = expr_;
      } else {
        result.expr_ = exprBuilder_.build();
      }
      if (listBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          list_ = java.util.Collections.unmodifiableList(list_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.list_ = list_;
      } else {
        result.list_ = listBuilder_.build();
      }
      result.negated_ = negated_;
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
      if (other instanceof org.ballistacompute.protobuf.PhysicalInListNode) {
        return mergeFrom((org.ballistacompute.protobuf.PhysicalInListNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.PhysicalInListNode other) {
      if (other == org.ballistacompute.protobuf.PhysicalInListNode.getDefaultInstance()) return this;
      if (other.hasExpr()) {
        mergeExpr(other.getExpr());
      }
      if (listBuilder_ == null) {
        if (!other.list_.isEmpty()) {
          if (list_.isEmpty()) {
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureListIsMutable();
            list_.addAll(other.list_);
          }
          onChanged();
        }
      } else {
        if (!other.list_.isEmpty()) {
          if (listBuilder_.isEmpty()) {
            listBuilder_.dispose();
            listBuilder_ = null;
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000001);
            listBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getListFieldBuilder() : null;
          } else {
            listBuilder_.addAllMessages(other.list_);
          }
        }
      }
      if (other.getNegated() != false) {
        setNegated(other.getNegated());
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
      org.ballistacompute.protobuf.PhysicalInListNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.PhysicalInListNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private org.ballistacompute.protobuf.PhysicalExprNode expr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> exprBuilder_;
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     * @return Whether the expr field is set.
     */
    public boolean hasExpr() {
      return exprBuilder_ != null || expr_ != null;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     * @return The expr.
     */
    public org.ballistacompute.protobuf.PhysicalExprNode getExpr() {
      if (exprBuilder_ == null) {
        return expr_ == null ? org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
      } else {
        return exprBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder setExpr(org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (exprBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        expr_ = value;
        onChanged();
      } else {
        exprBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder setExpr(
        org.ballistacompute.protobuf.PhysicalExprNode.Builder builderForValue) {
      if (exprBuilder_ == null) {
        expr_ = builderForValue.build();
        onChanged();
      } else {
        exprBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder mergeExpr(org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (exprBuilder_ == null) {
        if (expr_ != null) {
          expr_ =
            org.ballistacompute.protobuf.PhysicalExprNode.newBuilder(expr_).mergeFrom(value).buildPartial();
        } else {
          expr_ = value;
        }
        onChanged();
      } else {
        exprBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder clearExpr() {
      if (exprBuilder_ == null) {
        expr_ = null;
        onChanged();
      } else {
        expr_ = null;
        exprBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode.Builder getExprBuilder() {
      
      onChanged();
      return getExprFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder() {
      if (exprBuilder_ != null) {
        return exprBuilder_.getMessageOrBuilder();
      } else {
        return expr_ == null ?
            org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
        getExprFieldBuilder() {
      if (exprBuilder_ == null) {
        exprBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder>(
                getExpr(),
                getParentForChildren(),
                isClean());
        expr_ = null;
      }
      return exprBuilder_;
    }

    private java.util.List<org.ballistacompute.protobuf.PhysicalExprNode> list_ =
      java.util.Collections.emptyList();
    private void ensureListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        list_ = new java.util.ArrayList<org.ballistacompute.protobuf.PhysicalExprNode>(list_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> listBuilder_;

    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.PhysicalExprNode> getListList() {
      if (listBuilder_ == null) {
        return java.util.Collections.unmodifiableList(list_);
      } else {
        return listBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public int getListCount() {
      if (listBuilder_ == null) {
        return list_.size();
      } else {
        return listBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode getList(int index) {
      if (listBuilder_ == null) {
        return list_.get(index);
      } else {
        return listBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder setList(
        int index, org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.set(index, value);
        onChanged();
      } else {
        listBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder setList(
        int index, org.ballistacompute.protobuf.PhysicalExprNode.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.set(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder addList(org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(value);
        onChanged();
      } else {
        listBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder addList(
        int index, org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(index, value);
        onChanged();
      } else {
        listBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder addList(
        org.ballistacompute.protobuf.PhysicalExprNode.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder addList(
        int index, org.ballistacompute.protobuf.PhysicalExprNode.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder addAllList(
        java.lang.Iterable<? extends org.ballistacompute.protobuf.PhysicalExprNode> values) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, list_);
        onChanged();
      } else {
        listBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder clearList() {
      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        listBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public Builder removeList(int index) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.remove(index);
        onChanged();
      } else {
        listBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode.Builder getListBuilder(
        int index) {
      return getListFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getListOrBuilder(
        int index) {
      if (listBuilder_ == null) {
        return list_.get(index);  } else {
        return listBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public java.util.List<? extends org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
         getListOrBuilderList() {
      if (listBuilder_ != null) {
        return listBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(list_);
      }
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode.Builder addListBuilder() {
      return getListFieldBuilder().addBuilder(
          org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode.Builder addListBuilder(
        int index) {
      return getListFieldBuilder().addBuilder(
          index, org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance());
    }
    /**
     * <code>repeated .ballista.protobuf.PhysicalExprNode list = 2;</code>
     */
    public java.util.List<org.ballistacompute.protobuf.PhysicalExprNode.Builder> 
         getListBuilderList() {
      return getListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
        getListFieldBuilder() {
      if (listBuilder_ == null) {
        listBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder>(
                list_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        list_ = null;
      }
      return listBuilder_;
    }

    private boolean negated_ ;
    /**
     * <code>bool negated = 3;</code>
     * @return The negated.
     */
    @java.lang.Override
    public boolean getNegated() {
      return negated_;
    }
    /**
     * <code>bool negated = 3;</code>
     * @param value The negated to set.
     * @return This builder for chaining.
     */
    public Builder setNegated(boolean value) {
      
      negated_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool negated = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNegated() {
      
      negated_ = false;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.PhysicalInListNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.PhysicalInListNode)
  private static final org.ballistacompute.protobuf.PhysicalInListNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.PhysicalInListNode();
  }

  public static org.ballistacompute.protobuf.PhysicalInListNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PhysicalInListNode>
      PARSER = new com.google.protobuf.AbstractParser<PhysicalInListNode>() {
    @java.lang.Override
    public PhysicalInListNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PhysicalInListNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PhysicalInListNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PhysicalInListNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalInListNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

