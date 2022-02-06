// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * Protobuf type {@code plan.protobuf.UnresolvedShuffleExecNode}
 */
public final class UnresolvedShuffleExecNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:plan.protobuf.UnresolvedShuffleExecNode)
    UnresolvedShuffleExecNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UnresolvedShuffleExecNode.newBuilder() to construct.
  private UnresolvedShuffleExecNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UnresolvedShuffleExecNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UnresolvedShuffleExecNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UnresolvedShuffleExecNode(
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
          case 8: {

            stageId_ = input.readUInt32();
            break;
          }
          case 18: {
            org.blaze.protobuf.Schema.Builder subBuilder = null;
            if (schema_ != null) {
              subBuilder = schema_.toBuilder();
            }
            schema_ = input.readMessage(org.blaze.protobuf.Schema.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(schema_);
              schema_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {

            inputPartitionCount_ = input.readUInt32();
            break;
          }
          case 32: {

            outputPartitionCount_ = input.readUInt32();
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
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_UnresolvedShuffleExecNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_UnresolvedShuffleExecNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.blaze.protobuf.UnresolvedShuffleExecNode.class, org.blaze.protobuf.UnresolvedShuffleExecNode.Builder.class);
  }

  public static final int STAGE_ID_FIELD_NUMBER = 1;
  private int stageId_;
  /**
   * <code>uint32 stage_id = 1;</code>
   * @return The stageId.
   */
  @java.lang.Override
  public int getStageId() {
    return stageId_;
  }

  public static final int SCHEMA_FIELD_NUMBER = 2;
  private org.blaze.protobuf.Schema schema_;
  /**
   * <code>.plan.protobuf.Schema schema = 2;</code>
   * @return Whether the schema field is set.
   */
  @java.lang.Override
  public boolean hasSchema() {
    return schema_ != null;
  }
  /**
   * <code>.plan.protobuf.Schema schema = 2;</code>
   * @return The schema.
   */
  @java.lang.Override
  public org.blaze.protobuf.Schema getSchema() {
    return schema_ == null ? org.blaze.protobuf.Schema.getDefaultInstance() : schema_;
  }
  /**
   * <code>.plan.protobuf.Schema schema = 2;</code>
   */
  @java.lang.Override
  public org.blaze.protobuf.SchemaOrBuilder getSchemaOrBuilder() {
    return getSchema();
  }

  public static final int INPUT_PARTITION_COUNT_FIELD_NUMBER = 3;
  private int inputPartitionCount_;
  /**
   * <code>uint32 input_partition_count = 3;</code>
   * @return The inputPartitionCount.
   */
  @java.lang.Override
  public int getInputPartitionCount() {
    return inputPartitionCount_;
  }

  public static final int OUTPUT_PARTITION_COUNT_FIELD_NUMBER = 4;
  private int outputPartitionCount_;
  /**
   * <code>uint32 output_partition_count = 4;</code>
   * @return The outputPartitionCount.
   */
  @java.lang.Override
  public int getOutputPartitionCount() {
    return outputPartitionCount_;
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
    if (stageId_ != 0) {
      output.writeUInt32(1, stageId_);
    }
    if (schema_ != null) {
      output.writeMessage(2, getSchema());
    }
    if (inputPartitionCount_ != 0) {
      output.writeUInt32(3, inputPartitionCount_);
    }
    if (outputPartitionCount_ != 0) {
      output.writeUInt32(4, outputPartitionCount_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (stageId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, stageId_);
    }
    if (schema_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSchema());
    }
    if (inputPartitionCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, inputPartitionCount_);
    }
    if (outputPartitionCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, outputPartitionCount_);
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
    if (!(obj instanceof org.blaze.protobuf.UnresolvedShuffleExecNode)) {
      return super.equals(obj);
    }
    org.blaze.protobuf.UnresolvedShuffleExecNode other = (org.blaze.protobuf.UnresolvedShuffleExecNode) obj;

    if (getStageId()
        != other.getStageId()) return false;
    if (hasSchema() != other.hasSchema()) return false;
    if (hasSchema()) {
      if (!getSchema()
          .equals(other.getSchema())) return false;
    }
    if (getInputPartitionCount()
        != other.getInputPartitionCount()) return false;
    if (getOutputPartitionCount()
        != other.getOutputPartitionCount()) return false;
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
    hash = (37 * hash) + STAGE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getStageId();
    if (hasSchema()) {
      hash = (37 * hash) + SCHEMA_FIELD_NUMBER;
      hash = (53 * hash) + getSchema().hashCode();
    }
    hash = (37 * hash) + INPUT_PARTITION_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getInputPartitionCount();
    hash = (37 * hash) + OUTPUT_PARTITION_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getOutputPartitionCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.UnresolvedShuffleExecNode parseFrom(
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
  public static Builder newBuilder(org.blaze.protobuf.UnresolvedShuffleExecNode prototype) {
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
   * Protobuf type {@code plan.protobuf.UnresolvedShuffleExecNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:plan.protobuf.UnresolvedShuffleExecNode)
      org.blaze.protobuf.UnresolvedShuffleExecNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_UnresolvedShuffleExecNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_UnresolvedShuffleExecNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.blaze.protobuf.UnresolvedShuffleExecNode.class, org.blaze.protobuf.UnresolvedShuffleExecNode.Builder.class);
    }

    // Construct using org.blaze.protobuf.UnresolvedShuffleExecNode.newBuilder()
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
      stageId_ = 0;

      if (schemaBuilder_ == null) {
        schema_ = null;
      } else {
        schema_ = null;
        schemaBuilder_ = null;
      }
      inputPartitionCount_ = 0;

      outputPartitionCount_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_UnresolvedShuffleExecNode_descriptor;
    }

    @java.lang.Override
    public org.blaze.protobuf.UnresolvedShuffleExecNode getDefaultInstanceForType() {
      return org.blaze.protobuf.UnresolvedShuffleExecNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.blaze.protobuf.UnresolvedShuffleExecNode build() {
      org.blaze.protobuf.UnresolvedShuffleExecNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.blaze.protobuf.UnresolvedShuffleExecNode buildPartial() {
      org.blaze.protobuf.UnresolvedShuffleExecNode result = new org.blaze.protobuf.UnresolvedShuffleExecNode(this);
      result.stageId_ = stageId_;
      if (schemaBuilder_ == null) {
        result.schema_ = schema_;
      } else {
        result.schema_ = schemaBuilder_.build();
      }
      result.inputPartitionCount_ = inputPartitionCount_;
      result.outputPartitionCount_ = outputPartitionCount_;
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
      if (other instanceof org.blaze.protobuf.UnresolvedShuffleExecNode) {
        return mergeFrom((org.blaze.protobuf.UnresolvedShuffleExecNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.blaze.protobuf.UnresolvedShuffleExecNode other) {
      if (other == org.blaze.protobuf.UnresolvedShuffleExecNode.getDefaultInstance()) return this;
      if (other.getStageId() != 0) {
        setStageId(other.getStageId());
      }
      if (other.hasSchema()) {
        mergeSchema(other.getSchema());
      }
      if (other.getInputPartitionCount() != 0) {
        setInputPartitionCount(other.getInputPartitionCount());
      }
      if (other.getOutputPartitionCount() != 0) {
        setOutputPartitionCount(other.getOutputPartitionCount());
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
      org.blaze.protobuf.UnresolvedShuffleExecNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.blaze.protobuf.UnresolvedShuffleExecNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int stageId_ ;
    /**
     * <code>uint32 stage_id = 1;</code>
     * @return The stageId.
     */
    @java.lang.Override
    public int getStageId() {
      return stageId_;
    }
    /**
     * <code>uint32 stage_id = 1;</code>
     * @param value The stageId to set.
     * @return This builder for chaining.
     */
    public Builder setStageId(int value) {
      
      stageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 stage_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStageId() {
      
      stageId_ = 0;
      onChanged();
      return this;
    }

    private org.blaze.protobuf.Schema schema_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.Schema, org.blaze.protobuf.Schema.Builder, org.blaze.protobuf.SchemaOrBuilder> schemaBuilder_;
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     * @return Whether the schema field is set.
     */
    public boolean hasSchema() {
      return schemaBuilder_ != null || schema_ != null;
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     * @return The schema.
     */
    public org.blaze.protobuf.Schema getSchema() {
      if (schemaBuilder_ == null) {
        return schema_ == null ? org.blaze.protobuf.Schema.getDefaultInstance() : schema_;
      } else {
        return schemaBuilder_.getMessage();
      }
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public Builder setSchema(org.blaze.protobuf.Schema value) {
      if (schemaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        schema_ = value;
        onChanged();
      } else {
        schemaBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public Builder setSchema(
        org.blaze.protobuf.Schema.Builder builderForValue) {
      if (schemaBuilder_ == null) {
        schema_ = builderForValue.build();
        onChanged();
      } else {
        schemaBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public Builder mergeSchema(org.blaze.protobuf.Schema value) {
      if (schemaBuilder_ == null) {
        if (schema_ != null) {
          schema_ =
            org.blaze.protobuf.Schema.newBuilder(schema_).mergeFrom(value).buildPartial();
        } else {
          schema_ = value;
        }
        onChanged();
      } else {
        schemaBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public Builder clearSchema() {
      if (schemaBuilder_ == null) {
        schema_ = null;
        onChanged();
      } else {
        schema_ = null;
        schemaBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public org.blaze.protobuf.Schema.Builder getSchemaBuilder() {
      
      onChanged();
      return getSchemaFieldBuilder().getBuilder();
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    public org.blaze.protobuf.SchemaOrBuilder getSchemaOrBuilder() {
      if (schemaBuilder_ != null) {
        return schemaBuilder_.getMessageOrBuilder();
      } else {
        return schema_ == null ?
            org.blaze.protobuf.Schema.getDefaultInstance() : schema_;
      }
    }
    /**
     * <code>.plan.protobuf.Schema schema = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.Schema, org.blaze.protobuf.Schema.Builder, org.blaze.protobuf.SchemaOrBuilder> 
        getSchemaFieldBuilder() {
      if (schemaBuilder_ == null) {
        schemaBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.blaze.protobuf.Schema, org.blaze.protobuf.Schema.Builder, org.blaze.protobuf.SchemaOrBuilder>(
                getSchema(),
                getParentForChildren(),
                isClean());
        schema_ = null;
      }
      return schemaBuilder_;
    }

    private int inputPartitionCount_ ;
    /**
     * <code>uint32 input_partition_count = 3;</code>
     * @return The inputPartitionCount.
     */
    @java.lang.Override
    public int getInputPartitionCount() {
      return inputPartitionCount_;
    }
    /**
     * <code>uint32 input_partition_count = 3;</code>
     * @param value The inputPartitionCount to set.
     * @return This builder for chaining.
     */
    public Builder setInputPartitionCount(int value) {
      
      inputPartitionCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 input_partition_count = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearInputPartitionCount() {
      
      inputPartitionCount_ = 0;
      onChanged();
      return this;
    }

    private int outputPartitionCount_ ;
    /**
     * <code>uint32 output_partition_count = 4;</code>
     * @return The outputPartitionCount.
     */
    @java.lang.Override
    public int getOutputPartitionCount() {
      return outputPartitionCount_;
    }
    /**
     * <code>uint32 output_partition_count = 4;</code>
     * @param value The outputPartitionCount to set.
     * @return This builder for chaining.
     */
    public Builder setOutputPartitionCount(int value) {
      
      outputPartitionCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 output_partition_count = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearOutputPartitionCount() {
      
      outputPartitionCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:plan.protobuf.UnresolvedShuffleExecNode)
  }

  // @@protoc_insertion_point(class_scope:plan.protobuf.UnresolvedShuffleExecNode)
  private static final org.blaze.protobuf.UnresolvedShuffleExecNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.blaze.protobuf.UnresolvedShuffleExecNode();
  }

  public static org.blaze.protobuf.UnresolvedShuffleExecNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UnresolvedShuffleExecNode>
      PARSER = new com.google.protobuf.AbstractParser<UnresolvedShuffleExecNode>() {
    @java.lang.Override
    public UnresolvedShuffleExecNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UnresolvedShuffleExecNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UnresolvedShuffleExecNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UnresolvedShuffleExecNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.blaze.protobuf.UnresolvedShuffleExecNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

