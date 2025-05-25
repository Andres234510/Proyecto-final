package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.HistorialMedicoController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistorialMedicoTableView {

    public void mostrarTabla() {
        Stage stage = new Stage();
        stage.setTitle("Historial Médico");

        HistorialMedicoController controller = new HistorialMedicoController();
        ObservableList<HistorialMedico> data = FXCollections.observableArrayList(controller.obtenerTodos());

        TableView<HistorialMedico> table = new TableView<>(data);

        TableColumn<HistorialMedico, String> colIdPaciente = new TableColumn<>("ID Paciente");
        colIdPaciente.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getPaciente().getId()));

        TableColumn<HistorialMedico, String> colEntradas = new TableColumn<>("Entradas");
        colEntradas.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getEntradas().toString()));

        table.getColumns().addAll(colIdPaciente, colEntradas);

        Button btnEliminar = new Button("Eliminar Historial");
        btnEliminar.setOnAction(e -> {
            HistorialMedico seleccionado = table.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                controller.eliminarHistorial(seleccionado);
                table.setItems(FXCollections.observableArrayList(controller.obtenerTodos()));
            }
        });

        VBox root = new VBox(10, table, btnEliminar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
