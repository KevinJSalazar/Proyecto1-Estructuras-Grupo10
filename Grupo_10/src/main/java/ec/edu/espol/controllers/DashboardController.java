/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.ArrayList;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.util.UtileriaFunciones;
import ec.edu.espol.util.UtileriaMensaje;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

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
    private TableView<Vehiculo> tvVehiculo;
    @FXML
    private TableColumn<Vehiculo, String> tvColTipo;
    @FXML
    private TableColumn<Vehiculo, String> tvColPlaca;
    @FXML
    private TableColumn<Vehiculo, String> tvColMarca;
    @FXML
    private TableColumn<Vehiculo, String> tvColModelo;
    @FXML
    private TableColumn<Vehiculo, Double> tvColPrecio;
    @FXML
    private TableColumn<Vehiculo, Integer> tvColKm;
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
    
    // ATRIBUTOS NO FXML
    private ObservableList obListVehiculos;
    
    private Usuario usuarioActual;
    FileChooser fc = new FileChooser();
    private File imgFile;
    private File imgCargarFile;
    private ArrayList<Vehiculo> vehiculos;
    private int indiceActual = 0;
    // ATRIBUTOS NO FXML
    
    @FXML
    private ImageView imMostrarVehiculo;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnAtrás;
    @FXML
    private Text txtAreaInfo;
    @FXML
    private ImageView imMostrarMiVehiculo;
    @FXML
    private ImageView imCargarVehiculo;
    @FXML
    private Text txtAreaInfoMiVeh;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxTipo.getItems().addAll("Carro", "Camioneta", "Moto");
        cargarFiltros();
        vehiculos = Vehiculo.readFileSer();
        navegarEnLista(vehiculos);
    }

    public void setUsuario(Usuario u){
        this.usuarioActual = u;
        lblNombreUsuario.setText(usuarioActual.getNombre());
    }
    
    public void navegarEnLista(ArrayList<Vehiculo> vehiculos){
        indiceActual = 0;
        actualizarVehiculo(vehiculos.get(indiceActual));

        btnSiguiente.setDisable(vehiculos.isEmpty());
        btnAtrás.setDisable(true);

        btnSiguiente.setOnAction(event -> {
            indiceActual++;
            if (indiceActual >= vehiculos.size()) {
                indiceActual = 0;
            }
            actualizarVehiculo(vehiculos.get(indiceActual));
        });

        btnAtrás.setOnAction(event -> {
            indiceActual--;
            if (indiceActual < 0) {
                indiceActual = vehiculos.size() - 1; 
            }
            actualizarVehiculo(vehiculos.get(indiceActual));
        });       
    }

    private void actualizarVehiculo(Vehiculo vehiculo) {
        UtileriaFunciones.mostrarImagen(vehiculo.getPlaca(), imgFile, imMostrarVehiculo);
        String mensaje = UtileriaFunciones.crearMensajeAuto(vehiculo.getTipo(), vehiculo.getPlaca(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getPrecio(), vehiculo.getKilometraje());
        txtAreaInfo.setText(mensaje);
        btnAtrás.setDisable(vehiculos.size() <= 1); 
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
            cargarVehiculos();
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

//    @FXML
//    private void fnFiltrar(MouseEvent event) {
//        String tipo = this.cbxFTipo.getSelectionModel().getSelectedItem();
//        String marca = this.cbxFMarca.getSelectionModel().getSelectedItem();
//        String modelo = this.cbxFModelo.getSelectionModel().getSelectedItem();
//        String precio = this.cbxFPrecio.getSelectionModel().getSelectedItem();
////        String kilometraje = this.cbxFKilometraje.getSelectionModel().getSelectedItem();
//        int precioMin, precioMax;
//        double kilometrajeMin, kilometrajeMax;
//        try{
//            if(precio.isEmpty()){
//                precioMin = 1; precioMax = Integer.MAX_VALUE;
//            } else if (precio.contains("+")){
//                precioMin = Integer.parseInt(precio.split("\\+")[0]);
//                precioMax = Integer.MAX_VALUE;
//            } else{
//                String[] precios = precio.split(" - ");
//                precioMin = Integer.parseInt(precios[0]);
//                precioMax = Integer.parseInt(precios[1]);
//            }
//            
//            if(kilometraje.isEmpty()){
//                kilometrajeMin = 1; kilometrajeMax = Integer.MAX_VALUE;
//            } else if (precio.contains("+")){
//                kilometrajeMin = Double.parseDouble(precio.split("\\+")[0]);
//                kilometrajeMax = Double.MAX_VALUE;
//            } else{
//                String[] precios = precio.split(" - ");
//                kilometrajeMin = Double.parseDouble(precios[0]);
//                kilometrajeMax = Double.parseDouble(precios[1]);
//            }
            
//            if((String)cbTipoVeh.getValue() != null)
//                tipo = (String)cbTipoVeh.getValue();
//            
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
//    }

    @FXML
    private void fnLimpiarFiltro(MouseEvent event) {
        cbxFTipo.getSelectionModel().clearSelection();
        cbxFMarca.getSelectionModel().clearSelection();
        cbxFModelo.getSelectionModel().clearSelection();
        cbxFPrecio.getSelectionModel().clearSelection();
//        cbxFKilometraje.getSelectionModel().clearSelection();
    }

    @FXML
    private void fnImportarImagen(MouseEvent event) {
        fc.setTitle("Buscar Imagen");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        
        imgCargarFile = fc.showOpenDialog(null);
        
        if(imgCargarFile != null)
            imCargarVehiculo.setImage(new Image(imgCargarFile.toURI().toString()));
    }

    @FXML
    private void fnAgregarVehiculo(MouseEvent event) throws IOException {
        ArrayList<Vehiculo> vehiculosReg = Vehiculo.readFileSer();
        String placa = (String)this.txtPlaca.getText();
        String marca = (String)this.txtMarca.getText();
        String modelo = (String)this.txtModelo.getText();
        String tipo = (String)this.cbxTipo.getSelectionModel().getSelectedItem();
        String stKilometraje = (String)this.txtKm.getText();
        String stPrecio = (String)this.txtPrecio.getText();
        
        if(placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || tipo.isEmpty() || stKilometraje.isEmpty() || stPrecio.isEmpty()){
            UtileriaMensaje.generarAlertaError("Información incompleta", "Debe rellenar todos los campos obligatoriamente");
        }
        else if(Vehiculo.checkPlaca(vehiculosReg, placa)){
            UtileriaMensaje.generarAlertaError("Vehiculo existente", "La placa del vehículo que intenta agregar ya se encuentra registrada");
        }
        else {
            try{
                double kilometraje; int precio;
                if(UtileriaFunciones.verificacionesNumericas(stKilometraje) && UtileriaFunciones.verificacionesNumericas(stPrecio)){
                    kilometraje = Double.parseDouble(stKilometraje);
                    precio = Integer.parseInt(stPrecio);
                    if(UtileriaMensaje.generarAlertaConfirmacion("Confirmar registro", "¿Está seguro de registrar este vehiculo?")){
                        Vehiculo newVehiculo = new Vehiculo(placa, marca, modelo, tipo, precio, kilometraje, usuarioActual);
                        UtileriaFunciones.guardarImagen(imgCargarFile, placa);
                        vehiculosReg.addLast(newVehiculo);
                        Vehiculo.saveListVehiculosSer(vehiculosReg);
                        UtileriaMensaje.generarAlertaInfo("Registro exitoso", "¡El vehiculo con placa "+ placa +" se ha registrado!");
                    }
                } else{
                    UtileriaMensaje.generarAlertaError("Valores no permitidos", "Ingrese valores válidos.");
                }  
            } catch(IOException ioe){
                    UtileriaMensaje.generarAlertaError("Falta imagen", "Suba una imagen de su vehículo.");       
            }
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
            if (!stKilometraje.isEmpty() && UtileriaFunciones.verificacionesNumericas(stKilometraje)){
                double kilometraje = Double.parseDouble(stKilometraje);
                vehiculoAct.setKilometraje(kilometraje);
            }
            if (!stPrecio.isEmpty() && UtileriaFunciones.verificacionesNumericas(stPrecio)){
                int precion = Integer.parseInt(stPrecio);
                vehiculoAct.setPrecio(precion);
            }
        } else{
            UtileriaMensaje.generarAlertaError("Vehiculo inexistente", "La placa del vehículo que intenta modificar no se encuentra registrada");
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
    
    private void cargarVehiculos(){
        obListVehiculos=FXCollections.observableArrayList();
        tvColTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tvColPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tvColMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tvColModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tvColPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tvColKm.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));
        
//        Vehiculo v1=new Vehiculo("MMM","Toyota","ni idea","Carrito",15000,19900.00,usuarioActual);
//        obListVehiculos.add(v1);
        ArrayList<Vehiculo> vehiculosSer=Vehiculo.readFileSer();
        for(int i=0;i<vehiculosSer.size();i++){
            obListVehiculos.add(vehiculosSer.get(i));
        }
        this.tvVehiculo.setItems(obListVehiculos);
    }
    
    private void cargarFiltros(){
        cbxFTipo.getItems().add("Todos");
        cbxFMarca.getItems().add("Todos");
        cbxFModelo.getItems().add("Todos");
        cbxFPrecio.getItems().addAll("Todos", "0 - 2000", "2001 - 5000" , "50001 - 8000", "8000+");
//        cbxFKilometraje.getItems().addAll("Todos", "0 - 2000", "2001 - 5000" , "50001 - 8000", "8000+");

        ArrayList<String> tipos = Vehiculo.getTipos();
        for(int i = 0; i < tipos.size(); i++){
            cbxFTipo.getItems().add(tipos.get(i));
        }
        ArrayList<String> marcas = Vehiculo.getMarcas();
        for(int i = 0; i < marcas.size(); i++){
            cbxFTipo.getItems().add(marcas.get(i));
        }
        ArrayList<String> modelos = Vehiculo.getModelos();
        for(int i = 0; i < modelos.size(); i++){
            cbxFTipo.getItems().add(modelos.get(i));
        }
    }
}
