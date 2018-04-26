package projeto3_SI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	Nivel_Sokoban niveis;
	private ServerSocket s; 
	
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
		
		String msg = dataIn.readUTF();
		System.out.println("Mensagem recebida...");
		if (msg.contains(" ") || msg.isEmpty()) {
			dataOut.writeUTF("NotOk");
			dataOut.flush();
		}
		else {
		dataOut.writeUTF("Ok");
		dataOut.flush();
		}
		
		
		//Fechar streams
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
		
		String msg = dataIn.readUTF();
		System.out.println("Mensagem recebida...");
		while(!(msg.equals("1")) && !(msg.equals("2")) && !(msg.equals("3")) && !(msg.equals("4")))
		{
			dataOut.writeUTF("ERRO");
			dataOut.flush();
			msg = dataIn.readUTF();
		}
			

		niveis = new Nivel_Sokoban(Integer.parseInt(msg));
		String tabuleiro = niveis.toString();
		
		
		dataOut.writeUTF("nivel:" + niveis.getLevel() + "\n" + tabuleiro);

		dataOut.flush();
	
		}
		catch (IOException e) {
			//Tratamento de falhas
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE,null,e);	
		}

	}
	private void trata3Conexao(Socket socket) throws IOException {
		
		//Tratar conversação cliente - servidor na escolha do nível
		
		try {	//Criar stream de entrada e saída
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		
		String tecla = dataIn.readUTF();
		System.out.println("Mensagem recebida..." + tecla);

			
		
		String resposta = niveis.movimentos(tecla);
		//Enquanto não sair, nem restar nem ganhar o jogo
		while (!resposta.equals("quit"))
		{
			dataOut.writeUTF(resposta);	
			dataOut.flush();
		}
		
		dataOut.flush();
		
		//Fechar streams
		dataIn.close();
		dataOut.close();
		}
		catch (IOException e) {
			//Tratamento de falhas
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
			Logger.getLogger(Cliente_Sokoban.class.getName()).log(Level.SEVERE,null,e);	
		}
		finally {
			//final do tratamento do protocolo
			fechaSocket(socket);
		}

	}
	public static void main(String args[]) throws IOException
	{
		// Register service on port 1234
			ArrayList<String> users = new ArrayList<String>();
			ArrayList<Integer> pontuações = new ArrayList<Integer>();
		
		try {

			// Wait and accept a connection
			Server_Sokoban server = new Server_Sokoban();
			System.out.println("Aguardando conexão...");
			server.criarServerSocket(1234);
			while (true)
			{
				System.out.println("1");
				//Primeira conexão - login
				Socket socket = server.esperaConexao();
				System.out.println("Cliente conectado.");
				server.trata1Conexao(socket);
				
				//Segunda conexão - escolha de nivel
				System.out.println("2");
				//server.esperaConexao();
				server.trata2Conexao(socket);
				
				//Terceira conexão - jogo
				System.out.println("3");
				//server.trata3Conexao(socket);
				
				System.out.println("Cliente finalizado.");
			
		}}
		catch (IOException e){
			
		}



			// use the DataInputStream to read a String sent by the client
		}
	}
