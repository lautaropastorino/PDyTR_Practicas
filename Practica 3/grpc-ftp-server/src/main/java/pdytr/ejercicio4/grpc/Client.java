package pdytr.ejercicio4.grpc;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;

import io.grpc.*;
import io.grpc.ejercicio4.ftp.*;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;


public class Client {

    private static final int STREAM_SIZE = 4096;

    public static void errorDeParametros() {
        System.out.println(String.format("Uso:%n-> -Dexec.args=\"direccion puerto leer/escribir archivo posicion/bytesAEscribir bytesALeer/dataSource\""));
        System.exit(1);
    }

    public static void localWrite(int bytesAEscribir, ByteString data, File file) {
        byte[] aEscribir;
        if (bytesAEscribir < data.size()) {
            aEscribir = new byte[bytesAEscribir];
        } else {
            aEscribir = new byte[data.size()];
        }

        aEscribir = data.toByteArray();
        try {
            FileOutputStream out = new FileOutputStream(file, true);
            
            out.write(aEscribir);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        LeerResponse r = response.next();
        File file = null;
        if (r.getBytesLeidos() != 0) {
            file = new File("clientFS/"+archivo);
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        localWrite(r.getBytesLeidos(), r.getBytes(), file);
        
        int cont = 1;
        while (response.hasNext()) {
            localWrite(r.getBytesLeidos(), r.getBytes(), file);
            r = response.next();
            System.out.println("Lectura N: " + cont + " - Bytes leidos: " + r.getBytesLeidos());
            cont++;
        }


        channel.shutdownNow();
    }

    private static class EscribirResponseObserver implements StreamObserver<EscribirResponse> {
        @Override
        public void onNext(EscribirResponse response) {
            System.out.println(response);
        }
        @Override
        public void onCompleted() {
            System.out.println("Fin del stream");
        }
        @Override
        public void onError(Throwable t) {
            System.out.println("Error: " + t);
        }
    }

    public static void escribir(String direccion, String puerto, String archivo, int bytesAEscribir, String dataSource) {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget(String.format("%s:%s", direccion, puerto))
            .usePlaintext()
            .build();
        FtpServiceGrpc.FtpServiceStub stub = FtpServiceGrpc.newStub(channel);
        StreamObserver<EscribirRequest> streamObserver = stub.escribir(new EscribirResponseObserver());

        File file = new File("clientFS/"+dataSource);
		if (!file.exists()) {
            System.out.println("El archivo no existe");
            System.exit(1);
        }

        try {
			byte[] fileContents = Files.readAllBytes(file.toPath()); 
            int filesize = (int) file.length();
            
            int length = Math.min(filesize, bytesAEscribir);
            int streams = length / STREAM_SIZE;
            int resto = length % STREAM_SIZE;

            System.out.println("Se requieren " + streams + " streams de " + STREAM_SIZE + " bytes.");
            System.out.println("Y sobran " + resto + " bytes");

            int posicion = 0;
            for (int i = 0; i < streams; i++) {
                ByteBuffer buf = ByteBuffer.allocate(STREAM_SIZE);
                for (int j = posicion; j < posicion + STREAM_SIZE; j++) {
                    buf.put(fileContents[j]);
                }
                buf.rewind();
                posicion += STREAM_SIZE;
                EscribirRequest request = EscribirRequest.newBuilder()
                        .setData(ByteString.copyFrom(buf))
                        .setBytesAEscribir(bytesAEscribir)
                        .setArchivo(archivo)
                        .build();
                streamObserver.onNext(request);
            }
            
            if (resto > 0) {
                ByteBuffer buf = ByteBuffer.allocate(resto);
                for (int i = posicion; i < posicion + resto; i++) {
                    buf.put(fileContents[i]);
                }
                buf.rewind();
                EscribirRequest request = EscribirRequest.newBuilder()
                        .setData(ByteString.copyFrom(buf))
                        .setBytesAEscribir(bytesAEscribir)
                        .setArchivo(archivo)
                        .build();
                streamObserver.onNext(request);
            }
            streamObserver.onCompleted();
            channel.awaitTermination(1, TimeUnit.SECONDS);
            System.exit(0);   
        } catch (Exception e) {
			e.printStackTrace();
		}
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
       
    
       if (operacion.equals("leer")) {
            int bytesALeer = Integer.parseInt(args[5]);
            leer(direccion, puerto, archivo, posicion, bytesALeer);
       } else if (operacion.equals("escribir")) {
            String dataSource = args[5];
            escribir(direccion, puerto, archivo, posicion, dataSource);
       } else {
           errorDeParametros();
       }
      
    }
}