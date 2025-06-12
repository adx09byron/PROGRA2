package org.example;

public class DvD implements Material {
    private String id;
    private String titulo;
    private String autor;
    private String genero;
    private String formato;
    private boolean habilitado;

    public DvD(String id, String titulo, String autor, String genero, String formato) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.formato = formato;
        this.habilitado = true;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getTitulo() {
        return titulo;
    }
    @Override
    public boolean isHabilitado() {
        return habilitado;
    }
    @Override
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public void mostrarMaterial() {
        System.out.printf("DVD: %s, ID: %s, Autor: %s, Género: %s, Formato: %s, Habilitado: %b%n",
                titulo, id, autor, genero, formato, habilitado);
    }
}
