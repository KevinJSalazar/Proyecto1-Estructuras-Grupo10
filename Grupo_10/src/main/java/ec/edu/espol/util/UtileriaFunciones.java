/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import ec.edu.espol.grupo_10.App;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author omits
 */
public class UtileriaFunciones {
    
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
    
    public static boolean verificarCondiciones(Boolean b){
        return b == false;
    }
}
