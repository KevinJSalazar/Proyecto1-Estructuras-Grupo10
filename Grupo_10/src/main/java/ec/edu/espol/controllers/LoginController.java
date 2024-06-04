/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.ArrayList;
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
public class LoginController implements Initializable {

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contraseña;
    
    ArrayList<Usuario> usuarios;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.usuarios = Usuario.readFileSer();
    }    
    
    @FXML
    private void login(MouseEvent event) {
        String usuario = (String)this.usuario.getText();
        String contraseña = (String)this.contraseña.getText();
        if(usuario.isEmpty()|| contraseña.isEmpty())
            UtileriaMensaje.generarAlertaInfo("Ingreso inválido", "Debe ingresar su usuario y contraseña.");
         // Por medios prácticos, simplemente haremos lo siguiente
        else{
            if(Usuario.verificarCuenta(usuarios, usuario, contraseña)){
                if(UtileriaMensaje.generarAlertaConfirmacion("Acceso permitido", "Permiso concedido. ¡Usuario correcto!")){
                    Usuario usuarioCuenta = Usuario.filtrarUsuario(usuarios, usuario);
                    UtileriaFunciones.cambiarDashboardPrincipal(usuarioCuenta);
                }
            } else{
                UtileriaMensaje.generarAlertaError("Ingreso inválido", "Usuario y/o contraseña incorrectos.");
            }
        }
    }

    @FXML
    public void fnSalir(MouseEvent event) {
        UtileriaFunciones.salirPantallaB(event);
    }

    @FXML
    private void fnRegistrar(MouseEvent event) {
        UtileriaFunciones.cambiarEscena(event, "register");
    }

    







    
}
