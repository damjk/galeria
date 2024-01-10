package Domain.Controller;


import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Domain.Repositorio;
import Domain.Usuario.Usuario;
import Domain.Utilitario.Const;

public final class LoginController {

    public static Object verificarUsuario(final Request request, final Response response) {

        final String username = request.queryParams("username");
        final String password = request.queryParams("password");
     
        List<Usuario> usuarios =  Repositorio.Usuarios();
        
        List<Usuario> result = usuarios.stream().filter(a-> a.getUsuario().equals(username)).collect(Collectors.toList());
         
       
        if (result.size()>0) {
            request.session(true);
            request.session().attribute(Const.ID_USUARIO, result.get(0).getUsuario());
            response.redirect("/");
        } else {
            response.redirect("/errorInicioSesion");
        }
        return null;
    }

    public static ModelAndView errorInicioSesion(final Request req, final Response res) {
        return new ModelAndView(null, "errorInicioSesion.hbs");
    }

    public static ModelAndView logout(Request req, Response res) {
        req.session(false);
        req.session().attribute(Const.ID_USUARIO, null);
        res.redirect("/");
        return null;
    }

    private LoginController() {
    }
}
