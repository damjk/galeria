package Domain.Galeria;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import Domain.Mascota.Foto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;


@Entity
public class MK {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer ID;
	

	private String nombre ;	
	
	
	private Blob imagen ;
	private Boolean banner = true;
	

	


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




public String getNombre() {
	return nombre;
}




public void setNombre(String nombre) {
	this.nombre = nombre;
}




public Blob getImagen() {
	return imagen;
}




public void setImagen(Blob imagen) {
	this.imagen = imagen;
}


public static String convertBlobToBase64(Blob blob) throws SQLException {
    // Paso 1: Leer los bytes del Blob
    byte[] blobBytes = blob.getBytes(1, (int) blob.length());

    // Paso 2: Convertir a Base64
    return Base64.getEncoder().encodeToString(blobBytes);
}



	   

	    
}






