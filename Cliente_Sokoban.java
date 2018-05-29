package projeto3_SI;

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
 * http://download.oracle.com/javase/tutorial/networking/sockets/index.html and in the book 'Head First Java' - Chapter
 * 15.
 */
public class Cliente_Sokoban
{
	// 'throws IOException' enables us to write the code without try/catch blocks
	// but it also keeps us from handling possible IO errors
	// (when for instance there is a problem when connecting with the other party)

	public char[][] tabuleiro(String serverResponse)
	{

		String[] tab = serverResponse.split("\n");
		char[][] tabs = new char[tab.length][tab[2].length()];

		for (int i = 1; i < tabs.length; i++)
		{
			for (int j = 0; j< tabs[0].length;j++) {
				
				tabs[i-1][j]=tab[i].charAt(j);
			
			}
		}

		return tabs;
	}

	public static void main(String args[]) throws IOException
	{
		Point M = null;
		ArrayList<Point> Xs = new ArrayList<Point>();
		Point X = null;
		Cliente_Sokoban cliente = new Cliente_Sokoban();
		try
		{
			boolean jogar = true;
			boolean menu = true;
			String username;
			String resposta;
			Scanner scan = new Scanner(System.in);


			System.out.println("===========WELCOME TO SOKOBAN!=================");

			
			while (menu)
			{
				// Open your connection to a server, at port 1234
				Socket socket = new Socket("localhost", 1234);

				// Build DataStreams (input and output) to send and receive messages to/from the server
				OutputStream out = socket.getOutputStream();
				DataOutputStream dataOut = new DataOutputStream(out);

				InputStream in = socket.getInputStream();
				DataInputStream dataIn = new DataInputStream(in);
				
				System.out.println("Introduza o USERNAME: ");

				username = scan.nextLine();
				dataOut.writeUTF(username);
				dataOut.flush();

				// Resposta à introdução do username
				resposta = dataIn.readUTF();
				while (resposta.equals("NotOk"))
				{
					System.out.println("Username não válido. \n");
					System.out.println("Introduza o USERNAME:");
					scan.nextLine();
					dataOut.writeUTF(username);
					dataOut.flush();
					
					resposta = dataIn.readUTF();
				}
				jogar = true;


				System.out.println("==========Bem vindo: " + username + "!==============");

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
					System.out.println("Choose a level: ");
					System.out.println("[1] -> Level 1");
					System.out.println("[2] -> Level 2");
					System.out.println("[3] -> Level 3");
					System.out.println("[4] -> Level 4");

					level = scan.nextLine();
					dataOut.writeUTF(level);
					dataOut.flush();

					serverResponse = dataIn.readUTF();
				}
				
				char[][] tabs = cliente.tabuleiro(serverResponse);
				
				for (int i = 0; i < tabs.length; i++)
				{
					System.out.println(tabs[i]);
				}
				System.out.println();
				
				for (int i = 0; i<tabs.length;i++) {
					for (int j = 0;j<tabs[0].length;j++) {
						if (tabs[i][j]=='M') {
							M = new Point(i,j);
						}
					}
				}
				for (int i = 0; i<tabs.length;i++) {
					for (int j = 0;j<tabs[0].length;j++) {
						if (tabs[i][j]=='X') {
							X = new Point(i,j);
							Xs.add(X);
						}
					}
				}

				while (jogar)
				{
					System.out.println("Prima w, s, a ou d para se mover. q para restart e x para terminar jogo.");
					String tecla = scan.nextLine();
					dataOut.writeUTF(tecla);
					dataOut.flush();

					serverResponse = dataIn.readUTF();
					
					
					
					String[] response = serverResponse.split(":");
					
					if (response[0].equals("teclaInvalida"))
					{
						System.out.println("Tecla Inválida!");
						continue;
					}
					else if (response[0].equals("movM"))
					{
						System.out.println("Pontos: " + response[response.length-1]);
						String[] coord = response[1].split(",");
						double x1 = Double.parseDouble(coord[0]);
						int x = (int) x1;
						double y1 = Double.parseDouble(coord[1]);
						int y = (int) y1;

						// Posicao antiga de M passa a vazia
						tabs[(int) M.getX()][(int) M.getY()] = ' ';
						// Nova posição de M
						M.setLocation(x, y);
						tabs[x][y] = 'M';

					}
					else if (response[0].equals("movMeB"))
					{
						System.out.println("Pontos: " + response[response.length-1]);
						String[] coordm = response[1].split(",");
						double mx1 = Double.parseDouble(coordm[0]);
						int mx = (int) mx1;
						double my1 = Double.parseDouble(coordm[1]);
						int my = (int) my1;

						String[] coordb = response[2].split(",");
						double bx1 = Double.parseDouble(coordb[0]);
						int bx = (int) bx1;
						double by1 = Double.parseDouble(coordb[1]);
						int by = (int) by1;

						tabs[(int) M.getX()][(int) M.getY()] = ' ';
						M.setLocation(mx, my);

						tabs[(int)M.getX()][(int) M.getY()] = 'M';
						tabs[bx][by] = 'B';

					}
					else if (Arrays.asList(response).contains("restart"))
					{
						String[] str = response[response.length-1].split("\n");
						String[] keysandvalues = new String[str.length];
						for (int i = 0; i<str.length;i++) {
							String[] str2 = str[i].split(";");
							keysandvalues[i] ="\nNome: " + str2[1] + " => " + str2[0] + " Pontos.";
							
							
							}
					
						System.out.println("Highscores: " + Arrays.toString(keysandvalues));
						Xs.clear();
						jogar = false;
					}
					else if (Arrays.asList(response).contains("quit"))
					{
						String[] str = response[response.length-1].split("\n");
						String[] keysandvalues = new String[str.length];
						for (int i = 0; i<str.length;i++) {
							String[] str2 = str[i].split(";");
							keysandvalues[i] ="Nome: " + str2[1] + " => " + str2[0] + " Pontos.";
							
							
							}
					
						System.out.println("Highscores: " + Arrays.toString(keysandvalues));
						System.out.println("\nAté à próxima!");
						menu = false;
						break;
					}
					else if (Arrays.asList(response).contains("movInvalido"))
					{
						System.out.println("Movimento Inválido");
					}
					
					if (Arrays.asList(response).contains("caixaSucesso"))
					{
						System.out.println("Caixa Sucesso");
					}
					if (Arrays.asList(response).contains("nivelConcluido"))
					{
						
						level = Integer.toString(Integer.parseInt(level) + 1);
						System.out.println("NivelConcluido! \nPassou para o nível " + level);
						dataOut.writeUTF(level);
						dataOut.flush();
						
						serverResponse = dataIn.readUTF();
						
						tabs = cliente.tabuleiro(serverResponse);
						
						Xs.clear();
						for (int i = 0; i<tabs.length;i++) {
							for (int j = 0;j<tabs[0].length;j++) {
								if (tabs[i][j]=='M') {
									M = new Point(i,j);
								}
							}
						}
						for (int i = 0; i<tabs.length;i++) {
							for (int j = 0;j<tabs[0].length;j++) {
								if (tabs[i][j]=='X') {
									X = new Point(i,j);
									Xs.add(X);
								}
							}
						}
						
						//jogar = false;
						//System.out.println("HIGHSCORES: \n " + cliente.highscores() );
						

					}
					else if (response[response.length - 1].equals("jogoConcluido"))
					{
						String[] str = response[response.length-1].split("\n");
						String[] keysandvalues = new String[str.length];
						for (int i = 0; i<str.length;i++) {
							String[] str2 = str[i].split(";");
							keysandvalues[i] ="\nNome: " + str2[1] + " => " + str2[0] + " Pontos.";
							
							
							}
					
						System.out.println("Highscore: " + Arrays.toString(keysandvalues));
						System.out.println("\nJogo Concluído!");
						
						jogar = false;
					}

					for (int i = 0; i < Xs.size(); i += 2)
					// Locais de Entrega X
					{
						if (tabs[(int) Xs.get(i).getX()][(int) Xs.get(i).getY()] == 'B')
						{
							tabs[(int) Xs.get(i).getX()][(int) Xs.get(i).getY()] = 'B';
						}
						else if (tabs[(int) Xs.get(i).getX()][(int) Xs.get(i).getY()] == 'M')
						{
							tabs[(int) Xs.get(i).getX()][(int) Xs.get(i).getY()] = 'M';
						}
						else
						{
							tabs[(int) Xs.get(i).getX()][(int) Xs.get(i).getY()] = 'X';
						}
					}
					for (int i = 0; i < tabs.length; i++)
					{
						System.out.println(tabs[i]);
					}
					System.out.println();

				}
				
				dataOut.close();
				dataIn.close();
				socket.close();
			}
			// Cleanup operations, close the streams, socket and then exit
			
			scan.close();
			
		}
		catch (IOException ex)
		{
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}