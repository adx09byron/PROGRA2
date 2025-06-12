package org.example;

public class Libro implements Material {
    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private boolean habilitado;

    public Libro(String id, String titulo, String autor, String editorial, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.habilitado = true;
    }

    @Override
    public String getId() { return id; }
    @Override
    public String getTitulo() { return titulo; }
    @Override
    public boolean isHabilitado() { return habilitado; }
    @Override
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }

    @Override
    public void mostrarMaterial() {
        System.out.printf("Libro: %s, ID: %s, Autor: %s, Editorial: %s, ISBN: %s, Habilitado: %b%n",
                titulo, id, autor, editorial, isbn, habilitado);
    }
}
