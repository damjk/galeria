package APIs.APIRefugio.Servicie;



import APIs.Entidades.RefugiosApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RefugiofService {
	@Headers(
		    {"Authorization: Bearer 0kYMipO7mgAAxKIfqcpqC4dDyBqiFKTDJzXMhfb38u95uoZDhViRdbEv7BNi",
			"Accept: application/json"}
			)
	//Pagina 1
	
	
    @GET("hogares?offset=1")
    Call<RefugiosApi> hogares();
	@Headers(
		    {"Authorization: Bearer 0kYMipO7mgAAxKIfqcpqC4dDyBqiFKTDJzXMhfb38u95uoZDhViRdbEv7BNi",
			"Accept: application/json"}
			)
	@GET("hogares")
	Call<RefugiosApi> hogares(@Query("offset") int offset);
}
