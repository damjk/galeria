package Domain.DTOs;

import Domain.Asociacion.Asociacion;
import Domain.Mascota.Mascota;
import Domain.Publicacion.EstadoPublicacion;
import Domain.Usuario.Usuario;

public class PublicacionTemplateDTO {
    private Integer idPublicacion ;
    private Asociacion asociacion;
    private Integer asociacionId;
    private Mascota mascota;
    private Usuario autor;
    private Boolean interes = true;
    EstadoPublicacion estado = EstadoPublicacion.PENDIENTE;
    private Boolean esDelUser = false;
    private String tipo;

    public PublicacionTemplateDTO(Integer id , Asociacion asociacion, Mascota mascota, Usuario autor, Boolean interes, Integer asociacionId, EstadoPublicacion estado, String loggedUser, String tipo)
    {
        this.idPublicacion = id ;
        this.asociacion = asociacion;
        this.asociacionId = asociacionId;
        this.mascota = mascota;
        this.autor = autor;
        this.interes = interes;
        this.estado = estado;
        this.setEsDelUser(loggedUser);
        this.tipo = tipo;
    }

    public void setEsDelUser (String loggedUser){
        this.esDelUser = loggedUser.equals(autor.getUsuario());
    }

    public Boolean getEsDelUser(){
        return esDelUser;
    }
    public Integer getIdPublicacion(){
        return idPublicacion;
    }

    public Asociacion getAsociacion(){
        return asociacion;
    }

    public Integer getAsociacionId(){
        return asociacionId;
    }

    public Mascota getMascota(){
        return mascota;
    }

    public Usuario getAutor(){
        return autor;
    }

    public EstadoPublicacion getEstado(){
        return estado;
    }

    public Boolean getInteres(){
        return interes;
    }

    public String getTipo(){
        return tipo;
    }
}
