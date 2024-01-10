package Domain.Utilitario;

import java.util.regex.Pattern;

/**
 * Coleccion de funciones útiles
 */
public class Utilitario {

    /**
     * Valida si se aplica la expresionRegular en la palabra
     * @param palabra
     * @param expresionRegular
     * @return
     */
    public boolean validarEr(String palabra, String expresionRegular){

        return Pattern.matches(expresionRegular, palabra);
        /*
        Pattern pattern = compile(expresionRegular);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
*/
    }
    
}