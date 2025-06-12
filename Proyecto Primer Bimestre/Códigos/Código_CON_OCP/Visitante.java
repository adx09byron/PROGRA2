package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Visitante implements Usuario, PrestamoStrategy {
    private String nombre;
    private String apellido;
    private int idBiblioteca;
    private int edad;
    private String correo;
    private String ciudad;
    private boolean extranjero;
    private ArrayList<Prestamo> prestamosActivos;

    public Visitante(String nombre, String apellido, int idBiblioteca, int edad, String correo, String ciudad, boolean extranjero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idBiblioteca = idBiblioteca;
        this.edad = edad;
        this.correo = correo;
        this.ciudad = ciudad;
        this.extranjero = extranjero;
        this.prestamosActivos = new ArrayList<>();
    }

    @Override
    public int getIdBiblioteca(){ 
        return idBiblioteca; 
    }
    @Override
    public String getNombre(){ 
        return nombre + " " + apellido;
    }
    @Override
    public boolean puedePrestar(){ 
        return prestamosActivos.size() < 1;
    }
    @Override
    public int getDiasMaximoPrestamo(){ 
        return 3; 
    }
    @Override
    public ArrayList<Prestamo> getPrestamosActivos(){ 
        return prestamosActivos; 
    }

    @Override
    public void mostrarCliente() {
        System.out.printf("Visitante: %s, ID: %d, Edad: %d, Correo: %s, Ciudad: %s, Extranjero: %b%n",
                getNombre(), idBiblioteca, edad, correo, ciudad, extranjero);
    }

    @Override
    public double calcularMulta(LocalDate fechaDevolucion, LocalDate fechaActual) {
        if (fechaActual.isAfter(fechaDevolucion)) {
            long diasRetraso = fechaActual.toEpochDay() - fechaDevolucion.toEpochDay();
            return diasRetraso * 5.0; // Multa de $5 por día de retraso
        }
        return 0.0;
    }
}
