package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.PacienteController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PacienteFormView {
    public void mostrarFormulario(Paciente pacienteExistente) {
        Stage stage = new Stage();
        stage.setTitle(pacienteExistente == null ? "Registrar Paciente" : "Editar Paciente");

        TextField txtId = new TextField();
        txtId.setPromptText("ID");
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        TextField txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");
        TextField txtDireccion = new TextField();
        txtDireccion.setPromptText("Dirección");

        Button btnGuardar = new Button("Guardar");
        if (pacienteExistente != null) {
            txtId.setText(pacienteExistente.getId());
            txtNombre.setText(pacienteExistente.getNombre());
            txtCorreo.setText(pacienteExistente.getCorreo());
            txtTelefono.setText(pacienteExistente.getTelefono());
            txtDireccion.setText(pacienteExistente.getDireccion());
        }

        btnGuardar.setOnAction(e -> {
            Paciente nuevo = new Paciente(
                    txtId.getText(),
                    txtNombre.getText(),
                    txtCorreo.getText(),
                    txtTelefono.getText(),
                    txtDireccion.getText()
            );
            PacienteController controller = new PacienteController();
            if (pacienteExistente == null) {
                controller.registrarPaciente(nuevo);
            } else {
                controller.actualizarPaciente(pacienteExistente, nuevo);
            }
            stage.close();
        });

        VBox root = new VBox(10, txtId, txtNombre, txtCorreo, txtTelefono, txtDireccion, btnGuardar);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center;");

        stage.setScene(new Scene(root, 300, 350));
        stage.show();
    }
}