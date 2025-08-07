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
import java.util.*;
import java.util.stream.Collectors;



public class EmpleadoControlador implements ICrudOperations<Empleado>, IFileLoader<Empleado> {
    private List<Empleado> empleados;
    private int siguienteId;
    private Empleado empleadoActual;
    
    public EmpleadoControlador() {
        this.empleados = new ArrayList<>();
        this.siguienteId = 1;
        cargarEmpleados();
    }
    
    private void cargarEmpleados() {
        try {
            this.empleados = cargarDesdeArchivo("src/main/resources/empleados.txt");
            if (!empleados.isEmpty()) {
                siguienteId = empleados.stream().mapToInt(Empleado::getId).max().orElse(0) + 1;
            }
        } catch (Exception e) {
            // Cargar empleado por defecto
            empleados.add(new Empleado(1, "Admin", "Sistema", "Administrador", "1234567890", "admin", "admin123"));
            siguienteId = 2;
        }
    }
    
    public boolean autenticar(String usuario, String contraseña) {
        empleadoActual = empleados.stream()
                .filter(e -> e.getUsuario().equals(usuario) && e.getContraseña().equals(contraseña))
                .findFirst()
                .orElse(null);
        return empleadoActual != null;
    }
    
    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }
    
    public void cerrarSesion() {
        empleadoActual = null;
    }
    
    @Override
    public void crear(Empleado empleado) {
        empleado.setId(siguienteId++);
        empleados.add(empleado);
    }
    
    @Override
    public Empleado obtenerPorId(int id) {
        return empleados.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Empleado> obtenerTodos() {
        return new ArrayList<>(empleados);
    }
    
    @Override
    public void actualizar(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                empleados.set(i, empleado);
                break;
            }
        }
    }
    
    @Override
    public void eliminar(int id) {
        empleados.removeIf(e -> e.getId() == id);
    }
    
    @Override
    public List<Empleado> cargarDesdeArchivo(String rutaArchivo) {
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 7) {
                    lista.add(new Empleado(
                        Integer.parseInt(datos[0]),
                        datos[1], datos[2], datos[3],
                        datos[4], datos[5], datos[6]
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo de empleados: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public void guardarEnArchivo(List<Empleado> lista, String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Empleado e : lista) {
                pw.println(e.getId() + "|" + e.getNombre() + "|" + e.getApellido() + "|" + 
                          e.getCargo() + "|" + e.getCedula() + "|" + e.getUsuario() + "|" + e.getContraseña());
            }
        } catch (IOException e) {
            System.err.println("Error guardando empleados: " + e.getMessage());
        }
    }
}