package co.edu.uniquindio.javafxtestnoche.proyectofinal.view.components;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotificacionPopup {

    /**
     * Muestra una notificación emergente al usuario.
     *
     * @param titulo   Título de la ventana emergente.
     * @param mensaje  Mensaje principal que se mostrará.
     */
    public static void mostrar(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una notificación de advertencia.
     *
     * @param titulo   Título de la advertencia.
     * @param mensaje  Mensaje principal que se mostrará.
     */
    public static void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una notificación de error.
     *
     * @param titulo   Título del error.
     * @param mensaje  Mensaje principal que se mostrará.
     */
    public static void mostrarError(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
