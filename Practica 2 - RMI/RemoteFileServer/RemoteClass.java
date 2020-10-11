/*
* RemoteClass.java
* Just implements the RemoteMethod interface as an extension to
* UnicastRemoteObject
*
*/
/* Needed for implementing remote method/s */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
/* This class implements the interface with remote methods */
public class RemoteClass extends UnicastRemoteObject implements IfaceRemoteClass
{
	protected RemoteClass() throws RemoteException
	{
		super();
	}
	/* Remote methods implementation */
	public byte[] readFile(String filename, int position, int bytelength) throws RemoteException
	{	
		System.out.println("Pedido de lectura recibido.");
		// Me creo un arreglo de los bytes que voy a leer de a lo sumo bytelength de largo.
        byte[] data = new byte[bytelength];
		try {
                    //IMPLEMENTAR DIRECCION BASE
					File file = new File(filename);
					// Obtengo el contenido del archivo con ese nombre
					byte[] fileContents = Files.readAllBytes(file.toPath()); 
					// Obtengo el tamanio del archivo
                    long filesize = file.length();
                    if (filesize >= position) {
						// Decido si voy a leer hasta el final del archivo o hasta la posicion + bytelength
                        long end = filesize < (position + bytelength) ? filesize : (position + bytelength);
						int j = 0;
						for (int i = position; i < end; i++) {
							data[j] = fileContents[i];
							j++;
						}
                    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int writeFile(String filename, int bytelength, byte[] data) throws RemoteException
	{
		return 0;
	}
}