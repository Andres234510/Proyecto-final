module co.edu.uniquindio.javafxtestnoche.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.javafxtestnoche.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.javafxtestnoche.proyectofinal;
}