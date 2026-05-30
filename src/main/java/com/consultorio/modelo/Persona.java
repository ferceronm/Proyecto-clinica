package com.consultorio.modelo;

/**
 * Clase abstracta base para todas las personas del sistema.
 * Implementa los atributos comunes (id y nombre).
 */
public abstract class Persona {
    protected String id;
    protected String nombreCompleto;

    public Persona() {}

    public Persona(String id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombreCompleto;
    }
}
