package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.Stream;
public class Sistema {
    private static ArrayList<Usuario> estudiantes = new ArrayList<>();
    private static ArrayList<Usuario> profesores = new ArrayList<>();
    private static ArrayList<Usuario> visitantes = new ArrayList<>();
    private static ArrayList<Materiales> dvds = new ArrayList<>();
    private static ArrayList<Materiales> libros = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("**** Menú ****");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de materiales");
            System.out.println("3. Gestión de préstamos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            switch (op) {
                case 1 :
                    gestionarClientes(sc);
                case 2 :
                    gestionarMateriales(sc);
                case 3 :
                    gestionarPrestamos(sc);
                case 4 :
                
                    System.out.println("Saliendo del programa. ¡Gracias por usar!");
                    menu = false;
                
            }
        }
        sc.close();
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

    private static void gestionarClientes(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Gestión de Clientes ****");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Ver lista de clientes");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Regresar al menú principal");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            switch (op) {
                case 1 :
                    agregarCliente(sc);
                case 2 :
                    mostrarClientes();
                case 3 :
                
                    System.out.print("Ingrese el ID del cliente a eliminar: ");
                    int idEliminar = leerOpcion(sc, 1000, 5000);
                    if (eliminarCliente(idEliminar)) {
                        System.out.println("Cliente eliminado exitosamente.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                
                case 4 :
                    submenu = false;
            }
        }
    }

    private static void mostrarClientes() {
        System.out.println("****** Lista de Clientes ******");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Estudiantes:");
            for (Usuario estudiante : estudiantes) {
                estudiante.mostrarCliente();
                System.out.println("-------------------");
            }
        }
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            System.out.println("Profesores:");
            for (Usuario profesor : profesores) {
                profesor.mostrarCliente();
                System.out.println("-------------------");
            }
        }
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
        } else {
            System.out.println("Visitantes:");
            for (Usuario visitante : visitantes) {
                visitante.mostrarCliente();
                System.out.println("-------------------");
            }
        }
    }

    private static boolean eliminarCliente(int idEliminar) {
        return estudiantes.removeIf(u -> u.getIdBiblioteca() == idEliminar) ||
                profesores.removeIf(u -> u.getIdBiblioteca() == idEliminar) ||
                visitantes.removeIf(u -> u.getIdBiblioteca() == idEliminar);
    }

    private static void agregarCliente(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Tipo de Cliente ****");
            System.out.println("1. Estudiante");
            System.out.println("2. Profesor");
            System.out.println("3. Visitante");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            if (op == 4) {
                submenu = false;
                continue;
            }

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

            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese el código único: ");
                    String codigoUnico = sc.nextLine().trim();
                    System.out.print("Ingrese el nivel académico (pregrado/posgrado): ");
                    String nivelAcademico = sc.nextLine().trim();
                    estudiantes.add(new Estudiante(nombre, apellido, idBiblioteca, edad, correo, codigoUnico, nivelAcademico));
                    System.out.println("Estudiante registrado.");
                }
                case 2 -> {
                    System.out.print("Ingrese el departamento: ");
                    String departamento = sc.nextLine().trim();
                    System.out.print("Ingrese el título académico: ");
                    String tituloAcademico = sc.nextLine().trim();
                    profesores.add(new Profesor(nombre, apellido, idBiblioteca, edad, correo, departamento, tituloAcademico));
                    System.out.println("Profesor registrado.");
                }
                case 3 -> {
                    System.out.print("Ingrese la ciudad: ");
                    String ciudad = sc.nextLine().trim();
                    System.out.print("¿Es extranjero? (sí/no): ");
                    boolean extranjero = sc.nextLine().trim().equalsIgnoreCase("sí");
                    visitantes.add(new Visitante(nombre, apellido, idBiblioteca, edad, correo, ciudad, extranjero));
                    System.out.println("Visitante registrado.");
                }
            }
            submenu = false;
        }
    }

    private static void gestionarMateriales(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Gestión de Materiales ****");
            System.out.println("1. Agregar material");
            System.out.println("2. Ver lista de materiales");
            System.out.println("3. Eliminar material");
            System.out.println("4. Regresar");
            System.out.println("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            switch (op) {
                case 1:
                    agregarMaterial(sc);
                    break;
                case 2:
                    if (dvds.isEmpty() && libros.isEmpty()) {
                        System.out.println("No hay materiales registrados.");
                    } else {
                        System.out.println("****** Lista de Materiales ******");
                        dvds.forEach(m -> {
                            m.mostrarMaterial();
                            System.out.println("-------------------");
                        });
                        libros.forEach(m -> {
                            m.mostrarMaterial();
                            System.out.println("-------------------");
                        });
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID del material a eliminar:");
                    String idEliminar = sc.nextLine().trim();
                    boolean removed = dvds.removeIf(m -> m.getId().equals(idEliminar)) || libros.removeIf(m -> m.getId().equals(idEliminar));
                    if (removed) {
                        System.out.println("Material eliminado exitosamente.");
                    } else {
                        System.out.println("Material no encontrado.");
                    }
                    break;
                case 4:
                    submenu = false;
                    break;
            }
        }
    }

    private static void agregarMaterial(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Tipo de Material ****");
            System.out.println("1. Libro");
            System.out.println("2. DVD");
            System.out.println("3. Regresar");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 3);
            if (op == 3) {
                submenu = false;
                continue;
            }

            System.out.print("Ingrese el ID: ");
            String id = sc.nextLine().trim();
            System.out.print("Ingrese el título: ");
            String titulo = sc.nextLine().trim();
            System.out.print("Ingrese el autor: ");
            String autor = sc.nextLine().trim();

            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese la editorial: ");
                    String editorial = sc.nextLine().trim();
                    System.out.print("Ingrese el código ISBN: ");
                    String isbn = sc.nextLine().trim();
                    libros.add(new Libro(id, titulo, autor, editorial, isbn));
                    System.out.println("Libro registrado.");
                }
                case 2 -> {
                    System.out.print("Ingrese el género: ");
                    String genero = sc.nextLine().trim();
                    System.out.print("Ingrese el formato: ");
                    String formato = sc.nextLine().trim();
                    dvds.add(new DvD(id, titulo, autor, genero, formato));
                    System.out.println("DVD registrado.");
                }
            }
            submenu = false;
        }
    }

    private static void gestionarPrestamos(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Gestión de Préstamos ****");
            System.out.println("1. Prestar material");
            System.out.println("2. Devolver material");
            System.out.println("3. Ver préstamos activos");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = leerOpcion(sc, 1000, 5000);
                    System.out.print("Ingrese el ID del material: ");
                    String idMaterial = sc.nextLine().trim();

                    Usuario usuario = buscarUsuario(idUsuario);
                    Materiales material = Stream.concat(dvds.stream(), libros.stream())
                            .filter(m -> m.getId().equals(idMaterial))
                            .findFirst()
                            .orElse(null);

                    if (usuario == null || material == null) {
                        System.out.println("Usuario o material no encontrado.");
                    } else if (!material.isHabilitado()) {
                        System.out.println("El material no está disponible.");
                    } else if (!usuario.puedePrestar()) {
                        System.out.println("El usuario no puede prestar más materiales.");
                    } else {
                        LocalDate fechaPrestamo = LocalDate.now();
                        LocalDate fechaDevolucion = fechaPrestamo.plusDays(usuario.getDiasMaximoPrestamo());
                        Prestamo prestamo = new Prestamo(material, usuario, fechaPrestamo, fechaDevolucion);
                        prestamos.add(prestamo);
                        usuario.getPrestamosActivos().add(prestamo);
                        material.setHabilitado(false);
                        System.out.println("Préstamo registrado.");
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese el ID del material a devolver: ");
                    String idMaterial = sc.nextLine().trim();
                    Prestamo prestamo = prestamos.stream()
                            .filter(p -> p.getMaterial().getId().equals(idMaterial) && p.isActivo())
                            .findFirst()
                            .orElse(null);
                    if (prestamo != null) {
                        prestamo.setActivo(false);
                        prestamo.getMaterial().setHabilitado(true);
                        double multa = prestamo.calcularMulta();
                        if (multa > 0) {
                            System.out.printf("Multa por retraso: $%.2f%n", multa);
                        }
                        System.out.println("Material devuelto.");
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                }
                case 3 -> {
                    if (prestamos.isEmpty()) {
                        System.out.println("No hay préstamos activos.");
                    } else {
                        System.out.println("****** Préstamos Activos ******");
                        for (Prestamo p : prestamos) {
                            if (p.isActivo()) {
                                System.out.printf("Usuario: %s, Material: %s, Fecha de devolución: %s%n",
                                        p.getUsuario().getNombre(),
                                        p.getMaterial().getTitulo(),
                                        p.getFechaDevolucion());
                            }
                        }
                    }
                }
                case 4 -> submenu = false;
            }
        }
    }

    private static Usuario buscarUsuario(int idUsuario) {
        return Stream.concat(estudiantes.stream(), Stream.concat(profesores.stream(), visitantes.stream()))
                .filter(u -> u.getIdBiblioteca() == idUsuario)
                .findFirst()
                .orElse(null);
    }
}
