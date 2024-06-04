module ec.edu.espol.grupo_10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.grupo_10 to javafx.fxml;
    exports ec.edu.espol.grupo_10;
    opens ec.edu.espol.controllers to javafx.fxml;
    exports ec.edu.espol.controllers;
    opens ec.edu.espol.model to javafx.fxml;
    exports ec.edu.espol.model;
    opens ec.edu.espol.util to javafx.fxml;
    exports ec.edu.espol.util;
}
