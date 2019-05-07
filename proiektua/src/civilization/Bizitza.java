package civilization;

public class Bizitza extends Atributua {
	private int balioa;
	public Bizitza() {
		super();
		this.balioa = 10;
	}
	
	public int getBal() {
		return this.balioa;
	}
	
	public void kenduBizitza(int pDMG) {
		this.balioa = this.balioa - pDMG;
	}
}
