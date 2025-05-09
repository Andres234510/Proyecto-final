package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces.GestionCitas;


import java.util.List;


public class Administrador extends Persona implements GestionCitas {

    public Administrador(String id, String nombre, String correo, String telefono) {
        super(id, nombre, correo, telefono);
    }

    // Métodos de gestión de usuarios
    public void registrarMedico(List<Medico> lista, Medico nuevo) {
        lista.add(nuevo);
    }

    public void eliminarMedico(List<Medico> lista, Medico medico) {
        lista.remove(medico);
    }

    public void registrarPaciente(List<Paciente> lista, Paciente nuevo) {
        lista.add(nuevo);
    }

    public void eliminarPaciente(List<Paciente> lista, Paciente paciente) {
        lista.remove(paciente);
    }

    public void generarReporteCitas(List<Cita> citas) {
        System.out.println("=== Reporte de Citas ===");
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }

    // Implementación de GestionCitas
    @Override
    public void solicitarCita(Cita cita) {
        System.out.println("Administrador solicita una cita para un paciente.");
        // Este método se puede ampliar para añadir a una lista general
    }

    @Override
    public void cancelarCita(Cita cita) {
        System.out.println("Administrador cancela una cita.");
        // Este método también puede integrarse con una lista global
    }

    @Override
    public List<Cita> listarCitas() {
        System.out.println("Este método debe recibir una lista global de citas.");
        return null; // Devolver una lista real en implementación con lógica central
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
