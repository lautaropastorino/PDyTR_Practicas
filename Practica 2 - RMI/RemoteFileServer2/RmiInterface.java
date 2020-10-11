//This class interfaces directly between the client and the server
import java.rmi.*;
import java.rmi.registry.*;
public interface RmiInterface extends Remote {

	public byte[] downloadFromServer(String filename, int position, int bytelength) throws RemoteException;
	public int uploadToServer(String filename, int bytelength, byte[] data) throws RemoteException;

}
