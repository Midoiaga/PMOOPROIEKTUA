package civilization;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEraikinak {
	
	//atrib
	private ArrayList<Eraikina> dituzunEraikinak;
	private ArrayList<Eraikina> bezteEraikinak;
	
	public ListaEraikinak() {
		this.dituzunEraikinak = new ArrayList<Eraikina>();
		this.bezteEraikinak = new ArrayList<Eraikina>();
		bezteEraikinak.add(new Eraikina("Zerratokia",100,100,50));
		bezteEraikinak.add(new Eraikina("Harrobia",100,100,50));
		bezteEraikinak.add(new Eraikina("Burdinola",100,100,50));
		bezteEraikinak.add(new Eraikina("Urre Mina",100,100,50));
	}
	
	public void printFalta() {
		//zein eraikinak eraiki dezakeen jokalariak
		System.out.println("Eta eraikin hauek eraiki ditzazkezu:");
		int i = 0;
		while(i<bezteEraikinak.size()) {
			bezteEraikinak.get(i).printKostua();
			i++;
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
			falta.add(bezteEraikinak.get(i).getIzena());
			i++;
		}
		return falta;
	}

	public Eraikina bilaturaikina(String aukera) {
		for(Eraikina e : this.bezteEraikinak) {
			if(e.izenBeraDu(aukera)) {
				return e;
			}
		}
		return null;
	}
	
}
