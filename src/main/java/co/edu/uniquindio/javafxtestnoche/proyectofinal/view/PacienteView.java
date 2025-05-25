package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
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
        Paciente pacienteDemo = new Paciente("001", "Carlos Ruiz", "carlos@uq.edu.co", "3130001111", "Calle 10");

        PacienteController controller = new PacienteController(pacienteDemo);
        btnVerHistorial.setOnAction(e -> controller.verHistorial());
        btnSolicitarCita.setOnAction(e -> controller.solicitarCita("Dolor de cabeza"));
        btnCancelarCita.setOnAction(e -> controller.cancelarUltimaCita());
        btnVerCitas.setOnAction(e -> controller.verCitas());
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
