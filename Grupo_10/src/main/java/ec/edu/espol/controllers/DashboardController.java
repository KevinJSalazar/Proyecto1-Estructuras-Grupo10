/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.ArrayList;
import ec.edu.espol.model.NegativeNumberException;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.util.UtileriaFunciones;
import ec.edu.espol.util.UtileriaMensaje;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
    private ComboBox<String> cbxFTipo;
    @FXML
    private ComboBox<String> cbxFMarca;
    @FXML
    private ComboBox<String> cbxFModelo;
    @FXML
    private ComboBox<String> cbxFPrecio;
    @FXML
    private AnchorPane dashboardAV;
    @FXML
    private ComboBox<String> cbxTipo;
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
        cbxTipo.getItems().addAll("Carro", "fdf", "Opción 3");
        cbxTipo.getSelectionModel().selectFirst();
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
//        try{
//            if(((String)this.minPrecio.getText()).equals(""))
//                precioMin = 1;
//            else precioMin = Integer.parseInt((String)this.minPrecio.getText());
//
//            if(((String)this.maxPrecio.getText()).equals(""))
//                precioMax = Integer.MAX_VALUE;
//            else precioMax = Integer.parseInt((String)this.maxPrecio.getText());
//
//            if(((String)this.minAño.getText()).equals(""))
//                añoMin = 1;
//            else añoMin = Integer.parseInt((String)this.minAño.getText());
//
//            if(((String)this.maxAño.getText()).equals(""))
//                añoMax = Integer.MAX_VALUE;
//            else añoMax = Integer.parseInt((String)this.maxAño.getText());
//
//            if(((String)this.minRec.getText()).equals(""))
//                recorridoMin = 0;
//            else recorridoMin = Double.parseDouble((String)this.minRec.getText());
//
//            if(((String)this.maxRec.getText()).equals(""))
//                recorridoMax = Double.MAX_VALUE;
//            else recorridoMax = Double.parseDouble((String)this.maxRec.getText());
//            
//            if((String)cbTipoVeh.getValue() != null)
//                tipo = (String)cbTipoVeh.getValue();
//            mostrarVehiculos(Vehiculo.filtrarVehiculos(vehiculos, tipo, recorridoMin, recorridoMax, añoMin, añoMax, precioMin, precioMax)); 
//            mostrarImagenesVehiculos(Vehiculo.filtrarVehiculos(vehiculos, tipo, recorridoMin, recorridoMax, añoMin, añoMax, precioMin, precioMax));
//        } catch(NegativeNumberException nn){
//            Alert mensaje = new Alert(Alert.AlertType.ERROR, "Ingrese valores numéricos válidos.");
//            mensaje.show();
//        } catch(NumberFormatException n){
//            Alert mensaje = new Alert(Alert.AlertType.ERROR, "Ingrese valores numéricos válidos.");
//            mensaje.show();
//        } catch(Exception ex){
//            Alert mensaje = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un error.");
//            mensaje.show();
//        }
    }

    @FXML
    private void fnLimpiarFiltro(MouseEvent event) {
    }

    @FXML
    private void fnImportarImagen(MouseEvent event) {
    }

    @FXML
    private void fnAgregarVehiculo(MouseEvent event) {
        String placa = (String)this.txtPlaca.getText();
        String marca = (String)this.txtMarca.getText();
        String modelo = (String)this.txtModelo.getText();
        String tipo = (String)this.cbxTipo.getItems().toString();
        String stKilometraje = (String)this.txtKm.getText();
        String stPrecio = (String)this.txtPrecio.getText();
        
        if(placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || tipo.isEmpty() || stKilometraje.isEmpty() || stPrecio.isEmpty()){
            UtileriaMensaje.generarAlertaError("Información incompleta", "Debe rellenar todos los campos obligatoriamente");
        }
        else{
            ArrayList<Vehiculo> vehiculosReg = Vehiculo.readFileSer();
            double kilometraje = Double.parseDouble(stKilometraje);
            int precion = Integer.parseInt(stPrecio);
            Vehiculo newVehiculo = new Vehiculo(placa, marca, modelo, tipo, precion, kilometraje, usuarioActual);
            vehiculosReg.addLast(newVehiculo);
            Vehiculo.saveListVehiculosSer(vehiculosReg);
        }
    }

    @FXML
    private void fnEliminarVehiculo(MouseEvent event) {
    }

    @FXML
    private void fnActualizarInfoVehiculo(MouseEvent event) {
        ArrayList<Vehiculo> vehiculosReg = Vehiculo.readFileSer();
        String placa = (String)this.txtPlaca.getText();
        if (Vehiculo.checkPlaca(vehiculosReg, placa)){
            Vehiculo vehiculoAct = Vehiculo.filtrarPlaca(vehiculosReg, placa);
            String marca = (String)this.txtMarca.getText();
            String modelo = (String)this.txtModelo.getText();
            String tipo = (String)this.cbxTipo.getItems().toString();
            String stKilometraje = (String)this.txtKm.getText();
            String stPrecio = (String)this.txtPrecio.getText();
            
            if (!marca.isEmpty()){
                vehiculoAct.setMarca(marca);
            }
            if (!modelo.isEmpty()){
                vehiculoAct.setModelo(modelo);
            }
            if (!tipo.isEmpty()){
                vehiculoAct.setTipo(tipo);
            }
            if (!stKilometraje.isEmpty()){
                double kilometraje = Double.parseDouble(stKilometraje);
                vehiculoAct.setKilometraje(kilometraje);
            }
            if (!stPrecio.isEmpty()){
                int precion = Integer.parseInt(stPrecio);
                vehiculoAct.setPrecio(precion);
            }
        }
    }

    @FXML
    private void fnLimpiar(MouseEvent event) {
        cbxTipo.getSelectionModel().clearSelection();
        txtPrecio.clear();
        txtModelo.clear();
        txtKm.clear();
        txtPlaca.clear();
        txtMarca.clear();
    }
    
}
