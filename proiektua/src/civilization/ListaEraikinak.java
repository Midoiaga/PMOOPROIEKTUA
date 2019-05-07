package civilization;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEraikinak {
	
	//atrib
	private ArrayList<Eraikina> dituzunEraikinak;
	private ArrayList<Eraikina> bezteEraikinak;
	
	public ListaEraikinak() {
		this.dituzunEraikinak = new ArrayList<Eraikina>();
	}
	
	public void printFalta() {
		//zein eraikinak eraiki dezakeen jokalariak
		System.out.println("Eta eraikin hauek eraiki ditzazkezu:");
		int i = 0;
		while(i<bezteEraikinak.size()) {
			bezteEraikinak.get(i).printKostua();
		}
		System.out.println("Aukeratu bat:");
	}
	
	
	public void printDaudenak() {
		//dauden eraikinen informazioa printeatu
		Iterator<Eraikina> itr = this.getIteradorea();
		Eraikina e = null;
		System.out.println("Eraikin hauek dituzu jada:");
		while(itr.hasNext()) {
			e = itr.next();
			e.print();
		}
	}
	
	private Iterator<Eraikina> getIteradorea(){
		return this.dituzunEraikinak.iterator();
	}

	public Eraikina bilatuIzenez(String pIzena) {
		Iterator<Eraikina> itr = this.getIteradorea();
		Eraikina e = null;
		while(itr.hasNext()) {
			e = itr.next();
			if(e.izenBeraDu(pIzena))return e;
		}
		return null;
	}

	public void gehitu(Eraikina pEraikina) {
		this.dituzunEraikinak.add(pEraikina);
		this.bezteEraikinak.remove(pEraikina);
		
	}

	public boolean ezinDaEzerEraiki(int pUrrea, int pHarria, int pEgurra) {
		Iterator<Eraikina> itr = this.getIteradorea();
		Eraikina e = null;
		boolean bol = false;
		while(itr.hasNext()) {
			e = itr.next();
			if(e.eraikiDaiteke(pUrrea, pHarria, pEgurra))bol = true;
		}
		return bol;
	}

	public ArrayList<String> falta() {
		ArrayList<String> falta = new ArrayList<String>();
		int i = 0;
		while(i<bezteEraikinak.size()) {
			falta.add(bezteEraikinak.get(i).izena());
		}
		return falta;
	}
	
}
