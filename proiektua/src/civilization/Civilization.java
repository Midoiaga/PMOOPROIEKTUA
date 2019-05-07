package civilization;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Civilization {

	private ArrayList<Jokalaria> jokalariak;
	
	private ArrayList<Hiria> hiriak;

	private static Civilization nirePartida = null;

	private Civilization() {

		this.jokalariak = new ArrayList<Jokalaria>();
		this.hiriak = new ArrayList<Hiria>();
	}

	public static Civilization getNirePartida() {
		if(nirePartida==null) {
			nirePartida = new Civilization();
		}

		return nirePartida;
	}
	
	private void gehituJokalaria(Jokalaria pJokalari) {
		this.jokalariak.add(pJokalari);
		
	}
	
	private void hasieratu() {
		this.jokalariak.clear();
		Mapa.getNireMapa().erreseteatu();
		
		String izen;
		// lehenengo jokalaria
		System.out.println("Sartu lehenengo jokalariaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.gehituJokalaria((new Jokalaria(izen)));
		
		System.out.println("Sartu lehenengo jokalariaren hiri inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.add(new Hiria(izen, 7, 17));
		System.out.println("Sartu lehenengo jokalariaren gerlari inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.get(0).sortuGerlaria(izen);
		
		// bigarren jokalaria
		System.out.println("");
		
		System.out.println("Sartu bigarren jokalariaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.gehituJokalaria((new Jokalaria(izen)));
		
		System.out.println("Sartu bigarren jokalariaren hiri inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.add(new Hiria(izen, 2, 4));
		System.out.println("Sartu bigarren jokalariaren gerlari inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.get(1).sortuGerlaria(izen);
		
		System.out.println("");
				
		jokalariak.get(0).gehituHiria(this.hiriak.get(0));
		jokalariak.get(1).gehituHiria(this.hiriak.get(1));

	}
	
	public void partida() {
		this.hasieratu();
		
		int txandaCounter = 0;
		while(!this.amaitu()) {
			for(Jokalaria j : jokalariak) {
				j.txanda();
				Mapa.getNireMapa().print();
				// pantaila garbitu hurrengo erabiltzailearentzako
				// for (int i = 0; i < 50; ++i) System.out.println();
			}
			txandaCounter++;
		}
		
		System.out.println("Partidak " + txandaCounter + " txanda iraun du.");

	}
	
	private boolean amaitu(){
		boolean emaitza=false;
		for(Jokalaria j : jokalariak) {
			if(j.hiriKop()==0)emaitza=true;
			else emaitza = false;
		}

		return emaitza;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Maparen tamaina " + Mapa.getNireMapa().maxX() + "," + Mapa.getNireMapa().maxY() + " da.");
					Civilization.getNirePartida().partida();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
