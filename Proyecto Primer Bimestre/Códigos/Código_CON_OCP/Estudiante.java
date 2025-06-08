package org.example;

public class Estudiante extends Usuario {
    private String codigoUnico;
    private String nivelAcademico;

    public Estudiante(String nombre, String apellido, int idBiblioteca, int edad, String correoElectronico, String codigoUnico, String nivelAcademico) {
        super(nombre, apellido, idBiblioteca, edad, correoElectronico);
        this.setCodigoUnico(codigoUnico);
        this.setNivelAcademico(nivelAcademico);
    }

    @Override
    public void mostrarCliente() {
        System.out.println("Estudiante: " + getNombre() + " " + getApellido() + "\nID: E" + getIdBiblioteca() + "\nEdad: " + getEdad() +
                "\nCorreo: " + getCorreoElectronico() + "\nCódigo Único: " + getCodigoUnico() + "\nNivel Académico: " + getNivelAcademico());
    }

    @Override
    public void mostrarDeudas() {
        System.out.println("Multas pendientes para " + getNombre() + ": $0.00 (sin implementar)");
    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 7; // Estudiantes tienen 7 días
    }


    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
