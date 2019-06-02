package civilization;

public class HiriaEzDagoException extends Exception {
	
	public HiriaEzDagoException() {
		super();
	}
	
	public void printStackTrace() {
		System.out.println("Sartu duzun aukera ez da existitzen, beste bat sartu :");
	}
}
