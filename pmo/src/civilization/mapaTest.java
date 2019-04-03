package civilization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class mapaTest {

	@Test
	void test() {
		Mapa.getNireMapa().print();	
		Jokalaria j = new Jokalaria("");
		j.gehituHiria(new Hiria("",1,1));
		Gerlaria g = new Gerlaria("");
		g.eliminar(5, 6);
		j.gehituGerlaria(g);
		Mapa.getNireMapa().printJokalariakIkustenDuena(j);
	}

	

}
