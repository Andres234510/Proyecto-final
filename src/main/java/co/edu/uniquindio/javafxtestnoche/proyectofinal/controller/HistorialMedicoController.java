package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.HistorialMedicoService;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.util.List;

public class HistorialMedicoController {

    public void registrarHistorial(HistorialMedico historial) {
        if (historial == null) {
            NotificacionPopup.mostrarAdvertencia("Datos inválidos", "El historial no puede ser nulo.");
            return;
        }
        HistorialMedicoService.agregar(historial);
        NotificacionPopup.mostrar("Historial Registrado", "El historial ha sido registrado exitosamente.");
    }

    public void eliminarHistorial(HistorialMedico historial) {
        if (!HistorialMedicoService.listar().contains(historial)) {
            NotificacionPopup.mostrarAdvertencia("No encontrado", "El historial no está registrado.");
            return;
        }
        HistorialMedicoService.eliminar(historial);
        NotificacionPopup.mostrar("Historial Eliminado", "El historial fue eliminado.");
    }

    public void actualizarHistorial(HistorialMedico original, HistorialMedico actualizado) {
        HistorialMedicoService.actualizar(original, actualizado);
        NotificacionPopup.mostrar("Historial Actualizado", "El historial fue actualizado correctamente.");
    }

    public List<HistorialMedico> obtenerTodos() {
        return HistorialMedicoService.listar();
    }
}
