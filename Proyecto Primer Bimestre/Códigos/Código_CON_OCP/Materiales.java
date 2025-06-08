package org.example;
public interface Materiales {
    String getId();
    String getTitulo();
    String getAutor();
    boolean isHabilitado();
    void setHabilitado(boolean habilitado);
    void mostrarMaterial();
}
