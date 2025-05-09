package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.util;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.interfaces.Notificable;

public class Notificador {

    // Enviar una notificación simple
    public static void enviar(Notificable destinatario, String mensaje) {
        if (destinatario != null && mensaje != null && !mensaje.isBlank()) {
            destinatario.recibirNotificacion(mensaje);
        } else {
            System.out.println("⚠️ No se pudo enviar la notificación. Datos inválidos.");
        }
    }

    // Sobrecarga: notificación con título
    public static void enviar(Notificable destinatario, String titulo, String mensaje) {
        String mensajeFormateado = String.format("[%s] %s", titulo, mensaje);
        enviar(destinatario, mensajeFormateado);
    }
}
