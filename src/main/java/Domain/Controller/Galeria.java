package Domain.Controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Galeria.DarkSoul;
import Domain.Galeria.GOD;
import Domain.Galeria.Imagen;
import Domain.Galeria.ImagenDTO;
import Domain.Galeria.MK;
import Domain.GodRepo;
import Domain.ImagenRepo;
import Domain.MKRepo;
import Domain.Utilitario.Const;
import spark.ModelAndView;
import spark.Request;
import spark.Response;





public abstract class Galeria implements  Serializable {


    
    public static ModelAndView Mortalkombat(Request req, Response res) throws SQLException {

    	  Map<String, Object> model = new HashMap<>();
          model.put("logged", req.session().attribute(Const.ID_USUARIO));
          model.put("banner", true);
          MKRepo rep= new MKRepo();
          List<MK> imagenes= rep.obtenerTodos();
          ImagenDTO imagen = new ImagenDTO();
          ImagenDTO imagen2 = new ImagenDTO();
          ImagenDTO imagen3 = new ImagenDTO();
          ImagenDTO imagen4 = new ImagenDTO();
          ImagenDTO imagen5 = new ImagenDTO();
          ImagenDTO imagen6 = new ImagenDTO();
          ImagenDTO imagen7 = new ImagenDTO();
          ImagenDTO imagen8 = new ImagenDTO();
          ImagenDTO imagen9 = new ImagenDTO();
          ImagenDTO imagen10 = new ImagenDTO();
          ImagenDTO imagen11 = new ImagenDTO();
          ImagenDTO imagen12 = new ImagenDTO();
          ImagenDTO imagen13 = new ImagenDTO();
          ImagenDTO imagen14 = new ImagenDTO();
          
          String imagenbase64  = ImagenDTO.convertBlobToBase64(imagenes.get(0).getImagen());
          String imagen2base64  = ImagenDTO.convertBlobToBase64(imagenes.get(1).getImagen());
          String imagen3base64  = ImagenDTO.convertBlobToBase64(imagenes.get(2).getImagen());
          String imagen4base64  = ImagenDTO.convertBlobToBase64(imagenes.get(3).getImagen());
          String imagen5base64  = ImagenDTO.convertBlobToBase64(imagenes.get(4).getImagen());
          String imagen6base64  = ImagenDTO.convertBlobToBase64(imagenes.get(5).getImagen());
          String imagen7base64  = ImagenDTO.convertBlobToBase64(imagenes.get(6).getImagen());
          String imagen8base64  = ImagenDTO.convertBlobToBase64(imagenes.get(7).getImagen());
          String imagen9base64  = ImagenDTO.convertBlobToBase64(imagenes.get(8).getImagen());
          String imagen10base64  = ImagenDTO.convertBlobToBase64(imagenes.get(9).getImagen());
          String imagen11base64  = ImagenDTO.convertBlobToBase64(imagenes.get(10).getImagen());
          String imagen12base64  = ImagenDTO.convertBlobToBase64(imagenes.get(11).getImagen());
          String imagen13base64  = ImagenDTO.convertBlobToBase64(imagenes.get(12).getImagen());
          String imagen14base64  = ImagenDTO.convertBlobToBase64(imagenes.get(13).getImagen());
          
          
          imagen.setImagen(imagenbase64);
          imagen2.setImagen(imagen2base64);
          imagen3.setImagen(imagen3base64);
          imagen4.setImagen(imagen4base64);
          imagen5.setImagen(imagen5base64);
          imagen6.setImagen(imagen6base64);
          imagen7.setImagen(imagen7base64);
          imagen8.setImagen(imagen8base64);
          imagen9.setImagen(imagen9base64);
          imagen10.setImagen(imagen10base64);
          imagen11.setImagen(imagen11base64);
          imagen12.setImagen(imagen12base64);
          imagen13.setImagen(imagen13base64);
          imagen14.setImagen(imagen14base64);
          
          imagen.setNombre(imagenes.get(0).getNombre());
          imagen2.setNombre(imagenes.get(1).getNombre());
          imagen3.setNombre(imagenes.get(2).getNombre());
          imagen4.setNombre(imagenes.get(3).getNombre());
          imagen5.setNombre(imagenes.get(4).getNombre());
          imagen6.setNombre(imagenes.get(5).getNombre());
          imagen7.setNombre(imagenes.get(6).getNombre());
          imagen8.setNombre(imagenes.get(7).getNombre());
          imagen9.setNombre(imagenes.get(8).getNombre());
          imagen10.setNombre(imagenes.get(9).getNombre());
          imagen11.setNombre(imagenes.get(10).getNombre());
          imagen12.setNombre(imagenes.get(11).getNombre());
          imagen13.setNombre(imagenes.get(12).getNombre());
          imagen14.setNombre(imagenes.get(13).getNombre());
             		
         
          model.put("foto1", imagen);
          model.put("foto2", imagen2);
          model.put("foto3", imagen3);
          model.put("foto4", imagen4);
          model.put("foto5", imagen5);
          model.put("foto6", imagen6);
          model.put("foto7", imagen7);
          model.put("foto8", imagen8);
          model.put("foto9", imagen9);
          model.put("foto10", imagen10);
          model.put("foto11", imagen11);
          model.put("foto12", imagen12);
          model.put("foto13", imagen13);
          model.put("foto14", imagen14);
          return new ModelAndView(model, "MortalKombat.hbs");
      }
    
    
    public static ModelAndView DarkSouls(Request req, Response res) throws SQLException {

    	  Map<String, Object> model = new HashMap<>();
          model.put("logged", req.session().attribute(Const.ID_USUARIO));
          model.put("banner", true);
          //DarkSoulRepo rep= new DarkSoulRepo();
          
          
          ImagenDTO imagen = new ImagenDTO();
          ImagenDTO imagen2 = new ImagenDTO();
          ImagenDTO imagen3 = new ImagenDTO();
          ImagenDTO imagen4 = new ImagenDTO();
          ImagenDTO imagen5 = new ImagenDTO();
          ImagenDTO imagen6 = new ImagenDTO();
          ImagenDTO imagen7 = new ImagenDTO();
          ImagenDTO imagen8 = new ImagenDTO();
         
          String rds1 = "ds1.jpg";
          String rds2 = "bloodborne.jpg";
          String rds3 = "ds3.jpg";
          String rds4 = "sekiro.jpg";
          String rds5 = "demonsoul.jpg";
          String rds6 = "eldenring.jpg";
          String rds7 = "dstrilogy2.jpg";
          String rds8 = "dstrilogy.jpg";
          
          
          DarkSoul ds = new DarkSoul();
          DarkSoul ds2 = new DarkSoul();
          DarkSoul ds3 = new DarkSoul();
          DarkSoul ds4 = new DarkSoul();
          DarkSoul ds5 = new DarkSoul();
          DarkSoul ds6 = new DarkSoul();
          DarkSoul ds7 = new DarkSoul();
          DarkSoul ds8 = new DarkSoul();
          
          ds.setNombre("DARKSOULS - PS3");
          ds2.setNombre("BLOODBORNE - PS4");
          ds3.setNombre("DARKSOULS 3 COMPLETE EDITION - PS4");
          ds4.setNombre("SEKIRO™: SHADOWS DIE TWICE - PS4");
          ds5.setNombre("DEMON SOULS - PS5");
          ds6.setNombre("ELDEN RING - PS5");
          ds7.setNombre("DARKSOULS TRILOGY - PS4");
          ds8.setNombre("DARKSOULS TRILOGY - PS4");

          
          
          imagen.setImagen(rds1);
          imagen2.setImagen(rds2);
          imagen3.setImagen(rds3);
          imagen4.setImagen(rds4);
          imagen5.setImagen(rds5);
          imagen6.setImagen(rds6);
          imagen7.setImagen(rds7);
          imagen8.setImagen(rds8);
       
        
          
          imagen.setNombre( "DARKSOULS - PS3");
          imagen2.setNombre("BLOODBORNE - PS4");
          imagen3.setNombre("DARKSOULS 3 COMPLETE EDITION - PS4");
          imagen4.setNombre("SEKIRO™: SHADOWS DIE TWICE - PS4");
          imagen5.setNombre("DEMON SOULS - PS5");
          imagen6.setNombre("ELDEN RING - PS5");
          imagen7.setNombre("DARKSOULS TRILOGY - PS4");
          imagen8.setNombre("DARKSOULS TRILOGY - PS4");
         
          
         
          model.put("foto1", imagen);
          model.put("foto2", imagen2);
          model.put("foto3", imagen3);
          model.put("foto4", imagen4);
          model.put("foto5", imagen5);
          model.put("foto6", imagen6);
          model.put("foto7", imagen7);
          model.put("foto8", imagen8);

          

// Agregar cada imagen como un mapa con su nombre y URL
// Agregar cada imagen como un mapa con su nombre y URL
List<ImagenDTO> imaganes = new ArrayList<>();

imaganes.add(imagen);
imaganes.add(imagen2);
imaganes.add(imagen3);
imaganes.add(imagen4);
imaganes.add(imagen5);
imaganes.add(imagen6);
imaganes.add(imagen7);
imaganes.add(imagen8);

// Guardar la lista en el model
model.put("imaganes", imaganes);

return new ModelAndView(model, "DarkSouls.hbs");
      }
    
    
    public static ModelAndView Godofwar(Request req, Response res) throws SQLException {


  	  Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        model.put("banner", true);
        GodRepo rep= new GodRepo();
        List<GOD> imagenes2= rep.obtenerTodos();
        List<ImagenDTO> imagenesDTO = new ArrayList<>();
        int cantidadDeImagenes = 28;
        ImagenDTO[] imagenes = new ImagenDTO[cantidadDeImagenes];

     // Crear instancias de ImagenDTO en un bucle
     for (int i = 0; i < cantidadDeImagenes; i++) {
         imagenes[i] = new ImagenDTO();
     }
       
        
 

  // Arreglo para almacenar las cadenas base64
  String[] imagenesBase64 = new String[cantidadDeImagenes];

  // Crear cadenas base64 en un bucle
  for (int i = 0; i < cantidadDeImagenes; i++) {
      imagenesBase64[i] = ImagenDTO.convertBlobToBase64(imagenes2.get(i).getImagen());
  }
       
        
        
        
//Establecer las imágenes en un bucle
for (int i = 0; i < cantidadDeImagenes; i++) {
   imagenes[i].setImagen(imagenesBase64[i]);
}
        
for (int i = 0;  i < imagenes2.size(); i++) {
    imagenes[i].setNombre(imagenes2.get(i).getNombre());
}
        
       
for (int i = 0; i < imagenes2.size(); i++) {
    String nombreClave = "foto" + (i + 1); // Generar la clave dinámicamente (foto1, foto2, ...)
    
    model.put(nombreClave, imagenes[i]);
    
    // También puedes establecer el nombre e imagen directamente si ya tienes esos valores
    // model.put(nombreClave, imagenes.get(i));
    // model.put(nombreClave + "base64", ImagenDTO.convertBlobToBase64(imagenes.get(i).getImagen()));
}
for (int i = 0; i < cantidadDeImagenes; i++) {
	imagenesDTO.add(imagenes[i]);
}
    	
		model.put("fotos", imagenesDTO);
        return new ModelAndView(model, "GodOfWar.hbs");
    }
    
