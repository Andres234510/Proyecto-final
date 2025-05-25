package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class HistorialMedicoView {

    public void mostrarHistorial(Paciente paciente) {
        Stage stage = new Stage();
        stage.setTitle("Historial Médico - " + paciente.getNombre());

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        Label titulo = new Label("Historial Médico con Atención de Profesionales");
        ListView<String> lista = new ListView<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Cita cita : paciente.listarCitas()) {
            if (cita.getMedico() != null && cita.getDiagnostico() != null) {
                String entrada = "🩺 " + cita.getMedico().getNombre() +
                        " | Diagnóstico: " + cita.getDiagnostico() +
                        " | Tratamiento: " + cita.getTratamiento() +
                        " | Fecha: " + cita.getFecha().format(String.valueOf(formatter));
                lista.getItems().add(entrada);
            }
        }

        if (lista.getItems().isEmpty()) {
            lista.getItems().add("No hay registros disponibles aún.");
        }

        root.getChildren().addAll(titulo, lista);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
