// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FtpService.proto

package io.grpc.ejercicio4.ftp;

public interface LeerRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pdytr.ejercicio4.grpc.LeerRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string archivo = 1;</code>
   * @return The archivo.
   */
  java.lang.String getArchivo();
  /**
   * <code>string archivo = 1;</code>
   * @return The bytes for archivo.
   */
  com.google.protobuf.ByteString
      getArchivoBytes();

  /**
   * <code>int32 posicion = 2;</code>
   * @return The posicion.
   */
  int getPosicion();

  /**
   * <code>int32 bytesALeer = 3;</code>
   * @return The bytesALeer.
   */
  int getBytesALeer();
}
