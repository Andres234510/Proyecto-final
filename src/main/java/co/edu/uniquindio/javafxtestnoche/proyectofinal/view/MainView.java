package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Gestión Hospitalaria - Hospital UQ");

        // Botones para cada tipo de usuario
        Button btnPaciente = new Button("Ingresar como Paciente");
        Button btnMedico = new Button("Ingresar como Médico");
        Button btnAdmin = new Button("Ingresar como Administrador");

        // Acciones (en el futuro, se conectan con controladores)
        btnPaciente.setOnAction(e -> System.out.println("🔓 Acceso como Paciente"));
        btnMedico.setOnAction(e -> System.out.println("🔓 Acceso como Médico"));
        btnAdmin.setOnAction(e -> System.out.println("🔓 Acceso como Administrador"));

        // Layout
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 40; -fx-alignment: center; -fx-background-color: #f0f8ff;");
        root.getChildren().addAll(btnPaciente, btnMedico, btnAdmin);

        // Escena
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método principal (requerido para lanzar JavaFX)
    public static void main(String[] args) {
        launch(args);
    }
}
