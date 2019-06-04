package civilization;

public class MapaPartida {
	
	private Mapa mapa;
	private Mapa ikusiJ1;
	private Mapa ikusiJ2;
	
	private static MapaPartida nireMapa = null;
	
	private MapaPartida(){
		mapa = new Mapa(8,18);
		
		mapa.set(1 , 1 , 'H');
		mapa.set(3 , 12, 'h');
		mapa.set(5 , 6 , 'h');
		mapa.set(6 , 16, 'H');
		
		ikusiJ1 = new Mapa(8,18);
		
		ikusiJ1.set(1 , 1 , 'H');
		
		ikusiJ2 = new Mapa(8,18);
		
		ikusiJ2.set(6 , 16, 'H');
	}
	
	public static MapaPartida getNireMapa() {
		if(nireMapa==null) {
			nireMapa = new MapaPartida();
		}
		
		return nireMapa;
	}
	
		public void print(){
			mapa.print();
		}
	
		public void printJ1(){
			ikusiJ1.print();
		}
	
		public void printJ2(){
			ikusiJ2.print();
		}
	
	public int maxX() {
		return mapa.maxX();
	}	
	
	public int maxY() {
		return mapa.maxY();
	}
	
	public void updateJ1(int x, int y) {
		ikusiJ1.set(x, y, mapa.get(x, y));
	}
	
	public void updateJ2(int x, int y) {
		ikusiJ2.set(x, y, mapa.get(x, y));
	}

	public void erreseteatu() {
		mapa = new Mapa(8,18);
		
		mapa.set(1 , 1 , 'H');
		mapa.set(3 , 12, 'h');
		mapa.set(5 , 6 , 'h');
		mapa.set(6 , 16, 'H');
	}
}
