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

public interface ICrudOperations<T> {
    void crear(T item);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
    void actualizar(T item);
    void eliminar(int id);
}
