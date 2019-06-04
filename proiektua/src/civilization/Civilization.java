package civilization;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

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
		MapaPartida.getNireMapa().erreseteatu();
		
		String izen;
		// lehenengo jokalaria
		System.out.println("Sartu lehenengo jokalariaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.jokalari1 = new Jokalaria(izen);
		
		System.out.println("Sartu lehenengo jokalariaren hiri inizialaren izena: ");
		izen = Teklatua.getNireTeklatua().irakurriIzena();
		this.hiriak.add(new Hiria(izen, 1, 1));
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
		this.hiriak.add(new Hiria(izen, 6, 16));
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
		boolean martxan = true;
		while(martxan) {
			MapaPartida.getNireMapa().printJ1();
			this.jokalari1.posBerekoHiriak(this.hiriak);
			this.jokalari1.txanda(1);
			MapaPartida.getNireMapa().printJ1();
			for(int i=0;i<50;i++) System.out.println();
			this.hiriKonkistatuak(hiriak);
			if(this.amaitu()) {
				martxan = false;
				break;
			}
			MapaPartida.getNireMapa().printJ2();
			this.jokalari2.posBerekoHiriak(this.hiriak);
			this.jokalari2.txanda(2);
			MapaPartida.getNireMapa().printJ1();
			for(int i=0;i<50;i++) System.out.println();
			this.hiriKonkistatuak(hiriak);
			if(this.amaitu()) {
				martxan = false;
				break;
			}			
			txandaCounter++;
		}
		
		System.out.println("Partidak " + txandaCounter + " txanda iraun du.");
		if(this.jokalari1.hiriKop()>this.jokalari2.hiriKop()) {
			System.out.println("Lehenengo jokalariak irabazi du");
		} else {
			System.out.println("Bigarren jokalariak irabazi du");
		}

	}
	
	/*
	public ArrayList<String> getHemengoHiriak(int pX, int pY) {
		
	}
	*/
	
	private void hiriKonkistatuak(ArrayList<Hiria> pHiriak) {
		Iterator<Hiria> itr = pHiriak.iterator();
		Hiria oraingoHir = null;
		while(itr.hasNext()) {
			oraingoHir = itr.next();
			if(oraingoHir.konkistatu()) {
				this.kenduHiria(oraingoHir);
			}
		}
	}
	
	private void kenduHiria(Hiria pHiria) {
		boolean j1 = this.jokalari1.kenduHiria(pHiria);
		boolean j2 = this.jokalari2.kenduHiria(pHiria);
		if(j1) {
			pHiria.konkistatu();
			this.jokalari2.gehituHiria(pHiria);
			System.out.println("j2-ek eramaten du hiria");
		}
		if(j2) {
			pHiria.konkistatu();
			this.jokalari1.gehituHiria(pHiria);
			System.out.println("j1-ek eramaten du hiria");
		}
		
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
					System.out.println("\r\n" + 
							" ________  ___  ___      ___ ___  ___       ___  ________  ________  _________  ___  ________  ________      \r\n" + 
							"|\\   ____\\|\\  \\|\\  \\    /  /|\\  \\|\\  \\     |\\  \\|\\_____  \\|\\   __  \\|\\___   ___\\\\  \\|\\   __  \\|\\   ___  \\    \r\n" + 
							"\\ \\  \\___|\\ \\  \\ \\  \\  /  / | \\  \\ \\  \\    \\ \\  \\\\|___/  /\\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\   \r\n" + 
							" \\ \\  \\    \\ \\  \\ \\  \\/  / / \\ \\  \\ \\  \\    \\ \\  \\   /  / /\\ \\   __  \\   \\ \\  \\ \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\  \r\n" + 
							"  \\ \\  \\____\\ \\  \\ \\    / /   \\ \\  \\ \\  \\____\\ \\  \\ /  /_/__\\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \r\n" + 
							"   \\ \\_______\\ \\__\\ \\__/ /     \\ \\__\\ \\_______\\ \\__\\\\________\\ \\__\\ \\__\\   \\ \\__\\ \\ \\__\\ \\_______\\ \\__\\\\ \\__\\\r\n" + 
							"    \\|_______|\\|__|\\|__|/       \\|__|\\|_______|\\|__|\\|_______|\\|__|\\|__|    \\|__|  \\|__|\\|_______|\\|__| \\|__|\r\n" + 
							"                                                                                                             \r\n" + 
							"                                                                                                             \r\n" + 
							"                                                                                                             \r\n" + 
							"");
					System.out.println("Maparen tamaina " + MapaPartida.getNireMapa().maxX() + "," + MapaPartida.getNireMapa().maxY() + " da.");
					
					Civilization.getNirePartida().partida();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

