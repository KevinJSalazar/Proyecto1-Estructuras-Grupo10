package ec.edu.espol.grupo_10;

//import ec.edu.espol.model.Usuario;
//import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Usuario;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
    
    static void setRoot(String fxml) throws IOException {
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
        for (Usuario u : Usuario.readFileSer())
            System.out.println(u);
        
        String filePath = "usuarios.ser";

        // Crea un objeto File con la ruta especificada
        File file = new File(filePath);

        // Verifica si el archivo existe
        if (file.exists()) {
            System.out.println("El archivo usuarios.ser existe en la ubicación especificada.");
        } else {
            System.out.println("El archivo usuarios.ser no existe en la ubicación especificada.");
        }
        launch();
    }
    
//    @Override
//    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        Scene scene1 = new Scene(root);
//        
//        stage.initStyle(StageStyle.UNDECORATED);
//        
//        root.setOnMousePressed((MouseEvent event) -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//        
//        root.setOnMouseDragged((MouseEvent event) -> {
//            stage.setX(event.getScreenX()- xOffset);
//            stage.setY(event.getScreenY()- yOffset);
//        });
//        
//        stage.setScene(scene1);
//        stage.show();
//    }




//    private static Scene scene;
//    private static Stage st;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("login").load(), 700, 500);
//        stage.setTitle("Proyecto Grupo_10");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    public static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml).load());
//    }
//    
//    public static FXMLLoader loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader;
//    }
//    
//    public static void setScene(Scene sc) throws IOException {
//        st.setScene(sc);
//    }

//    public static void main(String[] args) {
//        System.out.println(Usuario.readFileSer());
//        System.out.println(Vehiculo.readFileSer());
//        launch();
//    }

}