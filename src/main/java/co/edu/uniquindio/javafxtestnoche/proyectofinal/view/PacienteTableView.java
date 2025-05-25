package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.PacienteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PacienteTableView {
    public void mostrarTabla() {
        Stage stage = new Stage();
        stage.setTitle("Lista de Pacientes");

        TableView<Paciente> table = new TableView<>();
        ObservableList<Paciente> data = FXCollections.observableArrayList(PacienteService.listar());

        TableColumn<Paciente, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getId()));

        TableColumn<Paciente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getNombre()));

        TableColumn<Paciente, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getCorreo()));

        TableColumn<Paciente, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getDireccion()));

        table.getColumns().addAll(colId, colNombre, colCorreo, colDireccion);
        table.setItems(data);

        Button btnEliminar = new Button("Eliminar Paciente");
        Button btnEditar = new Button("Editar Paciente");

        btnEliminar.setOnAction(e -> {
            Paciente seleccionado = table.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                new PacienteController().eliminarPaciente(seleccionado);
                table.setItems(FXCollections.observableArrayList(PacienteService.listar()));
            }
        });

        btnEditar.setOnAction(e -> {
            Paciente seleccionado = table.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                new PacienteFormView().mostrarFormulario(seleccionado);
                stage.close();
            }
        });

        VBox root = new VBox(10, table, btnEditar, btnEliminar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}
