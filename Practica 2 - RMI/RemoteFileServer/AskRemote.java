/*
* AskRemote.java
* a) Looks up for the remote object
* b) "Makes" the RMI
*/
import java.rmi.Naming; /* lookup */
import java.rmi.registry.Registry; /* REGISTRY_PORT */
public class AskRemote
{
	public static void main(String[] args)
	{
		/* Look for hostname and msg length in the command line */
		if (args.length != 5)
		{
			System.out.println("5 arguments needed:"
				+ "1: (remote) hostname"
				+ "2: operation (read/write)"
				+ "3: filename"
				+ "4: length"
				+ "5: position/buffer");
			System.exit(1);
		}
		try {
			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);
			String filename = args[3];
			int bufferlength = Integer.parseInt(args[4]);
			if ("read".equals(args[1]))
			{
				int position = Integer.parseInt(args[5]);
				byte[] buffer = remote.readFile(filename, position, bufferlength);
				System.out.println("Bytes read: " + buffer.length());
				System.out.println("Read: " + buffer);
			}
			else if ("write".equals(args[1]))
			{
                                byte[] buffer;
				// IMPLEMENTAR BUSQUEDA DE BUFFER (arg[5])
				int byteswritten = remote.writeFile(filename, bufferlength, buffer);
				System.out.println("Bytes written: " + byteswritten);
			}
			// remote.sendThisBack(buffer);
			// System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}