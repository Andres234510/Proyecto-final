package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CitaFormView {

    public void mostrarFormulario(Paciente paciente, List<Medico> medicosDisponibles) {
        Stage stage = new Stage();
        stage.setTitle("Solicitar Cita Médica");

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20;");

        Label titulo = new Label("Solicitar Nueva Cita");
        TextField txtMotivo = new TextField();
        txtMotivo.setPromptText("Motivo de la cita");

        ComboBox<Medico> cmbMedicos = new ComboBox<>();
        cmbMedicos.getItems().addAll(medicosDisponibles);
        cmbMedicos.setPromptText("Seleccione un médico");

        Button btnSolicitar = new Button("Solicitar Cita");
        btnSolicitar.setOnAction(e -> {
            String motivo = txtMotivo.getText();
            Medico medicoSeleccionado = cmbMedicos.getValue();

            if (motivo.isBlank() || medicoSeleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Debe ingresar el motivo y seleccionar un médico.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            new PacienteController(paciente).solicitarCita(motivo, medicoSeleccionado);
            stage.close();
        });

        root.getChildren().addAll(titulo, txtMotivo, cmbMedicos, btnSolicitar);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
}
