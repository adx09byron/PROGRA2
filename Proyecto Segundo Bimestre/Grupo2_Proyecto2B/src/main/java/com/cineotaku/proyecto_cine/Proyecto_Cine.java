/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cineotaku.proyecto_cine;

/**
 *
 * @author User
 */
import com.cineotaku.proyecto_cine.vista.VentanaInicio;
import javax.swing.*;
import java.awt.*;

/**
 * Clase principal del sistema de cine Otaku
 * Implementa el patrón MVC y principios SOLID
 * 
 * @author Sistema Cine Otaku
 * @version 1.0
 */

public class Proyecto_Cine {
    
    /**
     * Método principal que inicia la aplicación
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           System.err.println("No se pudo establecer el Look and Feel del sistema: " + e.getMessage());
        }
        
        // Configurar propiedades de renderizado para mejor calidad visual
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // Ejecutar la aplicación en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarAplicacion();
            }
        });
    }
    
    /**
     * Inicializa y muestra la ventana principal de la aplicación
     */
    private static void iniciarAplicacion() {
        try {
            // Verificar que los directorios necesarios existan
            crearDirectoriosNecesarios();
            
            // Crear y mostrar la ventana de inicio
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.setVisible(true);
            
            // Mostrar mensaje de bienvenida en consola
            mostrarMensajeBienvenida();
            
        } catch (Exception e) {
            // Manejo de errores durante la inicialización
            String mensaje = "Error al iniciar la aplicación: " + e.getMessage();
            System.err.println(mensaje);
            
            JOptionPane.showMessageDialog(null, 
                mensaje, 
                "Error de Inicialización", 
                JOptionPane.ERROR_MESSAGE);
            
            System.exit(1);
        }
    }
    
    /**
     * Crea los directorios necesarios para el funcionamiento de la aplicación
     */
    private static void crearDirectoriosNecesarios() {
        try {
            java.io.File resourcesDir = new java.io.File("src/main/resources");
            if (!resourcesDir.exists()) {
                resourcesDir.mkdirs();
                System.out.println("Directorio resources creado: " + resourcesDir.getAbsolutePath());
            }
            
            // Crear archivos de datos por defecto si no existen
            crearArchivosDatosPorDefecto();
            
        } catch (Exception e) {
            System.err.println("Error creando directorios: " + e.getMessage());
        }
    }
    
    /**
     * Crea los archivos de datos por defecto si no existen
     */
    private static void crearArchivosDatosPorDefecto() {
        String[] archivos = {
            "peliculas.txt",
            "empleados.txt", 
            "funciones.txt",
            "salas.txt",
            "clientes.txt"
        };
        
        for (String archivo : archivos) {
            java.io.File file = new java.io.File("src/main/resources/" + archivo);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    System.out.println("Archivo creado: " + archivo);
                } catch (java.io.IOException e) {
                    System.err.println("Error creando archivo " + archivo + ": " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Muestra un mensaje de bienvenida en la consola
     */
    private static void mostrarMensajeBienvenida() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎬 SISTEMA DE CINE OTAKU - INICIADO");
        System.out.println("=".repeat(50));
        System.out.println("Versión: 1.0");
        System.out.println("Desarrollado con Java + Swing + Maven");
        System.out.println("Patrón: MVC con principios SOLID");
        System.out.println("Credenciales por defecto:");
        System.out.println("  Usuario: admin");
        System.out.println("  Contraseña: admin123");
        System.out.println("=".repeat(50) + "\n");
    }
    
    /**
     * Configura propiedades adicionales de la aplicación
     * Este método se puede expandir para configuraciones más avanzadas
     */
    private static void configurarPropiedadesAplicacion() {
        // Configurar codificación de caracteres
        System.setProperty("file.encoding", "UTF-8");
        
        // Configurar timezone por defecto
        System.setProperty("user.timezone", "America/Guayaquil");
        
        // Configurar comportamiento de Swing
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
    }
    
    /**
     * Método para realizar limpieza al cerrar la aplicación
     * Se puede usar con shutdown hooks si es necesario
     */
    public static void limpiezaAlCerrar() {
        System.out.println("Cerrando Sistema de Cine Otaku...");
        // Aquí se pueden agregar tareas de limpieza como:
        // - Guardar datos pendientes
        // - Cerrar conexiones
        // - Liberar recursos
        System.out.println("¡Hasta luego! 🎬");
    }
}