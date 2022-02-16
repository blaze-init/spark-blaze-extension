// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * Protobuf type {@code plan.protobuf.ShuffleReaderExecNode}
 */
public final class ShuffleReaderExecNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:plan.protobuf.ShuffleReaderExecNode)
    ShuffleReaderExecNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ShuffleReaderExecNode.newBuilder() to construct.
  private ShuffleReaderExecNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ShuffleReaderExecNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ShuffleReaderExecNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ShuffleReaderExecNode(
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
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_ShuffleReaderExecNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_ShuffleReaderExecNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.blaze.protobuf.ShuffleReaderExecNode.class, org.blaze.protobuf.ShuffleReaderExecNode.Builder.class);
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
    if (schema_ != null) {
      output.writeMessage(2, getSchema());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (schema_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSchema());
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
    if (!(obj instanceof org.blaze.protobuf.ShuffleReaderExecNode)) {
      return super.equals(obj);
    }
    org.blaze.protobuf.ShuffleReaderExecNode other = (org.blaze.protobuf.ShuffleReaderExecNode) obj;

    if (hasSchema() != other.hasSchema()) return false;
    if (hasSchema()) {
      if (!getSchema()
          .equals(other.getSchema())) return false;
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
    if (hasSchema()) {
      hash = (37 * hash) + SCHEMA_FIELD_NUMBER;
      hash = (53 * hash) + getSchema().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.ShuffleReaderExecNode parseFrom(
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
  public static Builder newBuilder(org.blaze.protobuf.ShuffleReaderExecNode prototype) {
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
   * Protobuf type {@code plan.protobuf.ShuffleReaderExecNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:plan.protobuf.ShuffleReaderExecNode)
      org.blaze.protobuf.ShuffleReaderExecNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_ShuffleReaderExecNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_ShuffleReaderExecNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.blaze.protobuf.ShuffleReaderExecNode.class, org.blaze.protobuf.ShuffleReaderExecNode.Builder.class);
    }

    // Construct using org.blaze.protobuf.ShuffleReaderExecNode.newBuilder()
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
      if (schemaBuilder_ == null) {
        schema_ = null;
      } else {
        schema_ = null;
        schemaBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_ShuffleReaderExecNode_descriptor;
    }

    @java.lang.Override
    public org.blaze.protobuf.ShuffleReaderExecNode getDefaultInstanceForType() {
      return org.blaze.protobuf.ShuffleReaderExecNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.blaze.protobuf.ShuffleReaderExecNode build() {
      org.blaze.protobuf.ShuffleReaderExecNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.blaze.protobuf.ShuffleReaderExecNode buildPartial() {
      org.blaze.protobuf.ShuffleReaderExecNode result = new org.blaze.protobuf.ShuffleReaderExecNode(this);
      if (schemaBuilder_ == null) {
        result.schema_ = schema_;
      } else {
        result.schema_ = schemaBuilder_.build();
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
      if (other instanceof org.blaze.protobuf.ShuffleReaderExecNode) {
        return mergeFrom((org.blaze.protobuf.ShuffleReaderExecNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.blaze.protobuf.ShuffleReaderExecNode other) {
      if (other == org.blaze.protobuf.ShuffleReaderExecNode.getDefaultInstance()) return this;
      if (other.hasSchema()) {
        mergeSchema(other.getSchema());
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
      org.blaze.protobuf.ShuffleReaderExecNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.blaze.protobuf.ShuffleReaderExecNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
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


    // @@protoc_insertion_point(builder_scope:plan.protobuf.ShuffleReaderExecNode)
  }

  // @@protoc_insertion_point(class_scope:plan.protobuf.ShuffleReaderExecNode)
  private static final org.blaze.protobuf.ShuffleReaderExecNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.blaze.protobuf.ShuffleReaderExecNode();
  }

  public static org.blaze.protobuf.ShuffleReaderExecNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ShuffleReaderExecNode>
      PARSER = new com.google.protobuf.AbstractParser<ShuffleReaderExecNode>() {
    @java.lang.Override
    public ShuffleReaderExecNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ShuffleReaderExecNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ShuffleReaderExecNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ShuffleReaderExecNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.blaze.protobuf.ShuffleReaderExecNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
