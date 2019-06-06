package civilization;

import java.util.ArrayList;

public class Hiria {
	
	private String izena;	
	private int posX;
	private int posY;
	private int urrea;
	private int egurra;
	private int harria;
	private Gerlaria gerlaria;
	private ListaEraikinak eraikinak;
	private int bizitza;
	private int erasoa;
		
	public Hiria(String pHiriIzena, int pPosX, int pPosY){
		this.urrea = 100;
		this.egurra = 100;
		this.harria = 100;
		this.izena = pHiriIzena;
		this.posX = pPosX;
		this.posY = pPosY;
		this.eraikinak = new ListaEraikinak();
		this.bizitza = 8;
		this.gerlaria = null;
		this.erasoa = 1;
	}
	
	public String izena() {
		return this.izena;
	}
	
	public void sortuGerlaria(String pGerIzena) {
		this.gerlaria = new Gerlaria(pGerIzena, this.posX, this.posY, this);
	}
	
	public void sortuGerlaria() {
		if(!this.gerlariaExistitzenDa()) {
			System.out.println("Ba dirudi ez dagoela gerlaririk hiri honetan");
			System.out.println("Sartu gerlari berriaren izena: ");
			this.gerlaria = new Gerlaria(Teklatua.getNireTeklatua().irakurriIzena(), this.posX, this.posY, this);
		}
	}

	public void print() {
		System.out.println(izena + " hiria(" + posX + "," + posY + ")" + " HP: " + this.bizitza);
		
	}
	
	private void printAukerak(ArrayList<String> pAuk) {
		for(String a : pAuk) {
			System.out.println("-" + a);
		}
	}

	public void administratu(ArrayList<String> pAukerak, int j) {
		System.out.println("Zer egin nahi duzu:");
		String aukera=null;
		this.printAukerak(pAukerak);
		aukera = Teklatua.getNireTeklatua().getAukerak(pAukerak);
		this.sortuGerlaria();
		switch(aukera) {
		case "Eraiki":
			
			System.out.println("Hiri honen lehengaiak dira :");
			System.out.println("Urrea: "+this.urrea);
			System.out.println("Egurra: "+this.egurra);
			System.out.println("Harria: "+this.harria);
			eraikinak.printDaudenak();
			eraikinak.printFalta();
			
			System.out.println("Eraikin bat aukeratu :");
			aukera = Teklatua.getNireTeklatua().getAukerak(eraikinak.falta());
			
			if(aukera.equals("Atera")) {
				
			} else {
				System.out.println("GEG");
				Eraikina eraikina = eraikinak.bilaturaikina(aukera);
				if(eraikina.eraikiDaiteke(urrea, harria, egurra)) {
					this.eraiki(eraikina);
					pAukerak.remove("Eraiki");
				}
				administratu(pAukerak, j);
			}
			
			break;
			
		case "Gerlaria":
			ArrayList<String> gerlariAukerak = new ArrayList<String>();
			gerlariAukerak.add("Mugitu");
			gerlariAukerak.add("Stats");
			gerlariAukerak.add("Eraso");
			this.gerlariaAdministratu(gerlariAukerak, j);
			pAukerak.remove("Gerlaria");
			this.administratu(pAukerak, j);
			break;
		case "Atera":
			
		}
		
	}
	
