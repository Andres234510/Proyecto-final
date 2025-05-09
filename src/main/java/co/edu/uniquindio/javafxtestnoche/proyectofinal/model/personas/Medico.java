package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces.ManejoHistorial;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces.Notificable;

import java.util.ArrayList;
import java.util.List;


public class Medico extends Persona implements ManejoHistorial, Notificable {
    private String especialidad;
    private List<Cita> citasAsignadas;

    public Medico(String id, String nombre, String correo, String telefono, String especialidad) {
        super(id, nombre, correo, telefono);
        this.especialidad = especialidad;
        this.citasAsignadas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitasAsignadas() {
        return citasAsignadas;
    }

    public void agregarCita(Cita cita) {
        citasAsignadas.add(cita);
    }

    // Implementación de ManejoHistorial
    @Override
    public void registrarDiagnostico(HistorialMedico historial, String diagnostico, String tratamiento) {
        historial.agregarEntrada(diagnostico, tratamiento);
        System.out.println("Diagnóstico registrado con éxito.");
    }

    @Override
    public void verHistorial(HistorialMedico historial) {
        System.out.println(historial);
    }

    // Implementación de Notificable
    @Override
    public void recibirNotificacion(String mensaje) {
        System.out.println("🔔 Notificación para el Dr. " + getNombre() + ": " + mensaje);
    }

    @Override
    public String getTipo() {
        return "Médico";
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + especialidad;
    }
}
