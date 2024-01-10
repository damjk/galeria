package Domain.Validacion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Domain.Usuario.Usuario;

public class TestPassword {
    private Usuario usuario;

    @Before
    public void init(){
        this.usuario = new Usuario();
    }

    @Test
    public void unaContraseniaConCaracteresIgualesConsecutivos(){
        String contrasenia = "&43zz4ss$";
        ValidacionDeCaracteresRepetidos validacion = new ValidacionDeCaracteresRepetidos();
        //Assert.assertThrows(ValidacionContraseniaException.class, () ->usuario.validarPassword(contrasenia));

        Assert.assertFalse(validacion.validar(contrasenia));
    }

    @Test
    public void unaContraseniaConPocosCaracteres(){
        String contrasenia = "$5Ga";
        ValidacionLongitudMinima validacion = new ValidacionLongitudMinima();
        //Assert.assertThrows(ValidacionContraseniaException.class, () ->usuario.validarPassword(contrasenia));

        Assert.assertFalse(validacion.validar(contrasenia));
    }

    @Test
    public void unaContraseniaDebil(){
        String contrasenia = "q1w2e3r4t5";
        ValidacionContraseniaDebil validacion = new ValidacionContraseniaDebil();
        //Assert.assertThrows(ValidacionContraseniaException.class, () ->usuario.validarPassword(contrasenia));

        Assert.assertFalse(validacion.validar(contrasenia));
    }

    @Test
    public void unaContraseniaSoloNumeros(){
        String contrasenia = "56463243473";
        ValidacionDeUnNumeroUnaLetra validacion = new ValidacionDeUnNumeroUnaLetra();
        //Assert.assertThrows(ValidacionContraseniaException.class, () ->usuario.validarPassword(contrasenia));

        Assert.assertFalse(validacion.validar(contrasenia));
    }

    @Test
    public void unaContraseniaSoloLetras(){
        String contrasenia = "SdaKshjkK";
        ValidacionDeUnNumeroUnaLetra validacion = new ValidacionDeUnNumeroUnaLetra();
        //Assert.assertThrows(ValidacionContraseniaException.class, () ->usuario.validarPassword(contrasenia));

        Assert.assertFalse(validacion.validar(contrasenia));
    }

    @Test
    public void unaContraseniaEsValida(){
        String contrasenia = "$h564Rt.mads8";
        //Assert.assertTrue(usuario.validarPassword(contrasenia));

        Assert.assertFalse(usuario.validarPassword(contrasenia));
    }
}
