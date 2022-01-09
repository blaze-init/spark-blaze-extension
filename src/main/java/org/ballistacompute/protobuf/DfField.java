// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.DfField}
 */
public final class DfField extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.DfField)
    DfFieldOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DfField.newBuilder() to construct.
  private DfField(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DfField() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DfField();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DfField(
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
            org.ballistacompute.protobuf.Field.Builder subBuilder = null;
            if (field_ != null) {
              subBuilder = field_.toBuilder();
            }
            field_ = input.readMessage(org.ballistacompute.protobuf.Field.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(field_);
              field_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.ballistacompute.protobuf.ColumnRelation.Builder subBuilder = null;
            if (qualifier_ != null) {
              subBuilder = qualifier_.toBuilder();
            }
            qualifier_ = input.readMessage(org.ballistacompute.protobuf.ColumnRelation.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(qualifier_);
              qualifier_ = subBuilder.buildPartial();
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_DfField_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_DfField_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.DfField.class, org.ballistacompute.protobuf.DfField.Builder.class);
  }

  public static final int FIELD_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.Field field_;
  /**
   * <code>.ballista.protobuf.Field field = 1;</code>
   * @return Whether the field field is set.
   */
  @java.lang.Override
  public boolean hasField() {
    return field_ != null;
  }
  /**
   * <code>.ballista.protobuf.Field field = 1;</code>
   * @return The field.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.Field getField() {
    return field_ == null ? org.ballistacompute.protobuf.Field.getDefaultInstance() : field_;
  }
  /**
   * <code>.ballista.protobuf.Field field = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.FieldOrBuilder getFieldOrBuilder() {
    return getField();
  }

  public static final int QUALIFIER_FIELD_NUMBER = 2;
  private org.ballistacompute.protobuf.ColumnRelation qualifier_;
  /**
   * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
   * @return Whether the qualifier field is set.
   */
  @java.lang.Override
  public boolean hasQualifier() {
    return qualifier_ != null;
  }
  /**
   * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
   * @return The qualifier.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ColumnRelation getQualifier() {
    return qualifier_ == null ? org.ballistacompute.protobuf.ColumnRelation.getDefaultInstance() : qualifier_;
  }
  /**
   * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ColumnRelationOrBuilder getQualifierOrBuilder() {
    return getQualifier();
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
    if (field_ != null) {
      output.writeMessage(1, getField());
    }
    if (qualifier_ != null) {
      output.writeMessage(2, getQualifier());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (field_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getField());
    }
    if (qualifier_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getQualifier());
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
    if (!(obj instanceof org.ballistacompute.protobuf.DfField)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.DfField other = (org.ballistacompute.protobuf.DfField) obj;

    if (hasField() != other.hasField()) return false;
    if (hasField()) {
      if (!getField()
          .equals(other.getField())) return false;
    }
    if (hasQualifier() != other.hasQualifier()) return false;
    if (hasQualifier()) {
      if (!getQualifier()
          .equals(other.getQualifier())) return false;
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
    if (hasField()) {
      hash = (37 * hash) + FIELD_FIELD_NUMBER;
      hash = (53 * hash) + getField().hashCode();
    }
    if (hasQualifier()) {
      hash = (37 * hash) + QUALIFIER_FIELD_NUMBER;
      hash = (53 * hash) + getQualifier().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.DfField parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.DfField parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.DfField parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.DfField parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.DfField prototype) {
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
   * Protobuf type {@code ballista.protobuf.DfField}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.DfField)
      org.ballistacompute.protobuf.DfFieldOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_DfField_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_DfField_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.DfField.class, org.ballistacompute.protobuf.DfField.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.DfField.newBuilder()
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
      if (fieldBuilder_ == null) {
        field_ = null;
      } else {
        field_ = null;
        fieldBuilder_ = null;
      }
      if (qualifierBuilder_ == null) {
        qualifier_ = null;
      } else {
        qualifier_ = null;
        qualifierBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_DfField_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.DfField getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.DfField.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.DfField build() {
      org.ballistacompute.protobuf.DfField result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.DfField buildPartial() {
      org.ballistacompute.protobuf.DfField result = new org.ballistacompute.protobuf.DfField(this);
      if (fieldBuilder_ == null) {
        result.field_ = field_;
      } else {
        result.field_ = fieldBuilder_.build();
      }
      if (qualifierBuilder_ == null) {
        result.qualifier_ = qualifier_;
      } else {
        result.qualifier_ = qualifierBuilder_.build();
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
      if (other instanceof org.ballistacompute.protobuf.DfField) {
        return mergeFrom((org.ballistacompute.protobuf.DfField)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.DfField other) {
      if (other == org.ballistacompute.protobuf.DfField.getDefaultInstance()) return this;
      if (other.hasField()) {
        mergeField(other.getField());
      }
      if (other.hasQualifier()) {
        mergeQualifier(other.getQualifier());
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
      org.ballistacompute.protobuf.DfField parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.DfField) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.Field field_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.Field, org.ballistacompute.protobuf.Field.Builder, org.ballistacompute.protobuf.FieldOrBuilder> fieldBuilder_;
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     * @return Whether the field field is set.
     */
    public boolean hasField() {
      return fieldBuilder_ != null || field_ != null;
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     * @return The field.
     */
    public org.ballistacompute.protobuf.Field getField() {
      if (fieldBuilder_ == null) {
        return field_ == null ? org.ballistacompute.protobuf.Field.getDefaultInstance() : field_;
      } else {
        return fieldBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public Builder setField(org.ballistacompute.protobuf.Field value) {
      if (fieldBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        field_ = value;
        onChanged();
      } else {
        fieldBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public Builder setField(
        org.ballistacompute.protobuf.Field.Builder builderForValue) {
      if (fieldBuilder_ == null) {
        field_ = builderForValue.build();
        onChanged();
      } else {
        fieldBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public Builder mergeField(org.ballistacompute.protobuf.Field value) {
      if (fieldBuilder_ == null) {
        if (field_ != null) {
          field_ =
            org.ballistacompute.protobuf.Field.newBuilder(field_).mergeFrom(value).buildPartial();
        } else {
          field_ = value;
        }
        onChanged();
      } else {
        fieldBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public Builder clearField() {
      if (fieldBuilder_ == null) {
        field_ = null;
        onChanged();
      } else {
        field_ = null;
        fieldBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public org.ballistacompute.protobuf.Field.Builder getFieldBuilder() {
      
      onChanged();
      return getFieldFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    public org.ballistacompute.protobuf.FieldOrBuilder getFieldOrBuilder() {
      if (fieldBuilder_ != null) {
        return fieldBuilder_.getMessageOrBuilder();
      } else {
        return field_ == null ?
            org.ballistacompute.protobuf.Field.getDefaultInstance() : field_;
      }
    }
    /**
     * <code>.ballista.protobuf.Field field = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.Field, org.ballistacompute.protobuf.Field.Builder, org.ballistacompute.protobuf.FieldOrBuilder> 
        getFieldFieldBuilder() {
      if (fieldBuilder_ == null) {
        fieldBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.Field, org.ballistacompute.protobuf.Field.Builder, org.ballistacompute.protobuf.FieldOrBuilder>(
                getField(),
                getParentForChildren(),
                isClean());
        field_ = null;
      }
      return fieldBuilder_;
    }

    private org.ballistacompute.protobuf.ColumnRelation qualifier_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ColumnRelation, org.ballistacompute.protobuf.ColumnRelation.Builder, org.ballistacompute.protobuf.ColumnRelationOrBuilder> qualifierBuilder_;
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     * @return Whether the qualifier field is set.
     */
    public boolean hasQualifier() {
      return qualifierBuilder_ != null || qualifier_ != null;
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     * @return The qualifier.
     */
    public org.ballistacompute.protobuf.ColumnRelation getQualifier() {
      if (qualifierBuilder_ == null) {
        return qualifier_ == null ? org.ballistacompute.protobuf.ColumnRelation.getDefaultInstance() : qualifier_;
      } else {
        return qualifierBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public Builder setQualifier(org.ballistacompute.protobuf.ColumnRelation value) {
      if (qualifierBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        qualifier_ = value;
        onChanged();
      } else {
        qualifierBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public Builder setQualifier(
        org.ballistacompute.protobuf.ColumnRelation.Builder builderForValue) {
      if (qualifierBuilder_ == null) {
        qualifier_ = builderForValue.build();
        onChanged();
      } else {
        qualifierBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public Builder mergeQualifier(org.ballistacompute.protobuf.ColumnRelation value) {
      if (qualifierBuilder_ == null) {
        if (qualifier_ != null) {
          qualifier_ =
            org.ballistacompute.protobuf.ColumnRelation.newBuilder(qualifier_).mergeFrom(value).buildPartial();
        } else {
          qualifier_ = value;
        }
        onChanged();
      } else {
        qualifierBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public Builder clearQualifier() {
      if (qualifierBuilder_ == null) {
        qualifier_ = null;
        onChanged();
      } else {
        qualifier_ = null;
        qualifierBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public org.ballistacompute.protobuf.ColumnRelation.Builder getQualifierBuilder() {
      
      onChanged();
      return getQualifierFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    public org.ballistacompute.protobuf.ColumnRelationOrBuilder getQualifierOrBuilder() {
      if (qualifierBuilder_ != null) {
        return qualifierBuilder_.getMessageOrBuilder();
      } else {
        return qualifier_ == null ?
            org.ballistacompute.protobuf.ColumnRelation.getDefaultInstance() : qualifier_;
      }
    }
    /**
     * <code>.ballista.protobuf.ColumnRelation qualifier = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ColumnRelation, org.ballistacompute.protobuf.ColumnRelation.Builder, org.ballistacompute.protobuf.ColumnRelationOrBuilder> 
        getQualifierFieldBuilder() {
      if (qualifierBuilder_ == null) {
        qualifierBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.ColumnRelation, org.ballistacompute.protobuf.ColumnRelation.Builder, org.ballistacompute.protobuf.ColumnRelationOrBuilder>(
                getQualifier(),
                getParentForChildren(),
                isClean());
        qualifier_ = null;
      }
      return qualifierBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.DfField)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.DfField)
  private static final org.ballistacompute.protobuf.DfField DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.DfField();
  }

  public static org.ballistacompute.protobuf.DfField getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DfField>
      PARSER = new com.google.protobuf.AbstractParser<DfField>() {
    @java.lang.Override
    public DfField parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DfField(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DfField> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DfField> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.DfField getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
