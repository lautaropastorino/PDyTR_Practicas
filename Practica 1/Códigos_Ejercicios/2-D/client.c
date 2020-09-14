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

    //Populamos el buffer con un mensaje de tamaño r
    int i;
    for (i = 0; i < r; i++) 
        buffer[i] = 'a';
    
    // Agrego el caracter 'fin de string' para que strlen entienda que no sigue más el mensaje
    //buffer[i+1] = '\0';
    

    printf("Mensaje de %d caracteres generado.\n", r);

    clock_t begin = clock(); //Comienza la comunicación
    //ENVIA UN MENSAJE AL SOCKET
	n = write(sockfd,buffer,strlen(buffer));
    if (n < 0) 
         error("ERROR writing to socket");
    printf("Mensaje enviado!\n");
    bzero(buffer,1000000);
    clock_t end = clock(); //Finaliza la comunicación
	
    //calculamos la diferencia entre los ciclos de reloj y la dividimos por la cantidad de ciclos por seg
    printf("Mensaje enviado en %f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
    //ESPERA RECIBIR UNA RESPUESTA
    //n = read(sockfd,buffer,1000000);
    // printf("Respuesta recibida: %d\n", n);
    
    // if (n < 0) 
    //      error("ERROR reading from socket");
    
	// printf("%s\n",buffer);
    return 0;
}
