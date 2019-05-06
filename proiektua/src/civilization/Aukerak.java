package civilization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Aukerak {
	
	private static Aukerak nireAukerak = new Aukerak();
	
	private Aukerak() {
		
	}
	
	public static Aukerak getAukerak() {
		return nireAukerak;
	}
	
	public ArrayList<String> aukerakFiltro(String pFiltroa){
		ArrayList<String> emaitza = new ArrayList<String>();
		String fitxategia = Aukerak.class.getResource("Aukerak.txt").getFile();
        String line = "";
        try (BufferedReader br1 = new BufferedReader(new FileReader(fitxategia))) {
            while ((line = br1.readLine()) != null) {
            	System.out.println("Entra en el while");
                if(line.equals(pFiltroa)) {
                	System.out.println("Entra en el if");
                	while (line != null&&!line.equals(pFiltroa)) {
                		System.out.println("while");
                		line = br1.readLine();
                		emaitza.add(line);
                	}
                	System.out.println("return emaitza");
                	return emaitza;
                }               
            }
            System.out.println("return null");
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	
}
