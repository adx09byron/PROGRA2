package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Biblioteca {
    private int idBiblioteca;
    private String nombre;
    private String apellido;
    private int edad;
    private String correoElectronico;
    private List<Prestamo> prestamosActivos;

    public Usuario(String nombre, String apellido, int idBiblioteca, int edad, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idBiblioteca = idBiblioteca;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.prestamosActivos = new ArrayList<>();
    }

    @Override
    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    @Override
    public boolean puedePrestar() {
        return prestamosActivos.size() < 3; // Ejemplo: límite de 3 préstamos
    }

    @Override
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String getCorreoElectronico(){
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }
}
