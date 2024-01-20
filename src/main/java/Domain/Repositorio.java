package Domain;

import Domain.Asociacion.Asociacion;
import Domain.Asociacion.Calidad;
import Domain.Asociacion.ConfiguracionAsociacion;

import Domain.Contacto.Contacto;

import Domain.DTOs.PublicacionTemplateDTO;
import Domain.Direccion.Direccion;
import Domain.Galeria.DarkSoul;
import Domain.Galeria.GOD;
import Domain.Galeria.Galeria;
import Domain.Galeria.Galeria.ImagenUtil;
import Domain.Galeria.MK;
import Domain.Mascota.Especie;
import Domain.Mascota.Foto;
import Domain.Mascota.Mascota;
import Domain.Mascota.Sexo;

import Domain.Publicacion.PublicacionMascotaEnAdopcion;
import Domain.Publicacion.PublicacionMascotaPerdida;
import Domain.Publicacion.PublicacionTemplate;
import Domain.Usuario.Persona;
import Domain.Usuario.TipoDocumento;
import Domain.Usuario.Usuario;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.io.IOException;

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
    public List<Galeria> galeria = new ArrayList<>();

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
            persistenceUnit = "mysql";
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
    
    public static void guardar2(Object  galeria2) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.merge(galeria2);
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
    
    
    public void setGaleria() throws IOException, SQLException
    {
    	 String ruta = "src\\main\\resources\\public\\UMK3.jpg";
         String ruta2 = "src\\main\\resources\\public\\trilogy.jpg";
         String ruta3 = "src\\main\\resources\\public\\MKPS2.jpg";
         String ruta4 = "src\\main\\resources\\public\\Armagedon.jpg";
         String ruta5 = "src\\main\\resources\\public\\deception.jpg";
         String ruta6 = "src\\main\\resources\\public\\deception2.jpg";
         String ruta7 = "src\\main\\resources\\public\\deception3.jpg";
         String ruta8 = "src\\main\\resources\\public\\shaolinmonks.jpg";
         String ruta9 = "src\\main\\resources\\public\\mkpack.jpg";
         String ruta10 = "src\\main\\resources\\public\\MK9.jpg";
         String ruta11 = "src\\main\\resources\\public\\MKVSDC.jpg";
         String ruta12 = "src\\main\\resources\\public\\MKXL.jpg";
         String ruta13 = "src\\main\\resources\\public\\packtilogy.jpg";
         String ruta14 = "src\\main\\resources\\public\\umksega.jpg";
         
         String rds1 = "src\\main\\resources\\public\\ds1.jpg";
         String rds2 = "src\\main\\resources\\public\\bloodborne.jpg";
         String rds3 = "src\\main\\resources\\public\\ds3.jpg";
         String rds4 = "src\\main\\resources\\public\\sekiro.jpg";
         String rds5 = "src\\main\\resources\\public\\demonsoul.jpg";
         String rds6 = "src\\main\\resources\\public\\eldenring.jpg";
         String rds7 = "src\\main\\resources\\public\\dstrilogy2.jpg";
         String rds8 = "src\\main\\resources\\public\\dstrilogy.jpg";
       

    	 String rgod = "src\\main\\resources\\public\\2.jpg";
         String rgod2 = "src\\main\\resources\\public\\3.jpg";
         String rgod3 = "src\\main\\resources\\public\\4.jpg";
         String rgod4 = "src\\main\\resources\\public\\5.jpg";
         String rgod5 = "src\\main\\resources\\public\\6.jpg";
         String rgod6 = "src\\main\\resources\\public\\7.jpg";
         String rgod7 = "src\\main\\resources\\public\\8.jpg";
         String rgod8 = "src\\main\\resources\\public\\9.jpg";
         String rgod9 = "src\\main\\resources\\public\\10.jpg";
         String rgod10 = "src\\main\\resources\\public\\11.jpg";
         String rgod11 = "src\\main\\resources\\public\\12.jpg";
         String rgod12 = "src\\main\\resources\\public\\13.jpg";
         String rgod13 = "src\\main\\resources\\public\\14.jpg";
         String rgod14 = "src\\main\\resources\\public\\15.jpg";
    	 String rgod15 = "src\\main\\resources\\public\\16.jpg";
         String rgod16 = "src\\main\\resources\\public\\17.jpg";
         String rgod17 = "src\\main\\resources\\public\\18.jpg";
         String rgod18 = "src\\main\\resources\\public\\19.jpg";
         String rgod19 = "src\\main\\resources\\public\\20.jpg";
         String rgod20 = "src\\main\\resources\\public\\21.jpg";
         String rgod21 = "src\\main\\resources\\public\\22.jpg";
         String rgod22 = "src\\main\\resources\\public\\23.jpg";
         String rgod23 = "src\\main\\resources\\public\\controlPs3Kratos.jpg";
         String rgod24 = "src\\main\\resources\\public\\26.jpg";
         String rgod25 = "src\\main\\resources\\public\\27.jpg";
         String rgod26 = "src\\main\\resources\\public\\28.jpg";
         String rgod27 = "src\\main\\resources\\public\\29.jpg";
         String rgod28 = "src\\main\\resources\\public\\30.jpg";
         
     
        
         MK mk = new MK();
         MK mk2 = new MK();
         MK mk3 = new MK();
         MK mk4 = new MK();
         MK mk5 = new MK();
         MK mk6 = new MK();
         MK mk7 = new MK();
         MK mk8 = new MK();
         MK mk9 = new MK();
         MK mk10 = new MK();
         MK mk11 = new MK();
         MK mk12 = new MK();
         MK mk13 = new MK();
         MK mk14 = new MK();
         
         DarkSoul ds = new DarkSoul();
         DarkSoul ds2 = new DarkSoul();
         DarkSoul ds3 = new DarkSoul();
         DarkSoul ds4 = new DarkSoul();
         DarkSoul ds5 = new DarkSoul();
         DarkSoul ds6 = new DarkSoul();
         DarkSoul ds7 = new DarkSoul();
         DarkSoul ds8 = new DarkSoul();
         
         GOD god = new GOD();
         GOD god2 = new GOD();
         GOD god3= new GOD();
         GOD god4 = new GOD();
         GOD god5 = new GOD();
         GOD god6 = new GOD();
         GOD god7 = new GOD();
         GOD god8 = new GOD();
         GOD god9 = new GOD();
         GOD god10 = new GOD();
         GOD god11 = new GOD();
         GOD god12 = new GOD();
         GOD god13 = new GOD();
         GOD god14 = new GOD();
         GOD god15 = new GOD();
         GOD god16 = new GOD();
         GOD god17 = new GOD();
         GOD god18 = new GOD();
         GOD god19 = new GOD();
         GOD god20 = new GOD();
         GOD god21 = new GOD();
         GOD god22 = new GOD();
         GOD god23 = new GOD();
         GOD god24 = new GOD();
         GOD god25 = new GOD();
         GOD god26 = new GOD();
         GOD god27 = new GOD();
         GOD god28 = new GOD();
       
         
         mk.setNombre("ULTIMATE MORTALAL KOMBAT 3 - SEGA");
         mk2.setNombre("MORTAL KOMBAT TRILOGY - PS1");
         mk3.setNombre("MORTAL KOMBAT PACK3");
         mk4.setNombre("MORTAL KOMBAT ARMAGEDDON - PS2");
         mk5.setNombre("MORTAL KOMBAT DECEPTION - PS2");
         mk6.setNombre("MORTAL KOMBAT PREMIUM PACK - PS2");
         mk7.setNombre("MORTAL KOMBAT PREMIUM PACK - BOX");
         mk8.setNombre("MORTAL KOMBAT SHAOIN MONKS");
         mk9.setNombre("PACK");
         mk10.setNombre("MORTAL KOMBAT 9 - PS3");
         mk11.setNombre("MORTAL KOMBAT VS DC UNIVERSE - PS3");
         mk12.setNombre("MORTAL KOMBAT XL - PS4");
         mk13.setNombre("MORTAL KOMBAT COLLECTION - PS2");
         mk14.setNombre("ULTIMATE MORTAL KOMBAT 3 - SEGA");
         
         ds.setNombre("DARKSOULS - PS3");
         ds2.setNombre("BLOODBORNE - PS4");
         ds3.setNombre("DARKSOULS 3 COMPLETE EDITION - PS4");
         ds4.setNombre("SEKIRO™: SHADOWS DIE TWICE - PS4");
         ds5.setNombre("DEMON SOULS - PS5");
         ds6.setNombre("ELDEN RING - PS5");
         ds7.setNombre("DARKSOULS TRILOGY - PS4");
         ds8.setNombre("DARKSOULS TRILOGY - PS4");
        
         
        
         Blob mkBlob = ImagenUtil.convertirImagenABlob(ruta);
         Blob mkBlob2 = ImagenUtil.convertirImagenABlob(ruta2);
         Blob mkBlob3 = ImagenUtil.convertirImagenABlob(ruta3);
         Blob mkBlob4 = ImagenUtil.convertirImagenABlob(ruta4);
         Blob mkBlob5 = ImagenUtil.convertirImagenABlob(ruta5);
         Blob mkBlob6 = ImagenUtil.convertirImagenABlob(ruta6);
         Blob mkBlob7 = ImagenUtil.convertirImagenABlob(ruta7);
         Blob mkBlob8 = ImagenUtil.convertirImagenABlob(ruta8);
         Blob mkBlob9 = ImagenUtil.convertirImagenABlob(ruta9);
         Blob mkBlob10 = ImagenUtil.convertirImagenABlob(ruta10);
         Blob mkBlob11 = ImagenUtil.convertirImagenABlob(ruta11);
         Blob mkBlob12 = ImagenUtil.convertirImagenABlob(ruta12);
         Blob mkBlob13 = ImagenUtil.convertirImagenABlob(ruta13);
         Blob mkBlob14 = ImagenUtil.convertirImagenABlob(ruta14);
         
         Blob dsBlob = ImagenUtil.convertirImagenABlob(rds1);
         Blob dsBlob2 = ImagenUtil.convertirImagenABlob(rds2);
         Blob dsBlob3 = ImagenUtil.convertirImagenABlob(rds3);
         Blob dsBlob4 = ImagenUtil.convertirImagenABlob(rds4);
         Blob dsBlob5 = ImagenUtil.convertirImagenABlob(rds5);
         Blob dsBlob6 = ImagenUtil.convertirImagenABlob(rds6);
         Blob dsBlob7 = ImagenUtil.convertirImagenABlob(rds7);
         Blob dsBlob8 = ImagenUtil.convertirImagenABlob(rds8);
         
         Blob godBlob = ImagenUtil.convertirImagenABlob(rgod);
         Blob godBlob2 = ImagenUtil.convertirImagenABlob(rgod2);
         Blob godBlob3 = ImagenUtil.convertirImagenABlob(rgod3);
         Blob godBlob4 = ImagenUtil.convertirImagenABlob(rgod4);
         Blob godBlob5 = ImagenUtil.convertirImagenABlob(rgod5);
         Blob godBlob6 = ImagenUtil.convertirImagenABlob(rgod6);
         Blob godBlob7 = ImagenUtil.convertirImagenABlob(rgod7);
         Blob godBlob8 = ImagenUtil.convertirImagenABlob(rgod8);
         Blob godBlob9 = ImagenUtil.convertirImagenABlob(rgod9);
         Blob godBlob10 = ImagenUtil.convertirImagenABlob(rgod10);
         Blob godBlob11 = ImagenUtil.convertirImagenABlob(rgod11);
         Blob godBlob12 = ImagenUtil.convertirImagenABlob(rgod12);
         Blob godBlob13 = ImagenUtil.convertirImagenABlob(rgod13);
         Blob godBlob14 = ImagenUtil.convertirImagenABlob(rgod14);
         Blob godBlob15 = ImagenUtil.convertirImagenABlob(rgod15);
         Blob godBlob16 = ImagenUtil.convertirImagenABlob(rgod16);
         Blob godBlob17 = ImagenUtil.convertirImagenABlob(rgod17);
         Blob godBlob18 = ImagenUtil.convertirImagenABlob(rgod18);
         Blob godBlob19 = ImagenUtil.convertirImagenABlob(rgod19);
         Blob godBlob20 = ImagenUtil.convertirImagenABlob(rgod20);
         Blob godBlob21 = ImagenUtil.convertirImagenABlob(rgod21);
         Blob godBlob22 = ImagenUtil.convertirImagenABlob(rgod22);
         Blob godBlob23 = ImagenUtil.convertirImagenABlob(rgod23);
         Blob godBlob24 = ImagenUtil.convertirImagenABlob(rgod24);
         Blob godBlob25 = ImagenUtil.convertirImagenABlob(rgod25);
         Blob godBlob26 = ImagenUtil.convertirImagenABlob(rgod26);
         Blob godBlob27 = ImagenUtil.convertirImagenABlob(rgod27);
         Blob godBlob28 = ImagenUtil.convertirImagenABlob(rgod28);
        
    
         
         mk.setImagen(mkBlob);
         mk2.setImagen(mkBlob2);
         mk3.setImagen(mkBlob3);
         mk4.setImagen(mkBlob4);
         mk5.setImagen(mkBlob5);
         mk6.setImagen(mkBlob6);
         mk7.setImagen(mkBlob7);
         mk8.setImagen(mkBlob8);
         mk9.setImagen(mkBlob9);
         mk10.setImagen(mkBlob10);
         mk11.setImagen(mkBlob11);
         mk12.setImagen(mkBlob12);
         mk13.setImagen(mkBlob13);
         mk14.setImagen(mkBlob14);
         
         ds.setImagen(dsBlob);
         ds2.setImagen(dsBlob2);
         ds3.setImagen(dsBlob3);
         ds4.setImagen(dsBlob4);
         ds5.setImagen(dsBlob5);
         ds6.setImagen(dsBlob6);
         ds7.setImagen(dsBlob7);
         ds8.setImagen(dsBlob8);
         
         god.setImagen(godBlob);
         god2.setImagen(godBlob2);
         god3.setImagen(godBlob3);
         god4.setImagen(godBlob4);
         god5.setImagen(godBlob5);
         god6.setImagen(godBlob6);
         god7.setImagen(godBlob7);
         god8.setImagen(godBlob8);
         god9.setImagen(godBlob9);
         god10.setImagen(godBlob10);
         god11.setImagen(godBlob11);
         god12.setImagen(godBlob12);
         god13.setImagen(godBlob13);
         god14.setImagen(godBlob14);
         god15.setImagen(godBlob15);
         god16.setImagen(godBlob16);
         god17.setImagen(godBlob17);
         god18.setImagen(godBlob18);
         god19.setImagen(godBlob19);
         god20.setImagen(godBlob20);
         god21.setImagen(godBlob21);
         god22.setImagen(godBlob22);
         god23.setImagen(godBlob23);
         god24.setImagen(godBlob24);
         god25.setImagen(godBlob25);
         god26.setImagen(godBlob26);
         god27.setImagen(godBlob27);
         god28.setImagen(godBlob28);
       
        Galeria galeria = new Galeria();
       
        
        List<MK> mkes = new ArrayList<>();
        List<DarkSoul> dses = new ArrayList<>();
        List<GOD> godes = new ArrayList<>();
     
        mkes.add(mk);
        mkes.add(mk2);
        mkes.add(mk3);
        mkes.add(mk4);
        mkes.add(mk5);
        mkes.add(mk6);
        mkes.add(mk7);
        mkes.add(mk8);
        mkes.add(mk9);
        mkes.add(mk10);
        mkes.add(mk11);
        mkes.add(mk12);
        mkes.add(mk13);
        mkes.add(mk14);
        
        dses.add(ds);
        dses.add(ds2);
        dses.add(ds3);
        dses.add(ds4);
        dses.add(ds5);
        dses.add(ds6);
        dses.add(ds7);
        dses.add(ds8);
        
        godes.add(god);
        godes.add(god2);
        godes.add(god3);
        godes.add(god4);
        godes.add(god5);
        godes.add(god6);
        godes.add(god7);
        godes.add(god8);
        godes.add(god9);
        godes.add(god10);
        godes.add(god11);
        godes.add(god12);
        godes.add(god13);
        godes.add(god14);
        godes.add(god15);
        godes.add(god16);
        godes.add(god17);
        godes.add(god18);
        godes.add(god19);
        godes.add(god20);
        godes.add(god21);
        godes.add(god22);
        godes.add(god23);
        godes.add(god24);
        godes.add(god25);
        godes.add(god26);
        godes.add(god27);
        godes.add(god28);
     
        
        galeria.setImagenes(mkes);
        galeria.setImagenes2(dses);
        galeria.setImagenes3(godes);
        this.galeria.add(galeria);
        
    }
    
    public static String convertBlobToBase64(Blob blob) throws SQLException {
        // Paso 1: Leer los bytes del Blob
        byte[] blobBytes = blob.getBytes(1, (int) blob.length());

        // Paso 2: Convertir a Base64
        return Base64.getEncoder().encodeToString(blobBytes);
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
    
    public List<T> obtenerTodos() {
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
