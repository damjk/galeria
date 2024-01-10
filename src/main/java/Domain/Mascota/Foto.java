package Domain.Mascota;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Domain.Asociacion.Calidad;
@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer ID;
    private Integer alto;
    private Integer ancho;
    private Calidad calidad;
    private String archivo;
    
    public Foto(){}
}
