package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.service.PacienteService;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.time.LocalDateTime;
import java.util.UUID;

public class PacienteController {

    private Paciente paciente;

    // Constructor para vistas que gestionan un paciente individual
    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
    }

    // Constructor vacío para CRUD desde AdminView
    public PacienteController() {}

    // CRUD: Registrar paciente
    public void registrarPaciente(Paciente nuevo) {
        if (nuevo == null) {
            NotificacionPopup.mostrarAdvertencia("Datos inválidos", "No se puede registrar un paciente nulo.");
            return;
        }
        PacienteService.agregar(nuevo);
        NotificacionPopup.mostrar("Registro Exitoso", "El paciente ha sido registrado.");
    }

    // CRUD: Eliminar paciente
    public void eliminarPaciente(Paciente paciente) {
        if (!PacienteService.listar().contains(paciente)) {
            NotificacionPopup.mostrarAdvertencia("No encontrado", "El paciente no está registrado.");
            return;
        }
        PacienteService.eliminar(paciente);
        NotificacionPopup.mostrar("Eliminación Exitosa", "El paciente ha sido eliminado.");
    }

    // CRUD: Actualizar paciente
    public void actualizarPaciente(Paciente original, Paciente actualizado) {
        PacienteService.actualizar(original, actualizado);
        NotificacionPopup.mostrar("Actualizado", "El paciente fue actualizado correctamente.");
    }

    // Operación: Solicitar cita
    public void solicitarCita(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            NotificacionPopup.mostrarAdvertencia("Motivo Requerido", "Debe ingresar el motivo de la cita.");
            return;
        }

        Cita cita = new Cita(
                UUID.randomUUID().toString(),
                LocalDateTime.now().plusDays(2),
                paciente,
                null,
                motivo
        );

        paciente.solicitarCita(cita);
        NotificacionPopup.mostrar("Cita Solicitada", "Tu cita fue registrada exitosamente.");
    }

    // Operación: Cancelar última cita
    public void cancelarUltimaCita() {
        var citas = paciente.listarCitas();
        if (citas.isEmpty()) {
            NotificacionPopup.mostrarAdvertencia("Sin Citas", "No tienes citas para cancelar.");
            return;
        }

        Cita ultima = citas.get(citas.size() - 1);
        paciente.cancelarCita(ultima);
        NotificacionPopup.mostrar("Cita Cancelada", "Se ha cancelado tu última cita.");
    }

    // Operación: Ver historial médico
    public void verHistorial() {
        System.out.println(paciente.getHistorial());
        NotificacionPopup.mostrar("Historial Médico", "Historial mostrado en consola.");
    }

    // Operación: Ver citas activas
    public void verCitas() {
        var citas = paciente.listarCitas();
        if (citas.isEmpty()) {
            NotificacionPopup.mostrar("Citas Activas", "No tienes citas registradas.");
        } else {
            System.out.println("=== Citas del Paciente ===");
            for (Cita c : citas) {
                System.out.println(c);
                System.out.println("---");
            }
            NotificacionPopup.mostrar("Citas Activas", "Tus citas se han mostrado en consola.");
        }
    }
}
