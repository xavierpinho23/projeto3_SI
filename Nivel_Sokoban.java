package SocketsAvaliacao;
import java.awt.Point;
import java.util.ArrayList;

public class Nivel_Sokoban
{
	//É aqui que estão definidos os diferentes níveis
	
	private int level;
	char[][] table;
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
		M1 = new Point(y1M,x1M);
		
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
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);pointsNivel.add(B3);pointsNivel.add(X4);pointsNivel.add(B4);
		
		// criação do tabuleiro de jogo do nível 1
		char[][] table = {
				{ ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*','*' },
				{ '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ','*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*','*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ',' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ',' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ',' ' }};
		
		// positions of boxes B, worker M and storage locations X of level 1
		table[yX1][xX1] = 'X'; 
		table[yB1][xB1] = 'B';
		table[yB2][xB2] = 'B';
		table[yX2][xX2] = 'X';
		table[yX3][xX3] = 'X';
		table[yB3][xB3] = 'B';
		table[yM][xM] = 'M';
		table[yB4][xB4] = 'B';
		table[yX4][xX4] = 'X';
	
		
		this.table=table;
		}
		else if(level==2){

		yM=2;  // original row of M
		xM=7;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		M1 = new Point(y1M,x1M);
		
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
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);pointsNivel.add(B3);
		
		char[][] table = {
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*','*', '*', '*', '*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ',' ', ' ', ' ', '*' },
				{ '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ',' ', ' ', ' ', '*' },
				{ ' ', ' ', ' ', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', '*' },
				{ ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', ' ', ' ',' ', ' ', ' ', '*' },
				{ ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', '*', '*', '*','*', '*', '*', '*' },
				{ ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ' }, };		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = 'X';
		table[yB1][xB1] = 'B';
		table[yB2][xB2] = 'B';
		table[yX2][xX2] = 'X';
		table[yX3][xX3] = 'X';
		table[yB3][xB3] = 'B';
		table[yM][xM] = 'M';
	
		this.table=table;
	}
		else if (level==3) {
		yM=2;  // original row of M
		xM=5;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		M1 = new Point(y1M,x1M);
		
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
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);pointsNivel.add(B3);pointsNivel.add(X4);pointsNivel.add(B4);pointsNivel.add(X5);pointsNivel.add(B5);
		
		// criação do tabuleiro de jogo do nível 3
		char[][] table = { 
				{ ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ' },
				{ '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ' },
				{ '*', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*' },
				{ '*', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' },};
		
		
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = 'X';
		table[yB1][xB1] = 'B';
		table[yB2][xB2] = 'B';
		table[yX2][xX2] = 'X';
		table[yX3][xX3] = 'X';
		table[yB3][xB3] = 'B';
		table[yB4][xB4] = 'B';
		table[yB5][xB5] = 'B';
		table[yX4][xX4] = 'X';
		table[yX5][xX5] = 'X';
		table[yM][xM] = 'M';
		
		this.table=table;
	}

		else if (level==4) {
		yM=1;  // original row of M
		xM=6;  // original column of M
		y1M=yM; // new row of M
		x1M=xM; // new column of M
		
		Point M = new Point(yM,xM);
		M1 = new Point(y1M,x1M);
		
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
		
		pointsNivel.add(M);pointsNivel.add(X1);pointsNivel.add(B1);pointsNivel.add(X2);pointsNivel.add(B2);pointsNivel.add(X3);pointsNivel.add(B3);
		
		// criação do tabuleiro de jogo do nível 4
		char[][] table = {
				{ ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ' },
				{ ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ',' ' },
				{ ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ',' ' },
				{ '*', '*', '*', '*', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*','*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*','*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ','*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ','*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*','*' },};
	
		// positions of boxes B, worker M and storage locations X of level 2
		table[yX1][xX1] = 'X';
		table[yB1][xB1] = 'B';
		table[yB2][xB2] = 'B';
		table[yX2][xX2] = 'X';
		table[yX3][xX3] = 'X';
		table[yB3][xB3] = 'B';
		table[yM][xM] = 'M';
				
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
		String s=" ";
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table[0].length; j++)
			{
				s = s + table[i][j];
			}
			s = s + "\n";
		}
		return s;
	}

	public String movimentos(String tecla)
	{
		String resposta = "";

		if (!(tecla.equals("a") || !tecla.equals("s") || !tecla.equals("d") || !tecla.equals("w") || !tecla.equals("q") || !tecla.equals("x")))
		{
			resposta = "teclaInvalida";
		}
		else if (tecla.equals("a"))
		{
			M1.translate(0, -1);
			resposta = "movM";
		}
		else if (tecla.equals("s"))
		{
			M1.translate(+1, 0);
			resposta = "movM";
		}
		else if (tecla.equals("d"))
		{
			M1.translate(0, +1);
			resposta = "movM";
		}
		else if (tecla.equals("w"))
		{
			M1.translate(-1, 0);
			resposta = "movM";
		}
		else if (tecla.equals("q"))
		{
			resposta = "restart";
		}
		else if (tecla.equals("x"))
		{
			resposta = "quit";
			///
		}

		if (table[(int) M1.getX()][(int) M1.getY()] == '*') 
		// If the future position of worker M is occupied by '*' the system doesn't evolve
		{
			//M1 volta à posição original
			M1.setLocation(pointsNivel.get(0));
			resposta = "movInvalido";
		}
		else if (table[(int) M1.getX()][(int) M1.getY()] == ' ' || table[(int) M1.getX()][(int) M1.getY()] == 'X')
		//Caso a nova posicao do M seja um espaço vazio
		{
			resposta = "movM:" + M1.getX() + "," + M1.getY();
			this.table[(int) pointsNivel.get(0).getX()][(int) pointsNivel.get(0).getY()] = ' '; 
			pointsNivel.get(0).setLocation(M1.getX(),M1.getY());
			this.table[(int) M1.getX()][(int) M1.getY()] = 'M';
		}
		else
		//caso seja caixa B ou local de entrega X
		{
		for (int i = 2; i < pointsNivel.size(); i += 2)
		//Caixas B
		{
			//Se o M vai para uma das posicoes de B
			if (M1.equals(pointsNivel.get(i)))
			{
				//System.out.println(pointsNivel.get(i));
				fB = pointsNivel.get(i);				
				fB.translate((int) (M1.getX() - pointsNivel.get(0).getX()),(int) (M1.getY() - pointsNivel.get(0).getY()));

				// If the future position of B is occupied by '*' or 'B' the system doesn't evolve
				if (table[(int) fB.getX()][(int) fB.getY()] == '*' || table[(int) fB.getX()][(int) fB.getY()] == 'B')
				{
					//System.out.println(fB.getX() + " e " + fB.getY());
					M1.setLocation(pointsNivel.get(0));
					fB.setLocation(pointsNivel.get(i).getX(), pointsNivel.get(i).getY());
					//fB = null;
					resposta = "movInvalido";
				}
				else
				{				
					this.table[(int) pointsNivel.get(0).getX()][(int) pointsNivel.get(0).getY()] = ' ';
					this.table[(int) M1.getX()][(int) M1.getY()] = 'M';
					this.table[(int) fB.getX()][(int) fB.getY()] = 'B';
					
					pointsNivel.get(i).setLocation(fB.getX(), fB.getY());
					//System.out.println(pointsNivel.get(i).getX() +" e " + pointsNivel.get(i).getY());
					//System.out.println("pointsNivel i =" + pointsNivel.set(i, fB));
					
					pointsNivel.get(0).setLocation(M1.getX(), M1.getY());
					//System.out.println(pointsNivel.get(0).getX() +" e " + pointsNivel.get(0).getY());
					//System.out.println("pointsNivel M1 =" + pointsNivel.set(0, M1));

					resposta = "movMeB:" + M1.getX() + "," + M1.getY() + ":" + fB.getX() + "," + fB.getY();
				}
			}
		}	
		}
		for (int i = 1; i<pointsNivel.size();i+=2)
			//Locais de Entrega X
		{
			if (table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] == 'B')
			{
				this.table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] = 'B';
			}
			else if (table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] == 'M')
			{
				this.table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] = 'M';
			}
			else
			{
				this.table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] = 'X';
			}

		
		}
			/*for (int r = 0;r<table.length;r++) {
				for (int j = 0; j<table[0].length;j++) {
					System.out.print(table[r][j]);
				}
				System.out.println("\n");
			}*/
		
		//Verificar se o nivel está concluido
		/*for (int i = 1; i < pointsNivel.size(); i += 2)
			//locais de entrega X
		{
			int contadorCiclo = 0;
			int contadorCaixas = 0;
			if (!(this.table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] == 'B'))
			{
				resposta = resposta;
			}
			
			else if (this.table[(int) pointsNivel.get(i).getX()][(int) pointsNivel.get(i).getY()] == 'B')
			{
				resposta = resposta + ":caixaSucesso";
				contadorCaixas = +1 ;
			}
			
			if (contadorCaixas == contadorCiclo)
			{	
				if (!(getLevel() == 4))
				{
					resposta = resposta + ":NivelConcluido";
					setLevel(getLevel()+1);
				}
				else
				{
					resposta = resposta + ":JogoConcluido";
				}
				
			}
			
		}*/
				
		return resposta;		
}
}
