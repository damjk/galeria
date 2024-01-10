package Domain.Validacion;

public class ValidacionDeCaracteresRepetidos implements Validacion {

    /**
     * Valida que la contraseia no tenga mas de dos caracteres repetidos
     * @param contrasenia
     */
    @Override
    public boolean validar(String contrasenia) {
        char charAnterior = ' ';
        char charActual;

        for(int i=0; i<contrasenia.length(); i++){
            charActual=contrasenia.charAt(i);

            if(charActual==charAnterior){
//               throw new ValidacionContraseniaException("La clave "+contrasenia+" tiene caracteres repetidos");
                 return false;
            }

            charAnterior=charActual;
        }

        return true;
    }
}
