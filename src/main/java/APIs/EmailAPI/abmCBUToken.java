package APIs.EmailAPI;

import Domain.Contacto.Contacto;
import Domain.Contacto.FormaDeNotificacion;
import Domain.Contacto.NotificacionEmail;
import Domain.Usuario.Persona;
import okhttp3.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import APIs.APIRefugio.Servicie.RefugiofService;
import APIs.APIRefugio.Servicie.ServicioRefugio;
import APIs.Entidades.CBU;
import APIs.Entidades.CBUTOKEN;
import APIs.Entidades.RefugiosApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;

public class abmCBUToken  {
    private static abmCBUToken instancia = null;
    private static final String urlToken = "https://api-homo.prismamediosdepago.com/";
    private Retrofit retrofit;
    private int lastResponseCode;

    private abmCBUToken() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlToken)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static abmCBUToken instancia(){
        if(instancia== null){
            instancia = new abmCBUToken();
        }
        return instancia;
    }

    public Response<CBUTOKEN> altaToken() throws IOException
    {
    	

     
    	abmCBUAPI mailjetEmail = this.retrofit.create(abmCBUAPI.class);
        Call<CBUTOKEN> request = mailjetEmail.enviarToken();

        Response<CBUTOKEN> response = request.execute();
        this.lastResponseCode = response.code();

    
	       
    	return response;
    }


    public Retrofit devolver() {
        return retrofit;
    }

    public int getLastResponseCode() {
        return lastResponseCode;
    }

	


	

	
}
