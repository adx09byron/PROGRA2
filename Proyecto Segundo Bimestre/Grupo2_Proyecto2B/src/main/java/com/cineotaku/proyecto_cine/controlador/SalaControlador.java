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

public class SalaControlador implements ICrudOperations<Sala>, IFileLoader<Sala> {
    private List<Sala> salas;
    private Map<Integer, List<Butaca>> butacasPorSala;
    private int siguienteId;
    
    public SalaControlador() {
        this.salas = new ArrayList<>();
        this.butacasPorSala = new HashMap<>();
        this.siguienteId = 1;
        cargarSalas();
        generarButacas();
    }
    
    private void cargarSalas() {
        try {
            this.salas = cargarDesdeArchivo("src/main/resources/salas.txt");
            if (!salas.isEmpty()) {
                siguienteId = salas.stream().mapToInt(Sala::getId).max().orElse(0) + 1;
            }
        } catch (Exception e) {
            // Salas por defecto - 5 filas (A-E) y 4 columnas (1-4) = 20 asientos
            salas.add(new Sala(1, "Sala Otaku 1", 5, 4, true));
            salas.add(new Sala(2, "Sala Otaku 2", 5, 4, true));
            siguienteId = 3;
        }
    }
    
    private void generarButacas() {
        for (Sala sala : salas) {
            List<Butaca> butacas = new ArrayList<>();
            char[] filas = {'A', 'B', 'C', 'D', 'E'};
            
            for (int fila = 0; fila < sala.getFilas(); fila++) {
                for (int columna = 1; columna <= sala.getColumnas(); columna++) {
                    butacas.add(new Butaca(columna, filas[fila], sala.getId()));
                }
            }
            butacasPorSala.put(sala.getId(), butacas);
        }
    }
    
    public List<Butaca> obtenerButacasPorSala(int salaId) {
        return butacasPorSala.getOrDefault(salaId, new ArrayList<>());
    }
    
    public Butaca obtenerButaca(int salaId, char fila, int numero) {
        List<Butaca> butacas = obtenerButacasPorSala(salaId);
        return butacas.stream()
                .filter(b -> b.getFila() == fila && b.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
    
    public boolean reservarButaca(int salaId, char fila, int numero) {
        Butaca butaca = obtenerButaca(salaId, fila, numero);
        if (butaca != null && butaca.isDisponible()) {
            butaca.setReservada(true);
            return true;
        }
        return false;
    }
    
    public boolean ocuparButaca(int salaId, char fila, int numero) {
        Butaca butaca = obtenerButaca(salaId, fila, numero);
        if (butaca != null && butaca.isDisponible()) {
            butaca.setOcupada(true);
            butaca.setReservada(false);
            return true;
        }
        return false;
    }
    
    public void liberarButaca(int salaId, char fila, int numero) {
        Butaca butaca = obtenerButaca(salaId, fila, numero);
        if (butaca != null) {
            butaca.setOcupada(false);
            butaca.setReservada(false);
        }
    }
    
    @Override
    public void crear(Sala sala) {
        sala.setId(siguienteId++);
        salas.add(sala);
        // Generar butacas para la nueva sala
        List<Butaca> butacas = new ArrayList<>();
        char[] filas = {'A', 'B', 'C', 'D', 'E'};
        for (int fila = 0; fila < sala.getFilas(); fila++) {
            for (int columna = 1; columna <= sala.getColumnas(); columna++) {
                butacas.add(new Butaca(columna, filas[fila], sala.getId()));
            }
        }
        butacasPorSala.put(sala.getId(), butacas);
    }
    
    @Override
    public Sala obtenerPorId(int id) {
        return salas.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Sala> obtenerTodos() {
        return new ArrayList<>(salas);
    }
    
    @Override
    public void actualizar(Sala sala) {
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getId() == sala.getId()) {
                salas.set(i, sala);
                break;
            }
        }
    }
    
    @Override
    public void eliminar(int id) {
        salas.removeIf(s -> s.getId() == id);
        butacasPorSala.remove(id);
    }
    
    @Override
    public List<Sala> cargarDesdeArchivo(String rutaArchivo) {
        List<Sala> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 5) {
                    lista.add(new Sala(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Boolean.parseBoolean(datos[4])
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo de salas: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public void guardarEnArchivo(List<Sala> lista, String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Sala s : lista) {
                pw.println(s.getId() + "|" + s.getNombre() + "|" + s.getFilas() + "|" + 
                          s.getColumnas() + "|" + s.isHabilitada());
            }
        } catch (IOException e) {
            System.err.println("Error guardando salas: " + e.getMessage());
        }
    }
}
