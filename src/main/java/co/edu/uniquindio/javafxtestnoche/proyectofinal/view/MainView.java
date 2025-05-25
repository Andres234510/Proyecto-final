package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Gestión Hospitalaria - Hospital UQ");

        Button btnPaciente = new Button("Ingresar como Paciente");
        Button btnMedico = new Button("Ingresar como Médico");
        Button btnAdmin = new Button("Ingresar como Administrador");

        btnPaciente.setOnAction(e -> abrirLoginConTipo("Paciente"));
        btnMedico.setOnAction(e -> abrirLoginConTipo("Médico"));
        btnAdmin.setOnAction(e -> abrirLoginConTipo("Administrador"));

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 40; -fx-alignment: center; -fx-background-color: #f0f8ff;");
        root.getChildren().addAll(btnPaciente, btnMedico, btnAdmin);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void abrirLoginConTipo(String tipo) {
        Stage loginStage = new Stage();
        LoginView loginView = new LoginView();
        loginView.setTipoUsuarioInicial(tipo);
        try {
            loginView.start(loginStage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
