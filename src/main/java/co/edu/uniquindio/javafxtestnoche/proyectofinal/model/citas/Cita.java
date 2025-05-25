package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.time.LocalDateTime;


public class Cita {
    private String id;
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Medico medico;
    private String motivo;
    private String tratamiento;
    private String diagnostico;
    private String fecha;

    // Constructor
    public Cita(String id, LocalDateTime fechaHora, Paciente paciente, Medico medico, String motivo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.motivo = motivo;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Representación en texto
    @Override
    public String toString() {
        return String.format(
                "Cita ID: %s\nFecha: %s\nPaciente: %s\nMédico: %s\nMotivo: %s",
                id, fechaHora.toString(), paciente.getNombre(), medico.getNombre(), motivo
        );
    }


    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

