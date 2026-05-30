package com.consultorio.servicio;

import com.consultorio.modelo.Doctor;
import com.consultorio.util.ArchivoUtil;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Servicio encargado de la gestión de doctores.
 */
public class ServicioDoctor {

    private List<Doctor> doctores;
    private static final String ARCHIVO = "doctores.json";

    public ServicioDoctor() {
        cargarDoctores();
    }

    private void cargarDoctores() {
        Type tipo = new TypeToken<List<Doctor>>(){}.getType();
        doctores = ArchivoUtil.leerLista(ARCHIVO, tipo);
        if (doctores == null) {
            doctores = new ArrayList<>();
        }
    }

    public void altaDoctor(Scanner scanner) {
        System.out.println("\n--- Alta de Doctor ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine().trim();

        Doctor doctor = new Doctor(id, nombre, especialidad);
        doctores.add(doctor);
        ArchivoUtil.guardarLista(ARCHIVO, doctores);
        System.out.println("Doctor registrado exitosamente.");
    }

    public void listarDoctores() {
        System.out.println("\n--- Lista de Doctores ---");
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
            return;
        }
        for (Doctor d : doctores) {
            System.out.println(d);
        }
    }

    public Doctor buscarPorId(String id) {
        for (Doctor d : doctores) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }
}
