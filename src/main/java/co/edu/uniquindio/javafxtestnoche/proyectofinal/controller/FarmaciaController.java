package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.FarmaciaService;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

public class FarmaciaController {

    public void solicitarMedicamento(Paciente paciente, String medicamento) {
        if (paciente == null || medicamento == null || medicamento.isBlank()) {
            NotificacionPopup.mostrarAdvertencia("Datos Incompletos", "Debe seleccionar un paciente y especificar el medicamento.");
            return;
        }
        FarmaciaService.solicitarMedicamento(paciente, medicamento);
        NotificacionPopup.mostrar("Solicitud Exitosa", "El medicamento fue solicitado a la farmacia.");
    }

    public void cancelarPedido(Paciente paciente) {
        FarmaciaService.cancelarPedido(paciente);
        NotificacionPopup.mostrar("Pedido Cancelado", "Se ha cancelado el pedido del paciente.");
    }

    public void consultarPedido(Paciente paciente) {
        String info = FarmaciaService.consultarPedido(paciente);
        NotificacionPopup.mostrar("Consulta de Pedido", info);
    }
}
