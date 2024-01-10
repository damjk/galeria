package Domain.Publicacion;

import Domain.Asociacion.Asociacion;
import Domain.Direccion.Direccion;
import Domain.Mascota.Mascota;
import Domain.Usuario.Persona;

import java.util.Set;

public class Publicacion {

	public void setAsociacionId(Integer id) {
		// TODO Auto-generated method stub
		
	}
/*

    private Mascota mascota;
    private Direccion direccionTransito;
    private Direccion direccionEncontrado;
    private EstadoPublicacion estado;
    private Persona autor;

    public void contactarAutor(Persona interesado, String mensaje){
        //autor.notificar(interesado,mensaje);
    }

    public Publicacion( Mascota mascota, Persona autor, Direccion direccionEncontrado, Direccion direccionTransito )
    {
        this.setMascota(mascota);
        this.setDireccionTransito(direccionTransito);
        this.setDireccionEncontrado(direccionTransito);
        this.setAutor(autor);
        this.setEstado(EstadoPublicacion.PENDIENTE);
        // mascota.getAsociacion().agregarPublicacion(this);
    }

    public void contactarAutor()
    {
        //rescatista.recibirMensaje("Soy el duenio -- Atte. "+rescatista.getNombre()+" "+rescatista.getApellido() );
    }

    public void setEstado(EstadoPublicacion estado)
    {
        this.estado = estado;
    }


    public void contactarRescatista()
    {
        rescatista.recibirMensaje("Soy el duenio -- Atte. "+rescatista.getNombre()+" "+rescatista.getApellido() );
    }


    public void aprobar()
    {
        this.setEstado(EstadoPublicacion.APROBADA);
    }

    public void finalizar()
    {
        this.setEstado(EstadoPublicacion.FINALIZADA);
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Direccion getDireccionTransito() {
        return direccionTransito;
    }

    public void setDireccionTransito(Direccion direccionTransito) {
        this.direccionTransito = direccionTransito;
    }
    public Mascota getMascota() {
        return mascota;
    }
    
    public Asociacion getAsociacion() { return asociacion; }


    public Set<Publicacion> mascotasQueLePuedenInteresar(Set<Publicacion> publicacionesDeMascotasDisponibles) {
        return (Set<Publicacion>) publicacionesDeMascotasDisponibles.stream().filter(publicacion -> this.mascota.seParece(publicacion));
    }

    public Direccion getDireccionEncontrado() {
        return direccionEncontrado;
    }

    public void setDireccionEncontrado(Direccion direccionEncontrado) {
        this.direccionEncontrado = direccionEncontrado;
    }

    public EstadoPublicacion getEstado() {
        return estado;
    }
    */
}
