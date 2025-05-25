package co.edu.uniquindio.javafxtestnoche.proyectofinal.service;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.util.HashMap;
import java.util.Map;

public class FarmaciaService {
    private static final Map<Paciente, String> pedidos = new HashMap<>();

    public static void solicitarMedicamento(Paciente paciente, String medicamento) {
        if (paciente != null && medicamento != null && !medicamento.isBlank()) {
            pedidos.put(paciente, medicamento);
        }
    }

    public static String consultarPedido(Paciente paciente) {
        return pedidos.getOrDefault(paciente, "No hay pedidos registrados para este paciente.");
    }

    public static void cancelarPedido(Paciente paciente) {
        pedidos.remove(paciente);
    }

    public static Map<Paciente, String> listarPedidos() {
        return new HashMap<>(pedidos);
    }
}

