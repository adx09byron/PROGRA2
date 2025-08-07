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

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String cedula;
    private String usuario;
    private String contraseña;
    
    // Constructor
    public Empleado(int id, String nombre, String apellido, String cargo, 
                   String cedula, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contraseña = contraseña;
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
    
    public String getCargo() { 
        return cargo; }
    public void setCargo(String cargo) { 
        this.cargo = cargo; }
    
    public String getCedula() { 
        return cedula; }
    public void setCedula(String cedula) { 
        this.cedula = cedula; }
    
    public String getUsuario() { 
        return usuario; }
    public void setUsuario(String usuario) { 
        this.usuario = usuario; }
    
    public String getContraseña() { 
        return contraseña; }
    public void setContraseña(String contraseña) { 
        this.contraseña = contraseña; }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    @Override
    public String toString() {
        return getNombreCompleto() + " - " + cargo;
    }
}
