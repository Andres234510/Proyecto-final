package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.farmacia;

public class Medicamento {
    private String nombre;
    private String presentacion;
    private int cantidad;

    public Medicamento(String nombre, String presentacion, int cantidad) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - " + presentacion + " - " + cantidad + " unidades";
    }
}

