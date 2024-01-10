package Domain.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Domain.Repositorio;
import Domain.Asociacion.Asociacion;
import Domain.Mascota.Mascota;

import Domain.Publicacion.PublicacionTemplate;
import Domain.Utilitario.Const;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MascotaController {
	
	
	 public static ModelAndView detallePublicacion(final Request request, final Response response) {
			return formularioPublicacionConDatos(request, "cargarPublicacionQR.hbs");
		}
	
	 private static ModelAndView formularioPublicacionConDatos(final Request request, final String nombreTemplate) {
			final Map<String, Object> model = new HashMap<>();
			final Asociacion asociacion = ControllerUtils.obtenerAsosiacion(request);
			List<PublicacionTemplate> publicaciones = Repositorio.getPublicaciones();
			List<Mascota> mascotas = new ArrayList<>();
			final Integer idMascota = Integer.valueOf((request.params("idMascota")));
			 for (int i=0; i < publicaciones.size();i++) {
				 
				 mascotas.add(publicaciones.get(i).getMascota());
			 }
		
			List<Mascota> result = mascotas.stream().filter(a-> a.getIdMascota().equals(idMascota)).collect(Collectors.toList());
			Mascota mascota = result.get(0);
			model.put(ControllerUtils.MODEL_KEY_USERNAME, request.session().attribute(Const.ID_USUARIO));
			//model.put("publicacion", publicacion);
			//model.put("autor", publicacion.getAutor());
			
			model.put("especie", ControllerUtils.obtenerEspecie());
			model.put("sexo", ControllerUtils.obtenerSexo());
			model.put("mascota", mascota);
			model.put("estado", ControllerUtils.obtenerEstadoMascota());
			model.put("caracteristica", asociacion.getConfiguracionAsociacion().getCaracteristicas());
			model.put("caracteristicasMascota", mascota.getCaracteristicas());
			model.put("CaracteristicasLength", mascota.getCaracteristicas().size());
			return new ModelAndView(model, nombreTemplate);
		    }

}