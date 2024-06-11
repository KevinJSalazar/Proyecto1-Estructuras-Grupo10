package ec.edu.espol.grupo_10;

import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.ArrayList;
import ec.edu.espol.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import static javafx.application.Application.launch;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    
    private static Scene scene;
    private static Stage st;


    @Override
    public void start(Stage stage) throws IOException {
        st = stage;
        scene = new Scene(loadFXML("login").load(), 700, 500);
        stage.initStyle(StageStyle.UNDECORATED);
        
        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        
        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX()- xOffset);
            stage.setY(event.getScreenY()- yOffset);
        });
        
        stage.setScene(scene);
        stage.show();
    }
        
    public static Stage getStage(){
        return st;
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }
    
    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    public static void setScene(Scene sc) throws IOException {
        st.setScene(sc);
    }

    public static void main(String[] args) {
//        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
//        Usuario u0 = new Usuario("Kevin", "Salazar", "kevjoel200@gmail.com", "a");
//        Usuario u1 = new Usuario("Joel", "Rodriguez", "joelk120r@gmail.com", "a");
//        Usuario u2 = new Usuario("Steven", "Lino", "stevenlino2017@gmail.com", "a");
//        
//        Usuario[] usuarios = {u0, u1, u2};
//        String[] marcas = {"TOYOTA", "NISAN", "CHEVROLET", "HONDA"};
//        String[] modelos = {"GRANDE", "PEQUEÑO", "MEDIANO", "SUPER"};
//        String[] tipos = {"Camioneta", "Carro", "Moto"};
//        
//        String placa, marca, modelo, tipo;
//        int precio; int kilometraje;
//        Usuario usuario; Vehiculo vehiculo;
//        for (int i = 1; i <= 20; i++){
//            marca = marcas[new Random().nextInt(marcas.length)];
//            modelo = modelos[new Random().nextInt(modelos.length)];
//            tipo = tipos[new Random().nextInt(tipos.length)];
//            usuario = usuarios[new Random().nextInt(usuarios.length)];
//            precio = new Random().nextInt(19);
//            kilometraje = new Random().nextInt(20);
//            vehiculo = new Vehiculo(""+i, marca, modelo, tipo, precio+1, kilometraje, usuario);
//            vehiculos.addLast(vehiculo);
//            usuario.getVehiculos().addLast(vehiculo);
//        }
//        for(Vehiculo v : vehiculos){
//            System.out.println(v);
//        }
//        
//        System.out.println("//////////////////");
//        
//        ArrayList<Vehiculo> vehfiltrados = Vehiculo.filtrarVehiculos(vehiculos, "", "TOYOTA", "", 1, 20, 0, 20);
//        for(Vehiculo v : vehfiltrados){
//            System.out.println(v);
//        }
//        
//        System.out.println("//////////////////");
//        
//        for(Vehiculo v : u1.getVehiculos()){
//            System.out.println(v);
//        }
//        
//        ArrayList<Usuario> usuariosAL = new ArrayList<>();
//        usuariosAL.addLast(u1);
//        usuariosAL.addLast(u2);
//        usuariosAL.addLast(u0);
//        Vehiculo.saveListVehiculosSer(vehiculos);
//        Usuario.saveListUsuariosSer(usuariosAL);

        for (Vehiculo v : Vehiculo.readFileSer()){
            System.out.println(v);
        }
        for (Usuario u : Usuario.readFileSer()){
            System.out.println(u);
        }

        launch();
    }
}