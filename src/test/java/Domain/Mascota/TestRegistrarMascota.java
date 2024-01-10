package Domain.Mascota;

import Domain.Contacto.Contacto;
import Domain.Repositorio;
import Domain.Usuario.Persona;
import Domain.Usuario.TipoDocumento;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestRegistrarMascota {

    @Test
    public void registrarMascotaConDuenio() throws IOException {
        Persona persona = Repositorio.getPersona();
        Set<Foto> fotos = new HashSet<>();
        Mascota mascota = Mascota.registrarMascotaConDuenio( persona, "Dolca", "Negrita", 2, Sexo.FEMENINO, Especie.PERRO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), Repositorio.getAsociacion() );

        Assert.assertEquals("Alejandro", mascota.getDuenio().getNombre());
    }

    @Test
    public void registrarMascotaPerdida() throws IOException {
        Set<Foto> fotos = new HashSet<>();
        Mascota mascota = Mascota.registrarMascotaPerdida("Dolca", "Negrita", 2, Sexo.FEMENINO, Especie.PERRO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), Repositorio.getAsociacion() );

        Assert.assertEquals("Dolca", mascota.getNombre());
    }

}
