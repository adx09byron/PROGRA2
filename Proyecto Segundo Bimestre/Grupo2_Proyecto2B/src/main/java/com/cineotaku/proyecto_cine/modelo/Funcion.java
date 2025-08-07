/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineotaku.proyecto_cine.modelo;

/**
 *
 * @author User
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Funcion {
    private int id;
    private int peliculaId;
    private int salaId;
    private LocalDateTime fechaHora;
    private int duracionMinutos;
    private double precio;
    
    // Constructor
    public Funcion(int id, int peliculaId, int salaId, LocalDateTime fechaHora, 
                   int duracionMinutos, double precio) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.fechaHora = fechaHora;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
    }
    
    // Getters y Setters
    public int getId() { 
        return id; }
    public void setId(int id) { 
        this.id = id; }
    
    public int getPeliculaId() { 
        return peliculaId; }
    public void setPeliculaId(int peliculaId) { 
        this.peliculaId = peliculaId; }
    
    public int getSalaId() { 
        return salaId; }
    public void setSalaId(int salaId) { 
        this.salaId = salaId; }
    
    public LocalDateTime getFechaHora() { 
        return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { 
        this.fechaHora = fechaHora; }
    
    public int getDuracionMinutos() { 
        return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { 
        this.duracionMinutos = duracionMinutos; }
    
    public double getPrecio() { 
        return precio; }
    public void setPrecio(double precio) { 
        this.precio = precio; }
    
    public LocalDateTime getFechaFin() {
        return fechaHora.plusMinutes(duracionMinutos);
    }
}
