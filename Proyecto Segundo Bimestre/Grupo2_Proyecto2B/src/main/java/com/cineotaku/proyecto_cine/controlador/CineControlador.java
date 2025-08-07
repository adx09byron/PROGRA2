/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineotaku.proyecto_cine.controlador;

/**
 *
 * @author User
 */

import com.cineotaku.proyecto_cine.modelo.*;
import com.cineotaku.proyecto_cine.controlador.ICrudOperations;
import com.cineotaku.proyecto_cine.controlador.IFileLoader;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class CineControlador {
    private PeliculaControlador peliculaControlador;
    private EmpleadoControlador empleadoControlador;
    private FuncionControlador funcionControlador;
    private SalaControlador salaControlador;
    
    public CineControlador() {
        this.peliculaControlador = new PeliculaControlador();
        this.empleadoControlador = new EmpleadoControlador();
        this.funcionControlador = new FuncionControlador();
        this.salaControlador = new SalaControlador();
    }
    
    // Métodos de acceso a controladores
    public PeliculaControlador getPeliculaControlador() {
        return peliculaControlador;
    }
    
    public EmpleadoControlador getEmpleadoControlador() {
        return empleadoControlador;
    }
    
    public FuncionControlador getFuncionControlador() {
        return funcionControlador;
    }
    
    public SalaControlador getSalaControlador() {
        return salaControlador;
    }
    
    // Métodos de conveniencia
    public boolean autenticarEmpleado(String usuario, String contraseña) {
        return empleadoControlador.autenticar(usuario, contraseña);
    }
    
    public List<Pelicula> obtenerPeliculasEnCartelera() {
        return peliculaControlador.obtenerTodos();
    }
    
    public List<Funcion> obtenerFuncionesPorPelicula(int peliculaId) {
        return funcionControlador.obtenerFuncionesPorPelicula(peliculaId);
    }
    
    public boolean reservarAsiento(int salaId, char fila, int numero) {
        return salaControlador.reservarButaca(salaId, fila, numero);
    }
}
