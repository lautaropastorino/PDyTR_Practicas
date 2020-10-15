import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.FileOutputStream;
import java.util.Arrays; 

/* This class implements the interface with remote methods */
public class RemoteClass extends UnicastRemoteObject implements IfaceRemoteClass {
	
	protected RemoteClass() throws RemoteException {
		super();
	}

	/* Remote methods implementation */
	public byte[] readFile(String filename, int position, int bytelength) throws RemoteException {	
		System.out.println("Pedido de lectura recibido.");

		// Me creo un arreglo de los bytes que voy a leer de a lo sumo bytelength de largo.
		byte[] data = new byte[bytelength];

		File file = new File("serverFS/"+filename);
		if (!file.exists()) {
			System.out.println("El archivo no existe");
			return data;
		}
		
		try {
			//IMPLEMENTAR DIRECCION BASE
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

	public int writeFile(String filename, int bytelength, byte[] data) throws RemoteException {
		System.out.println("Pedido de escritura recibido.");

		int escritos = 0;
		File file = new File("serverFS/"+filename);

		try {
			// Si no existe el archivo lo creo
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bytelength < data.length) {
			data = Arrays.copyOfRange(data, 0, bytelength);
		}
		
		try {
			FileOutputStream out=new FileOutputStream(file, true);
			
			out.write(data);
			out.flush();
			out.close();
			escritos = data.length;
	 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return escritos;
	}
}