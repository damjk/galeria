package Domain.Contacto;

import Domain.Usuario.Persona;

import java.io.IOException;

public interface FormaDeNotificacion {
    void enviarNotificacion(Contacto contacto, Persona emisor, String mensaje) throws IOException;

	void altaCBU(String mensaje) throws IOException;

	Void altaCBU() throws IOException;
}
