package civilization;

public class Civilization {

	private Jokalaria[] jokalariak;

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
	public void partida() {
		while(!this.amaitu()) {
			for(Jokalaria j : jokalariak) {
				j.txanda();
			}
		}

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
					System.out.println(Mapa.getNireMapa().maxY());
					Civilization.getNirePartida().partida();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
