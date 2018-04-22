package SocketsAvaliacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
	
	static Nivel_Sokoban niveis = new Nivel_Sokoban();
	
	public static void main(String args[]) throws IOException
	{
		// Register service on port 1234
		ServerSocket s = new ServerSocket(1234);
		while (true)
		{
			// Wait and accept a connection
			Socket s1 = s.accept();

			// Build DataStreams (input and output) to send and receive messages to/from the client
			OutputStream out = s1.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(out);

			InputStream in = s1.getInputStream();
			DataInputStream dataIn = new DataInputStream(in);

			// use the DataInputStream to read a String sent by the client
			String level = dataIn.readUTF();
			//int nivel = Integer.parseInt(level);
			//fazer while
			if (level.equals("1"))
			{
				niveis.getNivel1();
				//dataOut.writeLong(niveis.getNivel1());
				dataOut.writeUTF("Cliente escolheu o nível 1 \n");
				dataOut.flush();
			}
			else if(level.equals("2"))
			{
				niveis.getNivel2();
				dataOut.writeUTF("Cliente escolheu o nível 2 \n");
				dataOut.flush();
			}
			else if(level.equals("3"))
			{
				niveis.getNivel3();
				dataOut.writeUTF("Cliente escolheu o nível 3 \n");
				dataOut.flush();
			}
			else if(level.equals("4"))
			{
				niveis.getNivel4();
				dataOut.writeUTF("Cliente escolheu o nível 4 \n");
				dataOut.flush();
			}
			while (level.equals("1", ...))
			{
				dataOut.writeUTF("ERRO");
				dataOut.flush();
			}


			// Cleanup operations, close the streams, the connection, but don't close the ServerSocket
			dataOut.close();
			dataIn.close();
			s1.close();
		}
	}
}