package org.example;
import java.util.List;
public interface Biblioteca {
    int getIdBiblioteca();
    void mostrarCliente();
    void mostrarDeudas();
    boolean puedePrestar();
    int getDiasMaximoPrestamo();
    List<Prestamo> getPrestamosActivos();
}
