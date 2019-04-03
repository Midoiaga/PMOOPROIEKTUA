package civilization;

public class Civilization {

	private Jokalaria[] jokalariak;
	private Hiria[] hiriak;
	
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
	
	public void txanda() {
		this.jokalariak[0].txanda();
		atakeak();
		this.jokalariak[1].txanda();
		atakeak();
	}
	
	
	private void atakeak() {}
}
