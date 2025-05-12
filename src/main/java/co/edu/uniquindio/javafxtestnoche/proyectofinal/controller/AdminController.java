package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Administrador;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.util.List;

public class AdminController {

    private Administrador administrador;

    public AdminController(Administrador administrador) {
        this.administrador = administrador;
    }

    // Registrar un nuevo médico
    public void registrarMedico(List<Medico> medicos, Medico nuevo) {
        if (nuevo == null) {
            NotificacionPopup.mostrarAdvertencia("Datos inválidos", "No se puede registrar un médico nulo.");
            return;
        }
        administrador.registrarMedico(medicos, nuevo);
        NotificacionPopup.mostrar("Registro Exitoso", "El médico ha sido registrado.");
    }

    // Eliminar un médico
    public void eliminarMedico(List<Medico> medicos, Medico medico) {
        if (!medicos.contains(medico)) {
            NotificacionPopup.mostrarAdvertencia("No encontrado", "El médico no está registrado.");
            return;
        }
        administrador.eliminarMedico(medicos, medico);
        NotificacionPopup.mostrar("Eliminación Exitosa", "El médico ha sido eliminado.");
    }

    // Registrar un nuevo paciente
    public void registrarPaciente(List<Paciente> pacientes, Paciente nuevo) {
        if (nuevo == null) {
            NotificacionPopup.mostrarAdvertencia("Datos inválidos", "No se puede registrar un paciente nulo.");
            return;
        }
        administrador.registrarPaciente(pacientes, nuevo);
        NotificacionPopup.mostrar("Registro Exitoso", "El paciente ha sido registrado.");
    }

    // Eliminar un paciente
    public void eliminarPaciente(List<Paciente> pacientes, Paciente paciente) {
        if (!pacientes.contains(paciente)) {
            NotificacionPopup.mostrarAdvertencia("No encontrado", "El paciente no está registrado.");
            return;
        }
        administrador.eliminarPaciente(pacientes, paciente);
        NotificacionPopup.mostrar("Eliminación Exitosa", "El paciente ha sido eliminado.");
    }

    // Mostrar reporte de citas médicas
    public void verReporteCitas(List<Cita> citas) {
        if (citas == null || citas.isEmpty()) {
            NotificacionPopup.mostrar("Reporte de Citas", "No hay citas registradas.");
            return;
        }

        System.out.println("=== Reporte de Citas ===");
        administrador.generarReporteCitas(citas);
        NotificacionPopup.mostrar("Reporte Generado", "El reporte se ha mostrado en consola.");
    }
}
