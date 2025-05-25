package co.edu.uniquindio.javafxtestnoche.proyectofinal.view;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.controller.FarmaciaController;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.farmacia.Farmacia;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.farmacia.Medicamento;
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
        Button btnCerrar = new Button("Cerrar");

        FarmaciaController controller = new FarmaciaController();

        btnSolicitar.setOnAction(e -> controller.solicitarMedicamento(paciente, txtMedicamento.getText()));
        btnCancelar.setOnAction(e -> controller.cancelarPedido(paciente));
        btnConsultar.setOnAction(e -> controller.consultarPedido(paciente));
        btnCerrar.setOnAction(e -> stage.close());

        VBox root = new VBox(10, txtMedicamento, btnSolicitar, btnCancelar, btnConsultar, btnCerrar);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    public void mostrarVista(Farmacia farmacia) {
        Stage stage = new Stage();
        stage.setTitle("Lista de Medicamentos Disponibles");

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label lblTitulo = new Label("🧴 Medicamentos disponibles en la farmacia:");
        ListView<String> listaMedicamentos = new ListView<>();

        for (Medicamento m : farmacia.getMedicamentos()) {
            listaMedicamentos.getItems().add(m.getNombre() + " - " + m.getPresentacion() + " - " + m.getCantidad() + " unidades");
        }

        if (listaMedicamentos.getItems().isEmpty()) {
            listaMedicamentos.getItems().add("No hay medicamentos disponibles actualmente.");
        }

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> stage.close());

        root.getChildren().addAll(lblTitulo, listaMedicamentos, btnCerrar);
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }
}


