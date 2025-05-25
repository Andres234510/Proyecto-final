package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.CitaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CitaTableView {

    public void mostrarTabla() {
        Stage stage = new Stage();
        stage.setTitle("Gestión de Citas");

        CitaController controller = new CitaController();
        ObservableList<Cita> data = FXCollections.observableArrayList(controller.obtenerTodas());

        TableView<Cita> table = new TableView<>(data);

        TableColumn<Cita, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getId()));

        TableColumn<Cita, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getFechaHora().toString()));

        TableColumn<Cita, String> colPaciente = new TableColumn<>("Paciente");
        colPaciente.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getPaciente().getNombre()));

        TableColumn<Cita, String> colMotivo = new TableColumn<>("Motivo");
        colMotivo.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getMotivo()));

        table.getColumns().addAll(colId, colFecha, colPaciente, colMotivo);

        Button btnEliminar = new Button("Eliminar Cita");
        btnEliminar.setOnAction(e -> {
            Cita seleccionada = table.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                controller.eliminarCita(seleccionada);
                table.setItems(FXCollections.observableArrayList(controller.obtenerTodas()));
            }
        });

        VBox root = new VBox(10, table, btnEliminar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
