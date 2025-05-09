package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.HistorialMedico;

public interface ManejoHistorial {
    void registrarDiagnostico(HistorialMedico historial, String diagnostico, String tratamiento);
    void verHistorial(HistorialMedico historial);
}
