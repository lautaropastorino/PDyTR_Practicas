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
		if (args.length != 2)
		{
			System.out.println("2 argument needed:"
				+ "1: (remote) hostname"
				+ "2: string");
			System.exit(1);
		}
		try {
			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);
			String data = args[1];
			remote.sendThisBack(data);
			System.out.println("Listo "+ data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}