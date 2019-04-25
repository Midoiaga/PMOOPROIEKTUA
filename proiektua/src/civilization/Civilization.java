package civilization;

public class Civilization {

	private Jokalaria[] jokalariak;

	private static Civilization nirePartida = null;

	private Civilization() {

		this.jokalariak[0] = new Jokalaria("");
		this.jokalariak[1] = new Jokalaria("");
	}

	public static Civilization getNirePartida() {
		if(nirePartida==null) {
			nirePartida = new Civilization();
		}

		return nirePartida;
	}
	public void partida(){
		while(this.amaitu()==false){
			this.jokalariak[0].txanda();
			this.jokalariak[1].txanda();
		}

	}
	private boolean amaitu(){
		boolean emaitza=false;
		if(this.jokalariak[0].hiriKop()==0||this.jokalariak[1].hiriKop()==0){
			emaitza=true;
		}
		return emaitza;
	}
}
