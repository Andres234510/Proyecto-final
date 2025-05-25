package co.edu.uniquindio.javafxtestnoche.proyectofinal.service;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;

import java.util.ArrayList;
import java.util.List;

public class CitaService {
    private static final List<Cita> citas = new ArrayList<>();

    public static void agregar(Cita cita) {
        citas.add(cita);
    }

    public static void eliminar(Cita cita) {
        citas.remove(cita);
    }

    public static List<Cita> listar() {
        return new ArrayList<>(citas);
    }

    public static void actualizar(Cita original, Cita actualizada) {
        int i = citas.indexOf(original);
        if (i != -1) {
            citas.set(i, actualizada);
        }
    }
}
