//This class connects to the server and accepts commands from the user.

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming; /* lookup */
import java.rmi.registry.Registry; /* REGISTRY_PORT */
import java.util.Arrays;

public class RMIClient implements Serializable {

	public static void main(String[] args) {
		
		/* Look for hostname and msg length in the command line */
		if (args.length < 4)
		{
			System.out.println("5 arguments needed:"
				+ "1: (remote) hostname:port"
				+ "2: operation"
				+ "3: filename"
				+ "4: length"
				+ "5: position (only reading)");
			System.exit(1);
		}

		String upload = "upload";
		String download = "download";
		String shutdown= "shutdown";
		
		try{
			String rname = "//" + args[0] + "/remote";
			RmiInterface remote = (RmiInterface) Naming.lookup(rname);
			String filename = args[3];
			int bufferlength = Integer.parseInt(args[4]);
			
			//to upload a file
			if(upload.equals(args[1]))
			{
				File clientpathfile = new File(filename);
				byte [] mydata=new byte[(int) clientpathfile.length()];
				FileInputStream in=new FileInputStream(clientpathfile);	
				in.read(mydata, 0, mydata.length);
				int byteswritten = remote.uploadToServer(filename, bufferlength, mydata);
				System.out.println("Bytes written: " + byteswritten);

				in.close();
			}
			//to download a file
			if(download.equals(args[1]))
			{
				int position = Integer.parseInt(args[5]);
				byte [] mydata = remote.downloadFromServer(filename, position, bufferlength);
				System.out.println("Bytes read: " + mydata.length);
				System.out.println("Read: " + Arrays.toString(mydata));
			}

			//to shutdown the client
			if(shutdown.equals(args[1]))
			{
				System.exit(0);
				System.out.println("Client has shutdown. Close the console");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error with connection or command. Check your hostname or command");
		}				
		}
		
	}

