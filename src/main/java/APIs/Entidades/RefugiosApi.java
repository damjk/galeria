package APIs.Entidades;

import java.util.List;


public class RefugiosApi {

	public int total;

	public int offset;
	public List<Refugio> hogares;

	public List<Refugio> ListaRefugios() {
		return this.hogares;
	}

	public int getTotal() {
		return total;
	}

	public int getOffset() {
		return offset;
	}

}
