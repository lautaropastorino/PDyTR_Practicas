package pdytr.example.grpc;

import io.grpc.stub.StreamObserver;

public class FallaServidor extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
          StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
      // HelloRequest has toString auto-generated.
      System.out.println("Parametro de la request: " + request);
  
      System.exit(0);
    }
  }