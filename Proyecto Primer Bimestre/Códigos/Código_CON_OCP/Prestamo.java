package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Prestamo {
    private Materiales material;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private double multaDia;
    private boolean activo;

    public Prestamo(Materiales material, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.setMaterial(material);
        this.setUsuario(usuario);
        this.setFechaPrestamo(fechaPrestamo);
        this.setFechaDevolucion(fechaDevolucion);
        this.setActivo(true);
    }


    public Materiales getMaterial() {
        return material;
    }

    public void setMaterial(Materiales material) {
        this.material = material;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public long getDiasRetraso() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaDevolucion)) {
            return ChronoUnit.DAYS.between(fechaDevolucion, hoy);
        }
        return 0;
    }
    public double calcularMulta(){
        if(activo && LocalDate.now().isAfter(fechaDevolucion)){
            long diasretraso = LocalDate.now().toEpochDay() - fechaDevolucion.toEpochDay();
            return getDiasRetraso() * multaDia;
        }
        return 0.0;
    }



}
