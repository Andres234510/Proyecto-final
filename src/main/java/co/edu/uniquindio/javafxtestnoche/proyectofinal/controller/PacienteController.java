package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.farmacia.Farmacia;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.FarmaciaView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import javafx.scene.control.Alert;

import java.time.LocalDateTime;
import java.util.UUID;

public class PacienteController {

    private Paciente paciente;

    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteController() {

    }

    public void solicitarCita(String motivo, Medico medico) {
        if (motivo == null || motivo.isBlank()) {
            NotificacionPopup.mostrarAdvertencia("Motivo requerido", "Debe ingresar el motivo de la cita.");
            return;
        }

        if (medico == null) {
            NotificacionPopup.mostrarAdvertencia("Médico requerido", "Debe seleccionar un médico.");
            return;
        }

        Cita nuevaCita = new Cita(
                UUID.randomUUID().toString(),
                LocalDateTime.now().plusDays(2),
                paciente,
                medico,
                motivo
        );

        paciente.solicitarCita(nuevaCita);
        NotificacionPopup.mostrar("Cita solicitada", "Tu cita fue registrada exitosamente con " + medico.getNombre());
    }

    public void verHistorial() {
        if (paciente.getHistorial().getDiagnosticos().isEmpty()) {
            NotificacionPopup.mostrar("Historial vacío", "No tienes registros médicos aún.");
        } else {
            System.out.println(paciente.getHistorial());
            NotificacionPopup.mostrar("Historial Médico", "Historial mostrado en consola.");
        }
    }

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

    public void actualizarPaciente(Paciente pacienteExistente, Paciente nuevo) {
        pacienteExistente.setNombre(nuevo.getNombre());
        pacienteExistente.setCorreo(nuevo.getCorreo());
        pacienteExistente.setTelefono(nuevo.getTelefono());
        NotificacionPopup.mostrar("Paciente Actualizado", "Los datos del paciente fueron actualizados exitosamente.");
    }

    public void eliminarPaciente(Paciente seleccionado) {
        NotificacionPopup.mostrar("Paciente Eliminado", "El paciente " + seleccionado.getNombre() + " fue eliminado.");
    }

    public void registrarPaciente(Paciente nuevo) {
        NotificacionPopup.mostrar("Paciente Registrado", "Se ha registrado al paciente " + nuevo.getNombre());
    }

    public void accederFarmacia() {
        Farmacia farmacia = new Farmacia();
        new FarmaciaView().mostrarVista(farmacia);
    }
}