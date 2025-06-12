package org.example;

import java.util.Random;
import java.util.Scanner;

public class registrarUsuario {
    public static Usuario crearUsuario(Scanner sc, String tipo) {
        Random random = new Random();
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Ingrese el apellido: ");
        String apellido = sc.nextLine().trim();
        int idBiblioteca = random.nextInt(4001) + 1000;
        System.out.print("Ingrese la edad: ");
        int edad = leerOpcion(sc, 1, 100);
        System.out.print("Ingrese el correo electrónico: ");
        String correo = sc.nextLine().trim();

        switch (tipo.toLowerCase()) {
            case "estudiante":
                System.out.print("Ingrese el código único: ");
                String codigoUnico = sc.nextLine().trim();
                System.out.print("Ingrese el nivel académico (pregrado/posgrado): ");
                String nivelAcademico = sc.nextLine().trim();
                return new Estudiante(nombre, apellido, idBiblioteca, edad, correo, codigoUnico, nivelAcademico);
            case "profesor":
                System.out.print("Ingrese el departamento: ");
                String departamento = sc.nextLine().trim();
                System.out.print("Ingrese el título académico: ");
                String tituloAcademico = sc.nextLine().trim();
                return new Profesor(nombre, apellido, idBiblioteca, edad, correo, departamento, tituloAcademico);
            case "visitante":
                System.out.print("Ingrese la ciudad: ");
                String ciudad = sc.nextLine().trim();
                System.out.print("¿Es extranjero? (sí/no): ");
                boolean extranjero = sc.nextLine().trim().equalsIgnoreCase("sí");
                return new Visitante(nombre, apellido, idBiblioteca, edad, correo, ciudad, extranjero);
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }

    private static int leerOpcion(Scanner sc, int min, int max) {
        while (true) {
            try {
                int op = Integer.parseInt(sc.nextLine().trim());
                if (op < min || op > max) {
                    System.out.printf("Error: ingrese un número entre %d y %d%n", min, max);
                    continue;
                }
                return op;
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese solo números.");
            }
        }
    }
}
