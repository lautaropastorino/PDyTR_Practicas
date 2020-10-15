import java.rmi.Naming; 
import java.rmi.registry.Registry; 

public class Ejercicio5
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Parametro requerido: \n"+ "1: (remote) hostname ");
			System.exit(1);
		}
		try {

			String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
			IfaceRemoteClass remote = (IfaceRemoteClass) Naming.lookup(rname);
			
			float total = 0f;
			for (int i = 0; i < 1000; i++) {
				long startTime = System.nanoTime();
				remote.readFile("archivo", 0, 0);
				long endTime = System.nanoTime();

				total += (endTime - startTime);
				if (i % 10 == 0) {
					System.out.println((endTime - startTime)/1000);
				}
			}

			float prom = (total/1000)/1000;
			System.out.println("El promedio de tiempo de comunicacion es: " + prom + " microsegundos.");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}