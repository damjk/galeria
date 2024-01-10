package Domain.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Domain.Repositorio;
import Domain.RepositorioPublicacion;
import Domain.Asociacion.Asociacion;
import Domain.DTOs.PublicacionTemplateDTO;
import Domain.Mascota.Especie;
import Domain.Mascota.EstadoMascota;
import Domain.Mascota.Sexo;
import Domain.Publicacion.PublicacionTemplate;
import Domain.Usuario.Usuario;
import Domain.Utilitario.Const;
import spark.Request;

public class ControllerUtils {
	
	   static final String MODEL_KEY_USERNAME = "logged";
	
	  static Map<String, Object> modeloConSesion(final Request request) {
	        final Map<String, Object> model = new HashMap<>();
	        model.put(MODEL_KEY_USERNAME, request.session().attribute(Const.ID_USUARIO));
	        return model;
	    }

	  static Asociacion obtenerAsosiacion(final Request request) {
	        return obtenerUsuario(request).getAsociacion();
	    }
	  
	  static String obtenerUsername(final Request request) {
	        return request.session().attribute(Const.ID_USUARIO);
	    }
	  

	  private static  Usuario obtenerUsuario(final Request request) {
	        //final String username = obtenerUsername(request);
	       
	        Usuario usuario = Repositorio.Usuarios().stream().filter(a-> a.getUsuario().equals(ControllerUtils.obtenerUsername(request))).collect(Collectors.toList()).get(0);
	        return usuario;
	    }
	  
static List<Especie> obtenerEspecie() {
	List<Especie> especies = new ArrayList<>(); 
    especies.add(Especie.GATO);
    especies.add(Especie.PERRO);
	return especies;
	
}

static List<Sexo> obtenerSexo() {
	List<Sexo> sexos = new ArrayList<>(); 
    sexos.add(Sexo.MASCULINO);
    sexos.add(Sexo.FEMENINO);
	return sexos;
	
}

public static List<EstadoMascota> obtenerEstadoMascota() {
	
	List<EstadoMascota> estados = new ArrayList<>(); 
	estados.add(EstadoMascota.CONDUENIO);
	estados.add(EstadoMascota.ENADOPCION);
	estados.add(EstadoMascota.PERDIDA);
	
	return estados;
}


static  List<PublicacionTemplateDTO> agregarOperacionesPaginadasCategorizadas(
        final Request request,
        final RepositorioPublicacion repositorioOperaciones,
        final Map<String, Object> modelo,
        final String modelKeyOperaciones) {
    final String paginaString = request.queryParams("pagina");
    final int pagina = paginaString != null
            ? Integer.parseInt(paginaString)
            : 1;
    final String cantidadPorPaginaString = request.queryParams("cantidadPorPagina");
    final int cantidadPorPagina = cantidadPorPaginaString != null
            ? Integer.parseInt(cantidadPorPaginaString)
            : 4;
    modelo.put("paginaAnterior", pagina - 1);
    modelo.put("paginaSiguiente", pagina + 1);
    final long ultimaPagina = (repositorioOperaciones
            .cantidadPorCondicion("idPublicacion") /
            cantidadPorPagina + 1);
    final boolean esultimaPagina = pagina == ultimaPagina;
    modelo.put("esUltimaPagina", esultimaPagina);
    final List<PublicacionTemplate> publicaciones =
            obtenerOperacionesPaginadas(request, pagina, cantidadPorPagina, repositorioOperaciones);
    modelo.put("publicaicones", publicaciones);
    
    List<PublicacionTemplateDTO> publicacionTemplateDTOs = new ArrayList<>();
	for (int i =0; i<publicaciones.size(); i++){
		PublicacionTemplate p = publicaciones.get(i);
		PublicacionTemplateDTO pd = new PublicacionTemplateDTO(p.getIdPublicacion(), p.getAsociacion(), p.getMascota(), p.getAutor(), p.getInteres(), p.getAsociacion().getAsociacionnId(), p.getEstado(), ControllerUtils.obtenerUsername(request), p.getTipo());
		publicacionTemplateDTOs.add(pd);
	}
	modelo.put("publicaciones", publicacionTemplateDTOs);
	
	return publicacionTemplateDTOs;
	  
	  
}

private static  List<PublicacionTemplate> obtenerOperacionesPaginadas(
        final Request request,
        final int pagina,
        final int cantidadPorPagina,
        final RepositorioPublicacion repositorioOperaciones) {

    final int offset = (pagina - 1) * cantidadPorPagina;

    
    return repositorioOperaciones.obtenerPaginado(offset, cantidadPorPagina);
}

public static void agregarOperacionesPaginadasPerdidas(
	
	        final Request request,
	        final RepositorioPublicacion repositorioOperaciones,
	        final Map<String, Object> modelo,
	        final String modelKeyOperaciones) {
	    final String paginaString = request.queryParams("pagina");
	    final int pagina = paginaString != null
	            ? Integer.parseInt(paginaString)
	            : 1;
	    final String cantidadPorPaginaString = request.queryParams("cantidadPorPagina");
	    final int cantidadPorPagina = cantidadPorPaginaString != null
	            ? Integer.parseInt(cantidadPorPaginaString)
	            : 4;
	    modelo.put("paginaAnterior", pagina - 1);
	    modelo.put("paginaSiguiente", pagina + 1);
	    final long ultimaPagina = (repositorioOperaciones
	            .cantidadPorCondicion("idPublicacion") /
	            cantidadPorPagina + 1);
	    final boolean esultimaPagina = pagina == ultimaPagina;
	    modelo.put("esUltimaPagina", esultimaPagina);
	    final List<PublicacionTemplate> publicaciones =
	            obtenerOperacionesPaginadas(request, pagina, cantidadPorPagina, repositorioOperaciones);
	    modelo.put("publicaicones", publicaciones);
	    
	   
        List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getTipo().equals("Perdida")).collect(Collectors.toList());
        List<PublicacionTemplateDTO> publicacionTemplateDTOs = new ArrayList<>();
		for (int i =0; i<result.size(); i++){
			PublicacionTemplate p = result.get(i);
			PublicacionTemplateDTO pd = new PublicacionTemplateDTO(p.getIdPublicacion(), p.getAsociacion(), p.getMascota(), p.getAutor(), p.getInteres(), p.getAsociacion().getAsociacionnId(), p.getEstado(), ControllerUtils.obtenerUsername(request), p.getTipo());
			publicacionTemplateDTOs.add(pd);
		}
		

