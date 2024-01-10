package Domain;

import Domain.Asociacion.Asociacion;
import Domain.Asociacion.Calidad;
import Domain.Asociacion.ConfiguracionAsociacion;
import Domain.Caracteristica.CaracteristicaMascota;
import Domain.Contacto.Contacto;
import Domain.Controller.ControllerUtils;
import Domain.Controller.PublicacionController;
import Domain.DTOs.PublicacionTemplateDTO;
import Domain.Direccion.Direccion;
import Domain.Mascota.Especie;
import Domain.Mascota.Foto;
import Domain.Mascota.Mascota;
import Domain.Mascota.Sexo;
import Domain.Publicacion.Publicacion;
import Domain.Publicacion.PublicacionMascotaEnAdopcion;
import Domain.Publicacion.PublicacionMascotaPerdida;
import Domain.Publicacion.PublicacionTemplate;
import Domain.Usuario.Persona;
import Domain.Usuario.TipoDocumento;
import Domain.Usuario.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.HashSet;

public class Repositorio<T> {

    public Set<Asociacion> asociaciones;
    public List<ConfiguracionAsociacion> configuraciones= new ArrayList<>();
    public static List<Usuario> usuarios =  new ArrayList<>();
    public static List<PublicacionTemplate>  publicaciones = new ArrayList<>();
    public static List<Mascota> mascotas = new ArrayList<>();

    public static final EntityManager ENTITY_MANAGER;
	
	
    private final Class<T> clase;
   
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String persistenceUnit = System.getenv("PERSISTENCE_UNIT");
        if (Objects.isNull(persistenceUnit)) {
            persistenceUnit = "prod";
        }
        ENTITY_MANAGER = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
    }
    
    protected Repositorio(final Class<T> clase) {
        this.clase = clase;
    }
    
    public static void guardar(PublicacionTemplate  publicacion) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.merge(publicacion);
            ENTITY_MANAGER.getTransaction().commit();
        } catch (Exception e) {
            ENTITY_MANAGER.getTransaction().rollback();
            throw new RuntimeException("Error al persistir: ", e);
        }
    }

    public static List<PublicacionTemplateDTO> publicacionTemplateDTOs = new ArrayList<>();

    
    public static  List<Usuario> Usuarios()
    {
        Usuario usuario = new Usuario();
        usuario.setUsuario("user");
        Usuario usuario2 = new Usuario();
        usuario2.setUsuario("user2");  
        usuario.setPersona(getPersona());
        usuario2.setPersona(getPersona2());
        usuario.setAsociacion(getAsociacion());
        usuario2.setAsociacion(getAsociacion1());
        usuarios.add(usuario);
        usuarios.add(usuario2);
		return usuarios;
    }
    
    public void setAsociaciones()
    {
        Direccion direccion1 = new Direccion();
        Direccion direccion2 = new Direccion();
        Direccion direccion3 = new Direccion();
        Asociacion patitas = new Asociacion(1,"Patitas",configuraciones.get(1),direccion1);
        Asociacion gatitos = new Asociacion(2,"Gatitos", configuraciones.get(0),direccion2);
        Asociacion perritos = new Asociacion(3,"Perritos", configuraciones.get(0),direccion3);
        this.asociaciones.add(patitas);
        this.asociaciones.add(gatitos);
        this.asociaciones.add(perritos);
    }

    public void setConfiguraciones()
    {
        ConfiguracionAsociacion configuracion1 = new ConfiguracionAsociacion();
        configuracion1.setAltoFoto(500);
        configuracion1.setAnchoFoto(500);
        configuracion1.setCalidadFotos(Calidad.MEDIA);
        List<String> caracteristicas1 = Arrays.asList(new String[]{"castrado", "chico", "mediano", "grande","manso"});
        configuracion1.agregarCaracteristicas(caracteristicas1);
        configuraciones.add(configuracion1);

        ConfiguracionAsociacion configuracion2 = new ConfiguracionAsociacion();
        configuracion2.setAltoFoto(600);
        configuracion2.setAnchoFoto(800);
        configuracion2.setCalidadFotos(Calidad.ALTA);
        List<String> caracteristicas2 = Arrays.asList(new String[]{"chico","manso"});
        configuracion2.agregarCaracteristicas(caracteristicas2);
        configuraciones.add(configuracion2);
    }

    public static List<ConfiguracionAsociacion> getConfiguraciones()
    {
    	List<ConfiguracionAsociacion> configuraciones = new ArrayList<>();
        ConfiguracionAsociacion configuracion1 = new ConfiguracionAsociacion();
        configuracion1.setAltoFoto(500);
        configuracion1.setAnchoFoto(500);
        configuracion1.setCalidadFotos(Calidad.MEDIA);
        List<String> caracteristicas1 = Arrays.asList(new String[]{"castrado", "chico", "mediano", "grande","manso"});
        configuracion1.agregarCaracteristicas(caracteristicas1);
        configuraciones.add(configuracion1);

        ConfiguracionAsociacion configuracion2 = new ConfiguracionAsociacion();
        configuracion2.setAltoFoto(600);
        configuracion2.setAnchoFoto(800);
        configuracion2.setCalidadFotos(Calidad.ALTA);
        List<String> caracteristicas2 = Arrays.asList(new String[]{"Tierno","Manso","Delgado","Peligroso"});
        configuracion2.agregarCaracteristicas(caracteristicas2);
        configuraciones.add(configuracion2);
        return configuraciones;
    }

    public static List<Asociacion> getAsociaciones()
    {
        Direccion direccion1 = new Direccion();
        Direccion direccion2 = new Direccion();
        Direccion direccion3 = new Direccion();

        List<Asociacion> asociaciones = new ArrayList<>();
        Asociacion patitas = new Asociacion(1,"Patitas", Repositorio.getConfiguraciones().get(1), direccion1);
        Asociacion gatitos = new Asociacion(2,"Gatitos", Repositorio.getConfiguraciones().get(0), direccion2);
        Asociacion perritos = new Asociacion(3,"Perritos", Repositorio.getConfiguraciones().get(0), direccion3);
        asociaciones.add(patitas);
        asociaciones.add(gatitos);
        asociaciones.add(perritos);
        return asociaciones;
    }

    

    public static Set<String> getCaracteristicas()
    {
        Set<String> caracteristicas = new HashSet<>();
        caracteristicas.add( "manso" );
        caracteristicas.add( "castrado" );
        caracteristicas.add( "pequenio" );
        caracteristicas.add( "gloton" );
        return caracteristicas;
    }

    public static Asociacion getAsociacion()
    {
        return new Asociacion(4,"Callejeritos",Repositorio.getConfiguraciones().get(0), new Direccion());
    }
    
    public static Asociacion getAsociacion1()
    {
        return new Asociacion(5,"Patitas",Repositorio.getConfiguraciones().get(1), new Direccion());
    }

    public static List<Contacto> getContacto(String nombre, String apellido, String telefono, String email)
    {
        Contacto contacto = new Contacto( nombre, apellido, telefono, email );
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(contacto);
        return contactos;
    }