	public void gerlariaAdministratu(ArrayList<String> pAukerak, int j) {
		this.gerlaria.printGerlaria();
		System.out.println("Zer egin nahi duzu:");
		this.printAukerak(pAukerak);
		String gerlariAukera = Teklatua.getNireTeklatua().getAukerak(pAukerak);
			
		switch(gerlariAukera) {
		case "Mugitu":
			this.gerlaria.mugitu(j);
			pAukerak.remove("Mugitu");
			pAukerak.remove("Eraso");
			gerlariaAdministratu(pAukerak, j);
			break;
		case "Stats":
			if(this.gerlariaDago()) {
				this.urrea = this.gerlaria.aukerak(this.urrea, this.eraikinak);
			} else {
				System.out.println("Gerlaria ez dago hirian, ezin da hobetu");
			}
			pAukerak.remove("Stats");
			gerlariaAdministratu(pAukerak, j);
			break;
		case "Eraso":
			ArrayList<String> erasoAukerak = new ArrayList<String>();
			boolean erasoEginDa = false;
			erasoAukerak.add("Hiria");
			erasoAukerak.add("Gerlaria");
			System.out.println("Hiria ala Gerlaria erasotu? ");
			String erasoAukera = Teklatua.getNireTeklatua().getAukerak(erasoAukerak);
			if(erasoAukera.equals("Hiria")) {
				ArrayList<String> hiriAukerak = gerlaria.getPosBerekoHiriak();
				if(hiriAukerak == null || hiriAukerak.isEmpty()) {
					System.out.println("Ez daude hiriak gerlariaren posizioan");
					break;
				} else {
					System.out.println("Sartu hiriaren izena: ");
					String hiriAukera = Teklatua.getNireTeklatua().getAukerak(hiriAukerak);
					if(hiriAukera.equals("Atera") || hiriAukera.equals("Ezer")) break;
					erasoEginDa = true;
					this.gerlaria.hiriaEraso(hiriAukera);
					this.gerlaria.printGerlaria();
				}
			}
			
			if(erasoAukera.equals("Gerlaria")) {
				ArrayList<String> gerlariAukerak = gerlaria.getPosBerekoGerlariak();
				if(gerlariAukerak == null) {
					System.out.println("Ez daude gerlaririk zure gerlariaren posizioan");
					break;
				} else {
					System.out.println("Sartu gerlariaren izena: ");
					this.printAukerak(gerlariAukerak);
					String gerlariAukera2 = Teklatua.getNireTeklatua().getAukerak(gerlariAukerak);
					if(gerlariAukera2.equals("Atera") || gerlariAukera2.equals("Ezer")) break;
					erasoEginDa = true;
					this.gerlaria.gerlariEraso(gerlariAukera2);
					this.gerlaria.printGerlaria();
				}
			}
			
			pAukerak.remove("Eraso");
			pAukerak.remove("Mugitu");
			break;
		case "Atera":
				
		}
	}
	
	public boolean gerlariaDago() {
		if(this.gerlaria.dago(posX, posY))return true;
		else return false;
	}
	
	public boolean gerlariaExistitzenDa() {
		if(this.gerlaria != null) return true;
		else return false;
	}

	private void eraiki(Eraikina pEraikina) {
		this.eraikinak.gehitu(pEraikina);
		this.egurra = this.egurra-pEraikina.getEgurreKost();
		this.urrea = this.urrea-pEraikina.getUrreKost();
		this.harria = this.harria-pEraikina.getHarriKost();
	}

	public boolean izenHauDu(String pIzena) {
		boolean emaitza = false;
		if(this.izena.equals(pIzena)) {
			emaitza = true;
		}
		return emaitza;		
	}

	public boolean dago(int i, int j) {
		if(this.posX==i&&this.posY==j) return true;
		else return false;
	}

	public String getIzena() {
		return this.izena;
	}
	
	public void aldatuIzena(String pIzena) {
		this.izena = pIzena;
	}
	
	public Gerlaria getGer() {
		return this.gerlaria;
	}
	
	public int erasoJaso(int pDMG) {
		this.bizitza = this.bizitza - pDMG;
		if(!(this.bizitza<=0)) {
			this.print();
			return this.erasoa;
		}
		return 0;
	}

	public boolean konkistatu() {
		if(this.bizitza <= 0) {
			System.out.println("Hiria konkistatuta izan da");
			this.bizitza = 50;
			return true;
		}
		return false;
	}

	public void baliabideakLortu(int plus) {
		this.egurra = this.egurra + plus;
		this.urrea = this.urrea + plus;
		this.harria = this.harria + plus;
	}
}

