package Domain.Validacion;

public class ValidacionLongitudMinima implements Validacion{

    @Override
    public boolean validar(String contrasenia) {
//        if (contrasenia.length() < 8 ){
//            throw new ValidacionContraseniaException("La clave debe contenerar mas de 8 caracteres");
//        }
        return contrasenia.length() >= 8;
    }

}
