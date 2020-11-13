import jade.core.*;
public class AgenteMovil extends Agent
{
// Ejecutado por unica vez en la creacion
public void setup()
{
	Location origen = here();
	System.out.println("\n\nHola, agente con nombre local " + getLocalName());
	System.out.println("Y nombre completo... " + getName());
	System.out.println("Y en location " + origen.getID() + "\n\n");
// Para migrar el agente
try {
	ContainerID destino = new ContainerID("Main-Container", null);
	System.out.println("Migrando el agente a " + destino.getID());
	doMove(destino);
} catch (Exception e) {
	System.out.println("\n\n\nNo fue posible migrar el agente\n\n\n");}
}

// Ejecutado al llegar a un contenedor como resultado de una migracion
protected void afterMove()
{
	Location origen = here();
	System.out.println("\n\nHola, agente migrado con nombre local " + getLocalName());
	System.out.println("Y nombre completo... " + getName());
	System.out.println("Y en location " + origen.getID() + "\n\n");
}
}
