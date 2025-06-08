package org.example;

public class DvD implements Materiales{
    private String id;
    private String titulo;
    private String autor;
    private String genero;
    private String formato;
    private boolean habilitado;
    public DvD(String id, String titulo, String autor, String genero, String formato){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.habilitado = true;
        this.genero = genero;
        this.formato = formato;
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
    public String getAutor() {
        return autor;
    }

    @Override
    public boolean isHabilitado() {
        return habilitado;
    }

    @Override
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    public  void mostrarMaterial(){
        System.out.println("Dvd: " + titulo + "\nAutor: " + autor + "\nId: " + id + "\nDisponivilidad: " + "\nGenero: " + genero + (habilitado ? "Si" : "No"));
    }
}
