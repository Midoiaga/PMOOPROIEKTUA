package civilization;

import java.util.ArrayList;

public class Mapa {
	
	private char[][] mapa;
	
	public Mapa(int pX, int pY){
		mapa = new char[pX][pY];
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

	public int maxX() {
		return this.mapa.length;
	}
	
	public int maxY() {
		return this.mapa[1].length;
	}
	
	public char get(int x, int y) {
		return mapa[x][y];
	}
	
	public void set(int x, int y, char c) {
		mapa[x][y] = c;
	}
}
