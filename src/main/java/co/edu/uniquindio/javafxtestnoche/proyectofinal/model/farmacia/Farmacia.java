package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.farmacia;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.util.HashMap;
import java.util.Map;

public class Farmacia {
    // Simulación de pedidos de medicamentos por paciente
    private Map<Paciente, String> pedidos;

    public Farmacia() {
        this.pedidos = new HashMap<>();
    }

    // Solicita un medicamento para un paciente
    public void solicitarMedicamento(Paciente paciente, String medicamento) {
        if (paciente != null && medicamento != null && !medicamento.isBlank()) {
            pedidos.put(paciente, medicamento);
            System.out.println("🧾 Solicitud enviada a la farmacia:");
            System.out.println("Paciente: " + paciente.getNombre());
            System.out.println("Medicamento: " + medicamento);
        } else {
            System.out.println("⚠️ Solicitud inválida. Verifique los datos.");
        }
    }

    // Consulta el pedido actual de un paciente
    public String consultarPedido(Paciente paciente) {
        return pedidos.getOrDefault(paciente, "No hay pedidos registrados para este paciente.");
    }

    // Cancela un pedido existente
    public void cancelarPedido(Paciente paciente) {
        if (pedidos.containsKey(paciente)) {
            pedidos.remove(paciente);
            System.out.println("✅ Pedido cancelado para " + paciente.getNombre());
        } else {
            System.out.println("⚠️ No existe un pedido para cancelar.");
        }
    }
}
