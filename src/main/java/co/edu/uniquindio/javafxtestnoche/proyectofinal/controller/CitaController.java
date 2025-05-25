package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.CitaService;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.util.List;

public class CitaController {

    public void registrarCita(Cita cita) {
        if (cita == null) {
            NotificacionPopup.mostrarAdvertencia("Datos inválidos", "La cita no puede ser nula.");
            return;
        }
        CitaService.agregar(cita);
        NotificacionPopup.mostrar("Cita Registrada", "La cita ha sido registrada exitosamente.");
    }

    public void eliminarCita(Cita cita) {
        if (!CitaService.listar().contains(cita)) {
            NotificacionPopup.mostrarAdvertencia("No encontrada", "La cita no está registrada.");
            return;
        }
        CitaService.eliminar(cita);
        NotificacionPopup.mostrar("Cita Eliminada", "La cita fue eliminada.");
    }

    public void actualizarCita(Cita original, Cita actualizada) {
        CitaService.actualizar(original, actualizada);
        NotificacionPopup.mostrar("Cita Actualizada", "La cita fue actualizada correctamente.");
    }

    public List<Cita> obtenerTodas() {
        return CitaService.listar();
    }
}

