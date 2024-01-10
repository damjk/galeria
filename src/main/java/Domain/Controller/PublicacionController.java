package Domain.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import static spark.Spark.*;
import javax.servlet.http.HttpServletResponse;
import Domain.DTOs.PublicacionTemplateDTO;
import Domain.Publicacion.*;
import Domain.Server.Authentication;
import Domain.Utilitario.Const;
import Domain.Repositorio;
import Domain.RepositorioPublicacion;
import Domain.Asociacion.Asociacion;
import Domain.Caracteristica.Caracteristica;
import Domain.Mascota.Especie;
import Domain.Mascota.EstadoMascota;
import Domain.Mascota.Mascota;
import Domain.Mascota.Sexo;
import Domain.Usuario.Persona;
import Domain.Usuario.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class PublicacionController {
	private static  Integer id = 0;
	
	public static ModelAndView listarPublicaciones(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);
        
        /*
        ControllerUtils.agregarOperacionesPaginadasCategorizadas(
                request, REPOSITORIO_EGRESOS, model, MODEL_KEY_EGRESOS
        );
        */
        
        //Repositorio.PublicacionesMascotaPerdidas();

        //model.put("publicaciones", Repositorio.getPublicaciones());

        List<Usuario> usuarios =  Repositorio.Usuarios();
        Usuario user = usuarios.stream().filter(a-> a.getUsuario().equals(ControllerUtils.obtenerUsername(request))).collect(Collectors.toList()).get(0);
        model.put("usuario", user);
        
       
  
        
        List<PublicacionTemplateDTO> ptd = ControllerUtils.agregarOperacionesPaginadasCategorizadas(
        request, new RepositorioPublicacion(), model, "publicaciones"
        );
        
        
        
        return new ModelAndView(model, "publicaciones.hbs");
    }
	
	
	public static ModelAndView listarPublicacionesPerdidas(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);

        /*
        ControllerUtils.agregarOperacionesPaginadasCategorizadas(
                request, REPOSITORIO_EGRESOS, model, MODEL_KEY_EGRESOS
        );
        */
        
        //Repositorio.PublicacionesMascotaPerdidas();

        //model.put("publicaciones", Repositorio.getPublicaciones());

        List<Usuario> usuarios =  Repositorio.Usuarios();
        Usuario user = usuarios.stream().filter(a-> a.getUsuario().equals(ControllerUtils.obtenerUsername(request))).collect(Collectors.toList()).get(0);
        model.put("usuario", user);
        
        ControllerUtils.agregarOperacionesPaginadasPerdidas(
                request, new RepositorioPublicacion(), model, "publicaciones"
        );

       

        return new ModelAndView(model, "publicaciones.hbs");
    }
	
	public static ModelAndView listarPublicacionesIntereses(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);

        /*
        ControllerUtils.agregarOperacionesPaginadasCategorizadas(
                request, REPOSITORIO_EGRESOS, model, MODEL_KEY_EGRESOS
        );
        */
        
        //Repositorio.PublicacionesMascotaPerdidas();

        //model.put("publicaciones", Repositorio.getPublicaciones());

        List<Usuario> usuarios =  Repositorio.Usuarios();
        Usuario user = usuarios.stream().filter(a-> a.getUsuario().equals(ControllerUtils.obtenerUsername(request))).collect(Collectors.toList()).get(0);
        model.put("usuario", user);
        
        ControllerUtils.agregarOperacionesPaginadasInteres(
                request, new RepositorioPublicacion(), model, "publicaciones"
        );

       


        return new ModelAndView(model, "publicaciones.hbs");
    }
	
	public static ModelAndView listarPublicacionesAdopcion(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);

        List<Usuario> usuarios =  Repositorio.Usuarios();
        Usuario user = usuarios.stream().filter(a-> a.getUsuario().equals(ControllerUtils.obtenerUsername(request))).collect(Collectors.toList()).get(0);
        model.put("usuario", user);

        ControllerUtils.agregarOperacionesPaginadasPorAdopcion(
                request, new RepositorioPublicacion(), model, "publicaciones"
        );
        
      


        return new ModelAndView(model, "publicaciones.hbs");
    }
	
	
	
	public static ModelAndView contactar(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);
        final Integer idPublicacion = Integer.valueOf((request.params("idPublicacion")));
        List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
        List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getIdPublicacion().equals(idPublicacion)).collect(Collectors.toList());
        PublicacionTemplate publicacion = result.get(0);	
        publicacion.aprobarPublicacion();
        /*
        ControllerUtils.agregarOperacionesPaginadasCategorizadas(
                request, REPOSITORIO_EGRESOS, model, MODEL_KEY_EGRESOS
        );
        */
        //Repositorio.PublicacionesMascotaPerdidas();
        model.put("publicaciones", Repositorio.getPublicaciones());
        model.put("usuario", publicacion.getAutor());
        model.put("contactos", publicacion.getAutor().getPersona().getContactos());
        return new ModelAndView(model, "detalleContacto.hbs");
    }
	
	public static ModelAndView finalizar(final Request request, final Response response) {
        final Map<String, Object> model = ControllerUtils.modeloConSesion(request);
        final Integer idPublicacion = Integer.valueOf((request.params("idPublicacion")));
        List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
        List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getIdPublicacion().equals(idPublicacion)).collect(Collectors.toList());
        PublicacionTemplate publicacion = result.get(0);	
        
        publicacion.getMascota().setDuenio(obtenerUsuario(request));
        publicacion.getMascota().setEstado(EstadoMascota.CONDUENIO);
        publicacion.finalizarPublicacion();
        /*
        ControllerUtils.agregarOperacionesPaginadasCategorizadas(
                request, REPOSITORIO_EGRESOS, model, MODEL_KEY_EGRESOS
        );
        */
        //Repositorio.PublicacionesMascotaPerdidas();
        response.redirect("/publicaciones");
        return null;
    }
	
	
	 public static ModelAndView detallePublicacion(final Request request, final Response response) {
		return formularioPublicacionConDatos(request, "detallePublicacion.hbs");
	}
	 public static ModelAndView detallePublicacionMascota(final Request request, final Response response) {
		    before(Authentication::autenticar);
			return formularioPublicacionConDatosMascota(request, "detallePublicacion.hbs");
		}
	 
	 public static ModelAndView editarPublicacion(final Request request, final Response response) {
		 
		return formularioPublicacionConDatos1(request, "editarPublicacion.hbs");
	}

	 
	 private static ModelAndView formularioPublicacionConDatosMascota(final Request request, final String nombreTemplate) {
			final Map<String, Object> model = new HashMap<>();
			final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
			
			List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();


			 if( request.params("idMascota")!=null) {
			     	List<PublicacionTemplate> result1 = 
			     			publicaciones.stream().filter(a-> a.getMascota().getIdMascota() == Long.valueOf(request.params("idMascota"))).collect(Collectors.toList());
			     	if(result1.isEmpty()) {
			     		
			     		return new ModelAndView(model, "errorMascotaEncontrada.hbs");
						
			     	}
			     	PublicacionTemplate publicacionMascotaEncontrada = result1.get(0);
			     	
			 		model.put(ControllerUtils.MODEL_KEY_USERNAME, request.session().attribute(Const.ID_USUARIO));
			 		model.put("publicacion", publicacionMascotaEncontrada);
			 		model.put("autor", publicacionMascotaEncontrada.getAutor());
			 		model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
			 		model.put("caracteristicasMascota", publicacionMascotaEncontrada.getMascota().getCaracteristicas());
			 		model.put("CaracteristicasLength", publicacionMascotaEncontrada.getMascota().getCaracteristicas().size());
			 		model.put("estado", ControllerUtils.obtenerEstadoMascota());	
			 		model.put("especie", ControllerUtils.obtenerEspecie());
			 		model.put("sexo", ControllerUtils.obtenerSexo());
			     	return new ModelAndView(model, nombreTemplate);
			     }
			
			
			
			return new ModelAndView(model, nombreTemplate);
			
		    }
	 
	
	 
	 private static ModelAndView formularioPublicacionConDatos(final Request request, final String nombreTemplate) {
		final Map<String, Object> model = new HashMap<>();
		final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
		
		final Integer idPublicacion = Integer.valueOf((request.params("idPublicacion")));
		List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
		List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getIdPublicacion().equals(idPublicacion)).collect(Collectors.toList());
		PublicacionTemplate publicacion = result.get(0);
		model.put(ControllerUtils.MODEL_KEY_USERNAME, request.session().attribute(Const.ID_USUARIO));
		model.put("publicacion", publicacion);
		model.put("autor", publicacion.getAutor());
		model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
		model.put("caracteristicasMascota", publicacion.getMascota().getCaracteristicas());
		model.put("CaracteristicasLength", publicacion.getMascota().getCaracteristicas().size());
		model.put("estado", ControllerUtils.obtenerEstadoMascota());	
		model.put("especie", ControllerUtils.obtenerEspecie());
		model.put("sexo", ControllerUtils.obtenerSexo());
		
		String username = ControllerUtils.obtenerUsername(request);
		
		
		
		return new ModelAndView(model, nombreTemplate);
		
	    }
	 
	 private static ModelAndView formularioPublicacionConDatos1(final Request request, final String nombreTemplate) {
			final Map<String, Object> model = new HashMap<>();
			final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
			final Integer idPublicacion = Integer.valueOf((request.params("idPublicacion")));
			List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
			List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getIdPublicacion().equals(idPublicacion)).collect(Collectors.toList());
			PublicacionTemplate publicacion = result.get(0);
			model.put(ControllerUtils.MODEL_KEY_USERNAME, request.session().attribute(Const.ID_USUARIO));
			model.put("publicacion", publicacion);
			model.put("autor", publicacion.getAutor());
			model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
			model.put("caracteristicasMascota", publicacion.getMascota().getCaracteristicas());
			model.put("CaracteristicasLength", publicacion.getMascota().getCaracteristicas().size());
			model.put("estado", ControllerUtils.obtenerEstadoMascota());	
			model.put("especie", ControllerUtils.obtenerEspecie());
			model.put("sexo", ControllerUtils.obtenerSexo());
			
			String username = ControllerUtils.obtenerUsername(request);
			 if(username.equals(publicacion.getAutor().getUsuario())) {
				 
				 return new ModelAndView(model, nombreTemplate);
			 }
			 final Map<String, Object> model1 = new HashMap<>();
			 return new ModelAndView(model1, "errorPermisos.hbs");
		    }

	 public static ModelAndView crearNuevo(final Request request, final Response response) {
		final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
		final Map<String, Object> model = ControllerUtils.modeloConSesion(request);
		model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
		//model.put("caracteristicasMascota", asociacion.getConfiguracionAsociacion().getCaracteristicas());
		model.put("especie", ControllerUtils.obtenerEspecie());
		model.put("sexo", ControllerUtils.obtenerSexo());
		model.put("estado", ControllerUtils.obtenerEstadoMascota());
		return new ModelAndView(model, "cargarPublicacion.hbs");
	}

	public static ModelAndView crearInteresPublicacion(final Request request, final Response response){
		final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
		final Map<String, Object> model = ControllerUtils.modeloConSesion(request);
		model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
		model.put("especie", ControllerUtils.obtenerEspecie());
		model.put("sexo", ControllerUtils.obtenerSexo());
		return new ModelAndView(model, "publicacionInteres.hbs");
	}

	 public static ModelAndView guardarPublicacion(final Request request, final Response response) {
	        final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
	        final PublicacionTemplate publicacion = construirPublicacion(request);	        
	        //agregarOActualizarpublicacion(publicacion,request);	   
	        Repositorio.guardar(publicacion);
	        //REPOSITORIO_ORGANIZACIONES.guardar(organizacion);	        			
	        response.redirect("/publicaciones");
	        // TODO: esto está bien? creo que debería retornar algo
	        return null;
	}

	public static ModelAndView guardarPublicacionInteres(final Request request, final Response response) {
		final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
		final PublicacionTemplate publicacion = construirPublicacionInteres(request);
		//agregarOActualizarpublicacion(publicacion,request);
		
		Repositorio.guardar(publicacion);
		response.redirect("/publicaciones");
		// TODO: esto está bien? creo que debería retornar algo
		return null;
	}

	 private static PublicacionTemplate construirPublicacion(Request request) {
		 final String idPublicacion = request.params("idPublicacion");
		 EstadoMascota estadoMascota = obtenerEstadoMascota(request);
		  Usuario usuario =  obtenerUsuario(request);
		  String mascotaNombre =  obtenerMascotaNombre(request);
		  Especie especie = obtenerEspecie(request);
		 Sexo sexo = obtenerSexo(request);
		 Set<String> caracteristicas = obtenerCaracteristicasV2(request);
		 Mascota mascota = new Mascota();

		 mascota.setNombre(mascotaNombre);
		 mascota.setEspecie(especie);
		 mascota.setEstado(estadoMascota);
		 mascota.setCaracteristicas(caracteristicas);
		 mascota.setSexo(sexo);
		// mascota.setAsociacion(ControllerUtils.obtenerAsosiacion(request));

		 final PublicacionTemplate publicacion;
		 if (Objects.nonNull(idPublicacion)) {
			 publicacion = obtenerpublicacion(request);
		 } else {
		 	int id = Repositorio.getPublicaciones().size() + 1;
			 if(estadoMascota.equals(EstadoMascota.PERDIDA)){
				 publicacion = new  PublicacionMascotaPerdida(
						 id,ControllerUtils.obtenerAsosiacion(request), mascota, usuario, null, null, "Perdida");
			 }else{
				 publicacion = new PublicacionMascotaEnAdopcion(
						 id,ControllerUtils.obtenerAsosiacion(request), mascota, usuario);
			 }
		 }
	        publicacion.setMascota(mascota);
	        publicacion.setAutor(usuario);
	        publicacion.setAsociacion(ControllerUtils.obtenerAsosiacion(request));
	        
		 return publicacion;
	}

	private static PublicacionTemplate construirPublicacionInteres(Request request) {
		final String idPublicacion = request.params("idPublicacion");
		Usuario usuario =  obtenerUsuario(request);
		Especie especie = obtenerEspecie(request);
		Sexo sexo = obtenerSexo(request);
		Set<String> caracteristicas = obtenerCaracteristicasV2(request);
		Mascota mascota = new Mascota();

		mascota.setEspecie(especie);
		mascota.setCaracteristicas(caracteristicas);
		mascota.setSexo(sexo);
		//mascota.setAsociacion(ControllerUtils.obtenerAsosiacion(request));


		final PublicacionTemplate publicacion;
		if (Objects.nonNull(idPublicacion)) {
			publicacion = obtenerpublicacion(request);
		} else {
			int id = Repositorio.getPublicaciones().size() +1;
			publicacion = new PublicacionSolicitarMascota(
					id,ControllerUtils.obtenerAsosiacion(request), mascota, usuario);

		}
		publicacion.setMascota(mascota);
		publicacion.setAutor(usuario);
		publicacion.setAsociacion(ControllerUtils.obtenerAsosiacion(request));
		publicacion.setInteres(false);

		return publicacion;
	}
	 /*
	 private static EstadoPublicacion obtenerEstadoPublicacion(Request request) {
		 final EstadoPublicacion estado = EstadoPublicacion.valueOf(request.queryParams("estadoPublicacion"));
			
			return estado;
	}
	*/

	private static EstadoMascota obtenerEstadoMascota(Request request) {
		 final EstadoMascota estado = EstadoMascota.valueOf(request.queryParams("estado"));
		 return estado;
	}


	private static PublicacionTemplate obtenerpublicacion(Request request) {
		Integer idPublicacion = Integer.valueOf(request.params("idPublicacion"));
		// TODO: excepción
		return Repositorio.getPublicaciones().stream()
				.filter(e -> e.getIdPublicacion().equals(idPublicacion))
				.findAny()
				.orElseThrow(RuntimeException::new);
	}

	


	private static Set<String> obtenerCaracteristicas(final Request request) {
		final Set<String> caracteristicas = new HashSet<>();
		request.queryMap().toMap().entrySet().stream()
				.filter(param -> param.getKey().startsWith("caracteristicas-"))
				.collect(Collectors.groupingBy(param -> param.getKey().split("-")[2]))
				.values().stream()
				.map(params -> params.stream()
						.collect(Collectors.toMap(param -> param.getKey().split("-")[1], param -> param.getValue()[0]))
				)
				.forEach((params) -> {
					final String caracteristica =
							params.get("nombre");

					caracteristicas.add(caracteristica);
				});
		return caracteristicas;
	}
	
	private static Set<String> obtenerCaracteristicasV2(final Request request) {
		final Set<String> caracteristicas = new HashSet<>();
		for(int i = 0 ; i<8 ;i++){ 
		String  caracteristica = request.queryParams("caracteristica-nombre-" + String.valueOf(i) );
		if(caracteristica == (null)) {
			break;
		}
		caracteristicas.add(caracteristica);
		}
		return caracteristicas;
	}


	private static Sexo obtenerSexo(Request request) {
		final Sexo sexo = Sexo.valueOf(request.queryParams("sexo"));
		return sexo;
	}


	private static Especie obtenerEspecie(Request request) {
		// TODO Auto-generated method stub
		final Especie especie = Especie.valueOf(request.queryParams("especie"));
		return especie;
	}


	private static String obtenerMascotaNombre(Request request) {
		// TODO Auto-generated method stub
		final String mascota = request.queryParams("mascotaNombre");
		return mascota;
	}


	private static PublicacionTemplate obtenerPublicacion(Request request) {
		final Integer idPublicacion = Integer.valueOf(request.params("id"));
		ControllerUtils.obtenerAsosiacion(request);
		// TODO: excepción
		return Asociacion.getPublicaciones().stream()
				.filter(e -> e.getIdPublicacion().equals(idPublicacion))
				.findAny()
				.orElseThrow(RuntimeException::new);
	}
	
	private static Usuario obtenerUsuario(final Request request) {
		final String nombreUsuario = ControllerUtils.obtenerUsername(request);
		List<Usuario> usuarios = Repositorio.Usuarios();

		List<Usuario> result = usuarios.stream().filter(a-> a.getUsuario().equals(nombreUsuario)).collect(Collectors.toList());
		Usuario usuario = result.get(0);

		return usuario;
	}
	 
	public static Object eliminarPublicacion(final Request request, final Response response) {
	   final Integer idPublicacion = Integer.valueOf(request.params("idPublicacion"));
	   final Asociacion asosiacion = ControllerUtils.obtenerAsosiacion(request);
	   String username = ControllerUtils.obtenerUsername(request);
	  
	   
	   List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
       List<PublicacionTemplate> result = publicaciones.stream().filter(a-> a.getIdPublicacion().equals(idPublicacion)).collect(Collectors.toList());
       PublicacionTemplate publicacion = result.get(0);	
       
       if(username.equals(publicacion.getAutor().getUsuario())) {
			 
    	   borrarPublicacion(publicacion);
   		//REPOSITORIO_ORGANIZACIONES.guardar(organizacion);
   		//REPOSITORIO_EGRESOS.borrarPorId(idEgreso);
   		response.status(HttpServletResponse.SC_ACCEPTED);
   		return "Publicacion eliminado correctamente";
		 }
		 final Map<String, Object> model1 = new HashMap<>();
		 return new ModelAndView(model1, "errorPermisos.hbs");
	    }
       
	 
	
	 
	 public static void agregarOActualizarpublicacion( PublicacionTemplate publicacion,Request request) {
		 List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
	       
		 if ( publicaciones.contains(publicacion)) {
			 
			 borrarPublicacion(publicacion);
		 }
		 agregarPublicacion(publicacion);
		 
	}
	 
	 public static void borrarPublicacion(PublicacionTemplate Publicacion) {
		 RepositorioPublicacion rep = new RepositorioPublicacion();
		rep.borrar(Publicacion);
	}
	 
	 public static void agregarPublicacion(PublicacionTemplate publicacion){
		 
		 Repositorio.guardar(publicacion);
	}
	 
	
	 
	 
	 
	  
	  
	  

}


	

