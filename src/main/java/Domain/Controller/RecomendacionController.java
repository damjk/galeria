package Domain.Controller;



import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class RecomendacionController {
	 private static Gson gson = new Gson();
	
	public static Object sugerencias(Request request, Response response)  {
    	 
         return gson.toJson("En mantenimiento");
    }

}
