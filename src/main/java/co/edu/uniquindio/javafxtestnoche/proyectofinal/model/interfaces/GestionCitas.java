package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;

import java.util.List;

public interface GestionCitas {
    void solicitarCita(Cita cita);
    void cancelarCita(Cita cita);
    List<Cita> listarCitas();
}
