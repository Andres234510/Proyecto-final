package co.edu.uniquindio.javafxtestnoche.proyectofinal.service;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoService {
    private static final List<Medico> medicos = new ArrayList<>();

    public static void agregar(Medico medico) {
        medicos.add(medico);
    }

    public static void eliminar(Medico medico) {
        medicos.remove(medico);
    }

    public static List<Medico> listar() {
        return new ArrayList<>(medicos);
    }

    public static void actualizar(Medico original, Medico actualizado) {
        int i = medicos.indexOf(original);
        if (i != -1) {
            medicos.set(i, actualizado);
        }
    }
}
