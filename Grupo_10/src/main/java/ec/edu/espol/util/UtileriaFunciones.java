/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import ec.edu.espol.controllers.DashboardController;
import ec.edu.espol.grupo_10.App;
import ec.edu.espol.model.ArrayList;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author evin
 */
public class UtileriaFunciones {
    public static double xOffset = 0;
    public static double yOffset = 0;
    public static void salirPantallaB(Event event){
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public static void salirPantallaT(Event event){
        Stage stage = (Stage) ((Text) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public static void cambiarEscena(Event event, String fxml){
        try{
            FXMLLoader loader = App.loadFXML(fxml);
            Scene sc = new Scene(loader.load(), 700, 500);
            App.setScene(sc);
        } catch(IOException ex){}
    }
    
    public static void cambiarEscena(String fxml){
        
        try{
            FXMLLoader loader = App.loadFXML(fxml);
            Scene sc = new Scene(loader.load(), 700, 500);   
            App.setScene(sc);
        } catch(IOException ex){}
    }
    
    
    public static void cambiarDashboardPrincipal(Usuario usuario){
        try{
            FXMLLoader loader = App.loadFXML("dashboard");
            Scene sc = new Scene(loader.load(), 700, 500);
            DashboardController controlador = loader.getController();
            controlador.setUsuario(usuario);
            App.setScene(sc);
        } catch(IOException ex){}
    }
    
    public static boolean verificarCondiciones(Boolean b){
        return b == false;
    }
    
    public static boolean verificacionesNumericas(String str){
        return str.matches("\\d+(\\.\\d+)?");
    }
    
    public static String crearMensajeAuto(String tipo, String placa, String marca, String modelo, int precio, double km){
        String mensaje1 = "𝐃𝐄𝐓𝐀𝐋𝐋𝐄𝐒 𝐃𝐄𝐋 𝐀𝐔𝐓𝐎𝐌𝐎𝐓𝐎𝐑\n\n𝐓𝐢𝐩𝐨: "+tipo+"\n"+"𝐏𝐥𝐚𝐜𝐚: "+placa+"\n";
        String mensaje2 = "𝐌𝐚𝐫𝐜𝐚: "+marca+"\n"+"𝐌𝐨𝐝𝐞𝐥𝐨: "+modelo+"\n";
        String mensaje3 = "𝐏𝐫𝐞𝐜𝐢𝐨: "+precio+"\n"+"𝐊𝐢𝐥𝐨𝐦𝐞𝐭𝐫𝐚𝐣𝐞: "+km+"\n";
        return mensaje1+mensaje2+mensaje3;
    }
    
    public static void guardarImagen(File imagen, String n) throws IOException{
    String nombreImagen = n+".png";
    if(imagen != null){
        String rutaProyecto = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
        String rutaCarpetaDestino = rutaProyecto + File.separator + "imagenesVehiculos";
        File destinoCarpeta = new File(rutaCarpetaDestino);
        if(!destinoCarpeta.exists())
            destinoCarpeta.mkdir();

        File destinoArchivo = new File(rutaCarpetaDestino + File.separator + nombreImagen);
        if(destinoArchivo.exists())
            destinoArchivo.delete();

        Files.copy(imagen.toPath(), destinoArchivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } 
    else 
        throw new IOException();
    }
    
    public static void mostrarImagen(String n, File imgFile, ImageView imv){
        String nombreImagen = n+".png";
        String rutaProyecto = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
        String rutaCarpetaDestino = rutaProyecto + File.separator + "imagenesVehiculos";
        imgFile = new File(rutaCarpetaDestino, nombreImagen);
        Image imagen = new Image(imgFile.toURI().toString());
        // Ajustando imagen con el método creado :)
        imagen = ajustarTamañoImagen(imagen, imv.getFitWidth() ,imv.getFitHeight());
        imv.setImage(imagen);
    }
    
    public static Image ajustarTamañoImagen(Image imagen, double ancho, double alto){
        ImageView vistaPrevia = new ImageView(imagen);
        vistaPrevia.setFitWidth(ancho);
        vistaPrevia.setFitHeight(alto);
        return vistaPrevia.snapshot(null, null);
    }
    
    public static void eliminarImagenVehiculoEliminado(String placa){
        String nombreImagen = placa+".png";
        String rutaProyecto = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
        String directorioProyecto = rutaProyecto + File.separator + "imagenesVehiculos";        
        Path rutaImagen = Paths.get(directorioProyecto, nombreImagen);
        Path pathImagen = Paths.get(rutaImagen.toString());
        try{
            if(Files.exists(pathImagen)){
                Files.delete(pathImagen);
            } else{}
        } catch(IOException e){
            UtileriaMensajes.generarAlertaError("Error", "No se ha podido eliminar la imagen.");
        }
    }
    
    public static ArrayList<String> getTipos(ArrayList<Vehiculo> vehiculos){
        ArrayList<String> tipos = new ArrayList<>();
        Vehiculo v;
        for (int i = 0; i < vehiculos.size(); i++){
            if (!tipos.contains(vehiculos.get(i).getTipo())){
                tipos.addLast(vehiculos.get(i).getTipo());
            }
        }
        return tipos;
    }
    
    public static ArrayList<String> getMarcas(ArrayList<Vehiculo> vehiculos){
        ArrayList<String> marcas = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++){
            if (!marcas.contains(vehiculos.get(i).getMarca())){
                marcas.addLast(vehiculos.get(i).getMarca());
            }
        }
        return marcas;
    }
    
    public static ArrayList<String> getModelos(ArrayList<Vehiculo> vehiculos){
        ArrayList<String> modelos = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++){
            if (!modelos.contains(vehiculos.get(i).getModelo())){
                modelos.addLast(vehiculos.get(i).getModelo());
            }
        }
        return modelos;
    }
    
    public static int contarTipos(ArrayList<Vehiculo> vehiculos, String tipo){
        int contabilizado = 0;
        for (Vehiculo v : vehiculos){
            if(v.getTipo().equals(tipo))
                contabilizado++;
        }
        return contabilizado;
    }
    
    public static void verificarPertenencia(Usuario usuario, Vehiculo vehiculo, Button btn){
        if(vehiculo.getPropietario().getCorreo().equals(usuario.getCorreo())){
            btn.setVisible(true);
        } else{
            btn.setVisible(false);
        }      
    }
    
    public static boolean otorgarPermisos(Usuario usuario, Vehiculo vehiculo){
        return vehiculo.getPropietario().getCorreo().equals(usuario.getCorreo());
    }
    
    public static void eliminarMiVehiculo(Usuario usuario, Vehiculo vehiculo, ArrayList<Vehiculo> vehiculos){
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculo.getPlaca().equals(vehiculos.get(i).getPlaca())){
               vehiculos.remove(i);
               eliminarImagenVehiculoEliminado(vehiculo.getPlaca());  // Eliminar foto del vehículo
            }
        }
        Vehiculo.saveListVehiculosSer(vehiculos);
        
        for(int i = 0; i < usuario.getVehiculos().size(); i++){
            ArrayList<Vehiculo> vehiculosUsuario = usuario.getVehiculos();
            if(vehiculo.getPlaca().equals(vehiculosUsuario.get(i).getPlaca())){
                vehiculosUsuario.remove(i);
            }
        }
    }
    
    public static void eliminarVfavorito(Usuario usuario, Vehiculo vehiculo){
        ArrayList<Vehiculo> lFavoritos = usuario.getFavoritos();
        for(int i = 0; i < lFavoritos.size(); i++){
            if(vehiculo.getPlaca().equals(lFavoritos.get(i).getPlaca())){
                lFavoritos.remove(i);
                usuario.setFavoritos(lFavoritos);
            }
        }
    }
    
    public static void eliminarFavoritoOtrosUsuarios(ArrayList<Usuario> usuarios, Vehiculo vehiculo){
        for (Usuario u : usuarios){
            for(Vehiculo v : u.getFavoritos()){
                if(vehiculo.equals(v))
                    u.getFavoritos().remove(v);
            }
        }
    }
}
