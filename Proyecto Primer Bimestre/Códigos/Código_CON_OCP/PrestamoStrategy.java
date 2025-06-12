package org.example;

import java.time.LocalDate;

public interface PrestamoStrategy {
    int getDiasMaximoPrestamo();
    double calcularMulta(LocalDate fechaDevolucion, LocalDate fechaActual);
}
