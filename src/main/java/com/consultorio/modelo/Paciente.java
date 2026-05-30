package com.consultorio.modelo;

/**
 * Clase que representa a un Paciente del consultorio.
 * Hereda de Persona.
 */
public class Paciente extends Persona {

    public Paciente() {}

    public Paciente(String id, String nombreCompleto) {
        super(id, nombreCompleto);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
