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
		
	public Hiria(String pHiriIzena, int pPosX, int pPosY){
		this.urrea = 100;
		this.egurra = 100;
		this.harria = 100;
		this.izena = pHiriIzena;
		this.posX = pPosX;
		this.posY = pPosY;
		this.eraikinak = new ListaEraikinak();
		this.bizitza = 100;
		this.gerlaria = null;
	}
	
	public void sortuGerlaria(String pGerIzena) {
		if(!this.gerlariaDago()) {
			this.gerlaria = new Gerlaria(pGerIzena);
		} else {
			System.out.println("Gerlaria existitzen da jada hiri honetan:");
			this.gerlaria.printGerlaria();
		}
	}

	public void print() {
		System.out.println(izena + " hiria(" + posX + "," + posY + ")" + "HP:" + this.bizitza);
		
	}

	public void administratu() {
		
		System.out.println("Zer egin nahi duzu:");
		ArrayList<String> aukerak = new ArrayList<String>();
		aukerak.add("Eraiki");
		aukerak.add("Gerlaria");
		aukerak.add("Ezer");
		String aukera = Teklatua.getNireTeklatua().getAukerak(aukerak);
		switch(aukera) {
		case "Eraiki":
			
			System.out.println("Hiri honen lehengaiak dira :");
			System.out.println("Urrea: "+this.urrea);
			System.out.println("Egurra: "+this.egurra);
			System.out.println("Harria: "+this.harria);
			eraikinak.printDaudenak();
			eraikinak.printFalta();
			
			System.out.println("Eraikin bat aukeratu :");
			aukera = Teklatua.getNireTeklatua().getAukerak(Aukerak.getAukerak().aukerakFiltro("EraikinIzenak"));
			Eraikina eraikina = eraikinak.bilatuIzenez(aukera);
			
			//Exceptions y cosas
			
			
			
			if(!eraikinak.ezinDaEzerEraiki(this.urrea,this.harria,this.egurra)) {
				while(!eraikina.eraikiDaiteke(this.urrea,this.harria,this.egurra)) {
					eraikina = eraikinak.bilatuIzenez(aukera);
					aukera = Teklatua.getNireTeklatua().getAukerak(Aukerak.getAukerak().aukerakFiltro("EraikinIzenak"));
				}
				this.eraiki(eraikina);
			}
			this.administratu();
			break;
			
		case "Gerlaria":
			this.gerlariaAdministratu();
			this.administratu();
			break;
		case "Ezer":
			
		}
		
	}
	
	public void gerlariaAdministratu() {
		this.gerlaria.printGerlaria();
		if(!this.gerlariaDago()) System.out.println("Ez dago gerlaririk hiri honetan");
		else {
			System.out.println("Zer egin nahi duzu:");
			ArrayList<String> gerlariAukerak = new ArrayList<String>();
			gerlariAukerak.add("Mugitu");
			gerlariAukerak.add("Eraso");
			gerlariAukerak.add("Stats");
			gerlariAukerak.add("Ezer");
			String gerlariAukera = Teklatua.getNireTeklatua().getAukerak(gerlariAukerak);
			
			switch(gerlariAukera) {
			case "Mugitu":
				this.gerlaria.mugitu();
				break;
			case "Eraso":
				ArrayList<String> erasoAukerak = new ArrayList<String>();
				erasoAukerak.add("Hiria");
				erasoAukerak.add("Gerlaria");
				erasoAukerak.add("Ezer");
				String erasoAukera = Teklatua.getNireTeklatua().getAukerak(erasoAukerak);
				if(erasoAukera == "Gerlaria") {
					// TODO
					//this.gerlaria.gerlariEraso(pGerlaria);
				} else if(erasoAukera == "Hiria") {
					// TODO
					//this.gerlaria.hiriaEraso(pHiria);
				} else {
					System.out.println("Erasoa bertan bera utzi duzu");
				}
				break;
			case "Stats":
				this.urrea = this.gerlaria.aukerak(this.urrea);
				break;
			case "Ezer":
				
			}
		}
	}
	
	private boolean gerlariaDago() {
		// hiriak gerlaria badu true bestela false
		if(this.gerlaria!=null) {
			return true;
		}
		return false;
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
}
