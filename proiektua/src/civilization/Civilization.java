package civilization;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class Civilization {

	private Jokalaria jokalari1;
	private Jokalaria jokalari2;
	
	private ArrayList<Hiria> hiriak;
	private ArrayList<Gerlaria> gerlariak;

	private static Civilization nirePartida = null;

	private Civilization() {

		this.hiriak = new ArrayList<Hiria>();
		this.gerlariak = new ArrayList<Gerlaria>();
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

        this.hiriak.add(new Hiria("Bilbao", 3, 12));
        this.hiriak.add(new Hiria("Barcelona", 5 ,6));
        this.hiriak.add(new Hiria("Ceres", 2, 7));
        this.hiriak.add(new Hiria("Mundaka", 5, 11));

	}
	
	//no se me ocurre otra forma :(
	private void gerlariakEguneratu() {
		Iterator<Hiria> itrHir = this.hiriak.iterator();
		this.gerlariak.clear();
		Hiria hir = null;
		while(itrHir.hasNext()) {
			hir = itrHir.next();
			if(hir.gerlariaExistitzenDa()) {
				this.gerlariak.add(hir.getGer());
			}
		}
	}

	public void partida() {
		this.hasieratu();
		System.out.println("Hona hemen hiri guztien posizioak:");
		System.out.println("(1,1), (3,12), (5,6), (2,7), (5,11), (6,16)");
		System.out.println("Sakatu ENTER jarraitzeko:");
		Teklatua.getNireTeklatua().irakurri();
		
		int txandaCounter = 0;
		boolean martxan = true;
		while(martxan) {
			MapaPartida.getNireMapa().printJ1();
			this.gerlariakEguneratu();
			this.jokalari1.posBerekoHiriak(this.hiriak);
			this.jokalari1.posBerekoGerlariak(this.gerlariak);
			this.jokalari1.txanda(1);
			MapaPartida.getNireMapa().printJ1();
			for(int i=0;i<50;i++) System.out.println();
			this.hiriKonkistatuak(hiriak);
			if(this.amaitu()) {
				martxan = false;
				break;
			}
			MapaPartida.getNireMapa().printJ2();
			this.gerlariakEguneratu();
			this.jokalari2.posBerekoHiriak(this.hiriak);
			this.jokalari2.posBerekoGerlariak(this.gerlariak);
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
			System.out.println(jokalari1.getIzena() + " jokalariak irabazi du");
		} else {
			System.out.println(jokalari2.getIzena() + " jokalariak irabazi du");
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
			System.out.println(jokalari2.getIzena() + "-k (j2) eramaten du hiria");
		}
		if(j2) {
			pHiria.konkistatu();
			this.jokalari1.gehituHiria(pHiria);
			System.out.println(jokalari1.getIzena() + "-k (j1) eramaten du hiria");
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
					System.out.println(" ________  ___  ________  ___  ___       ___  ________  ________  ________  ___  ________  ________          \r\n" + 
							"|\\_____  \\|\\  \\|\\   __  \\|\\  \\|\\  \\     |\\  \\|\\_____  \\|\\   __  \\|\\_____  \\|\\  \\|\\   __  \\|\\   __  \\         \r\n" + 
							" \\|___/  /\\ \\  \\ \\  \\|\\ /\\ \\  \\ \\  \\    \\ \\  \\\\|___/  /\\ \\  \\|\\  \\\\|___/  /\\ \\  \\ \\  \\|\\  \\ \\  \\|\\  \\        \r\n" + 
							"     /  / /\\ \\  \\ \\   __  \\ \\  \\ \\  \\    \\ \\  \\   /  / /\\ \\   __  \\   /  / /\\ \\  \\ \\  \\\\\\  \\ \\   __  \\       \r\n" + 
							"    /  /_/__\\ \\  \\ \\  \\|\\  \\ \\  \\ \\  \\____\\ \\  \\ /  /_/__\\ \\  \\ \\  \\ /  /_/__\\ \\  \\ \\  \\\\\\  \\ \\  \\ \\  \\      \r\n" + 
							"   |\\________\\ \\__\\ \\_______\\ \\__\\ \\_______\\ \\__\\\\________\\ \\__\\ \\__\\\\________\\ \\__\\ \\_______\\ \\__\\ \\__\\     \r\n" + 
							"    \\|_______|\\|__|\\|_______|\\|__|\\|_______|\\|__|\\|_______|\\|__|\\|__|\\|_______|\\|__|\\|_______|\\|__|\\|__|     \r\n" + 
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

