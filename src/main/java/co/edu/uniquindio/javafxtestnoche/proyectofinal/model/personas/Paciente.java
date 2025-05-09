package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;


import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;

public class Paciente extends Persona {
    // Atributos propios del paciente
    private String direccion;
    private List<Cita> citas;
    private HistorialMedico historial;

    // Constructor
    public Paciente(String id, String nombre, String correo, String telefono, String direccion) {
        super(id, nombre, correo, telefono);
        this.direccion = direccion;
        this.citas = new ArrayList<>();
        this.historial = new HistorialMedico(); // Inicializa vacío
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    // Métodos para gestionar citas
    public void solicitarCita(Cita cita) {
        citas.add(cita);
    }

    public void cancelarCita(Cita cita) {
        citas.remove(cita);
    }

    // Método abstracto implementado (polimorfismo)
    @Override
    public String getTipo() {
        return "Paciente";
    }

    @Override
    public String toString() {
        return super.toString() + "\nDirección: " + direccion;
    }
}
