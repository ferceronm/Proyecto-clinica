package com.consultorio.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para el manejo de archivos JSON.
 * Permite leer y escribir listas de objetos en formato JSON.
 */
public class ArchivoUtil {

    private static final String CARPETA_DB = "db";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Inicializa la carpeta db y los archivos necesarios si no existen.
     */
    public static void inicializarArchivos() {
        try {
            Path carpeta = Paths.get(CARPETA_DB);
            if (!Files.exists(carpeta)) {
                Files.createDirectories(carpeta);
            }

            // Crear archivo de administradores por defecto si no existe
            Path archivoAdmin = carpeta.resolve("administradores.json");
            if (!Files.exists(archivoAdmin)) {
                String contenido = "[{\"usuario\":\"admin\",\"contrasena\":\"admin123\"}]";
                Files.writeString(archivoAdmin, contenido);
                System.out.println("Archivo de administradores creado con usuario por defecto (admin/admin123).");
            }

            // Crear archivos vacíos si no existen
            String[] archivos = {"doctores.json", "pacientes.json", "citas.json"};
            for (String archivo : archivos) {
                Path path = carpeta.resolve(archivo);
                if (!Files.exists(path)) {
                    Files.writeString(path, "[]");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al inicializar archivos: " + e.getMessage());
        }
    }

    /**
     * Lee una lista de objetos desde un archivo JSON.
     */
    public static <T> List<T> leerLista(String nombreArchivo, Type tipo) {
        Path path = Paths.get(CARPETA_DB, nombreArchivo);
        try {
            if (!Files.exists(path)) {
                return new ArrayList<>();
            }
            String contenido = Files.readString(path);
            List<T> lista = gson.fromJson(contenido, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error al leer archivo " + nombreArchivo + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Guarda una lista de objetos en un archivo JSON.
     */
    public static <T> void guardarLista(String nombreArchivo, List<T> lista) {
        Path path = Paths.get(CARPETA_DB, nombreArchivo);
        try {
            String contenido = gson.toJson(lista);
            Files.writeString(path, contenido);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
