package pdytr.ejercicio4.grpc;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import io.grpc.*;
import io.grpc.ejercicio4.ftp.*;


public class Client {

    public static void errorDeParametros() {
        System.out.println(String.format("Uso:%n-> -Dexec.args=\"direccion puerto archivo posicion bytesALeer\""));
        System.exit(1);
    }

    public static void main( String[] args ) throws Exception
    {
       if (args.length != 5) {
           errorDeParametros();
       }
       
       String direccion = args[0];
       String puerto = args[1];
       String archivo = args[2];
       int posicion = Integer.parseInt(args[3]);
       int bytesALeer = Integer.parseInt(args[4]);
    

      final ManagedChannel channel = ManagedChannelBuilder.forTarget(String.format("%s:%s", direccion, puerto))
        .usePlaintext()
        .build();

      FtpServiceGrpc.FtpServiceBlockingStub stub = FtpServiceGrpc.newBlockingStub(channel);
      LeerRequest request = LeerRequest.newBuilder()
        .setArchivo(archivo)
        .setPosicion(posicion)
        .setBytesALeer(bytesALeer)
        .build();

      System.out.println("Iniciando consulta");
      
      
      Iterator<LeerResponse> response = stub.leer(request);
    
      int cont = 1;
      while (response.hasNext()) {
        LeerResponse r = response.next();
        System.out.println("Lectura N: " + cont + " - Bytes leidos: " + r.getBytesLeidos());
        cont++;
      }
      

      channel.shutdownNow();
    }
}