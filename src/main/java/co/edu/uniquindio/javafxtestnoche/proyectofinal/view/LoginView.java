package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.LoginController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Application {

    private ComboBox<String> tipoUsuario;
    private String tipoUsuarioInicial;

    public void setTipoUsuarioInicial(String tipo) {
        this.tipoUsuarioInicial = tipo;
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Inicio de Sesión - Hospital UQ");

        // Campos de entrada
        TextField txtIdentificacion = new TextField();
        txtIdentificacion.setPromptText("ID o correo");

        // Selección de tipo de usuario
        tipoUsuario = new ComboBox<>();
        tipoUsuario.getItems().addAll("Paciente", "Médico", "Administrador");
        tipoUsuario.setPromptText("Seleccione tipo de usuario");

        if (tipoUsuarioInicial != null) {
            tipoUsuario.setValue(tipoUsuarioInicial);
        }

        // Botón de inicio de sesión
        Button btnIngresar = new Button("Ingresar");

        // Acción del botón (simulación)
        btnIngresar.setOnAction(e -> {
            String id = txtIdentificacion.getText();
            String tipo = tipoUsuario.getValue();

            if (id.isBlank() || tipo == null) {
                mostrarAlerta("Campos incompletos", "Debe ingresar su identificación y tipo de usuario.");
                return;
            }

            new LoginController().iniciarSesion(id, tipo, stage);

            System.out.println("🔓 Inicio de sesión como " + tipo + " con ID: " + id);
            // Aquí podrías redirigir a la vista correspondiente
        });

        // Layout
        VBox root = new VBox(15, txtIdentificacion, tipoUsuario, btnIngresar);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-alignment: center; -fx-background-color: #e6f2ff;");

        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
