package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudiante implements Usuario, PrestamoStrategy {
    private String nombre;
    private String apellido;
    private int idBiblioteca;
    private int edad;
    private String correo;
    private String codigoUnico;
    private String nivelAcademico;
    private ArrayList<Prestamo> prestamosActivos;

    public Estudiante(String nombre, String apellido, int idBiblioteca, int edad, String correo, String codigoUnico, String nivelAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idBiblioteca = idBiblioteca;
        this.edad = edad;
        this.correo = correo;
        this.codigoUnico = codigoUnico;
        this.nivelAcademico = nivelAcademico;
        this.prestamosActivos = new ArrayList<>();
    }

    @Override
    public int getIdBiblioteca() { return idBiblioteca; }
    @Override
    public String getNombre() { return nombre + " " + apellido; }
    @Override
    public boolean puedePrestar() { return prestamosActivos.size() < 3; }
    @Override
    public int getDiasMaximoPrestamo() { return 7; }
    @Override
    public ArrayList<Prestamo> getPrestamosActivos() { return prestamosActivos; }

    @Override
    public void mostrarCliente() {
        System.out.printf("Estudiante: %s, ID: %d, Edad: %d, Correo: %s, Código: %s, Nivel: %s%n",
                getNombre(), idBiblioteca, edad, correo, codigoUnico, nivelAcademico);
    }

    @Override
    public double calcularMulta(LocalDate fechaDevolucion, LocalDate fechaActual) {
        if (fechaActual.isAfter(fechaDevolucion)) {
            long diasRetraso = fechaActual.toEpochDay() - fechaDevolucion.toEpochDay();
            return diasRetraso * 2.0; // Multa de $2 por día de retraso
        }
        return 0.0;
    }
}
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
