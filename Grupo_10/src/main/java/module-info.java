module ec.edu.espol.grupo_10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.grupo_10 to javafx.fxml;
    exports ec.edu.espol.grupo_10;
}
