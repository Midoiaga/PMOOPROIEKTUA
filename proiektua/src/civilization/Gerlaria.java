package civilization;

import java.util.Scanner;

public class Gerlaria {

	//atrib
	private Bizitza HP;
	private Indarra A;
	private Defentza D;
	private Abiadura V;
	private String izena;
	private int posX;
	private int posY;
	
	public Gerlaria(String pIzena) {
		//eraikitzailea
		this.izena = pIzena;
	}

	public int aukerak(int pUrrea) {
		//aukerak aukeratu lol
		this.printAukerak();
		String aukera = Teklatu.getNireTeklatua().getAukerak("Gerlari Aukerak");
		switch(aukera) {
		case"Bisitza":
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
		if(!this.HP.mailaMaxDauka()) System.out.println("-Bisitza");
		if(!this.A.mailaMaxDauka()) System.out.println("-Indarra");
		if(!this.D.mailaMaxDauka()) System.out.println("-Defentza");
		if(!this.V.mailaMaxDauka()) System.out.println("-Abiadura");
	}
	
	public void printGerlaria() {
		//gerlariari buruzko informazioa printeatzen ditu
		System.out.println(this.izena + " " + this.posX + "," + this.posY + " posizioan dago.");
		
	}
	
	public void eliminar(int i, int j) {
		//gerlaria posizio batetik ezabatu
		this.posX = i;
		this.posY = j;
	}

	public void mugitu() {
		//gerlaria mugitu
		int abiadura = this.V.maila();
		System.out.println(abiadura + "kasila mugitu daiteke.");
		System.out.println("");
		String pos = Teklatu.getNireTeclatu().getPos();
		String[] xy = pos.split(",");
		int newPosX = Integer.parseInt(xy[0]);
		int newPosY = Integer.parseInt(xy[1]);
		if(((this.posX-newPosX)+(this.posY-newPosY))<=abiadura) {
			this.posX = newPosX;
			this.posY = newPosY;
		}else {
			this.mugitu();
		}
		
	}

	public boolean izenHauDu(String pIzena) {
		//gerlariak pIzena izena badu true, bestela false
		if(this.izena==pIzena) return true;
		return false;
	}

	public boolean dago(int i, int j) {
		//gerlaria i,j posizioan badagoen true, bestela false
		if(this.posX==i&&this.posY==j) return true;
		else return false;
	}
}
