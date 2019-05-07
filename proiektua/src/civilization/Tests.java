package civilization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tests {

	Jokalaria j = new Jokalaria("izena");
	Hiria h = new Hiria("hiri",5,5);
	
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void gerlariMugituTest() {
		Mapa.getNireMapa().print();
		Mapa.getNireMapa().printJokalariakIkustenDuena(j);
		h.sortuGerlaria("gerlari");
		
		
	}

}
