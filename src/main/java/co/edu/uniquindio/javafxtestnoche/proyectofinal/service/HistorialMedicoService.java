package co.edu.uniquindio.javafxtestnoche.proyectofinal.service;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoService {
    private static final List<HistorialMedico> historiales = new ArrayList<>();

    public static void agregar(HistorialMedico historial) {
        historiales.add(historial);
    }

    public static void eliminar(HistorialMedico historial) {
        historiales.remove(historial);
    }

    public static List<HistorialMedico> listar() {
        return new ArrayList<>(historiales);
    }

    public static void actualizar(HistorialMedico original, HistorialMedico actualizado) {
        int i = historiales.indexOf(original);
        if (i != -1) {
            historiales.set(i, actualizado);
        }
    }
}