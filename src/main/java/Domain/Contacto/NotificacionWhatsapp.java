package Domain.Contacto;

import java.io.IOException;

import Domain.Usuario.Persona;

public class NotificacionWhatsapp implements FormaDeNotificacion {
    public void enviarNotificacion(Contacto contacto, Persona emisor, String mensaje) {

    }

	@Override
	public void altaCBU(String mensaje) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Void altaCBU() throws IOException {
		return null;
		// TODO Auto-generated method stub
		
	}
}
