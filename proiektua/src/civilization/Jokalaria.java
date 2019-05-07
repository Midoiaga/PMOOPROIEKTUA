package civilization;

import java.util.ArrayList;
import java.util.Iterator;

public class Jokalaria {
	
	//atrib
	private ArrayList<Hiria> hiriak;
	private String izena;
	
	public Jokalaria(String pIzena) {
		this.hiriak = new ArrayList<Hiria>();
		//this.gerlariak = new ArrayList<Gerlaria>();
		this.izena = pIzena;
	}
	
	public void txanda() {
		System.out.println("");
		System.out.println(this.izena + "-(r)en txanda");
		this.hiriakAdministratu();
		this.gerlariakMugitu();
	}
	
	private void hiriakAdministratu() {
		//izenaren arabera hiriak administratu
		ArrayList<Hiria> listaHiri = hiriak;
		ArrayList<String> aukerak = this.hiriIzenLista();
		Hiria h = null;
		while(listaHiri.size()>0) {
			System.out.println("Zein hiri aukeratu nahi duzu :");
			int i = 0;
			while(i<listaHiri.size()) {
				listaHiri.get(i).print();
				i++;
			}
			String aukera = Teklatua.getNireTeklatua().getAukerak(aukerak);
			h = this.bilatuHiriaIzen(aukera);
			ArrayList<String> aukerakH = new ArrayList<String>();
			aukerakH.add("Eraiki");
			aukerakH.add("Gerlaria");
			h.administratu(aukerakH);
			listaHiri.remove(h);
			aukerak.remove(aukera);
		}
	}
	
	private ArrayList<String> hiriIzenLista() {
		ArrayList<String> izenak = new ArrayList<String>();
		for(Hiria h : this.hiriak)izenak.add(h.getIzena());
		return izenak;
	}

	public void gehituHiria(Hiria pHiria) {
		this.hiriak.add(pHiria);
	}

	
	
	private void gerlariakMugitu() {
		this.printGerlarienPos();
		ArrayList<String> aukeraPosibleak =  gerlariLista();
		Gerlaria g = null;
		boolean atera = false;
		while(aukeraPosibleak.size()>1&&!atera) {
			
			String aukera = Teklatua.getNireTeklatua().getAukerak(aukeraPosibleak);
			if(aukera.equals("Atera")) {
				atera=true;
			} else {
				g = this.bilatuGerlariaIzen(aukera);
				g.mugitu();
				aukeraPosibleak.remove(g.izena());
			}
			
		}
	}
	
	private Gerlaria bilatuGerlariaIzen(String pAukera) {
		Iterator<Hiria> itr = this.getIterHir();
		Hiria h = null;
		while(itr.hasNext()) {
			h = itr.next();
			if(h.getGer().izenHauDu(pAukera)) return h.getGer();
		}
		return null;
	}
	
	private ArrayList<String> gerlariLista(){
		Iterator<Hiria> itr = this.getIterHir();
		ArrayList<String> emaitza = new ArrayList<String>();
		Hiria h = null;
		while(itr.hasNext()) {
			h = itr.next();
			emaitza .add(h.getGer().izena());
		}
		return emaitza;
	}

	private void printGerlarienPos() {
		System.out.println("Zure gerlariak :");
		for(Hiria h : this.hiriak){
			if(h.gerlariaDago())System.out.println(h.getGer().izena()+" gerlaria "+h.izena()+" hirian dago");
			else h.getGer().printGerlaria();
		}
	}

	private Hiria bilatuHiriaIzen(String pAukera) {
		Iterator<Hiria> itr = this.getIterHir();
		Hiria h = null;
		while(itr.hasNext()) {
			h = itr.next();
			if(h.izenHauDu(pAukera)) return h;
		}
		return null;
	}

	private Iterator<Hiria> getIterHir(){
		return this.hiriak.iterator();
	}
	
	private Iterator<Gerlaria> getIterGer() {
		ArrayList<Gerlaria> itrG = new ArrayList<Gerlaria>();
		Iterator<Hiria> itrH = this.getIterHir();
		Hiria oraingoH = null;
		while(itrH.hasNext()) {
			oraingoH = itrH.next();
			itrG.add(oraingoH.getGer());
		}
		return itrG.iterator();
	}

	public boolean zerbaitDago(int i, int j) {
		boolean emaitza = false;
		if(hiriBatDago(i,j)) emaitza = true;
		if(gerlariBatDago(i,j)) emaitza = true;
		return emaitza;
	}

	public boolean gerlariBatDago(int i, int j) {
		Iterator<Gerlaria> itr = this.getIterGer();
		Gerlaria g = null;
		while(itr.hasNext()) {
			g = itr.next();
			if(g.dago(i,j)) return true;
		}
		return false;
	}

	private boolean hiriBatDago(int i, int j) {
		Iterator<Hiria> itr = this.getIterHir();
		Hiria h = null;
		while(itr.hasNext()) {
			h = itr.next();
			if(h.dago(i,j)) return true;
		}
		return false;
	}

	public int hiriKop() {
		return this.hiriak.size();
	}
	
}
