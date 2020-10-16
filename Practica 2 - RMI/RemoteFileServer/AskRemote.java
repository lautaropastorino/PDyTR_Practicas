import java.rmi.Naming; /* lookup */
import java.rmi.registry.Registry; /* REGISTRY_PORT */
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.charset.*;

public class AskRemote
{
	private static final int bufferSize = 1024;

	private static void errorDeParametros() {
		System.out.println("5 o 2 parametros requeridos: \n"
				+ "1: (remote) hostname "
				+ "2: operacion (read/write/copy) "
				+ "3: nombreArchivo "
				+ "4: cantidadDeBytes "
				+ "5: posicion/dataSource");
		System.exit(1);
	}

	private static int lastIndex(byte[] b) {
		int i = 0;
		while (i < b.length && b[i] != 0) {
			i++;
		}
		return i;
	}
	public static void main(String[] args)
	{
		/* Look for hostname and msg length in the command line */
		if (args.length != 5 && args.length != 3) {
			errorDeParametros();
		}
		if ((!"write".equals(args[1]) && !"read".equals(args[1]) && !"copy".equals(args[1]))) {
			errorDeParametros();
		}

		try {

			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);
			
			String filename = args[2];

			if ("read".equals(args[1]))
			{
				int bufferlength = Integer.parseInt(args[3]);
				int position = Integer.parseInt(args[4]);
				byte[] buffer = remote.readFile(filename, position, bufferlength);
				//transformo los bytes a string
				String s = new String(buffer, "ISO-8859-1");
				// le saco los blanco que pueden sobrar al final (si es que se acabo el archivo)
				System.out.println("Bytes read: " + s.trim().length());
			}
			else if ("write".equals(args[1]))
			{
				int bufferlength = Integer.parseInt(args[3]);
				byte[] buffer = new String(args[4]).getBytes(StandardCharsets.ISO_8859_1);
				int byteswritten = remote.writeFile(filename, bufferlength, buffer);
				System.out.println("Bytes written: " + byteswritten);
			}
			else if ("copy".equals(args[1]))
			{
				int position = 0;
				byte[] dataRead = remote.readFile(filename, position, bufferSize);
				int leidos = dataRead.length;

				if (leidos == 0) {
					System.out.println("El archivo no existe...");
					System.exit(0);
				}

				File file = new File("clientFS/"+filename);
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				FileOutputStream localWrite = new FileOutputStream(file);
				
				
				while (leidos > 0) {
					localWrite.write(dataRead);
					remote.writeFile("CopyOf" + filename, leidos, dataRead);
					position += leidos;
					dataRead = remote.readFile(filename, position, bufferSize);
					leidos = dataRead.length;
				}

				localWrite.flush();
				localWrite.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}