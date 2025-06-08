package org.example;


public class Libro implements Materiales {
    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private String IBSN;
    private boolean habilitado;

    public Libro(String id, String titulo, String autor, String editorial, String IBSN) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.habilitado = true;
        this.editorial = editorial;
        this.IBSN = IBSN;
    }

    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getTitulo(){
        return titulo;
    }
    @Override
    public String getAutor(){
        return autor;
    }
    @Override
    public boolean isHabilitado(){
        return habilitado;
    }
    @Override
    public void setHabilitado(boolean habilitado){
        this.habilitado = habilitado;
    }

    public void mostrarMaterial(){
        System.out.println("Libro: " + titulo + "\nAutor: " + autor + "\nID: " + id  + "\nEditorial: " + editorial + "\nNumero internacional: " + IBSN + "\nDisponible: " + (habilitado ? "Sí" : "No"));
    }
}
