package civilization;

public class AukeraEzEgokiaException extends Exception {
	
	public AukeraEzEgokiaException() {
		super();
	}
	
	public void printStackTrace() {
		System.out.println("Sartu duzun aukera ez da existitzen, bezte bat sartu :");
	}
}
