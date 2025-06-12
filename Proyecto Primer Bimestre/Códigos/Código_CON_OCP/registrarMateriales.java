package org.example;

import java.util.Scanner;

public class Materialfactory {
    public static Material crearMaterial(Scanner sc, String tipo) {
        System.out.print("Ingrese el ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Ingrese el título: ");
        String titulo = sc.nextLine().trim();
        System.out.print("Ingrese el autor: ");
        String autor = sc.nextLine().trim();

        switch (tipo.toLowerCase()) {
            case "libro":
                System.out.print("Ingrese la editorial: ");
                String editorial = sc.nextLine().trim();
                System.out.print("Ingrese el código ISBN: ");
                String isbn = sc.nextLine().trim();
                return new Libro(id, titulo, autor, editorial, isbn);
            case "dvd":
                System.out.print("Ingrese el género: ");
                String genero = sc.nextLine().trim();
                System.out.print("Ingrese el formato: ");
                String formato = sc.nextLine().trim();
                return new DvD(id, titulo, autor, genero, formato);
            default:
                throw new IllegalArgumentException("Tipo de material no válido");
        }
    }
}
