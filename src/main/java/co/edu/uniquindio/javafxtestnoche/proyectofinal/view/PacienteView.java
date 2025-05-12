package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PacienteView extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Paciente - Hospital UQ");

        // Información general
        Label lblBienvenida = new Label("👋 Bienvenido, Paciente");

        // Botones de acciones
        Button btnVerHistorial = new Button("Ver Historial Médico");
        Button btnSolicitarCita = new Button("Solicitar Nueva Cita");
        Button btnCancelarCita = new Button("Cancelar Cita");
        Button btnVerCitas = new Button("Ver Mis Citas");
        Button btnSalir = new Button("Cerrar Sesión");

        // Acciones (simuladas)
        btnVerHistorial.setOnAction(e -> System.out.println("📋 Mostrando historial médico..."));
        btnSolicitarCita.setOnAction(e -> System.out.println("📅 Solicitando nueva cita..."));
        btnCancelarCita.setOnAction(e -> System.out.println("❌ Cancelando cita..."));
        btnVerCitas.setOnAction(e -> System.out.println("📖 Listando citas activas..."));
        btnSalir.setOnAction(e -> stage.close());

        // Layout
        VBox root = new VBox(15, lblBienvenida, btnVerHistorial, btnSolicitarCita, btnCancelarCita, btnVerCitas, btnSalir);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #fefefe;");

        Scene scene = new Scene(root, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