/*
    public static PublicacionMascotaPerdida getPublicacionMascotaPerdida()
    {
        Mascota mascota = Repositorio.getMascota();
        Persona rescatista = Repositorio.getPersona();
        Direccion hogarDeTransito = new Direccion();
        Direccion laEsquina = new Direccion();
        return new PublicacionMascotaPerdida(0, mascota.getAsociacion(), mascota, rescatista, hogarDeTransito, laEsquina  );
    }
    
    public static List<PublicacionTemplate> PublicacionesMascotaPerdidas()
    {
        Mascota mascota = Repositorio.getMascota();
        Persona rescatista = Repositorio.getPersona();
        Direccion hogarDeTransito = new Direccion();
        Direccion laEsquina = new Direccion();
        
		PublicacionController.agregarPublicacion(new PublicacionMascotaPerdida(0,mascota.getAsociacion(), mascota, rescatista, hogarDeTransito, laEsquina));
    
        
        return publicaciones;
    }
    
    */
    
    public static List<PublicacionTemplate> getPublicacionesMascotaPerdidas()
    {
        return publicaciones;
    }
    
    public static List<PublicacionTemplate> getPublicaciones() {
    	/*
        if (publicaciones.size() == 0) {
            setPublicaciones();
            
            
        }
        */
        RepositorioPublicacion rep= new RepositorioPublicacion();
		publicaciones= rep.obtenerTodos();
       
        return publicaciones;
    }
    
    protected List<T> obtenerTodos() {
        return allQuery().getResultList();
    }
    
    private TypedQuery<T> allQuery() {
        final CriteriaBuilder cb = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<T> cq = cb.createQuery(clase);
        final Root<T> rootEntry = cq.from(clase);
        final CriteriaQuery<T> all = cq.select(rootEntry);
        return ENTITY_MANAGER.createQuery(all);
    }

    



    public static PublicacionMascotaEnAdopcion getPublicacionMascotaEnAdopcion()

    {
        Mascota mascota = Repositorio.getMascota();
        //Persona duenio = Repositorio.getPersona();
        //mascota.setDuenio(duenio);
        return new PublicacionMascotaEnAdopcion(0, null, mascota, null );
    }

    public static void setPublicaciones(){
        Direccion d1 = new Direccion();
        Direccion d2 = new Direccion();
        PublicacionMascotaPerdida p1 = new PublicacionMascotaPerdida(1, getAsociacion(), getMascotas().get(0), Usuarios().get(0), d1, d2,"Perdida");
        publicaciones.add(p1);

        PublicacionMascotaPerdida p2 = new PublicacionMascotaPerdida(2, getAsociacion(), getMascotas().get(1), Usuarios().get(0), d1, d2,"Perdida");
        publicaciones.add(p2);

        PublicacionMascotaEnAdopcion p3 = new PublicacionMascotaEnAdopcion(3, getAsociacion(), getMascotas().get(2), Usuarios().get(1));
        publicaciones.add(p3);
        Repositorio.guardar(p1);
        Repositorio.guardar(p2);
        Repositorio.guardar(p3);
        
    }

    public static Mascota getMascota()
    {
        Asociacion asociacion = Repositorio.getAsociacion();
        Set<Foto> fotos = new HashSet<>();
        return Mascota.registrarMascotaPerdida("Dolca", "Negrita", 2, Sexo.FEMENINO, Especie.PERRO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), asociacion );
    }

    public static List<Mascota> getMascotas()
    {
        Asociacion asociacion = Repositorio.getAsociacion();
        Set<Foto> fotos = new HashSet<>();

        Mascota m1 = Mascota.registrarMascotaPerdida("Dolca", "Negrita", 2, Sexo.FEMENINO, Especie.PERRO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), asociacion);
        mascotas.add(m1);

        Mascota m2 = Mascota.registrarMascotaPerdida("Lola", "Loli", 1, Sexo.FEMENINO, Especie.PERRO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), asociacion);
        mascotas.add(m2);

        Mascota m3 = Mascota.registrarMascotaPerdida("Michi", "Mini", 8, Sexo.MASCULINO, Especie.GATO, "asdjkaslkdj lasdkj", fotos, Repositorio.getCaracteristicas(), asociacion);
        mascotas.add(m3);

        return mascotas;
    }

    public static Persona getPersona()
    {
        List<Contacto> contactos = Repositorio.getContacto( "Alejandro", "Romero", "1130234991", "romero.m.alejandro@gmail.com" );
        return Persona.registrarPersona( "Alejandro", "Romero", TipoDocumento.DNI, 19890428, 34319384, contactos );
    }
    
    public static Persona getPersona2()
    {
        List<Contacto> contactos = Repositorio.getContacto( "Damian", "asd", "1231231231", "damian.m.alejandro@gmail.com" );
        return Persona.registrarPersona( "Damian", "asd", TipoDocumento.DNI, 19890428, 34319384, contactos );
    }
    
    public  void borrar(final T objeto) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
          
            ENTITY_MANAGER.remove(objeto);
            ENTITY_MANAGER.getTransaction().commit();
        } catch (Exception e) {
            ENTITY_MANAGER.getTransaction().rollback();
            throw new RuntimeException("Error al borrar: ", e);
        }
    }

    public List<T> obtenerPaginado(final int offset, final int cantidadPorPagina) {
        return allQuery().setFirstResult(offset).setMaxResults(cantidadPorPagina).getResultList();
    }	
    
    
    public long cantidadPorCondicion(final String campo) {
        return whereQuery(campo).getResultStream().count();
    }
    
    private TypedQuery<T> whereQuery(final String campo) {
        final CriteriaBuilder cb = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<T> cq = cb.createQuery(clase);
        final Root<T> rootEntry = cq.from(clase);
        
        return ENTITY_MANAGER.createQuery(cq);
    }

}
