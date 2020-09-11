/*
 * EchoServer.java
 * Just receives some data and sends back a "message" to a client
 *
 * Usage:
 * java Server port
 */

import java.io.*;
import java.net.*;

public class Server
{
  public static void main(final String[] args) throws IOException
  {
    /* Check the number of command line parameters */
    if ((args.length != 1) || (Integer.valueOf(args[0]) <= 0) )
    {
      System.out.println("1 arguments needed: port");
      System.exit(1);
    }

    /* The server socket */
    ServerSocket serverSocket = null;    
    try
    {
      // Crea un server socket en el puerto pasado por argumento
      serverSocket = new ServerSocket(Integer.valueOf(args[0]));
    } 
    catch (final Exception e)
    {
      System.out.println("Error on server socket");
      System.exit(1);
    }

    /* The socket to be created on the connection with the client */
    Socket connected_socket = null;

    try /* To wait for a connection with a client */
    {
      // Devuelve un socket con una conexión realizada al server_socket
      connected_socket = serverSocket.accept();
    }
    catch (final IOException e)
    {
      System.err.println("Error on Accept");
      System.exit(1);
    }

    /* Streams from/to client */
    DataInputStream fromclient;
    DataOutputStream toclient;

    /* Get the I/O streams from the connected socket */
    fromclient = new DataInputStream(connected_socket.getInputStream());
    toclient   = new DataOutputStream(connected_socket.getOutputStream());

    /* Buffer to use with communications (and its length) */
    byte[] buffer;
    buffer = new byte[256];
    
    /* Recv data from client */
    // Leo el data input stream y lo guardo en el bufer
    fromclient.read(buffer);

    /* Convert to string */
    final String str = new String(buffer);

    System.out.println("Here is the message: " +  str);

    /* Fixed string to the client */
    final String strresp = "I got your message";

    System.out.println("strrsp " + strresp);

    // Guardo la respuesta en el buffer
    buffer = strresp.getBytes();

    /* Send the bytes back */
    toclient.write(buffer, 0, buffer.length);

    /* Close everything related to the client connection */
    fromclient.close();
    toclient.close();
    connected_socket.close();
    serverSocket.close();
  }
}
