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
		try {
			//IMPLEMENTAR DIRECCIÓN BASE
			File file = new File(filename);
			int filesize = getFileSizeBytes(file);
			if (filesize >= position) {
				to = Math.min(filesize, (bytelength + position));
		      	byte[] data = Arrays.copyOfRange(Files.readAllBytes(file.toPath()), position, to);
			}
		    else {
				byte[] data = new byte[0];
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data
	}
	public int writeFile(String filename, int bytelength, byte[] data) throws RemoteException
	{

	}
}