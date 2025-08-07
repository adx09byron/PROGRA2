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

public class Entrada {
    private int id;
    private int clienteId;
    private int funcionId;
    private int butacaId;
    private double precio;
    private LocalDate fechaCompra;
    private boolean pagada;
    
    // Constructor
    public Entrada(int id, int clienteId, int funcionId, int butacaId, double precio) {
        this.id = id;
        this.clienteId = clienteId;
        this.funcionId = funcionId;
        this.butacaId = butacaId;
        this.precio = precio;
        this.fechaCompra = LocalDate.now();
        this.pagada = false;
    }
    
    // Getters y Setters
    public int getId() { 
        return id; }
    public void setId(int id) { 
        this.id = id; }
    
    public int getClienteId() { 
        return clienteId; }
    public void setClienteId(int clienteId) { 
        this.clienteId = clienteId; }
    
    public int getFuncionId() { 
        return funcionId; }
    public void setFuncionId(int funcionId) { 
        this.funcionId = funcionId; }
    
    public int getButacaId() { 
        return butacaId; }
    public void setButacaId(int butacaId) { 
        this.butacaId = butacaId; }
    
    public double getPrecio() { 
        return precio; }
    public void setPrecio(double precio) { 
        this.precio = precio; }
    
    public LocalDate getFechaCompra() { 
        return fechaCompra; }
    public void setFechaCompra(LocalDate fechaCompra) { 
        this.fechaCompra = fechaCompra; }
    
    public boolean isPagada() { 
        return pagada; }
    public void setPagada(boolean pagada) { 
        this.pagada = pagada; }
    
}
