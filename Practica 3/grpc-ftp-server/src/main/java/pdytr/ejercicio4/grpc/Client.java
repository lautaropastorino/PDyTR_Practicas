package pdytr.ejercicio4.grpc;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import io.grpc.*;
import io.grpc.ejercicio4.ftp.*;


public class Client {

    public static void errorDeParametros() {
        System.out.println(String.format("Uso:%n-> -Dexec.args=\"direccion puerto operacion archivo posicion bytesALeer\""));
        System.exit(1);
    }

    public static void leer(String direccion, String puerto, String archivo, int posicion, int bytesALeer) {
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

    public static void escribir(String direccion, String puerto, String archivo, int posicion, int bytesALeer) {
        System.out.println("Escribir");
    }

    public static void main( String[] args ) throws Exception
    {
       if (args.length != 6) {
           errorDeParametros();
       }
       
       String direccion = args[0];
       String puerto = args[1];
       String operacion = args[2];
       String archivo = args[3];
       int posicion = Integer.parseInt(args[4]);
       int bytesALeer = Integer.parseInt(args[5]);
    
       if (operacion.equals("leer")) {
            leer(direccion, puerto, archivo, posicion, bytesALeer);
       } else if (operacion.equals("escribir")) {
            escribir(direccion, puerto, archivo, posicion, bytesALeer);
       } else {
           errorDeParametros();
       }
      
    }
}