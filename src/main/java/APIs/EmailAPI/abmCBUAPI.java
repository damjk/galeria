package APIs.EmailAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import APIs.Entidades.CBU;
import APIs.Entidades.CBUTOKEN;
import retrofit2.Call;
import retrofit2.http.*;
//import sun.plugin.javascript.navig.JSObject;

import java.util.ArrayList;

public interface abmCBUAPI {
	public static  String tokenAPI = "";

    @Headers(
            {
            		"apiKey: 49df96c8-e3cf-45f3-a7a5-4297505d317f",
                    "Content-Type: application/json",
                    
            }
    )


    @POST("cbu")
    
    Call<CBU> enviarMail(@Body JsonObject Messages, @Header("Authorization") String authHeader);
    

    @Headers(
            {
            		
                    "Content-Type: application/json",
                    "Authorization: Basic YzJlZDkwMTUtOTkwMS00ZjNiLWE1NjctODczYzA5NDM3ZmU3OjQ5ZGY5NmM4LWUzY2YtNDVmMy1hN2E1LTQyOTc1MDVkMzE3Zg=="
            }
    )


     @GET("v1/oauth/accesstoken?grant_type=client_credentials")
    Call<CBUTOKEN> enviarToken();
    
    @Headers(
            {
            		"apiKey: 49df96c8-e3cf-45f3-a7a5-4297505d317f",
                    "Content-Type: application/json",
                    
            }
    )


    @PUT("cbu")
    
    Call<CBU> modificarCBU(@Body JsonObject Messages, @Header("Authorization") String authHeader);
    
    
  @POST("cbu/deletions")
    
    Call<CBU> bajaCBU(@Body JsonObject Messages, @Header("Authorization") String authHeader);

}
