package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminView extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Administrador - Hospital UQ");

        // Encabezado
        Label lblBienvenida = new Label("🔐 Bienvenido, Administrador");

        // Botones de acciones administrativas
        Button btnRegistrarMedico = new Button("Registrar Médico");
        Button btnEliminarMedico = new Button("Eliminar Médico");
        Button btnRegistrarPaciente = new Button("Registrar Paciente");
        Button btnEliminarPaciente = new Button("Eliminar Paciente");
        Button btnGestionSalas = new Button("Gestionar Salas y Horarios");
        Button btnVerReporte = new Button("Ver Reporte de Citas");
        Button btnSalir = new Button("Cerrar Sesión");

        // Acciones simuladas
        btnRegistrarMedico.setOnAction(e -> System.out.println("➕ Registrando nuevo médico..."));
        btnEliminarMedico.setOnAction(e -> System.out.println("🗑 Eliminando médico..."));
        btnRegistrarPaciente.setOnAction(e -> System.out.println("➕ Registrando nuevo paciente..."));
        btnEliminarPaciente.setOnAction(e -> System.out.println("🗑 Eliminando paciente..."));
        btnGestionSalas.setOnAction(e -> System.out.println("🏥 Gestionando salas y horarios..."));
        btnVerReporte.setOnAction(e -> System.out.println("📊 Mostrando reporte de citas..."));
        btnSalir.setOnAction(e -> stage.close());

        // Layout
        VBox root = new VBox(15,
                lblBienvenida,
                btnRegistrarMedico,
                btnEliminarMedico,
                btnRegistrarPaciente,
                btnEliminarPaciente,
                btnGestionSalas,
                btnVerReporte,
                btnSalir
        );
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #fff5f5;");

        Scene scene = new Scene(root, 450, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
