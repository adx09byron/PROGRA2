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

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private String clasificacion;
    private int duracionMinutos;
    private String director;
    private String sinopsis;
    
    // Constructor
    public Pelicula(int id, String titulo, String genero, String clasificacion,
                    int duracionMinutos, String director, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.duracionMinutos = duracionMinutos;
        this.director = director;
        this.sinopsis = sinopsis;
    }
    
    // Getters y Setters
    public int getId() { 
        return id; }
    public void setId(int id) { 
        this.id = id; }
    
    public String getTitulo() { 
        return titulo; }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; }
    
    public String getGenero() { 
        return genero; }
    public void setGenero(String genero) { 
        this.genero = genero; }
    
    public String getClasificacion() { 
        return clasificacion; }
    public void setClasificacion(String clasificacion) { 
        this.clasificacion = clasificacion; }
    
    public int getDuracionMinutos() { 
        return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { 
        this.duracionMinutos = duracionMinutos; }
    
    public String getDirector() { 
        return director; }
    public void setDirector(String director) { 
        this.director = director; }
    
    public String getSinopsis() { 
        return sinopsis; }
    public void setSinopsis(String sinopsis) { 
        this.sinopsis = sinopsis; }
    
    public String getDuracionFormateada() {
        int horas = duracionMinutos / 60;
        int minutos = duracionMinutos % 60;
        return horas + "h " + minutos + "min";
    }
    
    @Override
    public String toString() {
        return titulo + " (" + clasificacion + ") - " + getDuracionFormateada();
    }
}
