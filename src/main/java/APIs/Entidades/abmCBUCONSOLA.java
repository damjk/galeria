package APIs.Entidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import APIs.APIRefugio.Servicie.ServicioRefugio;
import APIs.EmailAPI.abmCBU;
import APIs.EmailAPI.abmCBUToken;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class abmCBUCONSOLA {

	public static void main(String[] args) throws IOException {
		abmCBU servicioRefugio = abmCBU.instancia();
		Response<CBU> listado = servicioRefugio.altaCBU();
		int listado1 = servicioRefugio.getLastResponseCode();
		int status = 200;
		abmCBUToken obtenerToken = abmCBUToken.instancia();
		Response<CBUTOKEN> token = obtenerToken.altaToken();
		System.out.println("CBU");
		 	System.out.println(new Gson().toJson(listado.body()));    
			System.out.println(listado.body());
			System.out.println(listado1);
			System.out.println(listado.errorBody().string());
			
			System.out.println("TOKEN");
			System.out.println(token.body().getAcess_token());
			 System.out.println(new Gson().toJson(token.body()));    
			
		}
			
	

	
}
