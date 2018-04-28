package SocketsAvaliacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Point;

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
	
	public static char[][] tabuleiro(String serverResponse){
		
		String[] tab = serverResponse.split("\n");
		char[][] tabs = new char[tab.length][tab[1].length()];
		
		for (int i = 1; i<tab.length;i++) 
		{
			for (int j = 0; j < tab[1].length();j++) 
			{
				tabs[i-1][j] = tab[i].charAt(j);
			}
		}
		System.out.println(Arrays.toString(tabs[0]));
		
		return tabs;
	}

	public static void main(String args[]) throws IOException
	{
		try
		{
			boolean jogar = true;
			String username;
			String resposta;
			Scanner scan = new Scanner(System.in);

			// Open your connection to a server, at port 1234
			Socket socket = new Socket("localhost", 1234);

			// Build DataStreams (input and output) to send and receive messages to/from the server
			OutputStream out = socket.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(out);

			InputStream in = socket.getInputStream();
			DataInputStream dataIn = new DataInputStream(in);

			System.out.println("WELCOME TO SOKOBAN! \n\n");
			System.out.println("Introduza o USERNAME: \n");

			username = scan.nextLine();
			dataOut.writeUTF(username);
			dataOut.flush();

			// Resposta à introdução do username
			resposta = dataIn.readUTF();
			while (resposta.equals("Not Ok"))
			{
				System.out.println("Username não válido. \n");
				System.out.println("Introduza o USERNAME: \n");
				scan.nextLine();
				dataOut.writeUTF(username);
				dataOut.flush();
			}

			System.out.println("Bem vindo: " + username + "!");

			System.out.println("Choose a level: \n");
			System.out.println("[1] -> Level 1");
			System.out.println("[2] -> Level 2");
			System.out.println("[3] -> Level 3");
			System.out.println("[4] -> Level 4");
			// Escolher o nível
			String level = scan.nextLine();
			// Enviar a escolha do nível para o servidor
			dataOut.writeUTF(level);
			dataOut.flush();

			String serverResponse = dataIn.readUTF();

			while (serverResponse.equals("ERRO"))
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

			char[][] tab = tabuleiro(serverResponse);
			
			//abrir o tabuleiro do nivel escolhido
			Nivel_Sokoban niveis = new Nivel_Sokoban(Integer.parseInt(level));
			ArrayList<Point> posicoes = niveis.pointsNivel;
			Point M1 = niveis.pointsNivel.get(0);

			while (jogar)
			{			
				System.out.println("Prima w, s, a ou d para se mover. q para restart e x para terminar jogo.");
				resposta = scan.nextLine();
				dataOut.writeUTF(resposta);
				dataOut.flush();
				
				System.out.println("estou sim?");
				
				serverResponse = dataIn.readUTF();
				System.out.println("sera?" + serverResponse);
				
				if (serverResponse.equals("teclaInvalida"))
				{
					System.out.println("Tecla Inválida!");
					continue;
				}
				else if (serverResponse.equals("movA"))
				{
					M1.translate(0,-1);
					System.out.println("carregou A");
				}
				else if (serverResponse.equals("movS"))
				{
					M1.translate(0, -1);
					System.out.println("carregou S");
				}
				else if (serverResponse.equals("movD"))
				{
					M1.translate(0, +1);
					System.out.println("carregou D");
				}
				else if (serverResponse.equals("movW"))
				{
					M1.translate(-1, 0);
					System.out.println("carregou W");
				}
				else if (serverResponse.equals("restart"))
				{
					return;
				}
				else if (serverResponse.equals("quit"))
				{
					//resposta = "quit";
					jogar = false;
				}
				else
				{
					System.out.println("AH?");
				}
				System.out.println("iniciio tabela");
								
				for (int i = 0; i<tab.length;i++) 
				{
					System.out.println(tab[i]);
				}
				System.out.println();
				

			}
			dataOut.writeUTF("");
			dataOut.flush();

			// Cleanup operations, close the streams, socket and then exit
			//dataOut.close();
			//dataIn.close();
			//socket.close();
			scan.close();
		}
		catch (IOException ex)
		{
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}