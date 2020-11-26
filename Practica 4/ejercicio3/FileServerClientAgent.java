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

	public void usage() {
        System.out.println(String.format("%nUso:%nleer: read archivo container posicionInicial bytesALeer%nescribir: write archivo container bytesAEscribir%ncopiar: copy archivo container%n"));
		System.exit(1);
    }

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
		if (args.length != 5) {
			usage();
		}
		String archivo = args[1];
		String container = args[2];
		int position = Integer.parseInt(args[3]);
		int aLeer = Integer.parseInt(args[4]);
		System.out.println(String.format("%nPedido de lectura sobre %s recibido%n", archivo));

		AID dest = new AID("FSA", AID.ISLOCALNAME);
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addUserDefinedParameter("FS_container", container);
		msg.addUserDefinedParameter("FS_action", "read");
		msg.addUserDefinedParameter("FS_filename", archivo);
		msg.addUserDefinedParameter("FS_position", Integer.toString(position));
		if (aLeer > BUFFERSIZE) { //Si tengo que leer menos bytes que el tamanio del buffer
			msg.addUserDefinedParameter("FS_length", Integer.toString(BUFFERSIZE));
		} else {
			msg.addUserDefinedParameter("FS_length", Integer.toString(aLeer));
		}
		msg.addReceiver(dest); 
		send(msg);

		ACLMessage msg_received = blockingReceive();
		if (msg_received.getUserDefinedParameter("FS_answer").equals("Lectura exitosa")) {
			byte[] dataRead = msg_received.getByteSequenceContent();
			int leidos = dataRead.length;
			aLeer = Math.max(aLeer - leidos, 0); // Actualizo los bytes que me quedan por leer
			File file = new File("clientFS/"+archivo);
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				FileOutputStream localWrite = new FileOutputStream(file);
				System.out.println(String.format("%nLeyendo archivo...%n"));
				int lecturas = 0;
				System.out.println(lecturas + ": " + leidos + " bytes leidos.");
				while (leidos == BUFFERSIZE) {
					localWrite.write(dataRead);
					position += leidos;
					msg.clearUserDefinedParameter("FS_position");
					msg.addUserDefinedParameter("FS_position",Integer.toString(position));
					aLeer = Math.max(aLeer - leidos, 0);
					if (aLeer < BUFFERSIZE) { //Si me quedan por leer menos bytes que el buffersize
						msg.clearUserDefinedParameter("FS_length");
						msg.addUserDefinedParameter("FS_length", Integer.toString(aLeer));
					}

					if (aLeer == 0) {
						break;
					}

					send(msg);
					lecturas++;
					msg_received = blockingReceive();
					dataRead = msg_received.getByteSequenceContent();
					leidos = dataRead.length;
					System.out.println(lecturas + ": " + leidos + " bytes leidos.");
				}
				localWrite.flush();
				localWrite.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void escribir(String[] args) {
		if (args.length != 4) {
			usage();
		}
		String archivo = args[1];
		String container = args[2];
		int bytesAEscribir = Integer.parseInt(args[3]);
		System.out.println(String.format("%nPedido de escritura sobre %s recibido%n", archivo));

		File file = new File("clientFS/" + archivo);
        if (!(file.exists())) {
            System.out.println("El archivo no existe");
            return;
        }

		try {
            // Obtengo el contenido del archivo con ese nombre
            byte[] fileContents = Files.readAllBytes(file.toPath()); 
            // Obtengo el tamanio del archivo
			int filesize = (int) file.length();
			int streams = Math.min(filesize, bytesAEscribir) / BUFFERSIZE;
            int resto = Math.min(filesize, bytesAEscribir) % BUFFERSIZE;

			AID dest = new AID("FSA", AID.ISLOCALNAME);
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.addReceiver(dest);
			msg.addUserDefinedParameter("FS_container", container);
			msg.addUserDefinedParameter("FS_action", "write");
			msg.addUserDefinedParameter("FS_filename", archivo);
		
			int aEscribir = Math.min(bytesAEscribir, BUFFERSIZE);
			msg.addUserDefinedParameter("FS_length", Integer.toString(aEscribir));
			
			int posicionArchivo = 0;
			for (int i = 0; i < streams; i++) {
				byte[] data = new byte[BUFFERSIZE];
				for (int j = 0; j < BUFFERSIZE; j++) {
					data[j] = fileContents[posicionArchivo];
					posicionArchivo++;
				}
				msg.setByteSequenceContent(data);
				send(msg);
			}

			msg.clearUserDefinedParameter("FS_length");
			msg.addUserDefinedParameter("FS_length", Integer.toString(resto));

			byte[] data = new byte[resto];
			for (int i = 0; i < resto; i++) {
				data[i] = fileContents[posicionArchivo];
				posicionArchivo++;
			}
			msg.setByteSequenceContent(data);
			send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private void copiar(String[] args) {
		if (args.length != 3) {
			usage();
		}

		String archivo = args[1];
		String container = args[2];
		int position = 0;

		AID dest = new AID("FSA", AID.ISLOCALNAME);
		ACLMessage msg = new ACLMessage( ACLMessage.INFORM );
		msg.addUserDefinedParameter("FS_container", container);
		msg.addUserDefinedParameter("FS_action","read");
		msg.addUserDefinedParameter("FS_filename",archivo);
		msg.addUserDefinedParameter("FS_position",Integer.toString(position));
		msg.addUserDefinedParameter("FS_length",Integer.toString(BUFFERSIZE));
		msg.addReceiver( dest );
		send(msg);
		ACLMessage msg_received = blockingReceive();
		System.out.println("Contenido: " + msg_received.toString() + "\n");
		if (("Lectura exitosa".equals(msg_received.getUserDefinedParameter("FS_answer")))) {
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
				ACLMessage msg_writing = new ACLMessage( ACLMessage.INFORM );
				msg_writing.addUserDefinedParameter("FS_container", container);
				msg_writing.addUserDefinedParameter("FS_action","write");
				msg_writing.addUserDefinedParameter("FS_filename","CopyOf" + archivo);
				msg_writing.addReceiver(dest);

				while (leidos > 0) {
					localWrite.write(dataRead);
					msg_writing.addUserDefinedParameter("FS_length",Integer.toString(leidos));
                    msg_writing.setByteSequenceContent(dataRead);
					send(msg_writing);
					msg_received = blockingReceive();
	
					msg_writing.clearUserDefinedParameter("FS_length");
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
			};
		} else {
			System.out.println("El archivo no existe...");
		}
	}
}