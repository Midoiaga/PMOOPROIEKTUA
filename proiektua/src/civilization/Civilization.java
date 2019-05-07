package civilization;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Civilization {

	private Jokalaria jokalari1;
	private Jokalaria jokalari2;
	
	private ArrayList<Hiria> hiriak;

	private static Civilization nirePartida = null;

	private Civilization() {

		this.hiriak = new ArrayList<Hiria>();
	}

	public static Civilization getNirePartida() {
		if(nirePartida==null) {
			nirePartida = new Civilization();
		}

		return nirePartida;
	}
	
	private void hasieratu() {
		Mapa.getNireMapa().erreseteatu();
		
		String izen;
		// lehenengo jokalaria
		System.out.println("Sartu lehenengo jokalariaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.jokalari1 = new Jokalaria(izen);
		
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
		this.jokalari2 = new Jokalaria(izen);
		
		System.out.println("Sartu bigarren jokalariaren hiri inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.add(new Hiria(izen, 2, 4));
		System.out.println("Sartu bigarren jokalariaren gerlari inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.get(1).sortuGerlaria(izen);
		
		System.out.println("");
				
		jokalari1.gehituHiria(this.hiriak.get(0));
		jokalari2.gehituHiria(this.hiriak.get(1));

	}
	
	public void partida() {
		this.hasieratu();
		
		int txandaCounter = 0;
		while(!this.amaitu()) {
			this.jokalari1.txanda();
			this.jokalari2.txanda();
			txandaCounter++;
		}
		
		System.out.println("Partidak " + txandaCounter + " txanda iraun du.");

	}
	
	private boolean amaitu(){
		boolean emaitza=false;
		if(this.jokalari1.hiriKop()==0)emaitza = true;
		if(this.jokalari2.hiriKop()==0)emaitza = true;

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
