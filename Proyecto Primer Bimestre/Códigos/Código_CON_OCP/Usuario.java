package org.example;
import java.util.ArrayList;
public interface Usuario {
    int getIdBiblioteca();
    String getNombre();
    boolean puedePrestar();
    int getDiasMaximoPrestamo();
    ArrayList<Prestamo> getPrestamosActivos();
    void mostrarCliente();
}
