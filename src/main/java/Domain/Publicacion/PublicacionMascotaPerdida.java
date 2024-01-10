package Domain.Publicacion;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import Domain.Asociacion.Asociacion;
import Domain.Direccion.Direccion;
import Domain.Mascota.Mascota;
import Domain.Usuario.Usuario;

@Entity
@PrimaryKeyJoinColumn(name="publicacionId")
public class PublicacionMascotaPerdida extends PublicacionTemplate {

	
    //private Direccion direccionTransito;
    
	//private Direccion direccionEncontrado;
    private String tipo = "Perdida";

    public PublicacionMascotaPerdida(Integer id,Asociacion asociacion, Mascota mascota, Usuario autor, Direccion direccionTransito, Direccion direccionEncontrado , String tipo )
    {
        super( id,asociacion, mascota, autor,"Perdida");
       // this.setDireccionTransito(direccionTransito);
        
        //this.setDireccionEncontrado(direccionEncontrado);
    }
    
    public PublicacionMascotaPerdida(){
    	super();
        

    }

    public DatosPublicacion mostrar()
    {
        String titulo = "Encontramos a " + this.getMascota().getNombre() + " y busca duenio.";
        String descripcion = this.getMascota().getDescripcion();
        return super.mostrar( titulo, descripcion, this.getMascota().getFotos() );
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    /*
    public void setDireccionTransito( Direccion direccionTransito )
    {
        this.direccionTransito = direccionTransito;
    }

    public void setDireccionEncontrado( Direccion direccionEncontrado )
    {
        this.direccionEncontrado = direccionEncontrado;
    }
    */

}
