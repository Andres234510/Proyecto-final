package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {

    private Paciente paciente;
    private CharSequence diagnosticos;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public CharSequence getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(CharSequence diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    // Clase interna para representar cada entrada del historial
    public static class Entrada {
        private LocalDateTime fecha;
        private String diagnostico;
        private String tratamiento;

        public Entrada(String diagnostico, String tratamiento) {
            this.fecha = LocalDateTime.now();  // Se asigna la fecha actual al crearla
            this.diagnostico = diagnostico;
            this.tratamiento = tratamiento;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getDiagnostico() {
            return diagnostico;
        }

        public String getTratamiento() {
            return tratamiento;
        }

        @Override
        public String toString() {
            return String.format("Fecha: %s\nDiagnóstico: %s\nTratamiento: %s",
                    fecha.toString(), diagnostico, tratamiento);
        }
    }

    // Lista de entradas del historial
    private List<String> entradas;

    public HistorialMedico() {
        this.entradas = new ArrayList<String>();
    }

    // Agrega una nueva entrada al historial
    public void agregarEntrada(String diagnostico, String tratamiento) {
        String entrada = "Diagnóstico: " + diagnostico + " | Tratamiento: " + tratamiento + " | Fecha: " + LocalDateTime.now();
        this.entradas.add(entrada);
    }

    public List<String> getEntradas() {
        return entradas;
    }

    // Imprime todo el historial
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Historial Médico ===\n");
        for (String e : entradas) {
            sb.append(e.toString()).append("\n---\n");
        }
        return sb.toString();
    }
}
