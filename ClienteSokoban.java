package SocketsAvaliacao;

import java.util.ArrayList;
import java.util.Collections;

import trabalho2_si.Cliente;

public class ClienteSokoban
{
	private String username;
	private int pontos;
	static ArrayList<ClienteSokoban> clientes = new ArrayList<ClienteSokoban>();
	ArrayList<String> users = new ArrayList<String>();
	ArrayList<Integer> pontuacoes = new ArrayList<Integer>();
	ArrayList<String> highscores = new ArrayList<String>();

	public ClienteSokoban(String username)
	{
		username = this.username;
		int pontos = this.pontos;		
	}
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getPontos()
	{
		return pontos;
	}

	public void setPontos(int pontos)
	{
		this.pontos = pontos;
	}

	public static ArrayList<ClienteSokoban> getClientes()
	{
		return clientes;
	}

	public static void setClientes(ArrayList<ClienteSokoban> clientes)
	{
		ClienteSokoban.clientes = clientes;
	}

	public ArrayList<String> getUsers()
	{
		return users;
	}

	public void setUsers(ArrayList<String> users)
	{
		this.users = users;
	}

	public ArrayList<Integer> getPontuacoes()
	{
		return pontuacoes;
	}

	public void setPontuacoes(ArrayList<Integer> pontuacoes)
	{
		this.pontuacoes = pontuacoes;
	}

	public ArrayList<String> getHighscores()
	{
		return highscores;
	}

	public void setHighscores(ArrayList<String> highscores)
	{
		this.highscores = highscores;
	}

	public String highscores()
	{
		String tabela = "Nome    -    Pontuação \n";
		
		Collections.sort(users, Collections.reverseOrder());
		for (int i = 0; i<users.size(); i++)
		{
			//highscores.add(i, users.get(i));
			//String p = Integer.toString(pontuacoes.get(i));
			//highscores.add(i, p);
			tabela = tabela + users.get(i) + "      -     " + pontuacoes.get(i) + "\n"; 
		}
		
		return tabela;
	}
	public void addClientes(ClienteSokoban cliente)
	{
		this.clientes.add(cliente);
	}
}
