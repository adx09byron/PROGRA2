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

public class FuncionControlador implements ICrudOperations<Funcion>, IFileLoader<Funcion> {
    private List<Funcion> funciones;
    private int siguienteId;
    
    public FuncionControlador() {
        this.funciones = new ArrayList<>();
        this.siguienteId = 1;
        cargarFunciones();
    }
    
    private void cargarFunciones() {
        try {
            this.funciones = cargarDesdeArchivo("src/main/resources/funciones.txt");
            if (!funciones.isEmpty()) {
                siguienteId = funciones.stream().mapToInt(Funcion::getId).max().orElse(0) + 1;
            }
        } catch (Exception e) {
            generarFuncionesPorDefecto();
        }
    }
    
    private void generarFuncionesPorDefecto() {
        // Crear funciones para las 6 películas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        funciones.add(new Funcion(1, 1, 1, LocalDateTime.parse("2025-07-27 14:00", formatter), 120, 8.50));
        funciones.add(new Funcion(2, 1, 1, LocalDateTime.parse("2025-07-27 18:00", formatter), 120, 8.50));
        funciones.add(new Funcion(3, 2, 2, LocalDateTime.parse("2025-07-27 15:30", formatter), 117, 9.00));
        funciones.add(new Funcion(4, 2, 2, LocalDateTime.parse("2025-07-27 19:30", formatter), 117, 9.00));
        funciones.add(new Funcion(5, 3, 1, LocalDateTime.parse("2025-07-28 16:00", formatter), 106, 7.50));
        funciones.add(new Funcion(6, 4, 2, LocalDateTime.parse("2025-07-28 14:30", formatter), 125, 8.00));
        funciones.add(new Funcion(7, 5, 1, LocalDateTime.parse("2025-07-28 20:00", formatter), 124, 9.50));
        funciones.add(new Funcion(8, 6, 2, LocalDateTime.parse("2025-07-28 17:00", formatter), 134, 8.75));
        siguienteId = 9;
    }
    
    public List<Funcion> obtenerFuncionesPorPelicula(int peliculaId) {
        return funciones.stream()
                .filter(f -> f.getPeliculaId() == peliculaId)
                .collect(Collectors.toList());
    }
    
    public List<Funcion> obtenerFuncionesPorSala(int salaId) {
        return funciones.stream()
                .filter(f -> f.getSalaId() == salaId)
                .collect(Collectors.toList());
    }
    
    @Override
    public void crear(Funcion funcion) {
        funcion.setId(siguienteId++);
        funciones.add(funcion);
    }
    
    @Override
    public Funcion obtenerPorId(int id) {
        return funciones.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Funcion> obtenerTodos() {
        return new ArrayList<>(funciones);
    }
    
    @Override
    public void actualizar(Funcion funcion) {
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getId() == funcion.getId()) {
                funciones.set(i, funcion);
                break;
            }
        }
    }
    
    @Override
    public void eliminar(int id) {
        funciones.removeIf(f -> f.getId() == id);
    }
    
    @Override
    public List<Funcion> cargarDesdeArchivo(String rutaArchivo) {
        List<Funcion> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 6) {
                    lista.add(new Funcion(
                        Integer.parseInt(datos[0]),
                        Integer.parseInt(datos[1]),
                        Integer.parseInt(datos[2]),
                        LocalDateTime.parse(datos[3], formatter),
                        Integer.parseInt(datos[4]),
                        Double.parseDouble(datos[5])
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo de funciones: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public void guardarEnArchivo(List<Funcion> lista, String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (Funcion f : lista) {
                pw.println(f.getId() + "|" + f.getPeliculaId() + "|" + f.getSalaId() + "|" + 
                          f.getFechaHora().format(formatter) + "|" + f.getDuracionMinutos() + "|" + f.getPrecio());
            }
        } catch (IOException e) {
            System.err.println("Error guardando funciones: " + e.getMessage());
        }
    }
}
