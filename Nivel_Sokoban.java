package SocketsAvaliacao;

public class Nivel_Sokoban
{
	//É aqui que estão definidos os diferentes níveis
	private String[][] nivel1;
	private String[][] nivel2;
	private String[][] nivel3;
	private String[][] nivel4;
	private int level;
	
	public String[][] nivel1()
	{
		int yM = 4;    //original row of M
		int xM = 12;   //original column of M
		int y1M = yM;  //new row of M
		int x1M = xM;  //new column of M
		
		int yX1=1; int yX2=3; int yX3=4; int yX4=6; //turned B and X positions into variables, so we can change them
		int xX1=9; int xX2=18; int xX3=3; int xX4=12;
		
		int yB1=3; int yB2=3; int yB3=4; int yB4=5;
		int xB1=9; int xB2=15; int xB3=9; int xB4=12;

		
		// criação do tabuleiro de jogo do nível 1
		String[][] table1 = {
				{ " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", "*", " ", " ", "X", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*","*" },
				{ "*", "*", "*", "*", "*", "*", "*", " ", " ", "B", " ", " ", " ", " ", " ", "B", " ", " ", "X", " ", " ","*" },
				{ "*", " ", " ", "X", " ", " ", " ", " ", " ", "B", " ", " ", "M", " ", " ", "*", "*", "*", "*", "*", "*","*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", "B", " ", " ", "*", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", "X", " ", " ", "*", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " "," " }};
		
		// positions of boxes B, worker M and storage locations X of level 1
		table1[yX1][xX1] = "X"; 
		table1[yB1][xB1] = "B";
		table1[yB2][xB2] = "B";
		table1[yX2][xX2] = "X";
		table1[yX3][xX3] = "X";
		table1[yB3][xB3] = "B";
		table1[yM][xM] = "M";
		table1[yB4][xB4] = "B";
		table1[yX4][xX4] = "X";
	
		return table1;
	}
	
	public String[][] nivel2()
	{

		int yM=2;  // original row of M
		int xM=7;  // original column of M
		int y1M=yM; // new row of M
		int x1M=xM; // new column of M
		
		int yX1=3; int yX2=4; int yX3=5;  //turned B and X positions into variables, so we can change them
		int xX1=22; int xX2=22; int xX3=22;
		
		int yB1=2; int yB2=3; int yB3=3; 
		int xB1=6; int xB2=6; int xB3=7;
		
		String[][] table2 = {
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", "B", " ", " ", "M", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*", "*", "*", "*" },
				{ "*", " ", " ", " ", " ", " ", "B", " ", " ", "B", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ","X", " ", " ", "*" },
				{ "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " ","X", " ", " ", "*" },
				{ " ", " ", " ", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ","X", " ", " ", "*" },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", " ", " "," ", " ", " ", "*" },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", "*", "*", "*","*", "*", "*", "*" },
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " "," ", " ", " ", " " }, };		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table2[yX1][xX1] = "X";
		table2[yB1][xB1] = "B";
		table2[yB2][xB2] = "B";
		table2[yX2][xX2] = "X";
		table2[yX3][xX3] = "X";
		table2[yB3][xB3] = "B";
		table2[yM][xM] = "M";
	
		return table2;
	
	}
	public String[][] nivel3()
	{
		int yM=2;  // original row of M
		int xM=5;  // original column of M
		int y1M=yM; // new row of M
		int x1M=xM; // new column of M
		
		int yX1=2; int yX2=5; int yX3=6; int yX4=6; int yX5=6; //turned B and X positions into variables, so we can change them
		int xX1=9; int xX2=3; int xX3=3; int xX4=6; int xX5=12;
		
		int yB1=3; int yB2=4; int yB3=4; int yB4=5; int yB5=6;
		int xB1=6; int xB2=2; int xB3=9; int xB4=6; int xB5=9;
		
		// criação do tabuleiro de jogo do nível 3
		String[][] table3 = { 
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " " },
				{ "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " " },
				{ "*", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*" },
				{ "*", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*" },};
		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table3[yX1][xX1] = "X";
		table3[yB1][xB1] = "B";
		table3[yB2][xB2] = "B";
		table3[yX2][xX2] = "X";
		table3[yX3][xX3] = "X";
		table3[yB3][xB3] = "B";
		table3[yM][xM] = "M";
		
		return table3;
	}

	
	public String[][] nivel4()
	{
		int yM=1;  // original row of M
		int xM=6;  // original column of M
		int y1M=yM; // new row of M
		int x1M=xM; // new column of M
		
		int yX1=4; int yX2=5; int yX3=6; //turned B and X positions into variables, so we can change them
		int xX1=3; int xX2=3; int xX3=3;
		
		int yB1=3; int yB2=4; int yB3=4; int yB4=5; int yB5=6;
		int xB1=6; int xB2=2; int xB3=9; int xB4=6; int xB5=9;
		
		
		// criação do tabuleiro de jogo do nível 4
		String[][] table4 = {
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " "," " },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " "," " },
				{ "*", "*", "*", "*", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*" },
				{ "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ","*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ","*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*","*" },};
	
		// positions of boxes B, worker M and storage locations X of level 2
		table4[yX1][xX1] = "X";
		table4[yB1][xB1] = "B";
		table4[yB2][xB2] = "B";
		table4[yX2][xX2] = "X";
		table4[yX3][xX3] = "X";
		table4[yB3][xB3] = "B";
		table4[yM][xM] = "M";
				
		return table4;
	}

	public String[][] getNivel1()
	{
		return nivel1;
	}

	public String[][] getNivel2()
	{
		return nivel2;
	}

	public String[][] getNivel3()
	{
		return nivel3;
	}

	public String[][] getNivel4()
	{
		return nivel4;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

}
