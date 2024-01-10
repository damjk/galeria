package Domain.Usuario;

import Domain.Contacto.Contacto;
import Domain.Mascota.Mascota;
import Domain.Publicacion.PublicacionMascotaPerdida;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer ID;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private Integer numeroDocumento;
    private Integer fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Contacto> contactos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Mascota> mascotas = new HashSet<>();

    public static Persona registrarPersona( String nombre, String apellido, TipoDocumento tipoDocumento, Integer numeroDocumento, Integer fechaNacimiento, List<Contacto> contactos )
    {
        Persona persona = new Persona();
        persona.setNombre( nombre );
        persona.setApellido( apellido );
        persona.setTipoDocumento( tipoDocumento );
        persona.setNumeroDocumento( numeroDocumento );
        persona.setFechaNacimiento( fechaNacimiento );
        persona.agregarContactos( contactos );
        return persona;
    }
    public void agregarContactos( List<Contacto> contactos2 )
    {
        this.getContactos().addAll( contactos2 );
    }

    public void agregarContactos( Contacto contacto )
    {
        this.getContactos().add( contacto );
    }

    public void asociarMascota( Mascota mascota )
    {
        this.mascotas.add( mascota );
    }

    /*public Publicacion registraMascotaPerdida( Mascota mascota, Direccion direccion )
    {
        //this.hogar.darTransito(mascota);
        return new Publicacion(mascota, direccion, this);
    }*/
    /*
    public Publicacion registraMascotaPerdida( Mascota mascota, Direccion direccion, Hogar hogar )
    {
        this.registrarMascota(mascota);
        hogar.darTransito(mascota);
        return new Publicacion(mascota, direccion, this);
    }
    */
    public void encontrarMascota(PublicacionMascotaPerdida publicacion)
    {
        publicacion.finalizarPublicacion();
       
        publicacion.getMascota().encontroDuenio();
    }
    /*
    public void recibirMensaje(String mensaje)
    {
        //this.contactos.stream().foreach( contacto => contacto.formaNotificacion.enviarNotificacion(contacto, mensaje) );

        this.getContactos().stream().forEach(contacto -> {
            try {
                contacto.notificar(mensaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void rescatarMascotaConChapita( Mascota mascota )
    {
        mascota.avisarDuenio(this.getContactos());
    }
    */
    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }
    /*
    public void encontrarMascota(Publicacion unaPublicacion, String mensaje){
        unaPublicacion.contactarAsociado(this, mensaje);
    }
    */

    public void interesadoEnAdoptar( Mascota mascota, Persona interesado )
    {
        String mensaje = interesado.getNombre() + " esta interesado en adoptar a " + mascota.getNombre();
        this.notificar( interesado, mensaje );
    }

    public void notificar(Persona persona,String mensaje) {

        getContactos().stream().forEach(contacto -> {try{contacto.notificar(persona, mensaje);}catch(IOException ex){ex.getMessage();}});

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

}
