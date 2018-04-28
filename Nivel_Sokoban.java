package SocketsAvaliacao;
import java.awt.Point;
import java.util.ArrayList;

public class Nivel_Sokoban
{
	//É aqui que estão definidos os diferentes níveis
	
	private int level;
	String[][] table;
	ArrayList<Point> pointsNivel = new ArrayList<Point>();

	private int xM;
	private int yM;
	private int x1M;
	private int y1M;
	Point fB;
	Point M1;
	private int posoffB;

	
	public Nivel_Sokoban(int nivel) {
		this.level=nivel;
		table();
	}
	
	public void table()
	{
		if (level==1) {
		yM = 4;    //original row of M
		xM = 12;   //original column of M
		y1M = yM;  //new row of M
		x1M = xM;  //new column of M
		
		Point M = new Point(yM,xM);
		
		int yX1=1; int yX2=3; int yX3=4; int yX4=6; //turned B and X positions into variables, so we can change them
		int xX1=9; int xX2=18; int xX3=3; int xX4=12;
		Point X1 = new Point(yX1,xX1);
		Point X2 = new Point(yX2,xX2);
		Point X3 = new Point(yX3,xX3);
		Point X4 = new Point(yX4,xX4);

		
		
		
		int yB1=3; int yB2=3; int yB3=4; int yB4=5;
		int xB1=9; int xB2=15; int xB3=9; int xB4=12;
		Point B1 = new Point(yB1,xB1);
		Point B2 = new Point(yB2,xB2);
		Point B3 = new Point(yB3,xB3);
		Point B4 = new Point(yB4,xB4);
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);
		pointsNivel.add(B3);pointsNivel.add(X4);pointsNivel.add(B4);
		
		// criação do tabuleiro de jogo do nível 1
		String[][] table = {
				{ " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*","*" },
				{ "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ","*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*","*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " "," " }};
		
		// positions of boxes B, worker M and storage locations X of level 1
		table[yX1][xX1] = "X"; 
		table[yB1][xB1] = "B";
		table[yB2][xB2] = "B";
		table[yX2][xX2] = "X";
		table[yX3][xX3] = "X";
		table[yB3][xB3] = "B";
		table[yM][xM] = "M";
		table[yB4][xB4] = "B";
		table[yX4][xX4] = "X";
	
		
		this.table=table;
		}
		else if(level==2){

		yM=2;  // original row of M
		xM=7;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		
		int yX1=3; int yX2=4; int yX3=5;  //turned B and X positions into variables, so we can change them
		int xX1=22; int xX2=22; int xX3=22;
		
		Point X1 = new Point(yX1,xX1);
		Point X2 = new Point(yX2,xX2);
		Point X3 = new Point(yX3,xX3);

		
		int yB1=2; int yB2=3; int yB3=3; 
		int xB1=6; int xB2=6; int xB3=7;
		
		Point B1 = new Point(yB1,xB1);
		Point B2 = new Point(yB2,xB2);
		Point B3 = new Point(yB3,xB3);
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);
		pointsNivel.add(B3);
		
		String[][] table = {
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*", "*", "*", "*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " "," ", " ", " ", "*" },
				{ "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " "," ", " ", " ", "*" },
				{ " ", " ", " ", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", "*" },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", " ", " "," ", " ", " ", "*" },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", "*", "*", "*","*", "*", "*", "*" },
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " "," ", " ", " ", " " }, };		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = "X";
		table[yB1][xB1] = "B";
		table[yB2][xB2] = "B";
		table[yX2][xX2] = "X";
		table[yX3][xX3] = "X";
		table[yB3][xB3] = "B";
		table[yM][xM] = "M";
	
		this.table=table;
	}
		else if (level==3) {
		yM=2;  // original row of M
		xM=5;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		
		int yX1=2; int yX2=5; int yX3=6; int yX4=6; int yX5=6; //turned B and X positions into variables, so we can change them
		int xX1=9; int xX2=3; int xX3=3; int xX4=6; int xX5=12;
		
		Point X1 = new Point(yX1,xX1);
		Point X2 = new Point(yX2,xX2);
		Point X3 = new Point(yX3,xX3);
		Point X4 = new Point(yX4,xX4);
		Point X5 = new Point(yX5,xX5);
		
		int yB1=3; int yB2=4; int yB3=4; int yB4=5; int yB5=6;
		int xB1=6; int xB2=2; int xB3=9; int xB4=6; int xB5=9;
		
		Point B1 = new Point(yB1,xB1);
		Point B2 = new Point(yB2,xB2);
		Point B3 = new Point(yB3,xB3);
		Point B4 = new Point(yB4,xB4);
		Point B5 = new Point(yB5,xB5);
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);
		pointsNivel.add(B3);pointsNivel.add(X4);pointsNivel.add(B4);pointsNivel.add(X5);pointsNivel.add(B5);
		
