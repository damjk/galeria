package Domain.Controller;
import java.util.HashMap;
import java.util.Map;
import Domain.Utilitario.Const;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public final class ApiController {

    public static ModelAndView documentacion(final Request req, final Response res) {
    	final Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "apiDocumentacion.hbs");
    }

    private ApiController() {
    }
}
