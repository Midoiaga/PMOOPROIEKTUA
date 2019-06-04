package civilization;

public abstract class Atributua {
	
	//atrib
	protected int maila;
	protected int mailaMax;
	protected int urreKost;
	
	public Atributua() {
		this.maila = 1;
		this.mailaMax = 10;
		this.urreKost = 100;
	}
	
	public boolean mailaMaxDauka() {
		if(this.maila >= this.mailaMax) return true;
		else return false;
	}
	
	public int gehituMaila(int pUrrea, ListaEraikinak eraikinak) {
		return 0;
	}
	
	public int maila() {
		return this.maila;
	}
	
	protected boolean urreNahiko(int pUrre) {
		if(this.urreKost<=pUrre) return true;
		else return false;
	}
	
	public int urreBerria(int pUrre) {
		return pUrre - this.urreKost;
	}
	
}
