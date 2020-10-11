//This class contains implementation of all the functionalities provided to the client. 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface, Serializable{

	protected RmiImplementation(String s) throws RemoteException {
		File storageDir = new File (s);
		storageDir.mkdir();
	}
	
	public byte[] downloadFromServer(String filename, int position, int bytelength) throws RemoteException {
					
		byte [] mydata;	
		
			File serverpathfile = new File(filename);			
			mydata=new byte[(int) serverpathfile.length()];
			FileInputStream in;
			if (mydata.length >= position) {
				int length = Math.min((mydata.length - position), bytelength);

				try {
					in = new FileInputStream(serverpathfile);
					try {
						in.read(mydata, position, length);
					} catch (IOException e) {
						
						e.printStackTrace();
					}						
					try {
						in.close();
					} catch (IOException e) {
					
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}

			return mydata;
				 
	}
	
	public int uploadToServer(String filename, int length , byte[] mydata) throws RemoteException {
		
		int writtenlength = 0;

    	try {
    		File serverpathfile = new File(filename);
    		FileOutputStream out=new FileOutputStream(serverpathfile);
    		byte [] data=mydata;
			
    		out.write(data);
			out.flush();
	    	out.close();
	    	writtenlength = data.length;
	 
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return writtenlength;
	}
	
}
