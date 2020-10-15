import java.rmi.Naming; /* lookup */
import java.rmi.registry.Registry; /* REGISTRY_PORT */
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.charset.*;

public class AskRemote
{

	private static void errorDeParametros() {
		System.out.println("5 o 2 parametros requeridos: \n"
				+ "1: (remote) hostname "
				+ "2: operation (read/write/ejercicio3b) "
				+ "3: filename "
				+ "4: length "
				+ "5: position/buffer");
		System.exit(1);
	}
	public static void main(String[] args)
	{
		/* Look for hostname and msg length in the command line */
		if (args.length != 2 && args.length != 5) {
			errorDeParametros();
		}
		if (args.length != 2 && "ejercicio3b".equals(args[1]))
		{
			errorDeParametros();
		}
		if (args.length != 5 && ("write".equals(args[1]) || "read".equals(args[1]))) {
			errorDeParametros();
		}

		try {
			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);

			if (args.length != 2) 
			{
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
					byte[] buffer = new String(args[4]).getBytes(StandardCharsets.ISO_8859_1);
					
					/* 
					Uso del write:
					Java AskRemote localhost write nombreArchivo unNumeroQueNoHaceNada "String entre comillas"
					*/

					// IMPLEMENTAR BUSQUEDA DE BUFFER (arg[5])
					int byteswritten = remote.writeFile(filename, bufferlength, buffer);
					System.out.println("Bytes written: " + byteswritten);
				}
			}
			else if ("ejercicio3b".equals(args[1]))
			{
				// byte[] remoto = remote.readFile("ejercicio3b", 0, 20000);

				// // Creo el archivo para la copia local
				// File file = new File("copiaLocal");
				// try {
				// 	file.createNewFile();
				// } catch (Exception e) {
				// 	e.printStackTrace();
				// }

				// String contenido = new String(remoto, "ISO-8859-1").trim();

				// // Escribo en la copia local
				// SeekableByteChannel byteChannel = Files.newByteChannel(file.toPath(), StandardOpenOption.APPEND);
				// ByteBuffer buffer = ByteBuffer.wrap((contenido + String.format("%n")).getBytes(StandardCharsets.ISO_8859_1));
				// byteChannel.write(buffer);

				// remote.writeFile("copiaRemota", 20000, contenido);
				;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}