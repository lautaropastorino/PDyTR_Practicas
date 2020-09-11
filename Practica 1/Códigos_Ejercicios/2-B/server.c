/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
#include <stdio.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>

void error(char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[])
{
     int sockfd, newsockfd, portno, clilen;
     char buffer[1000000]; // 10^6
     struct sockaddr_in serv_addr, cli_addr;
     int n;
     if (argc < 2) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }
	 //CREA EL FILE DESCRIPTOR DEL SOCKET PARA LA CONEXION
     sockfd = socket(AF_INET, SOCK_STREAM, 0);
	 //AF_INET - FAMILIA DEL PROTOCOLO - IPV4 PROTOCOLS INTERNET
	//SOCK_STREAM - TIPO DE SOCKET 
	
     if (sockfd < 0) 
        error("ERROR opening socket");

     // Pone en 0 los datos que haya en &serv_addr
     bzero((char *) &serv_addr, sizeof(serv_addr));
     
     //ASIGNA EL PUERTO PASADO POR ARGUMENTO
	//ASIGNA LA IP EN DONDE ESCUCHA (SU PROPIA IP)
	portno = atoi(argv[1]);
     serv_addr.sin_family = AF_INET;
     // Recibir paquetes de todas las interfaces
     serv_addr.sin_addr.s_addr = INADDR_ANY;
     // htons() converts the unsigned short integer hostshort from host byte order to network byte order.
     serv_addr.sin_port = htons(portno); 
	 
	 //VINCULA EL FILE DESCRIPTOR CON LA DIRECCION Y EL PUERTO
     if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) 
              error("ERROR on binding");
			  
	 //SETEA LA CANTIDAD QUE PUEDEN ESPERAR MIENTRAS SE MANEJA UNA CONEXION		  
     listen(sockfd,5);
	 
	 // SE BLOQUEA A ESPERAR UNA CONEXION
     clilen = sizeof(cli_addr);
     newsockfd = accept(sockfd, 
                 (struct sockaddr *) &cli_addr, 
                 &clilen);
				 
     //DEVUELVE UN NUEVO DESCRIPTOR POR EL CUAL SE VAN A REALIZAR LAS COMUNICACIONES
	 if (newsockfd < 0) 
          error("ERROR on accept");
          
     // Limpio el buffer poniendo todos 0 
     bzero(buffer,1000000);

	//LEE EL MENSAJE DEL CLIENTE
     n = read(newsockfd,buffer,1000000);
     if (n < 0) error("ERROR reading from socket");
     printf("Message received correctlty\n");
	 
	 //RESPONDE AL CLIENTE
     n = write(newsockfd,"I got your message",18);
     if (n < 0) error("ERROR writing to socket");
     return 0; 
}