		modelo.put("publicaciones", publicacionTemplateDTOs);
	
}

public static void agregarOperacionesPaginadasInteres( final Request request,
	        final RepositorioPublicacion repositorioOperaciones,
	        final Map<String, Object> modelo,
	        final String modelKeyOperaciones) {
	    final String paginaString = request.queryParams("pagina");
	    final int pagina = paginaString != null
	            ? Integer.parseInt(paginaString)
	            : 1;
	    final String cantidadPorPaginaString = request.queryParams("cantidadPorPagina");
	    final int cantidadPorPagina = cantidadPorPaginaString != null
	            ? Integer.parseInt(cantidadPorPaginaString)
	            : 4;
	    modelo.put("paginaAnterior", pagina - 1);
	    modelo.put("paginaSiguiente", pagina + 1);
	    final long ultimaPagina = (repositorioOperaciones
	            .cantidadPorCondicion("idPublicacion") /
	            cantidadPorPagina + 1);
	    final boolean esultimaPagina = pagina == ultimaPagina;
	    modelo.put("esUltimaPagina", esultimaPagina);
	    final List<PublicacionTemplate> publicaciones =
	            obtenerOperacionesPaginadas(request, pagina, cantidadPorPagina, repositorioOperaciones);
	    modelo.put("publicaicones", publicaciones);
	    
	   
	
        List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getTipo().equals("Interes")).collect(Collectors.toList());
        
        List<PublicacionTemplateDTO> publicacionTemplateDTOs = new ArrayList<>();
		for (int i =0; i<result.size(); i++){
			PublicacionTemplate p = result.get(i);
			PublicacionTemplateDTO pd = new PublicacionTemplateDTO(p.getIdPublicacion(), p.getAsociacion(), p.getMascota(), p.getAutor(), p.getInteres(), p.getAsociacion().getAsociacionnId(), p.getEstado(), ControllerUtils.obtenerUsername(request), p.getTipo());
			publicacionTemplateDTOs.add(pd);
		}
		
		modelo.put("publicaciones", publicacionTemplateDTOs);
	
	
}

public static void agregarOperacionesPaginadasPorAdopcion(final Request request,
        final RepositorioPublicacion repositorioOperaciones,
        final Map<String, Object> modelo,
        final String modelKeyOperaciones) {
    final String paginaString = request.queryParams("pagina");
    final int pagina = paginaString != null
            ? Integer.parseInt(paginaString)
            : 1;
    final String cantidadPorPaginaString = request.queryParams("cantidadPorPagina");
    final int cantidadPorPagina = cantidadPorPaginaString != null
            ? Integer.parseInt(cantidadPorPaginaString)
            : 4;
    modelo.put("paginaAnterior", pagina - 1);
    modelo.put("paginaSiguiente", pagina + 1);
    final long ultimaPagina = (repositorioOperaciones
            .cantidadPorCondicion("idPublicacion") /
            cantidadPorPagina + 1);
    final boolean esultimaPagina = pagina == ultimaPagina;
    modelo.put("esUltimaPagina", esultimaPagina);
    final List<PublicacionTemplate> publicaciones =
            obtenerOperacionesPaginadas(request, pagina, cantidadPorPagina, repositorioOperaciones);
    modelo.put("publicaicones", publicaciones);
    
   

   
    List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getTipo().equals("En Adopcion")).collect(Collectors.toList());
    List<PublicacionTemplateDTO> publicacionTemplateDTOs = new ArrayList<>();
	for (int i =0; i<result.size(); i++){
		PublicacionTemplate p = result.get(i);
		PublicacionTemplateDTO pd = new PublicacionTemplateDTO(p.getIdPublicacion(), p.getAsociacion(), p.getMascota(), p.getAutor(), p.getInteres(), p.getAsociacion().getAsociacionnId(), p.getEstado(), ControllerUtils.obtenerUsername(request), p.getTipo());
		publicacionTemplateDTOs.add(pd);
	}
	
	modelo.put("publicaciones", publicacionTemplateDTOs);

}

}
