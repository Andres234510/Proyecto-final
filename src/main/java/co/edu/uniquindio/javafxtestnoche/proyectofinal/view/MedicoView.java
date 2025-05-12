package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicoView extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Médico - Hospital UQ");

        // Encabezado
        Label lblBienvenida = new Label("👨‍⚕️ Bienvenido, Doctor");

        // Botones funcionales
        Button btnVerCitas = new Button("Ver Citas Asignadas");
        Button btnVerHistorial = new Button("Consultar Historial Médico");
        Button btnRegistrarDiagnostico = new Button("Registrar Diagnóstico y Tratamiento");
        Button btnSalir = new Button("Cerrar Sesión");

        // Acciones simuladas
        btnVerCitas.setOnAction(e -> System.out.println("📋 Mostrando citas asignadas..."));
        btnVerHistorial.setOnAction(e -> System.out.println("📖 Consultando historial del paciente..."));
        btnRegistrarDiagnostico.setOnAction(e -> System.out.println("💊 Registrando diagnóstico..."));
        btnSalir.setOnAction(e -> stage.close());

        // Layout
        VBox root = new VBox(15, lblBienvenida, btnVerCitas, btnVerHistorial, btnRegistrarDiagnostico, btnSalir);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #f4f9ff;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
