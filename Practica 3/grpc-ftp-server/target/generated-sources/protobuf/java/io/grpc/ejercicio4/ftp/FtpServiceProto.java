// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FtpService.proto

package io.grpc.ejercicio4.ftp;

public final class FtpServiceProto {
  private FtpServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pdytr_ejercicio4_grpc_LeerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pdytr_ejercicio4_grpc_LeerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pdytr_ejercicio4_grpc_EscribirRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pdytr_ejercicio4_grpc_EscribirRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pdytr_ejercicio4_grpc_EscribirResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pdytr_ejercicio4_grpc_EscribirResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020FtpService.proto\022\025pdytr.ejercicio4.grp" +
      "c\"D\n\013LeerRequest\022\017\n\007archivo\030\001 \001(\t\022\020\n\010pos" +
      "icion\030\002 \001(\005\022\022\n\nbytesALeer\030\003 \001(\005\"F\n\014LeerR" +
      "esponse\022\r\n\005bytes\030\001 \001(\014\022\022\n\nbytesALeer\030\002 \001" +
      "(\005\022\023\n\013byetsLeidos\030\003 \001(\005\"H\n\017EscribirReque" +
      "st\022\017\n\007archivo\030\001 \001(\t\022\026\n\016bytesAEscribir\030\002 " +
      "\001(\005\022\014\n\004data\030\003 \001(\014\")\n\020EscribirResponse\022\025\n" +
      "\rbytesEscritos\030\001 \001(\0052\276\001\n\nFtpService\022Q\n\004L" +
      "eer\022\".pdytr.ejercicio4.grpc.LeerRequest\032" +
      "#.pdytr.ejercicio4.grpc.LeerResponse0\001\022]" +
      "\n\010Escribir\022&.pdytr.ejercicio4.grpc.Escri" +
      "birRequest\032\'.pdytr.ejercicio4.grpc.Escri" +
      "birResponse(\001B+\n\026io.grpc.ejercicio4.ftpB" +
      "\017FtpServiceProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pdytr_ejercicio4_grpc_LeerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pdytr_ejercicio4_grpc_LeerRequest_descriptor,
        new java.lang.String[] { "Archivo", "Posicion", "BytesALeer", });
    internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pdytr_ejercicio4_grpc_LeerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor,
        new java.lang.String[] { "Bytes", "BytesALeer", "ByetsLeidos", });
    internal_static_pdytr_ejercicio4_grpc_EscribirRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pdytr_ejercicio4_grpc_EscribirRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pdytr_ejercicio4_grpc_EscribirRequest_descriptor,
        new java.lang.String[] { "Archivo", "BytesAEscribir", "Data", });
    internal_static_pdytr_ejercicio4_grpc_EscribirResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_pdytr_ejercicio4_grpc_EscribirResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pdytr_ejercicio4_grpc_EscribirResponse_descriptor,
        new java.lang.String[] { "BytesEscritos", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}