package civilization;
import java.util.ArrayList;
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

	public int irakurriKoordenatua(int max){
		try{
			String sar=this.sc.nextLine();
			int zenb =Integer.parseInt(sar);
			if(max>=zenb||zenb>=1)return zenb;
			throw new NumberFormatException();
		}catch(NumberFormatException nFE){
			nFE.printStackTrace();
			System.out.println("Berriro");
			return this.irakurriKoordenatua(max);
		}
	}
	public int irakurriZenb()throws NumberFormatException{
		String sar=this.sc.nextLine();
		int zenb =Integer.parseInt(sar);
		return zenb;

	}
	//public void dfjadsljfhd(){
	//}
	public String getAukerak(ArrayList<String> arrayList) {
		String sar=this.sc.nextLine();
		try {
			if(arrayList.contains(sar) || sar.equals("Atera") || sar.equals("Ezer")) return sar;
			throw new AukeraEzEgokiaException();
		}catch(AukeraEzEgokiaException hEDE) {
			hEDE.printStackTrace();
			return this.getAukerak(arrayList);
		}
	}
	
	public String irakurriIzena() {
		String izena = this.sc.nextLine();
		if(izena.isEmpty()) {
			System.out.println("Sartu zerbait mesedez...");
			izena = this.irakurriIzena();
		}
		return izena;
	}
}
