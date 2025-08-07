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

public class Pago {
    private int id;
    private int entradaId;
    private double monto;
    private LocalDateTime fechaPago;
    private String metodoPago;
    
    // Constructor
    public Pago(int id, int entradaId, double monto, String metodoPago) {
        this.id = id;
        this.entradaId = entradaId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = LocalDateTime.now();
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getEntradaId() { return entradaId; }
    public void setEntradaId(int entradaId) { this.entradaId = entradaId; }
    
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    
    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
    
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}

