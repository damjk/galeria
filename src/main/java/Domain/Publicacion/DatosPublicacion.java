package Domain.Publicacion;

import Domain.Mascota.Foto;

import java.util.HashSet;
import java.util.Set;

public class DatosPublicacion {
    private String titulo;
    private String descripcion;
    private Set<Foto> fotos = new HashSet<>();

    public DatosPublicacion( String titulo, String descripcion, Set<Foto> fotos )
    {
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setFotos(fotos);
    }

    public DatosPublicacion( String titulo, String descripcion )
    {
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(Set<Foto> fotos) {
        this.fotos = fotos;
    }
}
