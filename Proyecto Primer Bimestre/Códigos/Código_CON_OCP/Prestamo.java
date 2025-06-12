package org.example;

import java.time.LocalDate;

public class Prestamo {
    private Material material;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(Material material, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.material = material;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.activo = true;
    }

    public Material getMaterial() { return material; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public double calcularMulta() {
        if (usuario instanceof PrestamoStrategy strategy) {
            return strategy.calcularMulta(fechaDevolucion, LocalDate.now());
        }
        return 0.0;
    }
}
