package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.AdminView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.LoginView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.MedicoView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.PacienteView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;
import javafx.application.Platform;
import javafx.stage.Stage;

public class NavigationController {

    /**
     * Navega a la vista del login (reinicia aplicación).
     */
    public void irALogin() {
        Platform.runLater(() -> {
            try {
                new LoginView().start(new Stage());
            } catch (Exception e) {
                NotificacionPopup.mostrarError("Error", "No se pudo abrir la vista de login.");
                e.printStackTrace();
            }
        });
    }

    /**
     * Navega a la vista del paciente.
     */
    public void irAPaciente() {
        Platform.runLater(() -> {
            try {
                new PacienteView().start(new Stage());
            } catch (Exception e) {
                NotificacionPopup.mostrarError("Error", "No se pudo abrir la vista del paciente.");
                e.printStackTrace();
            }
        });
    }

    /**
     * Navega a la vista del médico.
     */
    public void irAMedico() {
        Platform.runLater(() -> {
            try {
                new MedicoView().start(new Stage());
            } catch (Exception e) {
                NotificacionPopup.mostrarError("Error", "No se pudo abrir la vista del médico.");
                e.printStackTrace();
            }
        });
    }

    /**
     * Navega a la vista del administrador.
     */
    public void irAAdministrador() {
        Platform.runLater(() -> {
            try {
                new AdminView().start(new Stage());
            } catch (Exception e) {
                NotificacionPopup.mostrarError("Error", "No se pudo abrir la vista del administrador.");
                e.printStackTrace();
            }
        });
    }
}
