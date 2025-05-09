package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;

import java.util.ArrayList;
import java.util.List;


public class Medico extends Persona {
    // Atributos específicos del médico
    private String especialidad;
    private List<Cita> citasAsignadas;

    // Constructor
    public Medico(String id, String nombre, String correo, String telefono, String especialidad) {
        super(id, nombre, correo, telefono);
        this.especialidad = especialidad;
        this.citasAsignadas = new ArrayList<>();
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitasAsignadas() {
        return citasAsignadas;
    }

    // Métodos clave
    public void agregarCita(Cita cita) {
        citasAsignadas.add(cita);
    }

    public void registrarDiagnostico(HistorialMedico historial, String diagnostico, String tratamiento) {
        historial.agregarEntrada(diagnostico, tratamiento);
    }

    // Implementación del método abstracto
    @Override
    public String getTipo() {
        return "Médico";
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + especialidad;
    }
}
