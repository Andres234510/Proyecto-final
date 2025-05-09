package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;

import java.util.List;


public class Administrador extends Persona {
    // Constructor
    public Administrador(String id, String nombre, String correo, String telefono) {
        super(id, nombre, correo, telefono);
    }

    // Métodos de administración (los detalles se pueden ampliar en otras clases de servicio o controladores)

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

    // Implementación del método abstracto
    @Override
    public String getTipo() {
        return "Administrador";
    }
}
