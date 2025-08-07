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

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    
    // Constructor
    public Cliente(int id, String nombre, String apellido, String cedula, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public int getId() { 
        return id; }
    public void setId(int id) { 
        this.id = id; }
    
    public String getNombre() { 
        return nombre; }
    public void setNombre(String nombre) { 
        this.nombre = nombre; }
    
    public String getApellido() { 
        return apellido; }
    public void setApellido(String apellido) { 
        this.apellido = apellido; }
    
    public String getCedula() { 
        return cedula; }
    public void setCedula(String cedula) { 
        this.cedula = cedula; }
    
    public String getCorreo() { 
        return correo; }
    public void setCorreo(String correo) { 
        this.correo = correo; }
    
    public String getTelefono() { 
        return telefono; }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    @Override
    public String toString() {
        return getNombreCompleto() + " (" + cedula + ")";
    }
}
