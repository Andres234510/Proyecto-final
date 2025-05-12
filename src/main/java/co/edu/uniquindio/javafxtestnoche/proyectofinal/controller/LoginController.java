package co.edu.uniquindio.javafxtestnoche.proyectofinal.controller;


import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.AdminView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.MedicoView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.PacienteView;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components.NotificacionPopup;
import javafx.stage.Stage;


public class LoginController {

    public void iniciarSesion(String identificacion, String tipoUsuario, Stage currentStage) {
        if (identificacion == null || identificacion.isBlank() || tipoUsuario == null) {
            NotificacionPopup.mostrarAdvertencia("Campos Incompletos", "Por favor, complete todos los campos.");
            return;
        }

        // Simulación de autenticación
        System.out.println("🔐 Usuario autenticado como " + tipoUsuario + " con ID: " + identificacion);

        // Cerrar ventana actual
        currentStage.close();

        // Redireccionar a la vista correspondiente
        switch (tipoUsuario.toLowerCase()) {
            case "paciente":
                new PacienteView().start(new Stage());
                break;
            case "médico":
            case "medico": // por si viene sin tilde
                new MedicoView().start(new Stage());
                break;
            case "administrador":
                new AdminView().start(new Stage());
                break;
            default:
                NotificacionPopup.mostrarError("Tipo no reconocido", "El tipo de usuario no es válido.");
                break;
        }
    }
}

