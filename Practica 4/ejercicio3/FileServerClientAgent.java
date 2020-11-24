package ejercicio3;

import java.io.File;
import jade.core.*;
import jade.lang.acl.ACLMessage;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileServerClientAgent extends Agent {

	private static final int BUFFERSIZE = 4096;

	public void setup() {
		Location origen = here();
		System.out.println(String.format("%n%s en %s%n", getName(), origen.getID()));

		File directory = new File("clientFS/");
		if (!directory.exists()){
			directory.mkdir();
		}

		String[] args = ((String) getArguments()[0]).split(" ");
		String accion = args[0];
		if (accion.equals("read")) {
			this.leer(args);
		} else if (accion.equals("write")) {
			this.escribir(args);
		} else if (accion.equals("copy")) {
			this.copiar(args);
		}
	}

	private void leer(String[] args) {
		String archivo = args[1];
		String container = args[2];
		int position = Integer.parseInt(args[3]);
		System.out.println(String.format("%nPedido de Lectura sobre %s recibido%n", archivo));

		AID dest = new AID("FSA", AID.ISLOCALNAME);
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addUserDefinedParameter("FS_container", container);
		msg.addUserDefinedParameter("FS_action", "read");
		msg.addUserDefinedParameter("FS_filename", archivo);
		msg.addUserDefinedParameter("FS_position", Integer.toString(position));
		msg.addUserDefinedParameter("FS_length", Integer.toString(BUFFERSIZE));
		msg.addReceiver(dest); 
		send(msg);

		ACLMessage msg_received = blockingReceive();
		if (msg_received.getUserDefinedParameter("FS_answer").equals("Lectura exitosa")) {
			byte[] dataRead = msg_received.getByteSequenceContent();
			int leidos = dataRead.length;

			File file = new File("clientFS/"+archivo);
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				FileOutputStream localWrite = new FileOutputStream(file);
				System.out.println(String.format("%nLeyendo archivo...%n"));
				while (leidos > 0) {
					localWrite.write(dataRead);
					position += leidos;
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
			}
		}

	}

	private void escribir(String[] args) {

	}

	private void copiar(String[] args) {

	}

	/* protected void afterMove() {
		Location origen = here();
		System.out.println("\n\nHola, agente migrado con nombre local " + getLocalName());
		System.out.println("Y nombre completo... " + getName());
		System.out.println("Y en location " + origen.getID() + "\n\n");

		int position = 0;
		int bufferSize = 4096;

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
				msg_writing.addUserDefinedParameter("FS_container", "Container-1");
				msg_writing.addUserDefinedParameter("FS_action","write");
				msg_writing.addUserDefinedParameter("FS_filename","CopyOf" + this.filename);
				msg_writing.addReceiver(dest);

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
	} */
}