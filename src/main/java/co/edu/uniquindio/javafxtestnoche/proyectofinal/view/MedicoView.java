package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.MedicoController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicoView extends Application {

    private final Medico medico = new Medico("M-001", "Dra. Ana Torres", "ana@uq.edu.co", "3123456789", "Pediatría");
    private final MedicoController controller = new MedicoController(medico);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Médico - Hospital UQ");

        Label lblBienvenida = new Label("🩺 Bienvenido, " + medico.getNombre());

        Button btnVerCitas = new Button("Ver Citas Asignadas");
        Button btnVerHistorial = new Button("Consultar Historial Médico");
        Button btnRegistrarDiagnostico = new Button("Registrar Diagnóstico");
        Button btnSalir = new Button("Cerrar Sesión");

        btnVerCitas.setOnAction(e -> controller.verCitasAsignadas());

        btnVerHistorial.setOnAction(e -> {
            if (!medico.getCitasAsignadas().isEmpty()) {
                Paciente paciente = medico.getCitasAsignadas().get(0).getPaciente();
                controller.consultarHistorial(paciente.getHistorial());
            }
        });

        btnRegistrarDiagnostico.setOnAction(e -> {
            if (!medico.getCitasAsignadas().isEmpty()) {
                Paciente paciente = medico.getCitasAsignadas().get(0).getPaciente();
                HistorialMedico historial = paciente.getHistorial();

                TextInputDialog diagDialog = new TextInputDialog();
                diagDialog.setTitle("Registrar Diagnóstico");
                diagDialog.setHeaderText("Ingrese el diagnóstico:");
                diagDialog.setContentText("Diagnóstico:");

                diagDialog.showAndWait().ifPresent(diagnostico -> {
                    TextInputDialog tratDialog = new TextInputDialog();
                    tratDialog.setTitle("Registrar Tratamiento");
                    tratDialog.setHeaderText("Ingrese el tratamiento:");
                    tratDialog.setContentText("Tratamiento:");

                    tratDialog.showAndWait().ifPresent(tratamiento -> {
                        controller.registrarDiagnostico(historial, diagnostico, tratamiento);
                    });
                });
            }
        });

        btnSalir.setOnAction(e -> stage.close());

        VBox root = new VBox(15, lblBienvenida, btnVerCitas, btnVerHistorial, btnRegistrarDiagnostico, btnSalir);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #e6f7ff;");

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
