package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.AdminController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicoFormView {
    public void mostrarFormulario(Medico medicoExistente) {
        Stage stage = new Stage();
        stage.setTitle(medicoExistente == null ? "Registrar Médico" : "Editar Médico");

        TextField txtId = new TextField();
        txtId.setPromptText("ID");
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        TextField txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");
        TextField txtEspecialidad = new TextField();
        txtEspecialidad.setPromptText("Especialidad");

        Button btnGuardar = new Button("Guardar");
        if (medicoExistente != null) {
            txtId.setText(medicoExistente.getId());
            txtNombre.setText(medicoExistente.getNombre());
            txtCorreo.setText(medicoExistente.getCorreo());
            txtTelefono.setText(medicoExistente.getTelefono());
            txtEspecialidad.setText(medicoExistente.getEspecialidad());
        }

        btnGuardar.setOnAction(e -> {
            Medico nuevo = new Medico(
                    txtId.getText(),
                    txtNombre.getText(),
                    txtCorreo.getText(),
                    txtTelefono.getText(),
                    txtEspecialidad.getText()
            );
            AdminController controller = new AdminController();
            if (medicoExistente == null) {
                controller.registrarMedico(nuevo);
            } else {
                controller.actualizarMedico(medicoExistente, nuevo);
            }
            stage.close();
        });

        VBox root = new VBox(10, txtId, txtNombre, txtCorreo, txtTelefono, txtEspecialidad, btnGuardar);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center;");

        stage.setScene(new Scene(root, 300, 350));
        stage.show();
    }
}