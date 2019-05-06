package civilization;

public abstract class Atributua {
	
	//atrib
	private int maila;
	private int mailaMax;
	private int urreKost;
	
	public Atributua() {
		this.maila = 1;
		this.mailaMax = 10;
		this.urreKost = 100;
	}
	
	public boolean mailaMaxDauka() {
		if(this.maila >= this.mailaMax) return true;
		else return false;
	}
	
	public void gehituMaila() {
		this.maila++;
		this.urreKost=this.urreKost+100+(this.urreKost/4);
	}
	
	public int maila() {
		return this.maila;
	}
	
	public boolean urreNahiko(int pUrre) {
		if(this.urreKost<=pUrre) return true;
		else return false;
	}
	
	public int urreBerria(int pUrre) {
		return pUrre - this.urreKost;
	}
	
}
