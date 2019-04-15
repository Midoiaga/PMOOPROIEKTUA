package civilization;
import java.util.Scanner;
public class Teklatua {
	private Scanner sc;
	private static Teklatua nireTeklatua;

	private Teklatua(){
		this.sc=new Scanner(System.in);
	}
	public static Teklatua getNireTeklatua(){
		if(nireTeklatua==null){
			nireTeklatua=new Teklatua();
		}
		return nireTeklatua;
	}
	public int irakurriZenb()throws NumberFormatException{

		try{
			String sar=this.sc.nextLine();
			int zenb =Integer.parseInt(sar);
			return zenb;
		}catch(NumberFormatException nFE){
			nFE.printStackTrace();
			System.out.println("Berriro");
			return this.irakurriZenb();
		}
	}
	public void irakurriKoordenatuak(){
		dgAFGSDHFSTHSTRHRWST
	}
}