    public static ModelAndView Playstation(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        model.put("banner", true);
        return new ModelAndView(model, "Playstation.hbs");
    }
    
    public static ModelAndView Playstation2(Request req, Response res) throws SQLException {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        ImagenRepo rep= new ImagenRepo();
        List<Imagen> imagenes= rep.obtenerTodos();
        ImagenDTO imagen = new ImagenDTO();
        ImagenDTO imagen2 = new ImagenDTO();
        ImagenDTO imagen3 = new ImagenDTO();
        ImagenDTO imagen4 = new ImagenDTO();
        ImagenDTO imagen5 = new ImagenDTO();
        ImagenDTO imagen6 = new ImagenDTO();
        ImagenDTO imagen7 = new ImagenDTO();
        ImagenDTO imagen8 = new ImagenDTO();
        ImagenDTO imagen9 = new ImagenDTO();
        
        String imagenbase64  = ImagenDTO.convertBlobToBase64(imagenes.get(0).getImagen());
        String imagen2base64  = ImagenDTO.convertBlobToBase64(imagenes.get(1).getImagen());
        String imagen3base64  = ImagenDTO.convertBlobToBase64(imagenes.get(2).getImagen());
        String imagen4base64  = ImagenDTO.convertBlobToBase64(imagenes.get(3).getImagen());
        String imagen5base64  = ImagenDTO.convertBlobToBase64(imagenes.get(4).getImagen());
        String imagen6base64  = ImagenDTO.convertBlobToBase64(imagenes.get(5).getImagen());
        String imagen7base64  = ImagenDTO.convertBlobToBase64(imagenes.get(6).getImagen());
        String imagen8base64  = ImagenDTO.convertBlobToBase64(imagenes.get(7).getImagen());
        String imagen9base64  = ImagenDTO.convertBlobToBase64(imagenes.get(8).getImagen());
        
        
        imagen.setImagen(imagenbase64);
        imagen2.setImagen(imagen2base64);
        imagen3.setImagen(imagen3base64);
        imagen4.setImagen(imagen4base64);
        imagen5.setImagen(imagen5base64);
        imagen6.setImagen(imagen6base64);
        imagen7.setImagen(imagen7base64);
        imagen8.setImagen(imagen8base64);
        imagen9.setImagen(imagen9base64);
        
        imagen.setNombre(imagenes.get(0).getNombre());
        imagen2.setNombre(imagenes.get(1).getNombre());
        imagen3.setNombre(imagenes.get(2).getNombre());
        imagen4.setNombre(imagenes.get(3).getNombre());
        imagen5.setNombre(imagenes.get(4).getNombre());
        imagen6.setNombre(imagenes.get(5).getNombre());
        imagen7.setNombre(imagenes.get(6).getNombre());
        imagen8.setNombre(imagenes.get(7).getNombre());
        imagen9.setNombre(imagenes.get(8).getNombre());
        
        
  
    
        		
       
        model.put("foto1", imagen);
        model.put("foto2", imagen2);
        model.put("foto3", imagen3);
        model.put("foto4", imagen4);
        model.put("foto5", imagen5);
        model.put("foto6", imagen6);
        model.put("foto7", imagen7);
        model.put("foto8", imagen8);
        model.put("foto9", imagen9);
        return new ModelAndView(model, "Playstation2.hbs");
    }
    
    public static ModelAndView Ps3(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Ps4(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    
    public static ModelAndView Accesorios(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "gallery.hbs");
    }
    public static ModelAndView MenuGaleria(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();
        model.put("logged", req.session().attribute(Const.ID_USUARIO));
        return new ModelAndView(model, "menuGaleria.hbs");
    }

}
