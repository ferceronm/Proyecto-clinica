package com.consultorio.servicio;

import com.consultorio.modelo.Paciente;
import com.consultorio.util.ArchivoUtil;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Servicio encargado de la gestión de pacientes.
 */
public class ServicioPaciente {

    private List<Paciente> pacientes;
    private static final String ARCHIVO = "pacientes.json";

    public ServicioPaciente() {
        cargarPacientes();
    }

    private void cargarPacientes() {
        Type tipo = new TypeToken<List<Paciente>>(){}.getType();
        pacientes = ArchivoUtil.leerLista(ARCHIVO, tipo);
        if (pacientes == null) {
            pacientes = new ArrayList<>();
        }
    }

    public void altaPaciente(Scanner scanner) {
        System.out.println("\n--- Alta de Paciente ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();

        Paciente paciente = new Paciente(id, nombre);
        pacientes.add(paciente);
        ArchivoUtil.guardarLista(ARCHIVO, pacientes);
        System.out.println("Paciente registrado exitosamente.");
    }

    public void listarPacientes() {
        System.out.println("\n--- Lista de Pacientes ---");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        for (Paciente p : pacientes) {
            System.out.println(p);
        }
    }

    public Paciente buscarPorId(String id) {
        for (Paciente p : pacientes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
