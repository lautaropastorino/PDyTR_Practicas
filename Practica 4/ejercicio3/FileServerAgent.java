package ejercicio3;

import java.io.File;
import jade.core.*;
import jade.lang.acl.ACLMessage;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileServerAgent extends Agent {

    // Ejecutado por unica vez en la creacion
    public void setup() {
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
        
    protected void afterMove() {
        Location origen = here();
        System.out.println("\n\nHola, agente migrado con nombre local " + getLocalName());
        System.out.println("Y nombre completo... " + getName());
        System.out.println("Y en location " + origen.getID() + "\n\n");
        File directory = new File("serverFS/");
        if (! directory.exists()){
            directory.mkdir();
            System.out.println("Directorio serverFS creado\n");
        }
        System.out.println("Antes del while\n");
        while (true) {
            System.out.println("Dentro del while\n");
            ACLMessage msg = blockingReceive();
            System.out.println("Msg recibido\n");
            String action = msg.getUserDefinedParameter("FS_action");
            System.out.println("Accion: " + msg.getUserDefinedParameter("FS_action") + "\n");
            if ("read".equals(action)) {
                String filename = msg.getUserDefinedParameter("FS_filename");
                int position = Integer.parseInt(msg.getUserDefinedParameter("FS_position"));
                int bytelength = Integer.parseInt(msg.getUserDefinedParameter("FS_length"));

                File file = new File("serverFS/"+filename);
                if (!(file.exists())) {
                    System.out.println("El archivo no existe");
                    ACLMessage reply = new ACLMessage( ACLMessage.INFORM );
                    reply.addReceiver( msg.getSender() );
                    reply.addUserDefinedParameter("FS_answer","El archivo no existe");
                    // reply.send();
                    send(reply);
                }
                
                try {
                    // Obtengo el contenido del archivo con ese nombre
                    byte[] fileContents = Files.readAllBytes(file.toPath()); 
                    // Obtengo el tamanio del archivo
                    int filesize = (int) file.length();

                    ACLMessage reply = new ACLMessage( ACLMessage.INFORM );
                    reply.addReceiver( msg.getSender() );
                    if (filesize >= position) {
                        // Decido si voy a leer hasta el final del archivo o hasta la posicion + bytelength
                        int length = Math.min((filesize - position), bytelength);
                        byte[] data = new byte[length];
                        int j = 0;
                        for (int i = position; i < (position + length); i++) {
                            data[j] = fileContents[i];
                            j++;
                        }
                        reply.addUserDefinedParameter("FS_answer","Lectura exitosa");
                        reply.setByteSequenceContent(data);
                    } else {
                        reply.addUserDefinedParameter("FS_answer","La posicion enviada es mayor al tamanio del archivo");
                    }
                    // reply.send();
                    send(reply);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("write".equals(action)) {
                System.out.println("Escribir");
                //Acciones escribir

                // String filename, int bytelength, byte[] data
                String filename = msg.getUserDefinedParameter("FS_filename");
                System.out.println("filename: " + filename);
                int bytelength = Integer.parseInt(msg.getUserDefinedParameter("FS_length"));
                System.out.println("length: " + bytelength);
                byte[] data = msg.getByteSequenceContent();

                int escritos = 0;
                File file = new File("serverFS/"+filename);

                try {
                    // Si no existe el archivo lo creo
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (bytelength < data.length) {
                    data = Arrays.copyOfRange(data, 0, bytelength);
                }
                
                try {
                    FileOutputStream out=new FileOutputStream(file, true);
                    
                    out.write(data);
                    out.flush();
                    out.close();
                    escritos = data.length;

                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
                ACLMessage reply = new ACLMessage( ACLMessage.INFORM );
                reply.addReceiver( msg.getSender() );
                reply.addUserDefinedParameter("FS_answer","Escrito");
                reply.addUserDefinedParameter("bytesWritten", Integer.toString(escritos));
                // reply.send();
                send(reply);
            } else {
                ACLMessage reply = new ACLMessage( ACLMessage.INFORM );
                reply.addReceiver( msg.getSender() );
                reply.addUserDefinedParameter("FS_answer","Accion invalida");
                System.out.println("Respuesta a enviar: " + reply.getUserDefinedParameter("FS_answer") + "\n");
                // reply.send();
                send(reply);
            }
        }
    }

}
