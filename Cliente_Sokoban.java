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
 * http://download.oracle.com/javase/tutorial/networking/sockets/index.html and in the book 'Head First Java' - Chapter
 * 15.
 */
public class Cliente_Sokoban
{
	// 'throws IOException' enables us to write the code without try/catch blocks
	// but it also keeps us from handling possible IO errors
	// (when for instance there is a problem when connecting with the other party)

	public static char[][] tabuleiro(String serverResponse)
	{

		String[] tab = serverResponse.split("\n");
		char[][] tabs = new char[tab.length][tab[1].length()];

		for (int i = 0; i < tab.length; i++)
		{
			tabs[i] = tab[i].toCharArray();
		}
		System.out.println(Arrays.toString(tabs));

		return tabs;
	}

	public static void main(String args[]) throws IOException
	{
		try
		{
			boolean jogar = true;
			boolean login = true;
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
			while (login)
			{
				System.out.println("===========WELCOME TO SOKOBAN!=================");
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
				}

				ClienteSokoban cliente = new ClienteSokoban(username);
				ClienteSokoban.clientes.add(cliente);

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

				System.out.println("Servidor disse: " + serverResponse);

				// abrir o tabuleiro do nivel escolhido
				Nivel_Sokoban niveis = new Nivel_Sokoban(Integer.parseInt(level));
				ArrayList<Point> posicoes = niveis.pointsNivel;

				while (jogar)
				{
					System.out.println("Prima w, s, a ou d para se mover. q para restart e x para terminar jogo.");
					String tecla = scan.nextLine();
					dataOut.writeUTF(tecla);
					dataOut.flush();

					serverResponse = dataIn.readUTF();
					// pontos
					String pontos = dataIn.readUTF();
					System.out.println("Pontos = " + pontos);
					int pt = Integer.parseInt(pontos);
					cliente.setPontos(pt);
					
					/*for (int k; k < ClienteSokoban.clientes.size();k++)
					{
						if (cliente.getUsername().equals(ClienteSokoban.clientes.get(k).getUsername()))
						{
							ClienteSokoban.clientes.get(k).setPontuacoes(cliente.getPontos());
						}
					}*/
					

					System.out.println("serverResponse= " + serverResponse);
					String[] response = serverResponse.split(":");
					// System.out.println("response[0] = " + response[0]);

					if (response[0].equals("teclaInvalida"))
					{
						System.out.println("Tecla Inválida!");
						continue;
					}
					else if (response[0].equals("movM"))
					{
						String[] coord = response[1].split(",");
						double x1 = Double.parseDouble(coord[0]);
						int x = (int) x1;
						double y1 = Double.parseDouble(coord[1]);
						int y = (int) y1;

						// Posicao antiga de M passa a vazia
						niveis.table[(int) posicoes.get(0).getX()][(int) posicoes.get(0).getY()] = ' ';
						// Nova posição de M
						posicoes.get(0).setLocation(x, y);
						niveis.table[x][y] = 'M';

					}
					else if (response[0].equals("movMeB"))
					{
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

						niveis.table[(int) posicoes.get(0).getX()][(int) posicoes.get(0).getY()] = ' ';
						posicoes.get(0).setLocation(mx, my);

						niveis.table[(int) posicoes.get(0).getX()][(int) posicoes.get(0).getY()] = 'M';
						niveis.table[bx][by] = 'B';

					}
					else if (response[0].equals("restart"))
					{
						login = false;
					}
					else if (response[0].equals("quit"))
					{
						jogar = false;
					}
					else if (response[0].equals("movInvalido"))
					{
						System.out.println("MovimentoInválido");
						continue;
					}
					if (response[response.length - 1].equals("nivelConcluido"))
					{
						System.out.println("NivelConcluido!");
						level = level + 1;
						niveis = new Nivel_Sokoban(Integer.parseInt(level));
						System.out.println("HIGHSCORES: \n " + cliente.highscores() );
						
						continue;
					}
					if (response[2].contains("caixaSucesso"))
					{
						System.out.println("CaixaSucesso");
					}
					if (response[response.length - 1].equals("jogoConcluido"))
					{
						System.out.println("jogoConcluido");
						login = false;
					}

					for (int i = 1; i < posicoes.size(); i += 2)
					// Locais de Entrega X
					{
						if (niveis.table[(int) posicoes.get(i).getX()][(int) posicoes.get(i).getY()] == 'B')
						{
							niveis.table[(int) posicoes.get(i).getX()][(int) posicoes.get(i).getY()] = 'B';
						}
						else if (niveis.table[(int) posicoes.get(i).getX()][(int) posicoes.get(i).getY()] == 'M')
						{
							niveis.table[(int) posicoes.get(i).getX()][(int) posicoes.get(i).getY()] = 'M';
						}
						else
						{
							niveis.table[(int) posicoes.get(i).getX()][(int) posicoes.get(i).getY()] = 'X';
						}
					}
					for (int i = 0; i < niveis.table.length; i++)
					{
						System.out.println(niveis.table[i]);
					}
					System.out.println();

				}

				// Cleanup operations, close the streams, socket and then exit
				dataOut.close();
				dataIn.close();
				socket.close();
				scan.close();
			}
		}
		catch (IOException ex)
		{
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}