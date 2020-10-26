package pdytr.ejercicio4.grpc;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import com.google.protobuf.ByteString;

import io.grpc.ejercicio4.ftp.*;

import io.grpc.stub.StreamObserver;

public class FtpServiceImpl extends FtpServiceGrpc.FtpServiceImplBase {
    
    private static final int STREAM_SIZE = 4096;

    @Override
    public void leer(LeerRequest request, StreamObserver<LeerResponse> responseObserver) {
        
        System.out.println(request);

        String archivo = request.getArchivo();
        int posicion = request.getPosicion();
        int bytesALeer = request.getBytesALeer();

        File file = new File("serverFS/"+archivo);
		if (!(file.exists())) {
			System.out.println("El archivo no existe");
            ByteString buffer = ByteString.copyFrom(ByteBuffer.allocate(0));
            LeerResponse response = LeerResponse.newBuilder()
                .setBytes(buffer)
                .setBytesALeer(bytesALeer)
                .setBytesLeidos(0)
                .build();
            //Envio buffer vacio
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        
        try {
			
			// Obtengo el contenido del archivo con ese nombre
			byte[] fileContents = Files.readAllBytes(file.toPath()); 
			// Obtengo el tamanio del archivo
			int filesize = (int) file.length();

			if (filesize >= posicion) {
				// Decido si voy a leer hasta el final del archivo o hasta la posicion + bytelength
				int length = Math.min((filesize - posicion), bytesALeer);
                // Cuantos streams de STREAM_SIZE bytes tengo que hacer?
                int streams = length / STREAM_SIZE;
                // Me fijo si tengo que hacer un stream mas de menos de STREAM_SIZE bytes
                int resto = length % STREAM_SIZE;

                System.out.println("Se requieren " + streams + " streams de " + STREAM_SIZE + " bytes.");
                System.out.println("Y sobran " + resto + " bytes");

                for (int i = 0; i < streams; i++) {
                    ByteBuffer buf = ByteBuffer.allocate(STREAM_SIZE);
                    for (int j = posicion; j < posicion + STREAM_SIZE; j++) {
                        buf.put(fileContents[j]);
                    }
                    posicion += STREAM_SIZE;
                    buf.rewind();
                    LeerResponse response = LeerResponse.newBuilder()
                            .setBytes(ByteString.copyFrom(buf))
                            .setBytesALeer(bytesALeer)
                            .setBytesLeidos(STREAM_SIZE)
                            .build();
                        
                        responseObserver.onNext(response);
                }

                if (resto > 0) {
                    ByteBuffer buf = ByteBuffer.allocate(resto);
                    for (int i = posicion; i < posicion + resto; i++) {
                        buf.put(fileContents[i]);
                    }
                    buf.rewind();
                    LeerResponse response = LeerResponse.newBuilder()
                    .setBytes(ByteString.copyFrom(buf))
                    .setBytesALeer(bytesALeer)
                    .setBytesLeidos(resto)
                    .build();
                
                    responseObserver.onNext(response);
                }
                responseObserver.onCompleted();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public StreamObserver<EscribirRequest> escribir(final StreamObserver<EscribirResponse> responseObserver) {
        return new StreamObserver<EscribirRequest>() {
            private int escritos = 0;
            {
                System.out.println("Pedido de escritura recibido");
            }

            @Override
            public void onCompleted() {
                System.out.println("Fin del stream");
                EscribirResponse response = EscribirResponse.newBuilder()
                    .setBytesEscritos(escritos)
                    .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t);
            }

            @Override
            public void onNext(EscribirRequest request) {
                String archivo = request.getArchivo();
                int bytesAEscribir = request.getBytesAEscribir();
                ByteString data = request.getData();
        
                File file = new File("serverFS/"+archivo);
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
                    escritos += aEscribir.length;
             
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
