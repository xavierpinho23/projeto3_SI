package SocketsAvaliacao;

import java.util.ArrayList;
import java.util.Collections;

import trabalho2_si.Cliente;

public class ClienteSokoban
{
	private String username;
	private int pontos;
	
	static ArrayList<ClienteSokoban> clientes = new ArrayList<ClienteSokoban>();
	
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

	public ArrayList<Integer> getPontuacoes()
	{
		return pontuacoes;
	}

	public void setPontuacoes(ArrayList<Integer> pontuacoes)
	{
		this.pontuacoes = pontuacoes;
	}

	public String highscores()
	{
		String tabela = "Nome    -    Pontuação \n";
		
		Collections.sort(pontuacoes, Collections.reverseOrder());
		for (int i = 0; i<clientes.size(); i++)
		{
			//highscores.add(i, users.get(i));
			//String p = Integer.toString(pontuacoes.get(i));
			//highscores.add(i, p);
			tabela = tabela + clientes.get(i) + "      -     " + pontuacoes.get(i) + "\n"; 
		}
		
		return tabela;
	}
	public void addClientes(ClienteSokoban cliente)
	{
		this.clientes.add(cliente);
	}
}
