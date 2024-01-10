package Domain.Publicacion;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import Domain.Asociacion.Asociacion;
import Domain.Mascota.Mascota;

import Domain.Usuario.Usuario;
@Entity
@PrimaryKeyJoinColumn(name="publicacionId")
public class PublicacionMascotaEnAdopcion extends PublicacionTemplate {
    public PublicacionMascotaEnAdopcion(Integer id,Asociacion asociacion, Mascota mascota, Usuario autor)
    {
        super(id,asociacion, mascota, autor, "En Adopcion");
    }
    
    public PublicacionMascotaEnAdopcion(){
    	super();
        
    }

    public DatosPublicacion mostrar()
    {
        String titulo = "Doy en adopcion a " + this.getMascota().getNombre();
        String descripcion = this.getMascota().getDescripcion();
        return super.mostrar(titulo, descripcion, this.getMascota().getFotos());
    }
}
