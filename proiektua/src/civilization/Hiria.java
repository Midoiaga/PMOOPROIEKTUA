package civilization;

import java.util.ArrayList;
import java.util.Scanner;

public class Hiria {
	
	private String izena;	
	private int posX;
	private int posY;
	private int urrea;
	private int egurra;
	private int harria;
	private Gerlaria gerlaria;
	private ListaEraikinak eraikinak;
		
	public Hiria(String pHiriIzena, int pPosX, int pPosY){
		this.urrea = 100;
		this.egurra = 100;
		this.harria = 100;
		this.izena = pHiriIzena;
		this.posX = pPosX;
		this.posY = pPosY;
		this.eraikinak = new ListaEraikinak();
	}

	public void print() {
		System.out.println(izena + " hiria(" + posX + "," + posY + ")");
		
	}

	public void administratu() {
		
		System.out.println("Zer nahi duzu egin:");
		String aukera = Teklatu.getNireTeclatu().getAukerak("Hiri Aukerak");
		switch(aukera) {
		case "Eraiki":
			
			System.out.println("Hiri honen lehengaiak dira :");
			System.out.println("Urrea: "+this.urrea);
			System.out.println("Egurra: "+this.egurra);
			System.out.println("Harria: "+this.harria);
			eraikinak.printDaudenak();
			eraikinak.printFalta();
			
			System.out.println("Eraikin bat aukeratu :");
			aukera = Teklatu.getNireTeclatu().getAukerak("Eraikin Aukerak");
			Eraikina eraikina = eraikinak.bilatuIzenez(aukera);
			if(!eraikinak.ezinDaEzerEraiki(this.urrea,this.harria,this.egurra)) {
				while(!eraikina.eraikiDaiteke(this.urrea,this.harria,this.egurra)) {
					System.out.println("Eraikin bat aukeratu :");
					aukera = Teklatu.getNireTeclatu().getAukerak("Eraikin Aukerak");
					eraikina = eraikinak.bilatuIzenez(aukera);
				}
				this.eraiki(eraikina);
			}
			this.administratu();
			break;
		case "Gerlaria":
			if(this.gerlaria==null) System.out.println("Ez dago gerlaririk hiri honetan");
			else this.urrea = this.gerlaria.aukerak(this.urrea);
			this.administratu();
			break;
		case "Ezer":
			
		}
		
	}
	
	private void eraiki(Eraikina pEraikina) {
		this.eraikinak.gehitu(pEraikina);
		this.egurra = this.egurra-pEraikina.getEgurreKost();
		this.urrea = this.urrea-pEraikina.getUrreKost();
		this.harria = this.harria-pEraikina.getHarriKost();
	}

	public boolean izenAuDu(String pIzena) {
		if(this.izena==pIzena) return true;
		return false;		
	}

	public boolean dago(int i, int j) {
		if(this.posX==i&&this.posY==j) return true;
		else return false;
	}

	public String getIzena() {
		return this.izena;
	}

}
