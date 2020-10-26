package pdytr.example.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
  @Override
  public void greeting(GreetingServiceOuterClass.HelloRequest request,
      StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
    // HelloRequest has toString auto-generated.
    System.out.println("Parametro de la request: " + request);

    // You must use a builder to construct a new Protobuffer object
    GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
        .setGreeting("Hola, " + request.getName()).build();

    try {
      System.out.println("Durmiendo");
      Thread.sleep(5000);
      System.out.println("Despertando");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Use responseObserver to send a single response back
    responseObserver.onNext(response);

    System.out.println(responseObserver);

    // When you are done, you must call onCompleted.
    responseObserver.onCompleted();
  }
}