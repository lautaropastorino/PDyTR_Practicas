package io.grpc.ejercicio4.ftp;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.0)",
    comments = "Source: FtpService.proto")
public final class FtpServiceGrpc {

  private FtpServiceGrpc() {}

  public static final String SERVICE_NAME = "pdytr.ejercicio4.grpc.FtpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.LeerRequest,
      io.grpc.ejercicio4.ftp.LeerResponse> getLeerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Leer",
      requestType = io.grpc.ejercicio4.ftp.LeerRequest.class,
      responseType = io.grpc.ejercicio4.ftp.LeerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.LeerRequest,
      io.grpc.ejercicio4.ftp.LeerResponse> getLeerMethod() {
    io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.LeerRequest, io.grpc.ejercicio4.ftp.LeerResponse> getLeerMethod;
    if ((getLeerMethod = FtpServiceGrpc.getLeerMethod) == null) {
      synchronized (FtpServiceGrpc.class) {
        if ((getLeerMethod = FtpServiceGrpc.getLeerMethod) == null) {
          FtpServiceGrpc.getLeerMethod = getLeerMethod =
              io.grpc.MethodDescriptor.<io.grpc.ejercicio4.ftp.LeerRequest, io.grpc.ejercicio4.ftp.LeerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Leer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.ejercicio4.ftp.LeerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.ejercicio4.ftp.LeerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FtpServiceMethodDescriptorSupplier("Leer"))
              .build();
        }
      }
    }
    return getLeerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.EscribirRequest,
      io.grpc.ejercicio4.ftp.EscribirResponse> getEscribirMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Escribir",
      requestType = io.grpc.ejercicio4.ftp.EscribirRequest.class,
      responseType = io.grpc.ejercicio4.ftp.EscribirResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.EscribirRequest,
      io.grpc.ejercicio4.ftp.EscribirResponse> getEscribirMethod() {
    io.grpc.MethodDescriptor<io.grpc.ejercicio4.ftp.EscribirRequest, io.grpc.ejercicio4.ftp.EscribirResponse> getEscribirMethod;
    if ((getEscribirMethod = FtpServiceGrpc.getEscribirMethod) == null) {
      synchronized (FtpServiceGrpc.class) {
        if ((getEscribirMethod = FtpServiceGrpc.getEscribirMethod) == null) {
          FtpServiceGrpc.getEscribirMethod = getEscribirMethod =
              io.grpc.MethodDescriptor.<io.grpc.ejercicio4.ftp.EscribirRequest, io.grpc.ejercicio4.ftp.EscribirResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Escribir"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.ejercicio4.ftp.EscribirRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.ejercicio4.ftp.EscribirResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FtpServiceMethodDescriptorSupplier("Escribir"))
              .build();
        }
      }
    }
    return getEscribirMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FtpServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FtpServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FtpServiceStub>() {
        @java.lang.Override
        public FtpServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FtpServiceStub(channel, callOptions);
        }
      };
    return FtpServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FtpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FtpServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FtpServiceBlockingStub>() {
        @java.lang.Override
        public FtpServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FtpServiceBlockingStub(channel, callOptions);
        }
      };
    return FtpServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FtpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FtpServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FtpServiceFutureStub>() {
        @java.lang.Override
        public FtpServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FtpServiceFutureStub(channel, callOptions);
        }
      };
    return FtpServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FtpServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void leer(io.grpc.ejercicio4.ftp.LeerRequest request,
        io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.LeerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLeerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.EscribirRequest> escribir(
        io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.EscribirResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getEscribirMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLeerMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.ejercicio4.ftp.LeerRequest,
                io.grpc.ejercicio4.ftp.LeerResponse>(
                  this, METHODID_LEER)))
          .addMethod(
            getEscribirMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.ejercicio4.ftp.EscribirRequest,
                io.grpc.ejercicio4.ftp.EscribirResponse>(
                  this, METHODID_ESCRIBIR)))
          .build();
    }
  }

  /**
   */
  public static final class FtpServiceStub extends io.grpc.stub.AbstractAsyncStub<FtpServiceStub> {
    private FtpServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FtpServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FtpServiceStub(channel, callOptions);
    }

    /**
     */
    public void leer(io.grpc.ejercicio4.ftp.LeerRequest request,
        io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.LeerResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLeerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.EscribirRequest> escribir(
        io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.EscribirResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getEscribirMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FtpServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FtpServiceBlockingStub> {
    private FtpServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FtpServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FtpServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<io.grpc.ejercicio4.ftp.LeerResponse> leer(
        io.grpc.ejercicio4.ftp.LeerRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLeerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FtpServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FtpServiceFutureStub> {
    private FtpServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FtpServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FtpServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LEER = 0;
  private static final int METHODID_ESCRIBIR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FtpServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FtpServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LEER:
          serviceImpl.leer((io.grpc.ejercicio4.ftp.LeerRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.LeerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ESCRIBIR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.escribir(
              (io.grpc.stub.StreamObserver<io.grpc.ejercicio4.ftp.EscribirResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FtpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FtpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FtpService");
    }
  }

  private static final class FtpServiceFileDescriptorSupplier
      extends FtpServiceBaseDescriptorSupplier {
    FtpServiceFileDescriptorSupplier() {}
  }

  private static final class FtpServiceMethodDescriptorSupplier
      extends FtpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FtpServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FtpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FtpServiceFileDescriptorSupplier())
              .addMethod(getLeerMethod())
              .addMethod(getEscribirMethod())
              .build();
        }
      }
    }
    return result;
  }
}
