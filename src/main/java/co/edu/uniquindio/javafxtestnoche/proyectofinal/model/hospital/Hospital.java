package co.edu.uniquindio.javafxtestnoche.proyectofinal.model.hospital;

import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.citas.Cita;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Administrador;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Medico;
import co.edu.uniquindio.javafxtestnoche.proyectofinal.model.personas.Paciente;

import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private  Administrador administrador;
    private ArrayList<Medico> medicos=new ArrayList<Medico>();
    private ArrayList<Paciente> pacientes =new ArrayList<Paciente>();
    private ArrayList<Cita> citas = new ArrayList<Cita>();
    public Hospital(String nombre,Administrador admin){
        this.nombre=nombre;
        this.administrador=admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    //CRUD paciente String id, String nombre, String correo, String telefono, String direccion
    public boolean existePaciente(String id){
        for(Paciente p:pacientes){
            if(p.getId().equals(id)){
                return true;
            }
        }return false;
    }
    public boolean crearPaciente(String id, String nombre, String correo, String telefono, String direccion){
        boolean estado =existePaciente(id);
        if(estado != true){
            Paciente p=new Paciente(id, nombre, correo, telefono, direccion);
            pacientes.add(p);
            return true;
        }
        return false;
    }
    public Paciente buscarPaciente(String id){
        for(Paciente p:pacientes){
            if(p.getId().equals(id)){
                return p;
            }
        }return null;
    }
    public boolean eliminarPaciente(String id){
        Paciente p=buscarPaciente(id);
        if(p!=null){
            pacientes.remove(p);
            return true;
        }return false;
    }
    public boolean actualizarPaciente(String idActual, String id, String nombre, String correo, String telefono, String direccion){
        Paciente p=buscarPaciente(id);
        if(p!=null){
            p.setId(id);
            p.setNombre(nombre);
            p.setCorreo(correo);
            p.setTelefono(telefono);
            p.setDireccion(direccion);
            return true;
        }return false;
    }
    //CRUD MEDICO String id, String nombre, String correo, String telefono, String especialidad
    public boolean existeMedico(String id){
        for(Medico m:medicos){
            if(m.getId().equals(id)){
                return true;
            }
        }return false;
    }
    public boolean crearMedico(String id, String nombre, String correo, String telefono, String especialidad){
        boolean estado =existeMedico(id);
        for(Medico m:medicos){
            if(m.getId().equals(id)){
                Medico medico=new Medico(id, nombre, correo, telefono, especialidad);
                medicos.add(medico);
                return true;
            }
        }return false;
    }



}
