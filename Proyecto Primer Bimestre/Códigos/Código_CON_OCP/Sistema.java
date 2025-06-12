package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Material> materiales = new ArrayList<>();
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
                case 1:
                    gestionarClientes(sc);
                    break;
                case 2:
                    gestionarMateriales(sc);
                    break;
                case 3:
                    gestionarPrestamos(sc);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Gracias por usar!");
                    menu = false;
                    break;
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
                case 1:
                    agregarCliente(sc);
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del cliente a eliminar: ");
                    int idEliminar = leerOpcion(sc, 1000, 5000);
                    if (eliminarCliente(idEliminar)) {
                        System.out.println("Cliente eliminado exitosamente.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 4:
                    submenu = false;
                    break;
            }
        }
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

            String tipo = switch (op) {
                case 1 -> "estudiante";
                case 2 -> "profesor";
                case 3 -> "visitante";
                default -> "";
            };

            try {
                Usuario usuario = UsuarioFactory.crearUsuario(sc, tipo);
                usuarios.add(usuario);
                System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + " registrado.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            submenu = false;
        }
    }

    private static void mostrarClientes() {
        System.out.println("****** Lista de Clientes ******");
        if (usuarios.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            usuarios.forEach(u -> {
                u.mostrarCliente();
                System.out.println("-------------------");
            });
        }
    }

    private static boolean eliminarCliente(int idEliminar) {
        return usuarios.removeIf(u -> u.getIdBiblioteca() == idEliminar);
    }

    private static void gestionarMateriales(Scanner sc) {
        boolean submenu = true;
        while (submenu) {
            System.out.println("**** Gestión de Materiales ****");
            System.out.println("1. Agregar material");
            System.out.println("2. Ver lista de materiales");
            System.out.println("3. Eliminar material");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            int op = leerOpcion(sc, 1, 4);
            switch (op) {
                case 1:
                    agregarMaterial(sc);
                    break;
                case 2:
                    if (materiales.isEmpty()) {
                        System.out.println("No hay materiales registrados.");
                    } else {
                        System.out.println("****** Lista de Materiales ******");
                        materiales.forEach(m -> {
                            m.mostrarMaterial();
                            System.out.println("-------------------");
                        });
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del material a eliminar: ");
                    String idEliminar = sc.nextLine().trim();
                    boolean removed = materiales.removeIf(m -> m.getId().equals(idEliminar));
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

            String tipo = switch (op) {
                case 1 -> "libro";
                case 2 -> "dvd";
                default -> "";
            };

            try {
                Material material = Materialfactory.crearMaterial(sc, tipo);
                materiales.add(material);
                System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + " registrado.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
                case 1:
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = leerOpcion(sc, 1000, 5000);
                    System.out.print("Ingrese el ID del material: ");
                    String idMaterial = sc.nextLine().trim();

                    Usuario usuario = buscarUsuario(idUsuario);
                    Material material = materiales.stream()
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
                    break;
                case 2:
                    System.out.print("Ingrese el ID del material a devolver: ");
                    idMaterial = sc.nextLine().trim();
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
                    break;
                case 3:
                    if (prestamos.isEmpty()) {
                        System.out.println("No hay préstamos activos.");
                    } else {
                        System.out.println("****** Préstamos Activos ******");
                        prestamos.stream()
                                .filter(Prestamo::isActivo)
                                .forEach(p -> System.out.printf("Usuario: %s, Material: %s, Fecha de devolución: %s%n",
                                        p.getUsuario().getNombre(),
                                        p.getMaterial().getTitulo(),
                                        p.getFechaDevolucion()));
                    }
                    break;
                case 4:
                    submenu = false;
                    break;
            }
        }
    }

    private static Usuario buscarUsuario(int idUsuario) {
        return usuarios.stream()
                .filter(u -> u.getIdBiblioteca() == idUsuario)
                .findFirst()
                .orElse(null);
    }
}
