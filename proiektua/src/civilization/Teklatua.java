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
	
	public String irakurriString() {
		String sar = this.sc.nextLine();
		return sar;
	}

	public String getAukerak(String pStr)
	{
		String erantzuna = null;
		switch(pStr)
		{
			case "Administratu Aukerak":
				//TODO
				//print jokalarien hiriak
				//irakurri administratu nahi den hiriaren izena
				break;
			case "Gerlari Aukerak":
				erantzuna = this.irakurriString();
				break;
			default:
				erantzuna = "Ezer";
				break;
		}
		
		return erantzuna;
		
	}

	//public void dfjadsljfhd(){
	//}
}
