package Domain.Validacion;

import APIs.EmailAPI.MailjetEmail;
import Domain.Contacto.Contacto;
import Domain.Contacto.NotificacionEmail;
import Domain.Repositorio;
import Domain.Usuario.Persona;
import Domain.Usuario.TipoDocumento;
import Domain.Usuario.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

public class TestNotificacion {
    /*
    @Before
    public void init(){

    }

    @Test
    public void seNotificaPorMail() throws IOException {
        Hashtable<String,String> datos = new Hashtable<>();
        String nombre = "Jorge";
        String apellido = "Ramirez";
        String telefono = "1123093041";
        String email = "ftorregrossajeff@gmail.com";
        Contacto contactoJorge = new Contacto(nombre, apellido, telefono, email);

        MailjetEmail servicioEmail = MailjetEmail.instancia();
        contactoJorge.setFormasDeNotificacion(servicioEmail);

        Set<Contacto> contactos = Repositorio.getContacto( "Alejandro", "Romero", "1130234991", "romero.m.alejandro@gmail.com" );
        Persona emisor = Persona.registrarPersona( "Alejandro", "Romero", TipoDocumento.DNI, 19890428, 34319384, contactos );


        try {
            contactoJorge.notificar(emisor, "Hola tenes a mi perrito por favor devolvelo");
        }catch( IOException exception ){
            exception.getMessage();
        }
        Assert.assertEquals(200, servicioEmail.getLastResponseCode());
    }

     */
}
