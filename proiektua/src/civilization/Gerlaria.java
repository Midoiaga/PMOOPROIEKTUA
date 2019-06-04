package civilization;

import java.util.ArrayList;
import java.util.Iterator;

public class Gerlaria {

	//atrib
	private Bizitza HP;
	private Indarra A;
	private Defentza D;
	private Abiadura V;
	private String izena;
	private int posX;
	private int posY;
	private ArrayList<Hiria> posBerekoHiriak;
	
	public Gerlaria(String pIzena, int pX, int pY) {
		//eraikitzailea
		this.izena = pIzena;
		this.HP= new Bizitza();
		this.A = new Indarra();
		this.D = new Defentza();
		this.V = new Abiadura();
		this.posX = pX;
		this.posY = pY;
		this.posBerekoHiriak = new ArrayList<Hiria>();
	}
	
	public boolean hildaDago() {
		if(this.HP.getBal()<=0) return true;
		return false;
	}

	public int aukerak(int pUrrea, ListaEraikinak eraikinak) {
		ArrayList<String> aukerak = this.aukerak();
		this.printAukerak(aukerak);
		String aukera = Teklatua.getNireTeklatua().getAukerak(aukerak);
		switch(aukera) {
		case"Bizitza":
			if(!this.HP.mailaMaxDauka()) {
				pUrrea = HP.gehituMaila(pUrrea,eraikinak);
			}
			
			break;
		case"Indarra":
			if(!this.A.mailaMaxDauka()) {
				pUrrea = A.gehituMaila(pUrrea,eraikinak);
			}
			break;
		case"Defentza":
			if(!this.D.mailaMaxDauka()) {
				pUrrea = D.gehituMaila(pUrrea,eraikinak);
			}
			break;
		case"Abiadura":
			if(!this.V.mailaMaxDauka()) {
				pUrrea = V.gehituMaila(pUrrea,eraikinak);
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
		System.out.println(this.izena + " " + this.posX + "," + this.posY + " posizioan dago eta " + this.HP.getBal() +" bizitza puntuak");
		System.out.println("Estadistikak: " + " HP=" + this.HP.maila() + " A=" + this.A.maila() + " D="+ this.D.maila() + " V=" + this.V.maila());
	}

	public void mugitu(int j) {
		
		int abiadura = this.V.maila();
		this.printGerlaria();
		System.out.println(abiadura + " kasila mugitu daiteke");
		System.out.println("Sartu x ardatzeko posizio berria: ");
		int newPosX = Teklatua.getNireTeklatua().irakurriKoordenatua(MapaPartida.getNireMapa().maxX());
		System.out.println("Sartu y adratzeko posizio berria: ");
		int newPosY = Teklatua.getNireTeklatua().irakurriKoordenatua(MapaPartida.getNireMapa().maxY());
		if(((this.posX-newPosX)+(this.posY-newPosY))<=abiadura) {
			this.posX = newPosX;
			this.posY = newPosY;
			if(j==1) MapaPartida.getNireMapa().updateJ1(newPosX,newPosY);
			else MapaPartida.getNireMapa().updateJ2(newPosX,newPosY);
		}else {
			System.out.println(abiadura+" kasila baino  gehiago mugitu da");
			this.mugitu(j);
		}
		
	}
	
	public void hiriakJaso(ArrayList<Hiria> pHiriak) {
		this.posBerekoHiriak.clear();
		for(Hiria h : pHiriak) {
			if(h.dago(posX, posY)) {
				this.posBerekoHiriak.add(h);
			}
		}
	}
	
	public ArrayList<String> getPosBerekoHiriak() {
		ArrayList<String> emaitza = new ArrayList<String>();
		Iterator<Hiria> itrHir = this.posBerekoHiriak.iterator();
		Hiria oraingoHir = null;
		while(itrHir.hasNext()) {
			oraingoHir = itrHir.next();
			emaitza.add(oraingoHir.getIzena());
			System.out.println(oraingoHir.getIzena());
		}
		return emaitza;
	}
	
	public void hiriaEraso(String pHiria) {
		Iterator<Hiria> itrHir = this.posBerekoHiriak.iterator();
		Hiria oraingoHir = null;
		while(itrHir.hasNext()) {
			oraingoHir = itrHir.next();
			if(oraingoHir.getIzena().equals(pHiria)) {
				int dmg = oraingoHir.erasoJaso(this.A.maila());
				this.HP.kenduBizitza(dmg);
			}
		}

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
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
}
