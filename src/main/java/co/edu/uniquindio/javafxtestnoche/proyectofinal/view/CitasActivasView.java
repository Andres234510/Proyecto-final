package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class CitasActivasView {

    public void mostrarCitas(Paciente paciente) {
        Stage stage = new Stage();
        stage.setTitle("Citas Activas - " + paciente.getNombre());

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        Label titulo = new Label("Tus Citas Activas");
        ListView<String> lista = new ListView<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Cita c : paciente.listarCitas()) {
            lista.getItems().add("🗓 " + c.getFecha().format(String.valueOf(formatter)) +
                    " | Motivo: " + c.getMotivo() +
                    (c.getMedico() != null ? " | Médico: " + c.getMedico().getNombre() : ""));
        }

        if (lista.getItems().isEmpty()) {
            lista.getItems().add("No tienes citas activas actualmente.");
        }

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> stage.close());

        root.getChildren().addAll(titulo, lista, btnCerrar);
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}
