// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.CrossJoinExecNode}
 */
public final class CrossJoinExecNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.CrossJoinExecNode)
    CrossJoinExecNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CrossJoinExecNode.newBuilder() to construct.
  private CrossJoinExecNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CrossJoinExecNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CrossJoinExecNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CrossJoinExecNode(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            org.ballistacompute.protobuf.PhysicalPlanNode.Builder subBuilder = null;
            if (left_ != null) {
              subBuilder = left_.toBuilder();
            }
            left_ = input.readMessage(org.ballistacompute.protobuf.PhysicalPlanNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(left_);
              left_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.ballistacompute.protobuf.PhysicalPlanNode.Builder subBuilder = null;
            if (right_ != null) {
              subBuilder = right_.toBuilder();
            }
            right_ = input.readMessage(org.ballistacompute.protobuf.PhysicalPlanNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(right_);
              right_ = subBuilder.buildPartial();
            }

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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CrossJoinExecNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CrossJoinExecNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.CrossJoinExecNode.class, org.ballistacompute.protobuf.CrossJoinExecNode.Builder.class);
  }

  public static final int LEFT_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.PhysicalPlanNode left_;
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   * @return Whether the left field is set.
   */
  @java.lang.Override
  public boolean hasLeft() {
    return left_ != null;
  }
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   * @return The left.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalPlanNode getLeft() {
    return left_ == null ? org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : left_;
  }
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getLeftOrBuilder() {
    return getLeft();
  }

  public static final int RIGHT_FIELD_NUMBER = 2;
  private org.ballistacompute.protobuf.PhysicalPlanNode right_;
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   * @return Whether the right field is set.
   */
  @java.lang.Override
  public boolean hasRight() {
    return right_ != null;
  }
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   * @return The right.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalPlanNode getRight() {
    return right_ == null ? org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : right_;
  }
  /**
   * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getRightOrBuilder() {
    return getRight();
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
    if (left_ != null) {
      output.writeMessage(1, getLeft());
    }
    if (right_ != null) {
      output.writeMessage(2, getRight());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (left_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLeft());
    }
    if (right_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getRight());
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
    if (!(obj instanceof org.ballistacompute.protobuf.CrossJoinExecNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.CrossJoinExecNode other = (org.ballistacompute.protobuf.CrossJoinExecNode) obj;

    if (hasLeft() != other.hasLeft()) return false;
    if (hasLeft()) {
      if (!getLeft()
          .equals(other.getLeft())) return false;
    }
    if (hasRight() != other.hasRight()) return false;
    if (hasRight()) {
      if (!getRight()
          .equals(other.getRight())) return false;
    }
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
    if (hasLeft()) {
      hash = (37 * hash) + LEFT_FIELD_NUMBER;
      hash = (53 * hash) + getLeft().hashCode();
    }
    if (hasRight()) {
      hash = (37 * hash) + RIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getRight().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CrossJoinExecNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.CrossJoinExecNode prototype) {
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
   * Protobuf type {@code ballista.protobuf.CrossJoinExecNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.CrossJoinExecNode)
      org.ballistacompute.protobuf.CrossJoinExecNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CrossJoinExecNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CrossJoinExecNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.CrossJoinExecNode.class, org.ballistacompute.protobuf.CrossJoinExecNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.CrossJoinExecNode.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (leftBuilder_ == null) {
        left_ = null;
      } else {
        left_ = null;
        leftBuilder_ = null;
      }
      if (rightBuilder_ == null) {
        right_ = null;
      } else {
        right_ = null;
        rightBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CrossJoinExecNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CrossJoinExecNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.CrossJoinExecNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CrossJoinExecNode build() {
      org.ballistacompute.protobuf.CrossJoinExecNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CrossJoinExecNode buildPartial() {
      org.ballistacompute.protobuf.CrossJoinExecNode result = new org.ballistacompute.protobuf.CrossJoinExecNode(this);
      if (leftBuilder_ == null) {
        result.left_ = left_;
      } else {
        result.left_ = leftBuilder_.build();
      }
      if (rightBuilder_ == null) {
        result.right_ = right_;
      } else {
        result.right_ = rightBuilder_.build();
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
      if (other instanceof org.ballistacompute.protobuf.CrossJoinExecNode) {
        return mergeFrom((org.ballistacompute.protobuf.CrossJoinExecNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.CrossJoinExecNode other) {
      if (other == org.ballistacompute.protobuf.CrossJoinExecNode.getDefaultInstance()) return this;
      if (other.hasLeft()) {
        mergeLeft(other.getLeft());
      }
      if (other.hasRight()) {
        mergeRight(other.getRight());
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
      org.ballistacompute.protobuf.CrossJoinExecNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.CrossJoinExecNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.PhysicalPlanNode left_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder> leftBuilder_;
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     * @return Whether the left field is set.
     */
    public boolean hasLeft() {
      return leftBuilder_ != null || left_ != null;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     * @return The left.
     */
    public org.ballistacompute.protobuf.PhysicalPlanNode getLeft() {
      if (leftBuilder_ == null) {
        return left_ == null ? org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : left_;
      } else {
        return leftBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public Builder setLeft(org.ballistacompute.protobuf.PhysicalPlanNode value) {
      if (leftBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        left_ = value;
        onChanged();
      } else {
        leftBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public Builder setLeft(
        org.ballistacompute.protobuf.PhysicalPlanNode.Builder builderForValue) {
      if (leftBuilder_ == null) {
        left_ = builderForValue.build();
        onChanged();
      } else {
        leftBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public Builder mergeLeft(org.ballistacompute.protobuf.PhysicalPlanNode value) {
      if (leftBuilder_ == null) {
        if (left_ != null) {
          left_ =
            org.ballistacompute.protobuf.PhysicalPlanNode.newBuilder(left_).mergeFrom(value).buildPartial();
        } else {
          left_ = value;
        }
        onChanged();
      } else {
        leftBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public Builder clearLeft() {
      if (leftBuilder_ == null) {
        left_ = null;
        onChanged();
      } else {
        left_ = null;
        leftBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalPlanNode.Builder getLeftBuilder() {
      
      onChanged();
      return getLeftFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getLeftOrBuilder() {
      if (leftBuilder_ != null) {
        return leftBuilder_.getMessageOrBuilder();
      } else {
        return left_ == null ?
            org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : left_;
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode left = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder> 
        getLeftFieldBuilder() {
      if (leftBuilder_ == null) {
        leftBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder>(
                getLeft(),
                getParentForChildren(),
                isClean());
        left_ = null;
      }
      return leftBuilder_;
    }

    private org.ballistacompute.protobuf.PhysicalPlanNode right_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder> rightBuilder_;
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     * @return Whether the right field is set.
     */
    public boolean hasRight() {
      return rightBuilder_ != null || right_ != null;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     * @return The right.
     */
    public org.ballistacompute.protobuf.PhysicalPlanNode getRight() {
      if (rightBuilder_ == null) {
        return right_ == null ? org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : right_;
      } else {
        return rightBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public Builder setRight(org.ballistacompute.protobuf.PhysicalPlanNode value) {
      if (rightBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        right_ = value;
        onChanged();
      } else {
        rightBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public Builder setRight(
        org.ballistacompute.protobuf.PhysicalPlanNode.Builder builderForValue) {
      if (rightBuilder_ == null) {
        right_ = builderForValue.build();
        onChanged();
      } else {
        rightBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public Builder mergeRight(org.ballistacompute.protobuf.PhysicalPlanNode value) {
      if (rightBuilder_ == null) {
        if (right_ != null) {
          right_ =
            org.ballistacompute.protobuf.PhysicalPlanNode.newBuilder(right_).mergeFrom(value).buildPartial();
        } else {
          right_ = value;
        }
        onChanged();
      } else {
        rightBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public Builder clearRight() {
      if (rightBuilder_ == null) {
        right_ = null;
        onChanged();
      } else {
        right_ = null;
        rightBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalPlanNode.Builder getRightBuilder() {
      
      onChanged();
      return getRightFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    public org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder getRightOrBuilder() {
      if (rightBuilder_ != null) {
        return rightBuilder_.getMessageOrBuilder();
      } else {
        return right_ == null ?
            org.ballistacompute.protobuf.PhysicalPlanNode.getDefaultInstance() : right_;
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalPlanNode right = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder> 
        getRightFieldBuilder() {
      if (rightBuilder_ == null) {
        rightBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.PhysicalPlanNode, org.ballistacompute.protobuf.PhysicalPlanNode.Builder, org.ballistacompute.protobuf.PhysicalPlanNodeOrBuilder>(
                getRight(),
                getParentForChildren(),
                isClean());
        right_ = null;
      }
      return rightBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.CrossJoinExecNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.CrossJoinExecNode)
  private static final org.ballistacompute.protobuf.CrossJoinExecNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.CrossJoinExecNode();
  }

  public static org.ballistacompute.protobuf.CrossJoinExecNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CrossJoinExecNode>
      PARSER = new com.google.protobuf.AbstractParser<CrossJoinExecNode>() {
    @java.lang.Override
    public CrossJoinExecNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CrossJoinExecNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CrossJoinExecNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CrossJoinExecNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.CrossJoinExecNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

