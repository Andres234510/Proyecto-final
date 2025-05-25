package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.FarmaciaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FarmaciaView {

    public void mostrar(Paciente paciente) {
        Stage stage = new Stage();
        stage.setTitle("Módulo de Farmacia");

        TextField txtMedicamento = new TextField();
        txtMedicamento.setPromptText("Medicamento a solicitar");

        Button btnSolicitar = new Button("Solicitar Medicamento");
        Button btnCancelar = new Button("Cancelar Pedido");
        Button btnConsultar = new Button("Consultar Pedido");

        FarmaciaController controller = new FarmaciaController();

        btnSolicitar.setOnAction(e -> controller.solicitarMedicamento(paciente, txtMedicamento.getText()));
        btnCancelar.setOnAction(e -> controller.cancelarPedido(paciente));
        btnConsultar.setOnAction(e -> controller.consultarPedido(paciente));

        VBox root = new VBox(10, txtMedicamento, btnSolicitar, btnCancelar, btnConsultar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 400, 250));
        stage.show();
    }
}
