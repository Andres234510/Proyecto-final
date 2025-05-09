package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces.GestionCitas;

import java.util.ArrayList;
import java.util.List;


public class Paciente extends Persona implements GestionCitas {
    private String direccion;
    private List<Cita> citas;
    private HistorialMedico historial;

    public Paciente(String id, String nombre, String correo, String telefono, String direccion) {
        super(id, nombre, correo, telefono);
        this.direccion = direccion;
        this.citas = new ArrayList<>();
        this.historial = new HistorialMedico();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    // Implementación de GestiónCitas
    @Override
    public void solicitarCita(Cita cita) {
        citas.add(cita);
    }

    @Override
    public void cancelarCita(Cita cita) {
        citas.remove(cita);
    }

    @Override
    public List<Cita> listarCitas() {
        return citas;
    }

    @Override
    public String getTipo() {
        return "Paciente";
    }

    @Override
    public String toString() {
        return super.toString() + "\nDirección: " + direccion;
    }
}
