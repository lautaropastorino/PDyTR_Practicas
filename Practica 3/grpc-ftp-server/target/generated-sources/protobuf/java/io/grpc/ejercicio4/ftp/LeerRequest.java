// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FtpService.proto

package io.grpc.ejercicio4.ftp;

/**
 * Protobuf type {@code pdytr.ejercicio4.grpc.LeerRequest}
 */
public final class LeerRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:pdytr.ejercicio4.grpc.LeerRequest)
    LeerRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LeerRequest.newBuilder() to construct.
  private LeerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeerRequest() {
    archivo_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LeerRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeerRequest(
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
            java.lang.String s = input.readStringRequireUtf8();

            archivo_ = s;
            break;
          }
          case 16: {

            posicion_ = input.readInt32();
            break;
          }
          case 24: {

            bytesALeer_ = input.readInt32();
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
    return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.ejercicio4.ftp.LeerRequest.class, io.grpc.ejercicio4.ftp.LeerRequest.Builder.class);
  }

  public static final int ARCHIVO_FIELD_NUMBER = 1;
  private volatile java.lang.Object archivo_;
  /**
   * <code>string archivo = 1;</code>
   * @return The archivo.
   */
  @java.lang.Override
  public java.lang.String getArchivo() {
    java.lang.Object ref = archivo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      archivo_ = s;
      return s;
    }
  }
  /**
   * <code>string archivo = 1;</code>
   * @return The bytes for archivo.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getArchivoBytes() {
    java.lang.Object ref = archivo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      archivo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int POSICION_FIELD_NUMBER = 2;
  private int posicion_;
  /**
   * <code>int32 posicion = 2;</code>
   * @return The posicion.
   */
  @java.lang.Override
  public int getPosicion() {
    return posicion_;
  }

  public static final int BYTESALEER_FIELD_NUMBER = 3;
  private int bytesALeer_;
  /**
   * <code>int32 bytesALeer = 3;</code>
   * @return The bytesALeer.
   */
  @java.lang.Override
  public int getBytesALeer() {
    return bytesALeer_;
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
    if (!getArchivoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, archivo_);
    }
    if (posicion_ != 0) {
      output.writeInt32(2, posicion_);
    }
    if (bytesALeer_ != 0) {
      output.writeInt32(3, bytesALeer_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getArchivoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, archivo_);
    }
    if (posicion_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, posicion_);
    }
    if (bytesALeer_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, bytesALeer_);
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
    if (!(obj instanceof io.grpc.ejercicio4.ftp.LeerRequest)) {
      return super.equals(obj);
    }
    io.grpc.ejercicio4.ftp.LeerRequest other = (io.grpc.ejercicio4.ftp.LeerRequest) obj;

    if (!getArchivo()
        .equals(other.getArchivo())) return false;
    if (getPosicion()
        != other.getPosicion()) return false;
    if (getBytesALeer()
        != other.getBytesALeer()) return false;
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
    hash = (37 * hash) + ARCHIVO_FIELD_NUMBER;
    hash = (53 * hash) + getArchivo().hashCode();
    hash = (37 * hash) + POSICION_FIELD_NUMBER;
    hash = (53 * hash) + getPosicion();
    hash = (37 * hash) + BYTESALEER_FIELD_NUMBER;
    hash = (53 * hash) + getBytesALeer();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerRequest parseFrom(
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
  public static Builder newBuilder(io.grpc.ejercicio4.ftp.LeerRequest prototype) {
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
   * Protobuf type {@code pdytr.ejercicio4.grpc.LeerRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pdytr.ejercicio4.grpc.LeerRequest)
      io.grpc.ejercicio4.ftp.LeerRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.ejercicio4.ftp.LeerRequest.class, io.grpc.ejercicio4.ftp.LeerRequest.Builder.class);
    }

    // Construct using io.grpc.ejercicio4.ftp.LeerRequest.newBuilder()
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
      archivo_ = "";

      posicion_ = 0;

      bytesALeer_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor;
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerRequest getDefaultInstanceForType() {
      return io.grpc.ejercicio4.ftp.LeerRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerRequest build() {
      io.grpc.ejercicio4.ftp.LeerRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerRequest buildPartial() {
      io.grpc.ejercicio4.ftp.LeerRequest result = new io.grpc.ejercicio4.ftp.LeerRequest(this);
      result.archivo_ = archivo_;
      result.posicion_ = posicion_;
      result.bytesALeer_ = bytesALeer_;
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
      if (other instanceof io.grpc.ejercicio4.ftp.LeerRequest) {
        return mergeFrom((io.grpc.ejercicio4.ftp.LeerRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.ejercicio4.ftp.LeerRequest other) {
      if (other == io.grpc.ejercicio4.ftp.LeerRequest.getDefaultInstance()) return this;
      if (!other.getArchivo().isEmpty()) {
        archivo_ = other.archivo_;
        onChanged();
      }
      if (other.getPosicion() != 0) {
        setPosicion(other.getPosicion());
      }
      if (other.getBytesALeer() != 0) {
        setBytesALeer(other.getBytesALeer());
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
      io.grpc.ejercicio4.ftp.LeerRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.ejercicio4.ftp.LeerRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object archivo_ = "";
    /**
     * <code>string archivo = 1;</code>
     * @return The archivo.
     */
    public java.lang.String getArchivo() {
      java.lang.Object ref = archivo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        archivo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string archivo = 1;</code>
     * @return The bytes for archivo.
     */
    public com.google.protobuf.ByteString
        getArchivoBytes() {
      java.lang.Object ref = archivo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        archivo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string archivo = 1;</code>
     * @param value The archivo to set.
     * @return This builder for chaining.
     */
    public Builder setArchivo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      archivo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string archivo = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearArchivo() {
      
      archivo_ = getDefaultInstance().getArchivo();
      onChanged();
      return this;
    }
    /**
     * <code>string archivo = 1;</code>
     * @param value The bytes for archivo to set.
     * @return This builder for chaining.
     */
    public Builder setArchivoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      archivo_ = value;
      onChanged();
      return this;
    }

    private int posicion_ ;
    /**
     * <code>int32 posicion = 2;</code>
     * @return The posicion.
     */
    @java.lang.Override
    public int getPosicion() {
      return posicion_;
    }
    /**
     * <code>int32 posicion = 2;</code>
     * @param value The posicion to set.
     * @return This builder for chaining.
     */
    public Builder setPosicion(int value) {
      
      posicion_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 posicion = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPosicion() {
      
      posicion_ = 0;
      onChanged();
      return this;
    }

    private int bytesALeer_ ;
    /**
     * <code>int32 bytesALeer = 3;</code>
     * @return The bytesALeer.
     */
    @java.lang.Override
    public int getBytesALeer() {
      return bytesALeer_;
    }
    /**
     * <code>int32 bytesALeer = 3;</code>
     * @param value The bytesALeer to set.
     * @return This builder for chaining.
     */
    public Builder setBytesALeer(int value) {
      
      bytesALeer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 bytesALeer = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearBytesALeer() {
      
      bytesALeer_ = 0;
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


    // @@protoc_insertion_point(builder_scope:pdytr.ejercicio4.grpc.LeerRequest)
  }

  // @@protoc_insertion_point(class_scope:pdytr.ejercicio4.grpc.LeerRequest)
  private static final io.grpc.ejercicio4.ftp.LeerRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.ejercicio4.ftp.LeerRequest();
  }

  public static io.grpc.ejercicio4.ftp.LeerRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LeerRequest>
      PARSER = new com.google.protobuf.AbstractParser<LeerRequest>() {
    @java.lang.Override
    public LeerRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LeerRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeerRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeerRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.ejercicio4.ftp.LeerRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

