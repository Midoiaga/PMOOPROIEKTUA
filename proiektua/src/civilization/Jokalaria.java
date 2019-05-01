package civilization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Jokalaria {
	
	//atrib
	private ArrayList<Hiria> hiriak;
	//private ArrayList<Gerlaria> gerlariak;
	private String izena;
	
	public Jokalaria(String pIzena) {
		this.hiriak = new ArrayList<Hiria>();
		//this.gerlariak = new ArrayList<Gerlaria>();
		this.izena = pIzena;
	}
	
	public void txanda() {
		this.hiriakAdministratu();
		this.gerlariakMugitu();
	}
	
	private void hiriakAdministratu() {
		//izenaren arabera hiriak administratu
		ArrayList<Hiria> listaHiri = hiriak;
		Hiria h = null;
		while(listaHiri.size()>0) {
			System.out.println("Zein hiri aukeratu nahi duzu :");
			int i = 0;
			while(i<listaHiri.size()) {
				listaHiri.get(i).print();
			}
			String aukera = Teklatua.getNireTeklatua().getAukerak(this.hiriIzenLista());
			h = this.bilatuHiriaIzen(aukera);
			h.administratu();
			listaHiri.remove(h);
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
		ArrayList<Hiria> listaGer = hiriak;
		Gerlaria g = null;
		while(listaGer.size()>0) {
			
			String aukera = Teklatua.getNireTeklatua().getAukerak();
			g = this.bilatuGerlariaIzen(aukera);
			g.mugitu();
			listaGer.remove(g);
		}
	}
	
	private Gerlaria bilatuGerlariaIzen(String pAukera) {
		Iterator<Gerlaria> itr = this.getIterGer();
		Gerlaria g = null;
		while(itr.hasNext()) {
			g = itr.next();
			if(g.izenHauDu(pAukera)) return g;
		}
		return null;
	}

	//private void printGerlarienPos() {
	//	//esto sobra no?? por lo menos tal
	//	//y como esta implementado
	//	System.out.println("Zure gerlariak :");
	//	for(int i = 0; i<gerlariak.size();i++)
	//		this.gerlariak.get(i).printGerlaria();
	//}

	private Hiria bilatuHiriaIzen(String pAukera) {
		Iterator<Hiria> itr = this.getIterHir();
		Hiria h = null;
		while(itr.hasNext()) {
			h = itr.next();
			if(h.izenHauDu(pAukera)) return h;
		}
		return null;
	}

	//private Iterator<Gerlaria> getIterGer(){
	//	return this.gerlariak.iterator();
	//}
	
	private Iterator<Hiria> getIterHir(){
		return this.hiriak.iterator();
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
