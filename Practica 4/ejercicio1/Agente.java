package ejercicio1;

import jade.core.*;

public class Agente extends Agent {
    
    private static final int inicio = 6;
    private int index = 0;
    private long start = 0;
    private long end = 0;

    public void moverse() {
        try {
            index++;
            ContainerID destino = new ContainerID("Container-" + index, null);
            System.out.println("Migrando el agente a " + destino.getID());
            doMove(destino);
        } catch (Exception e) {
            System.out.println("\n\n\nNo fue posible migrar el agente\n\n\n");
            e.printStackTrace();
        }
    }

    public void setup() {
        Location origen = here();
        System.out.println(String.format("%n"));
        System.out.println(getLocalName() + " en " + origen.getID());
        System.out.println(String.format("Iniciando recorrido%n"));
        start = System.currentTimeMillis();
        moverse();   
    }
        
    // Ejecutado al llegar a un contenedor como resultado de una migracion
    protected void afterMove()
    {
        Location origen = here();
        if (index == inicio) {
            end = System.currentTimeMillis();
            System.out.println("Tiempo en dar toda la vuelta: " + (end-start) + "ms");
        } else {
            System.out.println(String.format("%n"));
            System.out.println("Contenedor actual: " + origen.getID());
            //long allocatedMemory = (java.lang.Runtime.getRuntime().totalMemory()-java.lang.Runtime.getRuntime().freeMemory());
            //long presumableFreeMemory = java.lang.Runtime.getRuntime().maxMemory() - allocatedMemory;
            //System.out.println("-> Memoria disponible: " + presumableFreeMemory/1048576 + "mb");
            moverse();
        }   
    }


}
