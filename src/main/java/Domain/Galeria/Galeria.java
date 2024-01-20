package Domain.Galeria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import Domain.Mascota.Foto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public class Galeria {
	
	
@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer idimagen ;	
	
    @OneToMany (cascade=CascadeType.ALL)
	private List<MK> imagenes = new ArrayList<>();
    
    @OneToMany (cascade=CascadeType.ALL)
	private List<DarkSoul> imagenes2 = new ArrayList<>();
    @OneToMany (cascade=CascadeType.ALL)
  	private List<GOD> imagenes3 = new ArrayList<>();
	
	


public List<GOD> getImagenes3() {
		return imagenes3;
	}




	public void setImagenes3(List<GOD> imagenes3) {
		this.imagenes3 = imagenes3;
	}




public List<DarkSoul> getImagenes2() {
		return imagenes2;
	}




	public void setImagenes2(List<DarkSoul> imagenes2) {
		this.imagenes2 = imagenes2;
	}




public Integer getIdimagen() {
		return idimagen;
	}




	public void setIdimagen(Integer idimagen) {
		this.idimagen = idimagen;
	}




	public List<MK> getImagenes() {
		return imagenes;
	}




	public void setImagenes(List<MK> mkes) {
		this.imagenes = mkes;
	}




public class ImagenUtil {

    // Método para convertir un archivo de imagen en un objeto Blob
    public static Blob convertirImagenABlob(String rutaArchivo) throws IOException, SQLException {
        try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
            // Crea un arreglo de bytes del tamaño del archivo
            byte[] imagenBytes = new byte[(int) new File(rutaArchivo).length()];

            // Lee el archivo en el arreglo de bytes
            fis.read(imagenBytes);

            // Crea un objeto Blob a partir del arreglo de bytes
            return new javax.sql.rowset.serial.SerialBlob(imagenBytes);
        }
    }
}




	   

	    
}






