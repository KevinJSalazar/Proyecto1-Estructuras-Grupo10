package ec.edu.espol.grupo_10;

import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage st;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login").load(), 640, 480);
        stage.setTitle("Proyecto Grupo_10");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
        System.out.println(Usuario.readFileSer());
        System.out.println(Vehiculo.readFileSer());
        launch();
    }

}