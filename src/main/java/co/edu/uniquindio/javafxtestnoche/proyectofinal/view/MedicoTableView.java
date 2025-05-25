package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.AdminController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.MedicoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicoTableView {
    public void mostrarTabla() {
        Stage stage = new Stage();
        stage.setTitle("Lista de Médicos");

        TableView<Medico> table = new TableView<>();
        ObservableList<Medico> data = FXCollections.observableArrayList(MedicoService.listar());

        TableColumn<Medico, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getId()));

        TableColumn<Medico, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getNombre()));

        TableColumn<Medico, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getCorreo()));

        TableColumn<Medico, String> colEspecialidad = new TableColumn<>("Especialidad");
        colEspecialidad.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getEspecialidad()));

        table.getColumns().addAll(colId, colNombre, colCorreo, colEspecialidad);
        table.setItems(data);

        Button btnEliminar = new Button("Eliminar Médico");
        Button btnEditar = new Button("Editar Médico");

        btnEliminar.setOnAction(e -> {
            Medico seleccionado = table.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                new AdminController().eliminarMedico(seleccionado);
                table.setItems(FXCollections.observableArrayList(MedicoService.listar()));
            }
        });

        btnEditar.setOnAction(e -> {
            Medico seleccionado = table.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                new MedicoFormView().mostrarFormulario(seleccionado);
                stage.close();
            }
        });

        VBox root = new VBox(10, table, btnEditar, btnEliminar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}
