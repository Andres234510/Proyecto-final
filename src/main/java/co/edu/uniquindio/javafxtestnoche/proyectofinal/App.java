package co.edu.uniquindio.javafxtestnoche.proyectofinal;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.LoginView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Iniciar la vista del login
            new MainView().start(primaryStage);
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Lanza la aplicación JavaFX
    }
}
