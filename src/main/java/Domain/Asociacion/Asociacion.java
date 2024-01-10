package Domain.Asociacion;

import Domain.Direccion.Direccion;
import Domain.Mascota.Mascota;
import Domain.Publicacion.Publicacion;
import Domain.Publicacion.PublicacionTemplate;
import Domain.Repositorio;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Asociacion{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Mascota> mascotas;
	@OneToOne(cascade = CascadeType.ALL)
    private ConfiguracionAsociacion configuracionAsociacion;    
	@OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
    private String nombre;
   

    
    public Asociacion(  Integer id , String nombre, ConfiguracionAsociacion configuracion, Direccion direccion )
    {
    	this.id = id;
        this.setNombre(nombre);
        this.setConfiguracionAsociacion(configuracion);
        this.direccion = direccion;
    }
    
    public Asociacion(  )
    {
    	
    }
    
    
    

    public void agregarNuevaMascota(Mascota mascota) { mascotas.add(mascota); }

    

    public Direccion getDireccion()
    {
        return this.direccion;
    }

    /*
    public static Asociacion obtenerAsociacionMasCercana(Direccion direccion)
    {
        Set<Asociacion> asociaciones = Repositorio.getAsociaciones();
        // TO DO encontrar asociacion mas cercana del set de asociaciones
        return Repositorio(asociaciones);
    }

*/
    public static List<PublicacionTemplate> getPublicaciones()
    {
        return Repositorio.publicaciones;
    }
    
    
    
    

	public ConfiguracionAsociacion getConfiguracionAsociacion() {
		return configuracionAsociacion;
	}

	public void setConfiguracionAsociacion(ConfiguracionAsociacion configuracionAsociacion) {
		this.configuracionAsociacion = configuracionAsociacion;
	}
	
	public Integer getAsociacionnId() {
		return id;
	}
	public void setAsociacionnId(Integer id) {
		 this.id=id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
    /*
    public Set<Publicacion> mascotasEnAdopcion() {
        //TODO
    }*/
}

