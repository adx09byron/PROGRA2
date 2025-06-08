package org.example;

public class Profesor extends Usuario {
    private String departamento;
    private String tituloAcademico;

    public Profesor(String nombre, String apellido, int idBiblioteca, int edad, String correoElectronico, String departamento, String tituloAcademico) {
        super(nombre, apellido, idBiblioteca, edad, correoElectronico);
        this.setDepartamento(departamento);
        this.setTituloAcademico(tituloAcademico);
    }

    @Override
    public void mostrarCliente() {
        System.out.println("Profesor: " + getNombre() + " " + getApellido() + "\nID: P" + getIdBiblioteca() + "\nEdad: " + getEdad() +
                "\nCorreo: " + getCorreoElectronico() + "\nDepartamento: " + getDepartamento() + "\nTítulo Académico: " + getTituloAcademico());
    }

    @Override
    public void mostrarDeudas() {

    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 14;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

}
