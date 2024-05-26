/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import javafx.scene.control.Alert;

/**
 *
 * @author omits
 */
public class UtileriaMensaje {
    public static void generarAlertaInfo(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alerta.setTitle(titulo.toUpperCase());
        alerta.setHeaderText(null);
        alerta.show();
    }
    
    public static void generarAlertaError(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR, mensaje);
        alerta.setTitle(titulo.toUpperCase());
        alerta.setHeaderText(null);
        alerta.show();
    }
}
