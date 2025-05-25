package co.edu.uniquindio.javafxtestnoche.proyectofinal.service;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteService {
    private static final List<Paciente> pacientes = new ArrayList<>();

    public static void agregar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static void eliminar(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public static List<Paciente> listar() {
        return new ArrayList<>(pacientes);
    }

    public static void actualizar(Paciente original, Paciente actualizado) {
        int i = pacientes.indexOf(original);
        if (i != -1) {
            pacientes.set(i, actualizado);
        }
    }
}
