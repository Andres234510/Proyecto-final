package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas;

public abstract class Persona {
    // Atributos protegidos (encapsulamiento con protected)
    protected String id;
    protected String nombre;
    protected String correo;
    protected String telefono;

    // Constructor
    public Persona(String id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona() {

    }

    // Getters y Setters (encapsulamiento)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método abstracto: cada tipo de persona lo implementa diferente (polimorfismo)
    public abstract String getTipo();

    // Representación básica para impresión
    @Override
    public String toString() {
        return String.format("ID: %s\nNombre: %s\nCorreo: %s\nTeléfono: %s", id, nombre, correo, telefono);
    }
}