		// criação do tabuleiro de jogo do nível 3
		String[][] table = { 
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " " },
				{ "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " " },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " " },
				{ "*", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*" },
				{ "*", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*" },};
		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = "X";
		table[yB1][xB1] = "B";
		table[yB2][xB2] = "B";
		table[yX2][xX2] = "X";
		table[yX3][xX3] = "X";
		table[yB3][xB3] = "B";
		table[yB4][xB4] = "B";
		table[yB5][xB5] = "B";
		table[yX4][xX4] = "X";
		table[yX5][xX5] = "X";
		table[yM][xM] = "M";
		
		this.table=table;
	}

		else if (level==4) {
		yM=1;  // original row of M
		xM=6;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		
		int yX1=4; int yX2=5; int yX3=6; //turned B and X positions into variables, so we can change them
		int xX1=3; int xX2=3; int xX3=3;
		
		Point X1 = new Point(yX1,xX1);
		Point X2 = new Point(yX2,xX2);
		Point X3 = new Point(yX3,xX3);
		
		int yB1=2; int yB2=5; int yB3=6;
		int xB1=9; int xB2=5; int xB3=15; 
		
		Point B1 = new Point(yB1,xB1);
		Point B2 = new Point(yB2,xB2);
		Point B3 = new Point(yB3,xB3);
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);
		pointsNivel.add(B3);
		
		// criação do tabuleiro de jogo do nível 4
		String[][] table = {
				{ " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", " ", " ", " ", " ", " ", " ", " ", " "," " },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*", "*", "*", "*", "*", "*", " ", " "," " },
				{ " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " "," " },
				{ "*", "*", "*", "*", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*" },
				{ "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", "*", "*", "*","*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ","*" },
				{ "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ","*" },
				{ "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*","*" },};
	
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = "X";
		table[yB1][xB1] = "B";
		table[yB2][xB2] = "B";
		table[yX2][xX2] = "X";
		table[yX3][xX3] = "X";
		table[yB3][xB3] = "B";
		table[yM][xM] = "M";
				
		
		
		this.table=table;
		}
}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}
	//Método para converter o Array em String
	public String toString()
	{
		
		String s="";
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table[0].length; j++)
			{
				s = s + table[i][j];
			}
			s = s +"\n";
		}
		return s;
		
	}
	public String movimentos (String tecla)
	{
		M1 = new Point(y1M,x1M);
		String resposta = "";
		boolean jogo = true;
		
		while (jogo)
		{
			if (!(tecla.equals("a") || !tecla.equals("s") || !tecla.equals("d") || !tecla.equals("w")
					|| !tecla.equals("q") || !tecla.equals("x")))
			{
				resposta = "teclaInvalida";
			}
			else if (tecla.equals("a"))
			{
				M1.translate(0, -1);
				resposta = "movA";
			}
			else if (tecla.equals("s"))
			{
				M1.translate(+1, 0);
				resposta = "movS";
			}
			else if (tecla.equals("d"))
			{
				M1.translate(0, +1);
				resposta = "movD";
			}
			else if (tecla.equals("w"))
			{
				M1.translate(-1, 0);
				resposta = "movW";
			}
			else if (tecla.equals("q"))
			{
				resposta = "restart";
			}
			else if (tecla.equals("x"))
			{
				resposta = "quit";
				jogo = false;
			}
		}
		if (table[y1M][x1M].equals("*")) //If the future position of worker M is occupied by "*" the system doesn't evolve
		{
			System.out.println(M1);
			M1.setLocation(pointsNivel.get(0));
			
			resposta = "movInvalido";
			System.out.println("yo");
		}
		
		for (int i =2;i<pointsNivel.size();i+=2)
		{
			if (M1.equals(pointsNivel.get(i)))
			{
				
			//If the future position of B is occupied by "*" or "B" the system doesn't evolve
				fB = pointsNivel.get(i);
				posoffB=i;
				fB.translate((int) (M1.getX()-pointsNivel.get(0).getX()), (int) (M1.getY()-pointsNivel.get(0).getY())); 
				
				if (table[(int) fB.getX()][(int) fB.getY()].equals("*") 
					|| table[(int) fB.getX()][(int) fB.getY()].equals("B") ) 
				{
					M1.setLocation(pointsNivel.get(0));
					fB=null;
					resposta = "movInvalido";
				}
				else
				{
				table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()]=" ";
				table[(int)fB.getX()][(int) fB.getY()]="B";
			
				pointsNivel.set(i, fB);
				//resposta = "movMeB:"+M1.getX()+ ","+M1.getY()  + ":"+fB.getX() + "," + fB.getY();
				resposta = "movMeB";
				}
			}
		}
		return resposta;
		
}
	public void mover() {
		table[(int)pointsNivel.get(0).getX()][(int)pointsNivel.get(0).getY()]=" ";
		table[(int)M1.getX()][(int) M1.getY()] = "M";
		table[(int)pointsNivel.get(posoffB).getX()][(int)pointsNivel.get(posoffB).getY()]=" ";
		table[(int)fB.getX()][(int)fB.getY()] = "B";
		//This guarantee that X will appear if nothing is in X supposed positions
		for (int i =2;i<pointsNivel.size();i+=2)
		{
			for (int j =1;j<pointsNivel.size();j+=2) {
				if (!(M1.equals(pointsNivel.get(j)) && pointsNivel.get(i).equals(pointsNivel.get(j)))) {
					
					table[(int)pointsNivel.get(j).getX()][(int)pointsNivel.get(j).getY()]="X";
					
				}
			}
		
		}
		
		//This guarantee that M and B will appear if they are in X positions
		table[(int)pointsNivel.get(0).getX()][(int) pointsNivel.get(0).getY()] = "M";
		for (int i=2;i<pointsNivel.size();i+=2) {
			table[(int)pointsNivel.get(i).getX()][(int)pointsNivel.get(i).getY()]="B";
		}
		
	}
}
