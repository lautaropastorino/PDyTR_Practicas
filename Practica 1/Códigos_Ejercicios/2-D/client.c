#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 
#include <stdlib.h>
#include <time.h>

void error(char *msg)
{
    perror(msg);
    exit(0);
}

int main(int argc, char *argv[])
{
    int sockfd, portno, n;
    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[1000000]; //10^6
    if (argc < 3) {
       fprintf(stderr,"usage %s hostname port\n", argv[0]);
       exit(0);
    }
	//TOMA EL NUMERO DE PUERTO DE LOS ARGUMENTOS
    portno = atoi(argv[2]);
	
	//CREA EL FILE DESCRIPTOR DEL SOCKET PARA LA CONEXION
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
	//AF_INET - FAMILIA DEL PROTOCOLO - IPV4 PROTOCOLS INTERNET
	//SOCK_STREAM - TIPO DE SOCKET 
	
    if (sockfd < 0) 
        error("ERROR opening socket");
	
	//TOMA LA DIRECCION DEL SERVER DE LOS ARGUMENTOS
    // The gethostbyname() function returns a structure of type hostent for the given host name.
    server = gethostbyname(argv[1]);
    if (server == NULL) {
        fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }
    // Pongo en 0 el server address
    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
	
	//COPIA LA DIRECCION IP Y EL PUERTO DEL SERVIDOR A LA ESTRUCTURA DEL SOCKET
    bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_length);
    serv_addr.sin_port = htons(portno);
	
    //DESCRIPTOR - DIRECCION - TAMAÑO DIRECCION
    if (connect(sockfd, &serv_addr, sizeof(serv_addr)) < 0) 
        error("ERROR connecting");
    
    bzero(buffer,1000000);
    
    // Generamos un número aleatorio para determinar el tamaño del mensaje
    srand(time(NULL));   // Inicializamos la seed.
    int r = (rand() % 999997) + 1;      // Obtenemos un número aleatorio entre 1 y 999.998

    

    printf("Mensaje de %d caracteres generado.\n", r);

    double tot = 0.0;
    double totMedia = 0.0;

    for (int i = 0; i < 1000; i++) {
        
        //Populamos el buffer con un mensaje de tamaño r
        int j;
        for (j = 0; j < r; j++) 
            buffer[j] = 'a';
        
        //caracter de fin para que el servidor sepa cuando dejar de leer
        buffer[j] = 'f';

        clock_t begin = clock(); //Comienza la comunicación
        //ENVIA UN MENSAJE AL SOCKET
        n = write(sockfd,buffer,strlen(buffer));
        if (n < 0) 
            error("ERROR writing to socket");

        bzero(buffer,1000000);

        //ESPERA RECIBIR UNA RESPUESTA
        n = read(sockfd,buffer,1000000);
        if (n < 0) 
            error("ERROR reading from socket");
        
        clock_t end = clock(); //Finaliza la comunicación
        
        double comu = (double)(end - begin) / CLOCKS_PER_SEC;

        tot += comu;
        totMedia += comu/2;

        if (i % 10 == 0)
            printf("%f\n", comu);
    }
    

    printf("Promedio por comunicación completa: %f segundos\n", tot/1000);
    printf("Promedio por read/write por separado: %f segundos\n", totMedia/1000);
    
    return 0;
}
