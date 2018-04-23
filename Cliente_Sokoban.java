package projeto3_SI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple greeting client. More information about sockets at:
 * http://download.oracle.com/javase/tutorial/networking/sockets/index.html
 * and in the book "Head First Java" - Chapter 15.
 */
public class Cliente_Sokoban
{
	// 'throws IOException' enables us to write the code without try/catch blocks
	// but it also keeps us from handling possible IO errors 
	// (when for instance there is a problem when connecting with the other party) 
	public static void main(String args[]) throws IOException 
	{
		// Open your connection to a server, at port 1234
		Socket socket = new Socket("localhost", 1234);

		// Build DataStreams (input and output) to send and receive messages to/from the server
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		
		System.out.println("WELCOME TO SOKOBAN! \n\n");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose a level: \n");
		System.out.println("[1] -> Level 1");
		System.out.println("[2] -> Level 2");
		System.out.println("[3] -> Level 3");
		System.out.println("[4] -> Level 4");
		//Escolher o nível
		String level = scan.nextLine();
		//Enviar a escolha do nível para o servidor
		dataOut.writeUTF(level);
		dataOut.flush();
		
		String serverResponse = dataIn.readUTF();
		
		while(serverResponse.equals("ERRO"))
		{
			System.out.println("Choose a level: \n");
			System.out.println("[1] -> Level 1");
			System.out.println("[2] -> Level 2");
			System.out.println("[3] -> Level 3");
			System.out.println("[4] -> Level 4");
			
			level = scan.nextLine();
			dataOut.writeUTF(level);
			dataOut.flush();
			
			serverResponse = dataIn.readUTF();
					
		}
		
		System.out.println("Servidor disse: " + serverResponse);
		
		

		// Cleanup operations, close the streams, socket and then exit
		dataOut.close();
		dataIn.close();
		socket.close();
		scan.close();
		
	}
}