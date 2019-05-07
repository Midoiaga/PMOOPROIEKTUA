package civilization;

import java.util.ArrayList;

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
		ArrayList<String> aukerak = this.aukerak();
		this.printAukerak(aukerak);
		String aukera = Teklatua.getNireTeklatua().getAukerak(aukerak);
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
	
	private void printAukerak(ArrayList<String> aukerak) {
		//jokalariak egin ditzakeen akzioak printeatzen ditu
		System.out.println(this.izena + " hobetzeko dituzun aukerak hauek dira:");
		for(String aukera : aukerak) System.out.println("-"+aukera);
	}
	
	private ArrayList<String> aukerak() {
		ArrayList<String> aukerak = new ArrayList<String>();
		if(!this.HP.mailaMaxDauka()) aukerak.add("Bizitza");
		if(!this.A.mailaMaxDauka()) aukerak.add("Indarra");
		if(!this.D.mailaMaxDauka()) aukerak.add("Defentza");
		if(!this.V.mailaMaxDauka()) aukerak.add("Abiadura");
		return aukerak;
	}
	 
	public void printGerlaria() {
		//gerlariari buruzko informazioa printeatzen ditu (pos)
		System.out.println(this.izena + " " + this.posX + "," + this.posY + " posizioan dago.");
	}

	public void mugitu() {
		
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
			System.out.println(abiadura+" kasila baino  gehiago mugitu da");
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

	public String izena() {
		// TODO Auto-generated method stub
		return this.izena;
	}
}
