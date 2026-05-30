package com.consultorio.modelo;

/**
 * Clase que representa a un Doctor del consultorio.
 * Hereda de Persona y agrega la especialidad.
 */
public class Doctor extends Persona {
    private String especialidad;

    public Doctor() {}

    public Doctor(String id, String nombreCompleto, String especialidad) {
        super(id, nombreCompleto);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: " + especialidad;
    }
}
