package APIs.Entidades;

public class Refugio {
	public String id;
	
	public String nombre;
	
	public String direccion;
	public String telefono;
	
	public int capacidad;
	public int lugares_disponibles;
	public boolean patio;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
