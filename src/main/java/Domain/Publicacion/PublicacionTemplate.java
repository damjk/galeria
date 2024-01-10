
   
package Domain.Publicacion;

import Domain.Asociacion.Asociacion;
import Domain.Controller.ControllerUtils;
import Domain.Mascota.Foto;
import Domain.Mascota.Mascota;
import Domain.Usuario.Persona;
import Domain.Usuario.Usuario;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public abstract class PublicacionTemplate implements  Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer idPublicacion ;	
	@OneToOne(cascade=CascadeType.ALL)
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Asociacion asociacion;   
    @OneToOne (cascade=CascadeType.ALL)
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Mascota mascota; 
    @OneToOne (cascade=CascadeType.ALL)
    private Usuario autor;   
    private Boolean interes = true;   
    private EstadoPublicacion estado = EstadoPublicacion.PENDIENTE;
    private String tipo;
    private Boolean esDelUser = false;
    public PublicacionTemplate(Integer id , Asociacion asociacion, Mascota mascota, Usuario autor, String tipo )
    
    {
    	this.idPublicacion = id ;
        this.setAsociacion(asociacion);
        this.setMascota(mascota);
        this.setAutor(autor);
        this.tipo = tipo;
        
        
    }
    
    public EstadoPublicacion getEstado() {
    	return  this.estado;
    }

    
    public PublicacionTemplate() {}
    
    public void setEsDelUser (String loggedUser){
        this.esDelUser = loggedUser.equals(autor.getUsuario());
    }

    public Boolean getEsDelUser(){
        return esDelUser;
    }


    
    public DatosPublicacion mostrar( String titulo, String descripcion, Set<Foto> fotos)
    {
        return new DatosPublicacion( titulo, descripcion, fotos );
    }

    public void aprobarPublicacion()
    {
        this.estado = EstadoPublicacion.EnPROCESO;
    }
    public void rechazarPublicacion()
    {
        this.estado = EstadoPublicacion.RECHAZADA;
    }
    public void cancelarPublicacion()
    {
        this.estado = EstadoPublicacion.CANCELADA;
    }
    public void finalizarPublicacion()
    {
        this.estado = EstadoPublicacion.FINALIZADA;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	

	public Boolean getInteres() {
		return interes;
	}

	public void setInteres(Boolean interes) {
		this.interes = interes;
	}

    public String getTipo() {
        return tipo;
    }
}
