package Domain.Publicacion;

import Domain.Repositorio;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestPublicacionMascotaEnAdopcion {
    /*
    @Test
    public void publicacionMascotaEnAdopcion() throws IOException {
        PublicacionMascotaEnAdopcion publicacionMascotaEnAdopcion = Repositorio.getPublicacionMascotaEnAdopcion();
        Assert.assertEquals("Alejandro", publicacionMascotaEnAdopcion.getAutor().getNombre());
    }

     */

    @Test
    public void mostrarPublicacionMascotaEnAdopcion() throws IOException {
        PublicacionMascotaEnAdopcion publicacionMascotaEnAdopcion = Repositorio.getPublicacionMascotaEnAdopcion();
        Assert.assertEquals("Doy en adopcion a Dolca", publicacionMascotaEnAdopcion.mostrar().getTitulo());
    }
}
