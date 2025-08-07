/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineotaku.proyecto_cine.controlador;

/**
 *
 * @author User
 */

import java.util.List;

public interface IFileLoader<T> {
    List<T> cargarDesdeArchivo(String rutaArchivo);
    void guardarEnArchivo(List<T> lista, String rutaArchivo);
}