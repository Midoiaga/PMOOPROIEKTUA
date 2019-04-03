package civilization;

public class Mapa {
	
	private char[][] mapa;
	
	private static Mapa nireMapa = null;
	
	private Mapa(){
		mapa = new char[8][18];
				
		mapa[1][1]='H';
		mapa[3][12]='h';
		mapa[5][6]='h';
		mapa[6][16]='H';
	}
	
	public static Mapa getNireMapa() {
		if(nireMapa==null) {
			nireMapa = new Mapa();
		}
		
		return nireMapa;
	}
	
	public void print(){
		int i=0,j=0;
		System.out.print("+------------------------------------+");
		while (i<8) {
			System.out.println("");
			while(j<18) {
				if(j==0)System.out.print("|");
				System.out.print(mapa[i][j]);System.out.print(mapa[i][j]);
				j++;
			}
			j=0;
			i++;
			System.out.print("|");
		}
		System.out.println("");
		System.out.println("+------------------------------------+");
	}
	
	public void printJokalariakIkustenDuena(Jokalaria pJokalaria) {
		char[][] mapaPrint = new char[8][18];
		int i=0,j=0;
		while(i<8) {
			while(j<18) {
				if(pJokalaria.zerbaitDago(i,j)) {
					mapaPrint[i][j] = mapa[i][j];
					if(i-1!=-1) mapaPrint[i-1][j] = mapa[i-1][j];
					if(i+1!=9) mapaPrint[i+1][j] = mapa[i+1][j];
					if(j-1!=-1) mapaPrint[i][j-1] = mapa[i][j-1];
					if(j+1!=19) mapaPrint[i][j+1] = mapa[i][j+1];
				}
				j++;
			}
			j=0;
			i++;
		}
		i=0;
		j=0;
		System.out.print("+------------------------------------+");
		while (i<8) {
			System.out.println("");
			while(j<18) {
				if(j==0)System.out.print("|");
				if(pJokalaria.gerlariBatDago(i, j)) System.out.print("G");
				else System.out.print(mapaPrint[i][j]);System.out.print(mapaPrint[i][j]);
				j++;
			}
			j=0;
			i++;
			System.out.print("|");
		}
		System.out.println("");
		System.out.println("+------------------------------------+");
	}
}
