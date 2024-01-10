package Domain.Usuario;

import Domain.Asociacion.Asociacion;
import Domain.Excepcion.ValidacionContraseniaException;
import Domain.Validacion.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.HashSet;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer IdUsuario;
    private String usuario;
    private String password;    
    public String getPassword() {
		return password;
	}
    @OneToOne(cascade = CascadeType.ALL)
	private Asociacion asociacion;
    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;

    public void setPassword (String password ){
        if(this.validarPassword(password)) {
            this.password = password;
        }else{
            throw new ValidacionContraseniaException("La contraseña no cumple con el criterio");
        }
    }

    public boolean validarPassword(String password)
    {
        Set<Validacion> criterio = new HashSet<>();
        criterio.add(new ValidacionDeCaracteresRepetidos());
        criterio.add(new ValidacionContraseniaDebil());
        criterio.add(new ValidacionDeCaracteresRepetidos());
        criterio.add(new ValidacionDeUnNumeroUnaLetra());
        Validador validador = new Validador();
        return validador.validar(password,criterio);
    }

    public boolean autenticar(String usuario, String password)
    {
        // Traer el repo con todos los usuarios del sistema
        // Verificar que el usuario exista en el repo
        // Verificar que la password coincida con la del usuario
        // Devolver resultado
        return true;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}

	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}
