package com.consultorio.servicio;

import com.consultorio.modelo.Cita;
import com.consultorio.modelo.Doctor;
import com.consultorio.modelo.Paciente;
import com.consultorio.util.ArchivoUtil;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Servicio encargado de la gestión de citas.
 */
public class ServicioCita {

    private List<Cita> citas;
    private static final String ARCHIVO = "citas.json";

    public ServicioCita() {
        cargarCitas();
    }

    private void cargarCitas() {
        Type tipo = new TypeToken<List<Cita>>(){}.getType();
        citas = ArchivoUtil.leerLista(ARCHIVO, tipo);
        if (citas == null) {
            citas = new ArrayList<>();
        }
    }

    public void crearCita(Scanner scanner, ServicioDoctor servicioDoctor, ServicioPaciente servicioPaciente) {
        System.out.println("\n--- Crear Cita ---");

        // Mostrar doctores disponibles
        servicioDoctor.listarDoctores();
        System.out.print("ID del Doctor: ");
        String idDoctor = scanner.nextLine().trim();
        Doctor doctor = servicioDoctor.buscarPorId(idDoctor);
        if (doctor == null) {
            System.out.println("Error: Doctor no encontrado.");
            return;
        }

        // Mostrar pacientes disponibles
        servicioPaciente.listarPacientes();
        System.out.print("ID del Paciente: ");
        String idPaciente = scanner.nextLine().trim();
        Paciente paciente = servicioPaciente.buscarPorId(idPaciente);
        if (paciente == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        System.out.print("ID de la cita: ");
        String id = scanner.nextLine().trim();
        System.out.print("Fecha y hora (dd/MM/yyyy HH:mm): ");
        String fechaHora = scanner.nextLine().trim();
        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine().trim();

        Cita cita = new Cita(id, fechaHora, motivo, idDoctor, idPaciente);
        citas.add(cita);
        ArchivoUtil.guardarLista(ARCHIVO, citas);
        System.out.println("Cita creada exitosamente.");
    }

    public void listarCitas() {
        System.out.println("\n--- Lista de Citas ---");
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        for (Cita c : citas) {
            System.out.println(c);
        }
    }
}
