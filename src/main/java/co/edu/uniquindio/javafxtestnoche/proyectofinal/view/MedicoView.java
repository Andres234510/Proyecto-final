package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.MedicoController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
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
        Medico medicoDemo = new Medico("M-001", "Dra. Ana Torres", "ana@uq.edu.co", "3123456789", "Pediatría");
        MedicoController controller = new MedicoController(medicoDemo);

        btnVerCitas.setOnAction(e -> controller.verCitasAsignadas());
        btnVerHistorial.setOnAction(e -> controller.consultarHistorial(medicoDemo.getCitasAsignadas().isEmpty() ? null : medicoDemo.getCitasAsignadas().get(0).getPaciente().getHistorial()));
        btnRegistrarDiagnostico.setOnAction(e -> controller.registrarDiagnostico(medicoDemo.getCitasAsignadas().isEmpty() ? null : medicoDemo.getCitasAsignadas().get(0).getPaciente().getHistorial(), "Gripe común", "Reposo e hidratación"));

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
