package Domain.Mascota;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import Domain.Asociacion.Asociacion;
import Domain.Usuario.Persona;
import Domain.Usuario.Usuario;

@Entity
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Long IdMascota;
    private String nombre;
    private String apodo;
    private Integer edad;
   
    private Especie especie;
    @OneToOne (cascade = CascadeType.ALL)
    private Usuario duenio;
    
    @Column
    @ElementCollection(targetClass=Foto.class)
    private Set<Foto> fotos;
    private Sexo sexo;
    private String descripcion;
    
    //private Direccion direccion;
    @Column
    @ElementCollection(targetClass=String.class)
    private Set<String> caracteristicas = new HashSet<>();
    private EstadoMascota estado;

    public Mascota(   )
    {
        
    }

    public static Mascota registrarMascotaConDuenio(Persona duenio, String nombre, String apodo, Integer edad, Sexo sexo, Especie especie, String descripcion, Set<Foto> fotos, Set<String> caracteristicas, Asociacion asociacion )
    {
        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        mascota.setEdad(edad);
        mascota.setSexo(sexo);
        mascota.setEspecie(especie);
        mascota.setDescripcion(descripcion);
        mascota.setFotos(fotos);
        mascota.setCaracteristicas(caracteristicas);
        //mascota.setDuenio(duenio);
        return mascota;

    }

    public static Mascota registrarMascotaPerdida( String nombre, String apodo, Integer edad, Sexo sexo, Especie especie, String descripcion, Set<Foto> fotos, Set<String> caracteristicas, Asociacion asociacion )
    {
        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        mascota.setEdad(edad);
        mascota.setSexo(sexo);
        mascota.setEspecie(especie);
        mascota.setDescripcion(descripcion);
        mascota.setFotos(fotos);
        mascota.setCaracteristicas(caracteristicas);
        mascota.setEstado( EstadoMascota.PERDIDA );
        return mascota;
    }
/*
    public void setDireccion( Direccion direccion )
    {
        this.direccion = direccion;
    }

    public Direccion getDireccion()
    {
        return this.direccion;
    }
    
    */

   /* 
    public void notificarDuenio(Persona unRescatista, String mensaje) {
        this.getDuenio().notificar(unRescatista, mensaje);
    }
    
*/

    public void encontroDuenio()
    {
        this.setEstado(EstadoMascota.CONDUENIO);
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    
    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
        this.setEstado(EstadoMascota.CONDUENIO);
        //duenio.asociarMascota(this);
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(Set<Foto> fotos) {
        this.fotos = fotos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoMascota getEstado() {
        return estado;
    }

    public void setEstado(EstadoMascota estado) {
        this.estado = estado;
    }

    public Set<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public Long getIdMascota() {
		return IdMascota;
	}

	public void setIdMascota(Long iD) {
		IdMascota = iD;
	}
}
