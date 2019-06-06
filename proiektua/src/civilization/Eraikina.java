package civilization;

public class Eraikina {
	
	
	private int urreKostua;
	private int egurreKostua;
	private int harriKostua;
	private String izena;
	
	public Eraikina(String pIzena, int pEgurreKostua, int pHarriKostua, int pUrreKostua) {
		//eraikinaren eraikitzailea
		this.izena = pIzena;
		this.egurreKostua = pEgurreKostua;
		this.harriKostua = pHarriKostua;
		this.urreKostua = pUrreKostua;
	}

	public void print() {
		//
		System.out.println(izena);	
	}
	
	public void printKostua() {
		//eraikina eraikitzeko beharrezkoak diren baliabideak printeatzen ditu
		System.out.println("- " + izena+" eraikina eraikitzeak, urreko "+urreKostua+", egurreko "+egurreKostua+" eta harriko "+harriKostua+" kostatzen du.");	
	}

	public boolean eraikiDaiteke(int pUrrea, int pHarria, int pEgurra) {
		//eraiki daitekeen edo adierazten du, baliabide nahikoak ez badaude false, bestela true
		if(pUrrea>=this.egurreKostua&&pHarria>=this.harriKostua&&pEgurra>=this.harriKostua) {
			return true;
		}
		return false;
	}

	public boolean izenBeraDu(String pIzena) {
		//izen bera badu true, bestela false
		if(this.izena.equals(pIzena)) return true;
		return false;
	}
	
	public String getIzena() {
		return this.izena;
	}

	public int getEgurreKost() {
		//no voy ha explicar esto equisde
		return this.egurreKostua;
	}

	public int getHarriKost() {
		//no voy ha explicar esto equisde
		return this.harriKostua;
	}

	public int getUrreKost() {
		//no voy ha explicar esto equisde
		return this.urreKostua;
	}
	
}

