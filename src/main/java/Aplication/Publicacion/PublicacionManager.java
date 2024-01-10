package Aplication.Publicacion;

import Domain.Asociacion.Asociacion;
import Domain.Direccion.Direccion;
import Domain.Mascota.Mascota;
import Domain.Publicacion.EstadoPublicacion;
import Domain.Publicacion.Publicacion;
import Domain.Usuario.Persona;

import java.util.Set;

public class PublicacionManager {
/*
    private Set<Publicacion> interesadosDeAdopcion;

    public Publicacion darEnAdopcion(Mascota mascota, Persona asociado){
        Asociacion asociacion = mascota.getAsociacion();
        Hogar hogar = asociado.getHogar();
        Direccion direccion = asociado.getDireccion();

        return new Publicacion(mascota, asociado, asociacion, hogar, direccion, EstadoPublicacion.ACTIVA);
    }

    public void solicitarAdopcion(Publicacion publicacionDeAdopcion, Persona interesado ){
        publicacionDeAdopcion.contactarAsociado(interesado,"Hola! Quisiera Adoptar a mascota.");
    }

    public Publicacion solicitarAdoptarMascotaTipo(Mascota mascotaTipo, Persona interesado){
        Asociacion asociacion = mascotaTipo.getAsociacion();
        Hogar hogar = interesado.getHogar();
        Direccion direccion = interesado.getDireccion();
        Publicacion publicacion = new Publicacion(mascotaTipo, interesado, asociacion, hogar, direccion, EstadoPublicacion.PENDIENTE);
        // Generador de link para dar de baja subscripcion
        interesadosDeAdopcion.add(publicacion);
        interesado.notificar(String link);
    }

    public void notificarAInteresados(){
        interesadosDeAdopcion.forEach(subcriptor -> {
            Asociacion asociacion = subcriptor.getAsociacion();
            Persona interesado = subcriptor.getPersonaAsociada();
            Set<Publicacion> mascotasDisponibles = asociacion.mascotasEnAdopcion();
            Set<Publicacion> mascotasInteresantes = subcriptor.mascotasQueLePuedenInteresar(mascotasDisponibles);
            // se genera una pestaña WEB con las publicaciones de interes
            interesado.notificar(String linkDePublicacionesDeInteres);
            }
        );
    }
*/
}
