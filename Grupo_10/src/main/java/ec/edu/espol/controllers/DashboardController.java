/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Usuario;
import ec.edu.espol.util.UtileriaFunciones;
import ec.edu.espol.util.UtileriaMensaje;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    private AnchorPane dashboardAV;
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
    FileChooser fc = new FileChooser();
    private File imgFile;
        
    @FXML
    private ImageView imMostrarVehiculo;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnAtrás;
    @FXML
    private TextArea txtAreaInfo;
    @FXML
    private ImageView imMostrarMiVehiculo;
    @FXML
    private ImageView imCargarVehiculo;
    @FXML
    private TextArea txtAreaInfoMiVeh;
    

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
    public void cambiarPestañas(ActionEvent event){
        if(event.getSource() == btnSeccionPrincipal){
            dashboardPrincipal.setVisible(true);
            dashboardVV.setVisible(false);
            dashboardAV.setVisible(false);
        } else if(event.getSource() == btnSeccionVer){
            dashboardPrincipal.setVisible(false);
            dashboardVV.setVisible(true);
            dashboardAV.setVisible(false);
        } else if(event.getSource() == btnSeccionAgregar){
            dashboardPrincipal.setVisible(false);
            dashboardVV.setVisible(false);
            dashboardAV.setVisible(true);
        } else{
            dashboardPrincipal.setVisible(true);
            dashboardVV.setVisible(false);
            dashboardAV.setVisible(false);
        }
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
        cbxFTipo.getSelectionModel().clearSelection();
        cbxFMarca.getSelectionModel().clearSelection();
        cbxFModelo.getSelectionModel().clearSelection();
        cbxFPrecio.getSelectionModel().clearSelection();
    }

    @FXML
    private void fnImportarImagen(MouseEvent event) {
        fc.setTitle("Buscar Imagen");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        
        imgFile = fc.showOpenDialog(null);
        
        if(imgFile != null)
            imCargarVehiculo.setImage(new Image(imgFile.toURI().toString()));
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
