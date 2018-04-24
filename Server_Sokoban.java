package projeto3_SI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A simple greeting server. More information about sockets at:
 * http://download.oracle.com/javase/tutorial/networking/sockets/index.html
 * and in the book "Head First Java" - Chapter 15.
 */
public class Server_Sokoban
{
	// 'throws IOException' enables us to write the code without try/catch blocks
	// but it also keeps us from handling possible IO errors 
	// (when for instance there is a problem when connecting with the other party)
	

	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException
	{
		// Register service on port 1234
			ArrayList<String> users = new ArrayList<String>();
			ArrayList<Integer> pontuações = new ArrayList<Integer>();
		ServerSocket s = new ServerSocket(1234);
		
		while (true)
		{
			// Wait and accept a connection
			Socket s1 = s.accept();

			// Build DataStreams (input and output) to send and receive messages to/from the client
			InputStream in = s1.getInputStream();
			DataInputStream dataIn = new DataInputStream(in);
			
			OutputStream out = s1.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(out);


			// use the DataInputStream to read a String sent by the client
			String level = dataIn.readUTF();

			
			
			while(!(level.equals("1")) && !(level.equals("2")) && !(level.equals("3")) && !(level.equals("4")))
			{
				dataOut.writeUTF("ERRO");
				dataOut.flush();
				level = dataIn.readUTF();
			}
				

			Nivel_Sokoban niveis = new Nivel_Sokoban(Integer.parseInt(level));
			String tabuleiro = niveis.toString();
			
			
			dataOut.writeUTF("Cliente escolheu o nível: " + niveis.getLevel() + "\n" + tabuleiro);
			dataOut.flush();

			
				
		
			String tecla = dataIn.readUTF();
			String resposta = niveis.movimentos(tecla);
			//Enquanto não sair, nem restar nem ganhar o jogo
			while (!resposta.equals("quit"))
			{
				dataOut.writeUTF(resposta);	
			}
			
			
			
			
			
		


			// Cleanup operations, close the streams, the connection, but don't close the ServerSocket
			dataOut.close();
			dataIn.close();
			s1.close();
		}
	}
}