package Domain;

import APIs.EmailAPI.MailjetEmail;
import Domain.Asociacion.Asociacion;
import Domain.Contacto.Contacto;
import Domain.Direccion.Direccion;
import Domain.Mascota.Mascota;
import Domain.Usuario.Persona;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) throws IOException {
        /*Direccion laEsquina = new Direccion();
        Set<Asociacion> asociaciones = Repositorio.getAsociaciones();
        Hashtable<String,String> datos = new Hashtable<>();
        datos.put("nombre", "Jorge");
        datos.put("apellido", "Ramirez");
        datos.put("telefono", "1123093041");
        datos.put("email", "ftorregrossajeff@gmail.com");
        Contacto contactoJorge = new Contacto(datos);
        contactoJorge.setFormasDeNotificacion(MailjetEmail.instancia());
        contactoJorge.notificar("hola tengo tu perro");
        Persona jorge = new Persona(datos, contactoJorge);
        Asociacion asociacion1 = Asociacion.obtenerAsociacionMasCercana(laEsquina);
        Mascota firulais = new Mascota("firulais",asociacion1);
        jorge.registraMascotaPerdida(firulais,laEsquina);
        System.out.println(asociacion1.getPublicaciones().stream().findFirst().get().getMascota().getNombre());
         */
    }
}
