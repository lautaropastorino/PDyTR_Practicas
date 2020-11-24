package ejercicio3;

import java.io.File;
import jade.core.*;
import jade.lang.acl.ACLMessage;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileServerClientAgent extends Agent {

	private String filename = new String();

	// Ejecutado por unica vez en la creacion
	public void setup() {
		Location origen = here();
		System.out.println("\n\nHola, agente con nombre local " + getLocalName());
		System.out.println("Y nombre completo... " + getName());
		System.out.println("Y en location " + origen.getID() + "\n\n");
		// Para migrar el agente
		// Object[] args = getArguments();
		// this.filename = args[0].toString();  
		this.filename = "jade.pptx";
		/* try {
			ContainerID destino = new ContainerID("Main-Container", null);
			System.out.println("Migrando el agente a " + destino.getID());
			doMove(destino);
		} catch (Exception e) {
			System.out.println("\n\n\nNo fue posible migrar el agente\n\n\n");
		} */
		this.afterMove();
	}

	protected void afterMove() {
		Location origen = here();
		System.out.println("\n\nHola, agente migrado con nombre local " + getLocalName());
		System.out.println("Y nombre completo... " + getName());
		System.out.println("Y en location " + origen.getID() + "\n\n");
		File directory = new File("clientFS/");
		if (! directory.exists()){
			directory.mkdir();
		}
		int position = 0;
		int bufferSize = 4096;
		// remote.readFile(this.filename, position, bufferSize);
		AID dest = new AID("FSA", AID.ISLOCALNAME);
		ACLMessage msg = new ACLMessage( ACLMessage.INFORM );
		msg.addUserDefinedParameter("FS_container", "Container-1");
		msg.addUserDefinedParameter("FS_action","read");
		msg.addUserDefinedParameter("FS_filename",this.filename);
		msg.addUserDefinedParameter("FS_position",Integer.toString(position));
		msg.addUserDefinedParameter("FS_length",Integer.toString(bufferSize));
		msg.addReceiver( dest );
		send(msg);
		ACLMessage msg_received = blockingReceive();
		System.out.println("Contenido: " + msg_received.toString() + "\n");
		if (("Lectura exitosa".equals(msg_received.getUserDefinedParameter("FS_answer")))) {
			byte[] dataRead = msg_received.getByteSequenceContent();
			int leidos = dataRead.length;

			File file = new File("clientFS/"+filename);
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Directorio clientFS/ creado");

			try {
				FileOutputStream localWrite = new FileOutputStream(file);
				ACLMessage msg_writing = new ACLMessage( ACLMessage.INFORM );
				msg_writing.addUserDefinedParameter("FS_action","write");
				msg_writing.addUserDefinedParameter("FS_filename","CopyOf" + this.filename);
				msg_writing.addReceiver( dest );

				while (leidos > 0) {
					localWrite.write(dataRead);
					// remote.writeFile("CopyOf" + filename, leidos, dataRead);
					msg_writing.addUserDefinedParameter("FS_length",Integer.toString(leidos));
                    msg_writing.setByteSequenceContent(dataRead);
					send(msg_writing);
					msg_received = blockingReceive();
	
					msg_writing.clearUserDefinedParameter("FS_length");
					position += leidos;
					// dataRead = remote.readFile(filename, position, bufferSize);
					msg.clearUserDefinedParameter("FS_position");
					msg.addUserDefinedParameter("FS_position",Integer.toString(position));
					send(msg);
					msg_received = blockingReceive();
					dataRead = msg_received.getByteSequenceContent();
					leidos = dataRead.length;
				}
	
				localWrite.flush();
				localWrite.close();
			} catch (Exception e) {
				e.printStackTrace();
			};
		} else {
			System.out.println("El archivo no existe...");
		}
	}
}