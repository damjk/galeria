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





public class ABMCBUAPI {

    public static ModelAndView abm(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "abmCBU.hbs");
    }
    
    public static ModelAndView abmAlta(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "altaCBU.hbs");
    }
    
    public static ModelAndView abm1(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "modificarCBU.hbs");
    }
    
    public static ModelAndView abm2(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "bajaCBU.hbs");
    }
   
    
    
    
    

    public static Object altaCBU(final Request request, final Response response) throws IOException {

        final String nroDoc = request.queryParams("nrodoc");
        final String banco = request.queryParams("banco");       
        final String cbu = request.queryParams("cbu");
        final String NroCuenta = request.queryParams("nrocuenta");
        final String TipoCuenta = request.queryParams("TipoCuenta");
        final String Currency = request.queryParams("Currency");
        final String CUIT = request.queryParams("CUIT");
        final String Nombre = request.queryParams("Nombre");
        final String permiteTransf = request.queryParams("permiteTransf");
        final String PermiteDepositEnEfectivo = request.queryParams("PermiteDepositEnEfectivo");
        final String PermiteDepositoEnCheque = request.queryParams("PermiteDepositoEnCheque");
        
        
        		CBU objectCBU = new CBU();
        		objectCBU.setDocument_type("DNI");
        		objectCBU.setDocument_number(nroDoc);
        		objectCBU.setDebit_bank_id(banco);
        		objectCBU.setCbu(cbu);
        		objectCBU.setAccount_number(NroCuenta);
        		objectCBU.setAccount_type(TipoCuenta);
        		objectCBU.setCurrency(Currency);
        		objectCBU.setHolder_cuit(CUIT);
        		objectCBU.setSecond_holder_cuit("");
        		objectCBU.setThird_holder_cuit("");
        		objectCBU.setDenomination(Nombre);
        		objectCBU.setAllow_receive_transfers(permiteTransf);
        		objectCBU.setAllow_cash_deposits(PermiteDepositEnEfectivo);
        		objectCBU.setAllow_check_deposits(PermiteDepositoEnCheque);
        		objectCBU.setLast_transfers_date("");
        		
        		JsonObject body1 = new JsonObject();
            	body1.addProperty("document_type","DNI");
            	body1.addProperty("document_number",nroDoc);
            	body1.addProperty("debit_bank_id",banco);
            	body1.addProperty("cbu",cbu);
            	body1.addProperty("account_number",NroCuenta);
            	body1.addProperty("account_type",TipoCuenta);
            	body1.addProperty("currency",Currency);
            	body1.addProperty("holder_cuit",CUIT);
            	body1.addProperty("second_holder_cuit","");
            	body1.addProperty("third_holder_cuit","");
            	body1.addProperty("denomination",Nombre);
            	body1.addProperty("allow_cash_deposits",permiteTransf);
            	body1.addProperty("allow_check_deposits",PermiteDepositEnEfectivo);
            	body1.addProperty("allow_receive_transfers",PermiteDepositoEnCheque);
            	body1.addProperty("last_transfers_date","");
        		
        		abmCBU CBUAPI = abmCBU.instancia();
        		 retrofit2.Response<CBU> listado = CBUAPI.altaCBUv2(body1);
        		int estadoAPI = CBUAPI.getLastResponseCode();
       
        		int status = 200;
       
        if (estadoAPI == status) {
        	return new Gson().toJson(listado.body());
            
            
        } else {
        	return new Gson().toJson(listado.errorBody().string());
        }
       
    }
    
    
    public static Object bajaCBU(final Request request, final Response response) throws IOException {

        final String nroDoc = request.queryParams("nrodoc");
        final String banco = request.queryParams("banco");       
        final String cbu = request.queryParams("cbu");
        final String NroCuenta = request.queryParams("nrocuenta");
       
        
        
        		CBU objectCBU = new CBU();
        		objectCBU.setDocument_type("DNI");
        		objectCBU.setDocument_number(nroDoc);
        		objectCBU.setDebit_bank_id(banco);
        		objectCBU.setCbu(cbu);
        		objectCBU.setAccount_number(NroCuenta);
        		
        		
        		JsonObject body1 = new JsonObject();
            	body1.addProperty("document_type","DNI");
            	body1.addProperty("document_number",nroDoc);
            	body1.addProperty("debit_bank_id",banco);
            	body1.addProperty("cbu",cbu);
            	body1.addProperty("account_number",NroCuenta);
            	
        		
        		abmCBU CBUAPI = abmCBU.instancia();
        		 retrofit2.Response<CBU> listado = CBUAPI.bajaCBUv2(body1);
        		int estadoAPI = CBUAPI.getLastResponseCode();
       
        		int status = 200;
       
        if (estadoAPI == status) {
        	return new Gson().toJson(listado.body());
            
            
        } else {
        	return new Gson().toJson(listado.errorBody().string());
        }
       
    }
    
    public static Object modificarCBU(final Request request, final Response response) throws IOException {

        final String nroDoc = request.queryParams("nrodoc");
        final String banco = request.queryParams("banco");
        final String cbu = request.queryParams("cbu");
        final String NroCuenta = request.queryParams("nrocuenta");
        final String TipoCuenta = request.queryParams("TipoCuenta");
        final String Currency = request.queryParams("Currency");
        final String CUIT = request.queryParams("CUIT");
        final String Nombre = request.queryParams("Nombre");
        final String permiteTransf = request.queryParams("permiteTransf");
        final String PermiteDepositEnEfectivo = request.queryParams("PermiteDepositEnEfectivo");
        final String PermiteDepositoEnCheque = request.queryParams("PermiteDepositoEnCheque");
        
        
        		CBU objectCBU = new CBU();
        		objectCBU.setDocument_type("DNI");
        		objectCBU.setDocument_number(nroDoc);
        		objectCBU.setDebit_bank_id(banco);
        		objectCBU.setCbu(cbu);
        		objectCBU.setAccount_number(NroCuenta);
        		objectCBU.setAccount_type(TipoCuenta);
        		objectCBU.setCurrency(Currency);
        		objectCBU.setHolder_cuit(CUIT);
        		objectCBU.setSecond_holder_cuit("");
        		objectCBU.setThird_holder_cuit("");
        		objectCBU.setDenomination(Nombre);
        		objectCBU.setAllow_receive_transfers(permiteTransf);
        		objectCBU.setAllow_cash_deposits(PermiteDepositEnEfectivo);
        		objectCBU.setAllow_check_deposits(PermiteDepositoEnCheque);
        		objectCBU.setLast_transfers_date("");
        		
        		JsonObject body1 = new JsonObject();
            	body1.addProperty("document_type","DNI");
            	body1.addProperty("document_number",nroDoc);
            	body1.addProperty("debit_bank_id",banco);
            	body1.addProperty("cbu",cbu);
            	body1.addProperty("account_number",NroCuenta);
            	body1.addProperty("account_type",TipoCuenta);
            	body1.addProperty("currency",Currency);
            	body1.addProperty("holder_cuit",CUIT);
            	body1.addProperty("second_holder_cuit","");
            	body1.addProperty("third_holder_cuit","");
            	body1.addProperty("denomination",Nombre);
            	body1.addProperty("allow_cash_deposits",permiteTransf);
            	body1.addProperty("allow_check_deposits",PermiteDepositEnEfectivo);
            	body1.addProperty("allow_receive_transfers",PermiteDepositoEnCheque);
            	body1.addProperty("last_transfers_date","");
        		
        		abmCBU CBUAPI = abmCBU.instancia();
        		 retrofit2.Response<CBU> listado = CBUAPI.modificarCBU(body1);
        		int estadoAPI = CBUAPI.getLastResponseCode();
       
        		int status = 200;
       
        if (estadoAPI == status) {
        	return new Gson().toJson("Modificaicon Exitosa");
            
            
        } else {
        	return new Gson().toJson(listado.errorBody().string());
        }
       
    }

}
