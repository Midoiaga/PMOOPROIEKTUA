package civilization;

public abstract class Eraikina {
	
	private int urreKostua;
	private int egurreKostua;
	private int harriKostua;
	private String izena;
	
	public Eraikina(String pIzena) {
		this.izena = pIzena;
	}

	public void print() {
		System.out.println(izena);	
	}
	
	public void printKostua() {
		System.out.println(izena+" eraikina eraikitzeak, urreko "+urreKostua+", egurreko "+egurreKostua+" eta harriko "+harriKostua+" kostatzen du.");	
	}

	public boolean eraikiDaiteke(int pUrrea, int pHarria, int pEgurra) {
		if(pUrrea>=this.egurreKostua&&pHarria>=this.harriKostua&&pEgurra>=this.harriKostua) {
			return true;
		}
		return false;
	}

	public boolean izenBeraDu(String pIzena) {
		if(this.izena==pIzena) return true;
		return false;
	}

	public int getEgurreKost() {
		return this.egurreKostua;
	}

	public int getHarriKost() {
		return this.harriKostua;
	}

	public int getUrreKost() {
		return this.urreKostua;
	}
	
}