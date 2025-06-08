package org.example;

public class Visitante extends Usuario {
    private String ciudad;
    private boolean extranjero;

    public Visitante(String nombre, String apellido, int idBiblioteca, int edad, String correoElectronico, String ciudad, boolean extranjero) {
        super(nombre, apellido, idBiblioteca, edad, correoElectronico);
        this.setCiudad(ciudad);
        this.setExtranjero(extranjero);
    }

    @Override
    public void mostrarCliente() {
        System.out.println("Visitante: " + getNombre() + " " + getApellido() + "\nID: V" + getIdBiblioteca() + "\nEdad: " + getEdad() +
                "\nCorreo: " + getCorreoElectronico() + "\nCiudad: " + getCiudad() + "\nExtranjero: " + (isExtranjero() ? "Sí" : "No"));
    }

    @Override
    public void mostrarDeudas() {

    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 3;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isExtranjero() {
        return extranjero;
    }

    public void setExtranjero(boolean extranjero) {
        this.extranjero = extranjero;
    }
}
