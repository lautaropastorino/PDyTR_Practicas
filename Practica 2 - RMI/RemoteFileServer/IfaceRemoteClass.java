/*
* IfaceRemoteClass.java
* Interface defining only two methods which can be invoked remotely
*
*/
/* Needed for defining remote method/s */
import java.rmi.Remote;
import java.rmi.RemoteException;
/* This interface will need an implementing class */
public interface IfaceRemoteClass extends Remote
{
	/* It will be possible to invoke this method from an application in other JVM */
	public byte[] readFile(String filename, int position, int bytelength) throws RemoteException;
	public int writeFile(String filename, int bytelength, byte[] data) throws RemoteException;
}