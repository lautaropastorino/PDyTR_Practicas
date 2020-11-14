package ejercicio1;

import jade.core.*;

public class Agente extends Agent {
    
    private int index = 1;

    public void setup() {
        Location origen = here();
        System.out.println("========================================================");
        System.out.println("Soy " + getLocalName() + " y estoy en " + origen.getID());
        try {
            ContainerID destino = new ContainerID("Container-" + index, null);
            index++;
            System.out.println("Migrando el agente a " + destino.getID());
            System.out.println("========================================================");
	        doMove(destino);
        } catch (Exception e) {
            System.out.println("\n\n\nNo fue posible migrar el agente\n\n\n");
            e.printStackTrace();
        }
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
