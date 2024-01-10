package APIs.APIRefugio.Servicie;

import java.io.IOException;
import java.util.List;

import APIs.Entidades.Refugio;
import APIs.Entidades.RefugiosApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


	
	public class ServicioRefugio {
	    private static ServicioRefugio instancia = null;
	    private static int maximaCantidadRegistrosDefault = 200;
	    private static final String urlApi = "https://api.refugiosdds.com.ar/api/";
	    private Retrofit retrofit;

	    private ServicioRefugio() {
	        this.retrofit = new Retrofit.Builder()
	                .baseUrl(urlApi)
	                .addConverterFactory(GsonConverterFactory.create())
	                .build();
	    }

	    public static ServicioRefugio instancia(){
	        if(instancia== null){
	            instancia = new ServicioRefugio();
	        }
	        return instancia;
	    }

	    public RefugiosApi listadoDeHogares(int pagina) throws IOException {
	    	
	    	
	        RefugiofService refugioService = this.retrofit.create(RefugiofService.class);
	        Call<RefugiosApi> requestHogares = refugioService.hogares(pagina);
	        Response<RefugiosApi> responseHogares = requestHogares.execute();
	       
	    	return responseHogares.body() ;
	    }
	    
	    public Retrofit devolver() {
	    	return retrofit;
	    	
	    }
}
