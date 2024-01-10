package Domain.Excepcion;

public class ValidacionContraseniaException extends  RuntimeException {

    public ValidacionContraseniaException() {
        super();
    }

    public ValidacionContraseniaException(String message) {
        super(message);
    }
}
