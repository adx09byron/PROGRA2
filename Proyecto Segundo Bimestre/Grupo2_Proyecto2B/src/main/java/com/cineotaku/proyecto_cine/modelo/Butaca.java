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


public class Butaca {
    private int numero;
    private char fila;
    private boolean ocupada;
    private int salaId;
    private boolean reservada;
    
    // Constructor
    public Butaca(int numero, char fila, int salaId) {
        this.numero = numero;
        this.fila = fila;
        this.salaId = salaId;
        this.ocupada = false;
        this.reservada = false;
    }
    
    // Getters y Setters
    public int getNumero() { 
        return numero; }
    public void setNumero(int numero) { 
        this.numero = numero; }
    
    public char getFila() { 
        return fila; }
    public void setFila(char fila) { 
        this.fila = fila; }
    
    public boolean isOcupada() { 
        return ocupada; }
    public void setOcupada(boolean ocupada) { 
        this.ocupada = ocupada; }
    
    public int getSalaId() { 
        return salaId; }
    public void setSalaId(int salaId) { 
        this.salaId = salaId; }
    
    public boolean isReservada() { 
        return reservada; }
    public void setReservada(boolean reservada) { 
        this.reservada = reservada; }
    
    public boolean isDisponible() {
        return !ocupada && !reservada;
    }
    
    @Override
    public String toString() {
        return fila + String.valueOf(numero);
    }
}

    

