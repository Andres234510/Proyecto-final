package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.time.LocalDateTime;
import java.util.UUID;

public class PacienteController {

    private Paciente paciente;

    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
    }

    // Simular solicitud de cita
    public void solicitarCita(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            NotificacionPopup.mostrarAdvertencia("Motivo Requerido", "Debe ingresar el motivo de la cita.");
            return;
        }

        // Crear una cita simulada
        Cita cita = new Cita(
                UUID.randomUUID().toString(),
                LocalDateTime.now().plusDays(2),
                paciente,
                null, // en implementación real, se asignaría un médico
                motivo
        );

        paciente.solicitarCita(cita);
        NotificacionPopup.mostrar("Cita Solicitada", "Tu cita fue registrada exitosamente.");
    }

    // Simular cancelación de la última cita
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
    
    // Mostrar historial en consola (en GUI real se mostraría en una ventana)
    public void verHistorial() {
        System.out.println(paciente.getHistorial());
        NotificacionPopup.mostrar("Historial Médico", "Historial mostrado en consola.");
    }

    // Mostrar citas activas
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
