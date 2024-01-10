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

public class abmCBU  {
    private static abmCBU instancia = null;
    private static final String urlApi = "https://api-homo.prismamediosdepago.com/v2/cbu_management/accounts/account/";
    private static  String Token = "";
    private Retrofit retrofit;
    private int lastResponseCode;

    private abmCBU() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static abmCBU instancia(){
        if(instancia== null){
            instancia = new abmCBU();
        }
        return instancia;
    }

    public Response<CBU> altaCBU() throws IOException
    {
    	
    	
    	JsonObject body1 = new JsonObject();
    	body1.addProperty("document_type","DNI");
    	body1.addProperty("document_number","12345678");
    	body1.addProperty("debit_bank_id","NRJX");
    	body1.addProperty("cbu","4530099220000913395411");
    	body1.addProperty("account_number","91339541");
    	body1.addProperty("account_type","11");
    	body1.addProperty("currency","ARS");
    	body1.addProperty("holder_cuit","23638527499");
    	body1.addProperty("second_holder_cuit","");
    	body1.addProperty("third_holder_cuit","");
    	body1.addProperty("denomination","GUSTAVO CERATI");
    	body1.addProperty("allow_cash_deposits","S");
    	body1.addProperty("allow_check_deposits","S");
    	body1.addProperty("allow_receive_transfers","S");
    	body1.addProperty("last_transfers_date","2021-02-23T19:49:34+00:00");
    	
    	abmCBUToken obtenerToken = abmCBUToken.instancia();
		Response<CBUTOKEN> token = obtenerToken.altaToken();
	     String header="Bearer"+ " " + token.body().access_token;

     
    	abmCBUAPI mailjetEmail = this.retrofit.create(abmCBUAPI.class);
        Call<CBU> request = mailjetEmail.enviarMail(body1, header);

        Response<CBU> response = request.execute();
        this.lastResponseCode = response.code();

       
	       
    	return response;
    }
    
    
    public Response<CBU> altaCBUv2(JsonObject body1) throws IOException
    {
    	
    	
    	abmCBUToken obtenerToken = abmCBUToken.instancia();
		Response<CBUTOKEN> token = obtenerToken.altaToken();
	     String header="Bearer"+ " " + token.body().access_token;
    	abmCBUAPI mailjetEmail = this.retrofit.create(abmCBUAPI.class);
        Call<CBU> request = mailjetEmail.enviarMail(body1,header);

        
        
        Response<CBU> response = request.execute();
        this.lastResponseCode = response.code();

       
	       
    	return response;
    }
    
    
    public Response<CBU> bajaCBUv2(JsonObject body1) throws IOException
    {
    	
    	
    	abmCBUToken obtenerToken = abmCBUToken.instancia();
		Response<CBUTOKEN> token = obtenerToken.altaToken();
	     String header="Bearer"+ " " + token.body().access_token;
    	abmCBUAPI mailjetEmail = this.retrofit.create(abmCBUAPI.class);
        Call<CBU> request = mailjetEmail.bajaCBU(body1,header);

        
        
        Response<CBU> response = request.execute();
        this.lastResponseCode = response.code();

       
	       
    	return response;
    }
    
    public Response<CBU> modificarCBU(JsonObject body1) throws IOException
    {
    	
    	
    	abmCBUToken obtenerToken = abmCBUToken.instancia();
		Response<CBUTOKEN> token = obtenerToken.altaToken();
	     String header="Bearer"+ " " + token.body().access_token;
    	abmCBUAPI mailjetEmail = this.retrofit.create(abmCBUAPI.class);
        Call<CBU> request = mailjetEmail.modificarCBU(body1,header);

        Response<CBU> response = request.execute();
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
