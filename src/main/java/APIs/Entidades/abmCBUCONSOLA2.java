package APIs.Entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import APIs.APIRefugio.Servicie.ServicioRefugio;
import APIs.EmailAPI.abmCBU;
import APIs.EmailAPI.abmCBUToken;
import Domain.Repositorio;
import Domain.RepositorioPublicacion;
import Domain.Controller.Galeria;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class abmCBUCONSOLA2 {

	public static void main(String[] args) throws IOException, SQLException {
		Repositorio repositorio= new RepositorioPublicacion();
        repositorio.setGaleria();
        
        List<Galeria> blobList = new ArrayList<>();
        blobList=repositorio.galeria;
        Repositorio.guardar2(blobList.get(0));
        
        
			
		}
			
	

	
}
