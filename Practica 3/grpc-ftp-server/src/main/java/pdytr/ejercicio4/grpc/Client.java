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
        .setArchivo("theDrive.mp3")
        .setPosicion(0)
        .setBytesALeer(5000000)
        .build();

      System.out.println("Iniciando consulta");
      
      
      Iterator<LeerResponse> response = stub.leer(request);
    
      int cont = 1;
      while (response.hasNext()) {
        LeerResponse r = response.next();
        System.out.println(cont + "- Bytes leidos: " + r.getBytesLeidos());
        cont++;
      }
      

      channel.shutdownNow();
    }
}