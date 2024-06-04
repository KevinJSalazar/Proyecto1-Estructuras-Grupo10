/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import ec.edu.espol.controllers.DashboardController;
import ec.edu.espol.grupo_10.App;
import static ec.edu.espol.grupo_10.App.loadFXML;
import ec.edu.espol.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author omits
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
        imv.setImage(imagen);
    }
}
