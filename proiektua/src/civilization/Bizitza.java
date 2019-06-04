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
	
	public int gehituMaila(int pUrrea, ListaEraikinak eraikinak) {
		if(urreNahiko(pUrrea)) {
			if(eraikinak.bilaturaikina("Zerratokia")!=null) {
				this.maila++;
				pUrrea=pUrrea-this.urreKost;
				this.urreKost=this.urreKost+100+(this.urreKost/4);
			}
		}
		return pUrrea;
	}
}
