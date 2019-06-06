package civilization;

public class Indarra extends Atributua {
	public int gehituMaila(int pUrrea, ListaEraikinak eraikinak) {
		if(urreNahiko(pUrrea)) {
			if(eraikinak.daukazuEraikina("Burdinola")!=null) {
				this.maila++;
				pUrrea=pUrrea-this.urreKost;
				this.urreKost=this.urreKost+100+(this.urreKost/4);
			}
		}
		return pUrrea;
	}
}
