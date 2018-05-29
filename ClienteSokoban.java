package projeto3_SI;

public class ClienteSokoban
{
	private String username;
	private int pontos;

	public ClienteSokoban(String username)
	{
		this.username = username;	
		this.pontos=0;
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
}