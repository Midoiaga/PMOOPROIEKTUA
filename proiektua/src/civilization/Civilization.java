package civilization;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Civilization {

	private ArrayList<Jokalaria> jokalariak;

	private static Civilization nirePartida = null;

	private Civilization() {

		this.jokalariak = new ArrayList<Jokalaria>();
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
	
	public void partida() {
		String jokalariarenIzena;
		System.out.println("Sartu lehenengo jokalariaren izena: ");
		jokalariarenIzena = Teklatua.getNireTeklatua().irakurriIzena();
		this.gehituJokalaria((new Jokalaria(jokalariarenIzena)));
		
		System.out.println("Sartu bigarren jokalariaren izena: ");
		jokalariarenIzena = Teklatua.getNireTeklatua().irakurriIzena();
		this.gehituJokalaria((new Jokalaria(jokalariarenIzena)));
		
		jokalariak.get(0).gehituHiria(new Hiria("AnkhMorpork", 7, 17, "TwoFlower"));
		jokalariak.get(1).gehituHiria(new Hiria("Ceres", 2, 4, "JamesHolden"));
		
		int txandaCounter = 0;
		while(!this.amaitu()) {
			for(Jokalaria j : jokalariak) {
				j.txanda();
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
