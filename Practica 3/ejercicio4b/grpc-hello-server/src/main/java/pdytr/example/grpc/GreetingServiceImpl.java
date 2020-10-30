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

    System.out.println("Durmiendo");
    for (int i = 0; i < 10000000; i++) {
      for (int j = 0; j < 1000; j++) {
        // for (int k = 0; k < 10000000; k++) {
          if ((i % 1000000 == 0) && (j % 1000 == 0)) {
            System.out.println(j);
          }
        // }
      }
      if ( i % 1000000 == 0) {
        System.out.println(i);
      }
    }
    System.out.println("Despertando");

    // Use responseObserver to send a single response back
    responseObserver.onNext(response);

    System.out.println(responseObserver);

    // When you are done, you must call onCompleted.
    responseObserver.onCompleted();
  }
}