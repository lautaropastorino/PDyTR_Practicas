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
                byte[] data = new byte[0];
		try {
                    //IMPLEMENTAR DIRECCIÓN BASE
                    File file = new File(filename);
                    int filesize = getFileSizeBytes(file);
                    if (filesize >= position) {
                        int to = Math.min(filesize, (bytelength + position));
                        data = Arrays.copyOfRange(Files.readAllBytes(file.toPath()), position, to);
                    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int writeFile(String filename, int bytelength, byte[] data) throws RemoteException
	{

	}
}