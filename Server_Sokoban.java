package projeto3_SI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A simple greeting server. More information about sockets at:
 * http://download.oracle.com/javase/tutorial/networking/sockets/index.html
 * and in the book 'Head First Java' - Chapter 15.
 */
public class Server_Sokoban
{
	// 'throws IOException' enables us to write the code without try/catch blocks
	// but it also keeps us from handling possible IO errors 
	// (when for instance there is a problem when connecting with the other party)
	
	Nivel_Sokoban niveis;
	private ServerSocket s; 
	boolean jogoConcluido = false;
	ClienteSokoban cliente;
	ArrayList<ClienteSokoban> clientes = new ArrayList<ClienteSokoban>();
	
	public String highscores() {
		TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
		String str = "";
		for (int i = 0;i<clientes.size();i++) {
			tm.put(clientes.get(i).getPontos(), clientes.get(i).getUsername());
		}
	      Set set = tm.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         str = str + mentry.getKey() +";" + mentry.getValue() + "\n";
	      }
	      return str;
	   }
		
	
	
	private void setjogoConcluido(boolean jogoConcluido) {
		this.jogoConcluido=jogoConcluido;
	}
	
	
	private void criarServerSocket(int porta) throws IOException {
		s = new ServerSocket(porta); //Criar o servidor
	}
	private Socket esperaConexao() throws IOException {
		Socket socket = s.accept(); //Esperar pedido de conexão
		return socket;
	}
	private void fechaSocket(Socket socket) throws IOException {
		socket.close();
	}
	private void trata1Conexao(Socket socket) throws IOException {
	
		//Tratar conversação cliente - servidor no login
		
		try {	//Criar stream de entrada e saída
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		
		
		
		String username = dataIn.readUTF();
		System.out.println("Mensagem recebida 1...");
		
		while (username == " " || username.isEmpty()) {
			dataOut.writeUTF("NotOk");
			dataOut.flush();
			
			username = dataIn.readUTF();
		}
		dataOut.writeUTF("Ok");
		dataOut.flush();
		cliente = new ClienteSokoban(username);
		clientes.add(cliente);
		
		}
		catch (IOException e) {
			//Tratamento de falhas
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE,null,e);	
		}

	}

	private void trata2Conexao(Socket socket) throws IOException {
		
		//Tratar conversação cliente - servidor na escolha do nível
		
		try {	//Criar stream de entrada e saída
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		
		//Leitura do nivel escolhido pelo cliente
		String level = dataIn.readUTF();
		System.out.println("Mensagem recebida 2..." + level);
		
		while(!(level.equals("1")) && !(level.equals("2")) && !(level.equals("3")) && !(level.equals("4")))
		{
			dataOut.writeUTF("ERRO");
			dataOut.flush();
			level = dataIn.readUTF();
		}
		
		niveis = new Nivel_Sokoban(Integer.parseInt(level));
		String tabuleiro = niveis.toString();
		
		
		//enviar o tabuleiro para o Cliente
		dataOut.writeUTF("nivel: " + niveis.getLevel() + "\n" + tabuleiro);
		dataOut.flush();
	
		}
		catch (IOException e) {
			//Tratamento de falhas
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE,null,e);	
		}

	}
	private void trata3Conexao(Socket socket) throws IOException {
		
		//Tratar conversação cliente - jogar
		
		try {	//Criar stream de entrada e saída
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		
		System.out.println("Mensagem recebida 3...");
		
		String tecla = dataIn.readUTF();
		//System.out.println("tecla = " + tecla);

		String resposta = niveis.movimentos(tecla);
		
		//Pontos iniciais
		int pontos = 0;
		boolean jogar = true;
		String highscore = highscores();
		//Enquanto não sair, nem restar nem ganhar o jogo
		while (jogar)
		{

			if (resposta.contains("nivelConcluido"))
			{
				//ganha 100 pontos por concluir um nivel
				
				pontos = 100;
				cliente.setPontos(cliente.getPontos()+pontos);
				resposta = resposta + ":" + cliente.getPontos();
				jogar = false;
				dataOut.writeUTF(resposta);
				dataOut.flush();
				
			}
			else if (resposta.contains("jogoConcluido")) {
				pontos =100;
				cliente.setPontos(cliente.getPontos()+pontos);
				resposta = resposta + ":" + highscore;
				jogar = false;
				boolean c = true;
				setjogoConcluido(c);
				dataOut.writeUTF(resposta);
				
				dataOut.flush();
			}
			else if (resposta.contains("restart")) {
				jogar = false;
				setjogoConcluido(true);
				dataOut.writeUTF(resposta + ":" + highscore);
				dataOut.flush();
			}
			else if (resposta.contains("quit")) {
				jogar = false;
				boolean c = true;
				setjogoConcluido(c);
				System.out.println(jogoConcluido);
				dataOut.writeUTF(resposta + ":" + highscore);
				dataOut.flush();
			}
			else if (resposta.contains("movM"))
				//inclui o movM e o movMeB
			{
				//Perde 1 ponto por movimento válido
				pontos = -1;
				cliente.setPontos(cliente.getPontos()+pontos);
				resposta = resposta + ":" + cliente.getPontos();
				dataOut.writeUTF(resposta);
				dataOut.flush();
				
				tecla = dataIn.readUTF();
				resposta = niveis.movimentos(tecla);
				
			}
			else {
				dataOut.writeUTF(resposta);
				dataOut.flush();
				
				tecla = dataIn.readUTF();
				resposta = niveis.movimentos(tecla);
			}
			
			
		}			
		
		}
		catch (IOException e) {
			//Tratamento de falhas
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE,null,e);	
		}

	}
	public static void main(String args[]) throws IOException
	{
		// Registar serviço no porto 1234
		try
		{

			// Esperar e aceitar conexão
			Server_Sokoban server = new Server_Sokoban();
			System.out.println("Aguardando conexão...");
			server.criarServerSocket(1234);
			while (true)
			{
				server.setjogoConcluido(false);
				// Primeira conexão - login
				Socket socket = server.esperaConexao();
				System.out.println("Cliente conectado.");
				server.trata1Conexao(socket);

				while (!server.jogoConcluido) {
				// Segunda conexão - escolha de nivel
				// server.esperaConexao();
				server.trata2Conexao(socket);
				// Terceira conexão - jogo
				server.trata3Conexao(socket);
				}
				System.out.println("Cliente finalizado.");
				server.fechaSocket(socket);
			}
		}
		catch (IOException e)
		{
			System.out.println("upsss");

		}

	}
}
