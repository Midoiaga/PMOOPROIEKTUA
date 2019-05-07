package civilization;

public class Gerlaria {

	//atrib
	private Bizitza HP;
	private Indarra A;
	private Defentza D;
	private Abiadura V;
	private String izena;
	private int posX;
	private int posY;
	
	public Gerlaria(String pIzena, int pX, int pY) {
		//eraikitzailea
		this.izena = pIzena;
		this.HP= new Bizitza();
		this.A = new Indarra();
		this.D = new Defentza();
		this.V = new Abiadura();
		this.posX = pX;
		this.posY = pY;
	}
	
	public boolean hildaDago() {
		if(this.HP.getBal()<=0) return true;
		return false;
	}

	public int aukerak(int pUrrea) {
		//aukerak aukeratu lol
		this.printAukerak();
		String aukera = Teklatua.getNireTeklatua().getAukerak(Aukerak.getAukerak().aukerakFiltro("Stats"));
		switch(aukera) {
		case"Bizitza":
			if(!this.HP.mailaMaxDauka()) {
				if(this.HP.urreNahiko(pUrrea)) {
					this.HP.gehituMaila();
					pUrrea = this.HP.urreBerria(pUrrea);
				}
			}
			
			break;
		case"Indarra":
			if(!this.A.mailaMaxDauka()) {
				if(this.A.urreNahiko(pUrrea)) {
					this.A.gehituMaila();
					pUrrea = this.A.urreBerria(pUrrea);
				}
			}
			break;
		case"Defentza":
			if(!this.D.mailaMaxDauka()) {
				if(this.D.urreNahiko(pUrrea)) {
					this.D.gehituMaila();
					pUrrea = this.D.urreBerria(pUrrea);
				}
			}
			break;
		case"Abiadura":
			if(!this.V.mailaMaxDauka()) {
				if(this.V.urreNahiko(pUrrea)) {
					this.V.gehituMaila();
					pUrrea = this.V.urreBerria(pUrrea);
				}
			}
			break;
		case"Ezer":
			break;
		}
		return pUrrea;
	}
	
	private void printAukerak() {
		//jokalariak egin ditzakeen akzioak printeatzen ditu
		System.out.println(this.izena + " hobetzeko dituzun aukerak hauek dira:");
		if(!this.HP.mailaMaxDauka()) System.out.println("-Bizitza");
		if(!this.A.mailaMaxDauka()) System.out.println("-Indarra");
		if(!this.D.mailaMaxDauka()) System.out.println("-Defentza");
		if(!this.V.mailaMaxDauka()) System.out.println("-Abiadura");
	}
	
	public void printGerlaria() {
		//gerlariari buruzko informazioa printeatzen ditu (pos)
		System.out.println(this.izena + " " + this.posX + "," + this.posY + " posizioan dago.");
	}
	
	public void eliminar(int i, int j) {
		//gerlaria posizio batetik ezabatu
		this.posX = i;
		this.posY = j;
	}

	public void mugitu() {
		/*
		 * gerlaria mugitu
		 * azkarregia bada mezu bat pantailaratu
		 * eta berriro saiatu
		 */
		int abiadura = this.V.maila();
		this.printGerlaria();
		System.out.println(abiadura + " kasila mugitu daiteke");
		System.out.println("Sartu x ardatzeko posizio berria: ");
		int newPosX = Teklatua.getNireTeklatua().irakurriKoordenatua(Mapa.getNireMapa().maxX());
		System.out.println("Sartu y adratzeko posizio berria: ");
		int newPosY = Teklatua.getNireTeklatua().irakurriKoordenatua(Mapa.getNireMapa().maxY());
		if(((this.posX-newPosX)+(this.posY-newPosY))<=abiadura) {
			this.posX = newPosX;
			this.posY = newPosY;
		}else {
			System.out.println("Muy Rapidou Bakerou, osea... berriro\n");
			this.mugitu();
		}
		
	}
	
	public void hiriaEraso(Hiria pHiria) {
		int dmg = pHiria.erasoJaso(this.A.maila());
		this.HP.kenduBizitza(dmg);
	}
	
	public void gerlariEraso(Gerlaria pGerlaria) {
		int dmg = pGerlaria.erasoJaso(this.A.maila());
		this.HP.kenduBizitza(dmg);
	}

	public int erasoJaso(int pDMG) {
		this.HP.kenduBizitza(pDMG);
		return this.A.maila();
	}
	
	public boolean izenHauDu(String pIzena) {
		//gerlariak pIzena izena badu true, bestela false
		if(this.izena.equals(pIzena)) return true;
		return false;
	}

	public boolean dago(int i, int j) {
		//gerlaria i,j posizioan badagoen true, bestela false
		if(this.posX==i&&this.posY==j) return true;
		else return false;
	}
}
