package pdytr.ejercicio4.grpc;

import io.grpc.ejercicio4.ftp.*;

import io.grpc.stub.StreamObserver;

public class FtpServiceImpl extends FtpServiceGrpc.FtpServiceImplBase {
    
    @Override
    public void leer(LeerRequest request, StreamObserver<LeerResponse> responseObserver) {
        System.out.println(request);
    }

    @Override
    public StreamObserver<EscribirRequest> escribir(final StreamObserver<EscribirResponse> responseObserver) {
        return new StreamObserver<EscribirRequest>() {
            int bytesEscritos = 0;

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t);
            }

            @Override
            public void onNext(EscribirRequest request) {
                System.out.println(request);
            }
        };
    }
}
