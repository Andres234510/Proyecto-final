package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.FarmaciaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PacienteView extends Application {

    private final Paciente paciente = new Paciente("123", "Carlos Ruiz", "carlos@uq.edu.co", "3120000000", "Calle 10");
    private final PacienteController controller = new PacienteController(paciente);
    private final FarmaciaController farmaciaController = new FarmaciaController();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panel del Paciente - Hospital UQ");

        Label lblBienvenida = new Label("👤 Bienvenido, " + paciente.getNombre());

        Button btnVerHistorial = new Button("Ver Historial Médico");
        Button btnSolicitarCita = new Button("Solicitar Cita");
        Button btnCancelarCita = new Button("Cancelar Última Cita");
        Button btnVerCitas = new Button("Ver Citas Activas");
        Button btnFarmacia = new Button("Ir a Farmacia");
        Button btnSalir = new Button("Cerrar Sesión");

        btnVerHistorial.setOnAction(e -> controller.verHistorial());
        btnSolicitarCita.setOnAction(e -> controller.solicitarCita("Consulta general"));
        btnCancelarCita.setOnAction(e -> controller.cancelarUltimaCita());
        btnVerCitas.setOnAction(e -> controller.verCitas());
        btnFarmacia.setOnAction(e -> new FarmaciaView().mostrar(paciente));
        btnSalir.setOnAction(e -> stage.close());

        VBox root = new VBox(15, lblBienvenida, btnVerHistorial, btnSolicitarCita, btnCancelarCita, btnVerCitas, btnFarmacia, btnSalir);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #f0f8ff;");

        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

