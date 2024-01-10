package APIs.EmailAPI;

import Domain.Contacto.Contacto;
import Domain.Contacto.FormaDeNotificacion;
import Domain.Contacto.NotificacionEmail;
import Domain.Usuario.Persona;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import APIs.APIRefugio.Servicie.RefugiofService;
import APIs.APIRefugio.Servicie.ServicioRefugio;
import APIs.Entidades.RefugiosApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;

public class MailjetEmail implements FormaDeNotificacion {
    private static MailjetEmail instancia = null;
    private static final String urlApi = "https://api.mailjet.com/v3.1/";
    private Retrofit retrofit;
    private int lastResponseCode;

    private MailjetEmail() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MailjetEmail instancia(){
        if(instancia== null){
            instancia = new MailjetEmail();
        }
        return instancia;
    }

    @Override
    public void enviarNotificacion(Contacto contacto, Persona emisor, String mensaje) throws IOException
    {
        JsonObject message = new JsonObject();
        JsonObject from = new JsonObject();
        from.addProperty("Email","ftorregrossa@frba.utn.edu.ar");
        from.addProperty("Name","Rescate De Patitas");
        message.add("From", from);

        JsonArray destinatarios = new JsonArray();
        JsonObject to = new JsonObject();
        to.addProperty("Email", contacto.getEmail());
        to.addProperty("Name",contacto.getNombre());
        destinatarios.add(to);
        message.add("To", destinatarios);

        message.addProperty("Subject", "Encontraste a mi mascota");
        message.addProperty("TextPart", mensaje);
        message.addProperty("CustomID", "AppGettingStartedTest");

        JsonArray messages = new JsonArray();
        messages.add(message);

        JsonObject body = new JsonObject();
        body.add("Messages", messages);
        MailjetEmailAPI mailjetEmail = this.retrofit.create(MailjetEmailAPI.class);
        Call<Void> request = mailjetEmail.enviarMail(body);

        Response<Void> response = request.execute();
        this.lastResponseCode = response.code();

        //System.out.println(response.errorBody().string());
    }


    public Retrofit devolver() {
        return retrofit;
    }

    public int getLastResponseCode() {
        return lastResponseCode;
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
