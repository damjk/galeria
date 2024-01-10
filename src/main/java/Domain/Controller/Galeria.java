package Domain.Controller;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import APIs.EmailAPI.abmCBU;
import APIs.Entidades.CBU;
import Domain.Repositorio;
import Domain.Usuario.Usuario;
import Domain.Utilitario.Const;





public class Galeria {


    
    public static ModelAndView Mortalkombat(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Godofwar(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Playstation(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "Playstation.hbs");
    }
    
    public static ModelAndView Ps3(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Ps4(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Accesorios(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }

}
