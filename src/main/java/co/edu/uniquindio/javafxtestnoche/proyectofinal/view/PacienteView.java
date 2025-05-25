package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.FarmaciaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class PacienteView extends Application {

    private final Paciente paciente = new Paciente("P-001", "Carlos Mendoza", "carlos@correo.com", "3104567890");
    private final PacienteController controller = new PacienteController(paciente);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Paciente - Hospital UQ");

        Label lblBienvenida = new Label("👤 Bienvenido, " + paciente.getNombre());

        Button btnSolicitarCita = new Button("Solicitar Cita");
        Button btnVerHistorial = new Button("Ver Historial Médico");
        Button btnVerCitas = new Button("Ver Citas Activas");
        Button btnFarmacia = new Button("Acceder a Farmacia");
        Button btnSalir = new Button("Cerrar Sesión");

        btnSolicitarCita.setOnAction(e -> {
            List<Medico> medicos = Arrays.asList(
                    new Medico("M-001", "Dra. Ana Torres", "ana@uq.edu.co", "3123456789", "Pediatría"),
                    new Medico("M-002", "Dr. Luis García", "luis@uq.edu.co", "3112345678", "Cardiología")
            );
            new CitaFormView().mostrarFormulario(paciente, medicos);
        });

        btnVerHistorial.setOnAction(e -> new HistorialMedicoView().mostrarHistorial(paciente));
        btnVerCitas.setOnAction(e -> new CitasActivasView().mostrarCitas(paciente));
        btnFarmacia.setOnAction(e -> controller.accederFarmacia());
        btnSalir.setOnAction(e -> stage.close());

        VBox root = new VBox(15, lblBienvenida, btnSolicitarCita, btnVerHistorial, btnVerCitas, btnFarmacia, btnSalir);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #f2fff6;");

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}