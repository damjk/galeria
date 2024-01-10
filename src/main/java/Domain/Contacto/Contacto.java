package Domain.Contacto;

import Domain.Usuario.Persona;

import java.io.IOException;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer ID;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    @Transient
    private FormaDeNotificacion formaDeNotificacion;

    public Contacto( String nombre, String apellido, String telefono, String email )
    {
        this.nombre = nombre;
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.email = email;
    }
    
    public Contacto(  )
    {
        
    }

    public void notificar(Persona emisor, String mensaje) throws IOException {
        this.formaDeNotificacion.enviarNotificacion(this, emisor, mensaje);
    }

    public void setFormasDeNotificacion(FormaDeNotificacion formaDeNotificacion){
        this.formaDeNotificacion = formaDeNotificacion;
    }
    
    public String getEmail(){
        return email;
    }
    public String getNombre(){
        return nombre;
    }
    public FormaDeNotificacion getFormaDeNotificacion () { return formaDeNotificacion; }

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
