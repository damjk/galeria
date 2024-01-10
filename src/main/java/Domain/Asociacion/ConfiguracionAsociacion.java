package Domain.Asociacion;


//import jdk.internal.jimage.ImageStrings;
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
import javax.persistence.OneToOne;
@Entity
public class ConfiguracionAsociacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer ID;
    private Integer altoFoto;
	private Integer anchoFoto;
    private Calidad calidad;
    @Column
    @ElementCollection(targetClass=String.class)
    private Set<String> caracteristicas = new HashSet<>();
    @Column
    @ElementCollection(targetClass=String.class)
    private Set<String> preguntas;

    public void setAltoFoto(Integer altoFoto){
        this.altoFoto = altoFoto;
    }

    public void setAnchoFoto(Integer anchoFoto){
        this.anchoFoto = anchoFoto;
    }

    public void setCalidadFotos(Calidad calidadFotos){
        this.calidad = calidadFotos;
    }

    public Set<String> getCaracteristicas()
    {
        return this.caracteristicas;
    }

    public void agregarCaracteristicas(String caracteristica){
        this.caracteristicas.add(caracteristica);
    }
    public void agregarCaracteristicas(List<String> caracteristicas){
        caracteristicas.forEach(caracteristica -> this.agregarCaracteristicas(caracteristica));
    }

    public void eliminarCaracteristica(String caracteristica){
        this.caracteristicas.remove(caracteristica);
    }

    public void agregarPreguntas(String pregunta){
        this.preguntas.add(pregunta);
    }
    public void agregarPreguntas(List<String> preguntas){
        preguntas.forEach(pregunta -> this.agregarPreguntas(pregunta));
    }

    public void eliminarPreguntas(String pregunta){
        this.preguntas.remove(pregunta);
    }
    
    public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Calidad getCalidad() {
		return calidad;
	}

	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}

	public Set<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<String> preguntas) {
		this.preguntas = preguntas;
	}

	public Integer getAltoFoto() {
		return altoFoto;
	}

	public Integer getAnchoFoto() {
		return anchoFoto;
	}

	public void setCaracteristicas(Set<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
    


}
