import java.rmi.Naming; /* lookup */
import java.rmi.registry.Registry; /* REGISTRY_PORT */


public class AskRemote
{
	public static void main(String[] args)
	{
		/* Look for hostname and msg length in the command line */
		if (args.length != 5)
		{
			System.out.println("5 arguments needed: \n"
				+ "1: (remote) hostname "
				+ "2: operation (read/write) "
				+ "3: filename "
				+ "4: length "
				+ "5: position/buffer");
			System.exit(1);
		}
		try {
			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);
			String filename = args[2];
			int bufferlength = Integer.parseInt(args[3]);
			if ("read".equals(args[1]))
			{
				int position = Integer.parseInt(args[4]);
				byte[] buffer = remote.readFile(filename, position, bufferlength);
				//transformo los bytes a string
				String s = new String(buffer, "ISO-8859-1");
				// le saco los blanco que pueden sobrar al final (si es que se acabo el archivo)
				System.out.println("Bytes read: " + s.trim().length());
				System.out.println("Read: " + s);
			}
			else if ("write".equals(args[1]))
			{
				String buffer = new String(args[4]);
				
				/* 
				Uso del write:
				Java AskRemote localhost write nombreArchivo unNumeroQueNoHaceNada "String entre comillas"
				*/

				// IMPLEMENTAR BUSQUEDA DE BUFFER (arg[5])
				int byteswritten = remote.writeFile(filename, bufferlength, buffer);
				System.out.println("Bytes written: " + byteswritten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}