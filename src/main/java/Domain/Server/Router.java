package Domain.Server;
import Domain.Controller.*;
import javax.persistence.EntityManagerFactory;

import static spark.Spark.*;

public final class Router {

    private static final CustomHandlebarsTemplateEngine CUSTOM_HANDLEBARS_TEMPLATE_ENGINE =
            new CustomHandlebarsTemplateEngine();
    

	static EntityManagerFactory entityManagerFactory;

    public static void configureRoutes() {

    	//before(Authentication::autenticar);
        //AUTENTICACION
        post("/login", LoginController::verificarUsuario);
        get("/errorInicioSesion", LoginController::errorInicioSesion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
        get("/logout", LoginController::logout, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);

        //HOME
        get("/", HomeController::home, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
        
        //APIRecomendacion/sugerencias
         get("/api/sugerencias",RecomendacionController::sugerencias);
         
         //DOCUMENTACION API
         get("/api", ApiController::documentacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         
         //Publicacion
         get("/publicaciones", PublicacionController::listarPublicaciones, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/detalle/:idPublicacion", PublicacionController::detallePublicacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/detalle/", PublicacionController::detallePublicacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/detalle/mascota/:idMascota", PublicacionController::detallePublicacionMascota, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/nuevo", PublicacionController::crearNuevo, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/interes", PublicacionController::crearInteresPublicacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);

         get("/mascota/:idMascota", MascotaController::detallePublicacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         
         get("/publicaciones/perdidas",PublicacionController::listarPublicacionesPerdidas, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/intereses", PublicacionController::listarPublicacionesIntereses, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/publicaciones/adopcion", PublicacionController::listarPublicacionesAdopcion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         
         post("/guardarpublicacion/:idPublicacion", PublicacionController::guardarPublicacion);
         post("/guardarpublicacion/", PublicacionController::guardarPublicacion);

         post("/guardarpublicacion/interes/:idPublicacion", PublicacionController::guardarPublicacionInteres);
         post("/guardarpublicacion/interes/", PublicacionController::guardarPublicacionInteres);

         delete("/eliminarpublicacion/:idPublicacion", PublicacionController::eliminarPublicacion);
         get("/publicaciones/editar/:idPublicacion", PublicacionController::editarPublicacion, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         
         //Contacto
         post("/contactar", PublicacionController::contactar, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         post("/contactar/:idPublicacion", PublicacionController::contactar, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
    
         
       //finalizar
         post("/finalizar", PublicacionController::finalizar);
         post("/finalizar/:idPublicacion", PublicacionController::finalizar);
         
       //CBU
        
         get("/ABMCBUAPI/modificar", ABMCBUAPI::abm1, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         post("/ABMCBUAPI/alta", ABMCBUAPI::altaCBU);
         put("/ABMCBUAPI", ABMCBUAPI::altaCBU);
         post("/ABMCBUAPI/modificar", ABMCBUAPI::modificarCBU);
         get("/ABMCBUAPI", ABMCBUAPI::abm, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/ABMCBUAPI/alta", ABMCBUAPI::abmAlta, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/ABMCBUAPI", ABMCBUAPI::abm, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/ABMCBUAPI/baja", ABMCBUAPI::abm2, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         post("/ABMCBUAPI/baja", ABMCBUAPI::bajaCBU);
         
         //GALLERY
         get("/mortalkombat", Galeria::Mortalkombat, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/godofwar", Galeria::Godofwar, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/playstation", Galeria::Playstation, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/ps3", Galeria::Ps3, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/ps4", Galeria::Ps4, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         get("/accesorios", Galeria::Accesorios, CUSTOM_HANDLEBARS_TEMPLATE_ENGINE);
         
         
    }

    private Router() {
    }

}