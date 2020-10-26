package pdytr.ejercicio4.grpc;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import io.grpc.*;
import io.grpc.ejercicio4.ftp.*;


public class Client {

    public static void main( String[] args ) throws Exception
    {
      
      final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
        .usePlaintext()
        .build();

      FtpServiceGrpc.FtpServiceBlockingStub stub = FtpServiceGrpc.newBlockingStub(channel);
      LeerRequest request = LeerRequest.newBuilder()
        .setArchivo("Archivo")
        .setPosicion(3)
        .setBytesALeer(100)
        .build();

      System.out.println("Iniciando consulta");
      
      
      Iterator<LeerResponse> response = stub.leer(request);

      System.out.println(response.next().getBytes());

      channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}