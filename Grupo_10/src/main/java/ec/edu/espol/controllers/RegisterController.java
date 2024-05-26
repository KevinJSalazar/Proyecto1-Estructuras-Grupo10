/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Usuario;
import ec.edu.espol.util.UtileriaFunciones;
import ec.edu.espol.util.UtileriaMensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author omits
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField correo;
    @FXML
    private PasswordField contraseña;
    @FXML
    private PasswordField repetContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnRegresar(MouseEvent event) {
        UtileriaFunciones.cambiarEscena(event, "login");
    }

    @FXML
    private void register(MouseEvent event) {
        String nombre = (String)this.nombre.getText();
        String apellido = (String)this.apellido.getText();
        String correo = (String)this.correo.getText();
        String contraseña = (String)this.contraseña.getText();
        String repetContraseña = (String)this.repetContraseña.getText();
        
        if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contraseña.isEmpty()){
            UtileriaMensaje.generarAlertaInfo("Información incompleta", "Debe rellenar todos los campos obligatoriamente");
        } else{
            if(UtileriaFunciones.verificarCondiciones(Usuario.verificarCorreo(correo)))
                UtileriaMensaje.generarAlertaInfo("Correo inválido", "Debe ingresar una dirección de correo válida. No institucional.");
            else if(UtileriaFunciones.verificarCondiciones(Usuario.verificarExtContraseña(contraseña)))
                UtileriaMensaje.generarAlertaInfo("Contraseña inválida", "Debe ingresar una contraseña entre 8 y 20 caracteres.");
            else if(UtileriaFunciones.verificarCondiciones(repetContraseña.equals(contraseña)))
                UtileriaMensaje.generarAlertaError("Contraseñas inconsistentes", "Las contraseñas no coinciden.");
            
                
            
            // Aquí implementar condición del checkCorreo()con la lista de usuario implementada por nosotros
        }
        
        
    }

    @FXML
    private void fnSalir(MouseEvent event) {
        UtileriaFunciones.salirPantallaT(event);
    }
    
}
