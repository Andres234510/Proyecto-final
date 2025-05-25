package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;

import java.util.List;

public class MedicoController {

    private Medico medico;

    public MedicoController(Medico medico) {
        this.medico = medico;
    }

    // Ver las citas asignadas al médico
    public void verCitasAsignadas() {
        List<Cita> citas = medico.getCitasAsignadas();
        if (citas.isEmpty()) {
            NotificacionPopup.mostrar("Citas Asignadas", "No tienes citas asignadas actualmente.");
        } else {
            System.out.println("=== Citas Asignadas al Médico ===");
            for (Cita c : citas) {
                System.out.println(c);
                System.out.println("---");
            }
            NotificacionPopup.mostrar("Citas Asignadas", "Tus citas se han mostrado en consola.");
        }
    }

    // Consultar historial médico de un paciente
    public void consultarHistorial(HistorialMedico historial) {
        if (historial == null || historial.getEntradas().isEmpty()) {
            NotificacionPopup.mostrar("Historial Médico", "El historial está vacío.");
        } else {
            System.out.println(historial);
            NotificacionPopup.mostrar("Historial Médico", "Historial mostrado en consola.");
        }
    }

    // Registrar un nuevo diagnóstico y tratamiento
    public void registrarDiagnostico(HistorialMedico historial, String diagnostico, String tratamiento) {
        if (historial == null || diagnostico == null || diagnostico.isBlank() || tratamiento == null || tratamiento.isBlank()) {
            NotificacionPopup.mostrarAdvertencia("Datos Incompletos", "Debe ingresar diagnóstico y tratamiento.");
            return;
        }

        historial.agregarEntrada(diagnostico, tratamiento);
        NotificacionPopup.mostrar("Diagnóstico Registrado", "Se ha añadido una nueva entrada al historial médico.");
    }
}

