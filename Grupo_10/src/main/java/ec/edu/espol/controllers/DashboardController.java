/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Usuario;
import ec.edu.espol.util.UtileriaFunciones;
import ec.edu.espol.util.UtileriaMensaje;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omits
 */
public class DashboardController implements Initializable {

    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button btnSeccionPrincipal;
    @FXML
    private Button btnSeccionVer;
    @FXML
    private Button btnSeccionAgregar;
    @FXML
    private AnchorPane dashboardPrincipal;
    @FXML
    private Label lblCantAutos;
    @FXML
    private Label lblCantMotos;
    @FXML
    private Label lblCantCamionetas;
    @FXML
    private AnchorPane dashboardVV;
    @FXML
    private TableView<?> tvVehiculo;
    @FXML
    private TableColumn<?, ?> tvColTipo;
    @FXML
    private TableColumn<?, ?> tvColPlaca;
    @FXML
    private TableColumn<?, ?> tvColMarca;
    @FXML
    private TableColumn<?, ?> tvColModelo;
    @FXML
    private TableColumn<?, ?> tvColPrecio;
    @FXML
    private TableColumn<?, ?> tvColKm;
    @FXML
    private ComboBox<?> cbxFTipo;
    @FXML
    private ComboBox<?> cbxFMarca;
    @FXML
    private ComboBox<?> cbxFModelo;
    @FXML
    private ComboBox<?> cbxFPrecio;
    @FXML
    private ImageView imFVehiculo;
    @FXML
    private AnchorPane dashboardAV;
    @FXML
    private ImageView imVehiculo;
    @FXML
    private ComboBox<?> cbxTipo;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtKm;
    @FXML
    private TextField txtPrecio;
    
    private Usuario usuarioActual;
    
    private double x = 0;
    private double y = 0;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setUsuario(Usuario u){
        this.usuarioActual = u;
        lblNombreUsuario.setText(usuarioActual.getNombre());
    }


    
    @FXML
    private void fnSalir(MouseEvent event) {
        UtileriaFunciones.salirPantallaT(event);
    }

    @FXML
    public void fnCerrarSesion(MouseEvent event) {
        if(UtileriaMensaje.generarAlertaConfirmacion("Cerrar sesión", "¿Está seguro de cerrar su sesión?")){
            UtileriaFunciones.cambiarEscena(event, "login");
        }
    }

    @FXML
    private void fnFiltrar(MouseEvent event) {
    }

    @FXML
    private void fnLimpiarFiltro(MouseEvent event) {
    }

    @FXML
    private void fnImportarImagen(MouseEvent event) {
    }

    @FXML
    private void fnAgregarVehiculo(MouseEvent event) {
    }

    @FXML
    private void fnEliminarVehiculo(MouseEvent event) {
    }

    @FXML
    private void fnActualizarInfoVehiculo(MouseEvent event) {
    }

    @FXML
    private void fnLimpiar(MouseEvent event) {
    }
    
}
