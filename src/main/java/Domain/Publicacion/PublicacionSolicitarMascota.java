package Domain.Publicacion;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import Domain.Asociacion.Asociacion;
import Domain.Mascota.Mascota;
import Domain.Usuario.Usuario;

@Entity
@PrimaryKeyJoinColumn(name="publicacionId")
public class PublicacionSolicitarMascota extends PublicacionTemplate {
    public PublicacionSolicitarMascota(Integer id, Asociacion asociacion, Mascota mascota, Usuario autor) {
        super(id, asociacion, mascota, autor, "Interes");
    }

    
    public PublicacionSolicitarMascota( ) {
        
    }
	
}
