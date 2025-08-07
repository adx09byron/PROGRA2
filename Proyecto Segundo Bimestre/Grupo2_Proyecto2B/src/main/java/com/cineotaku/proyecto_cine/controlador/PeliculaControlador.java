/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineotaku.proyecto_cine.controlador;

/**
 *
 * @author User
 */

import com.cineotaku.proyecto_cine.modelo.Pelicula;
import com.cineotaku.proyecto_cine.controlador.ICrudOperations;
import com.cineotaku.proyecto_cine.controlador.IFileLoader;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PeliculaControlador implements ICrudOperations<Pelicula>, IFileLoader<Pelicula> {
    private List<Pelicula> peliculas;
    private int siguienteId;
    
    public PeliculaControlador() {
        this.peliculas = new ArrayList<>();
        this.siguienteId = 1;
        cargarPeliculas();
    }
    
    private void cargarPeliculas() {
        try {
            this.peliculas = cargarDesdeArchivo("src/main/resources/peliculas.txt");
            if (!peliculas.isEmpty()) {
                siguienteId = peliculas.stream().mapToInt(Pelicula::getId).max().orElse(0) + 1;
            }
        } catch (Exception e) {
            System.err.println("Error cargando películas: " + e.getMessage());
            // Cargar películas por defecto si no se puede leer el archivo
            cargarPeliculasPorDefecto();
        }
    }
    
    private void cargarPeliculasPorDefecto() {
        peliculas.add(new Pelicula(1, "Attack on Titan: The Final Season", "Anime/Acción", "PG-13", 120, "Hajime Isayama", "La batalla final por la humanidad"));
        peliculas.add(new Pelicula(2, "Demon Slayer: Mugen Train", "Anime/Aventura", "PG-13", 117, "Haruo Sotozaki", "Tanjiro y sus amigos abordan el Tren Infinito"));
        peliculas.add(new Pelicula(3, "Your Name", "Anime/Romance", "PG", 106, "Makoto Shinkai", "Dos adolescentes intercambian cuerpos misteriosamente"));
        peliculas.add(new Pelicula(4, "Spirited Away", "Anime/Fantasía", "G", 125, "Hayao Miyazaki", "Una niña debe trabajar para salvar a sus padres"));
        peliculas.add(new Pelicula(5, "Akira", "Anime/Ciencia Ficción", "R", 124, "Katsuhiro Otomo", "Neo-Tokyo en el año 2019"));
        peliculas.add(new Pelicula(6, "Princess Mononoke", "Anime/Aventura", "PG-13", 134, "Hayao Miyazaki", "La guerra entre humanos y dioses del bosque"));
        siguienteId = 7;
    }
    
    @Override
    public void crear(Pelicula pelicula) {
        pelicula.setId(siguienteId++);
        peliculas.add(pelicula);
    }
    
    @Override
    public Pelicula obtenerPorId(int id) {
        return peliculas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Pelicula> obtenerTodos() {
        return new ArrayList<>(peliculas);
    }
    
    @Override
    public void actualizar(Pelicula pelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == pelicula.getId()) {
                peliculas.set(i, pelicula);
                break;
            }
        }
    }
    
    @Override
    public void eliminar(int id) {
        peliculas.removeIf(p -> p.getId() == id);
    }
    
    @Override
    public List<Pelicula> cargarDesdeArchivo(String rutaArchivo) {
        List<Pelicula> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 7) {
                    lista.add(new Pelicula(
                        Integer.parseInt(datos[0]),
                        datos[1], datos[2], datos[3],
                        Integer.parseInt(datos[4]),
                        datos[5], datos[6]
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo de películas: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public void guardarEnArchivo(List<Pelicula> lista, String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Pelicula p : lista) {
                pw.println(p.getId() + "|" + p.getTitulo() + "|" + p.getGenero() + "|" + 
                          p.getClasificacion() + "|" + p.getDuracionMinutos() + "|" + 
                          p.getDirector() + "|" + p.getSinopsis());
            }
        } catch (IOException e) {
            System.err.println("Error guardando películas: " + e.getMessage());
        }
    }
}
