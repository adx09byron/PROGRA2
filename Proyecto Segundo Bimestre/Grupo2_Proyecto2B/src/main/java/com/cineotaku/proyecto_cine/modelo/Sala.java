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

public class Sala {
    private int id;
    private String nombre;
    private int capacidad;
    private int filas;
    private int columnas;
    private boolean habilitada;
    
    // Constructor
    public Sala(int id, String nombre, int filas, int columnas, boolean habilitada) {
        this.id = id;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.capacidad = filas * columnas;
        this.habilitada = habilitada;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    
    public int getFilas() { return filas; }
    public void setFilas(int filas) { 
        this.filas = filas;
        this.capacidad = filas * columnas;
    }
    
    public int getColumnas() { return columnas; }
    public void setColumnas(int columnas) { 
        this.columnas = columnas;
        this.capacidad = filas * columnas;
    }
    
    public boolean isHabilitada() { return habilitada; }
    public void setHabilitada(boolean habilitada) { this.habilitada = habilitada; }
    
    @Override
    public String toString() {
        return nombre + " (Capacidad: " + capacidad + ")";
    }
}
