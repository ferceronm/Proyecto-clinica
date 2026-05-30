package com.consultorio;

import com.consultorio.modelo.*;
import com.consultorio.servicio.*;
import com.consultorio.util.ArchivoUtil;
import java.util.Scanner;

/**
 * Clase principal del Sistema de Administración de Citas.
 * Punto de entrada de la aplicación.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ServicioAutenticacion servicioAuth = new ServicioAutenticacion();
    private static final ServicioDoctor servicioDoctor = new ServicioDoctor();
    private static final ServicioPaciente servicioPaciente = new ServicioPaciente();
    private static final ServicioCita servicioCita = new ServicioCita();

    public static void main(String[] args) {
        System.out.println("=== Sistema de Administración de Citas ===");
        System.out.println("         Consultorio Clínico");
        System.out.println("==========================================\n");

        // Validar y regenerar archivos si no existen
        ArchivoUtil.inicializarArchivos();

        // Control de acceso
        if (!iniciarSesion()) {
            System.out.println("Acceso denegado. El programa se cerrará.");
            return;
        }

        // Menú principal
        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1:
                        servicioDoctor.altaDoctor(scanner);
                        break;
                    case 2:
                        servicioPaciente.altaPaciente(scanner);
                        break;
                    case 3:
                        servicioCita.crearCita(scanner, servicioDoctor, servicioPaciente);
                        break;
                    case 4:
                        servicioDoctor.listarDoctores();
                        break;
                    case 5:
                        servicioPaciente.listarPacientes();
                        break;
                    case 6:
                        servicioCita.listarCitas();
                        break;
                    case 0:
                        ejecutando = false;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static boolean iniciarSesion() {
        System.out.println("--- Inicio de Sesión ---");
        for (int intentos = 0; intentos < 3; intentos++) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine().trim();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine().trim();

            if (servicioAuth.autenticar(usuario, contrasena)) {
                System.out.println("¡Bienvenido, " + usuario + "!\n");
                return true;
            }
            System.out.println("Credenciales incorrectas. Intentos restantes: " + (2 - intentos) + "\n");
        }
        return false;
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Dar de alta doctor");
        System.out.println("2. Dar de alta paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Listar doctores");
        System.out.println("5. Listar pacientes");
        System.out.println("6. Listar citas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
