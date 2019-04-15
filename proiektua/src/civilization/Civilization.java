package civilization;

public class Civilization {

	//acab
	private Jokalaria[] jokalariak;
	private Hiria[] hiriak;
	
	private static Civilization nirePartida = null;
	
	private Civilization() {
		//eraik
		this.jokalariak[0] = new Jokalaria("");
		this.jokalariak[1] = new Jokalaria("");
	}
	
	public static Civilization getNirePartida() {
		//singleton
		if(nirePartida==null) {
			nirePartida = new Civilization();
		}
		
		return nirePartida;
	}
	
	public void txanda() {
		//TODO jokalarien arabera aldatu
		this.jokalariak[0].txanda();
		atakeak();
		this.jokalariak[1].txanda();
		atakeak();
	}
	
	
	private void atakeak() {
		//TODO ???
	}
}
