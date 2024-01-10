package Domain.Validacion;


import Domain.Utilitario.Utilitario;

public class ValidacionDeUnNumeroUnaLetra implements Validacion {

    /**
     * Valida que la constrasenia tenga al menos undigito y una clave
     * @param contrasenia
     */
    @Override
    public boolean validar(String contrasenia) {
        Utilitario utils = new Utilitario();

//        if( !utils.validarEr(contrasenia,"^.(?=.[0-9])(?=.[a-zA-Z])([a-zA-Z0-9]+).$") ){
//            throw new ValidacionContraseniaException("La clave "+contrasenia+" debe tener al menos un número y una letra");
//        }

        return utils.validarEr(contrasenia,"^.(?=.[0-9])(?=.[a-zA-Z])([a-zA-Z0-9]+).$");
    }
}
