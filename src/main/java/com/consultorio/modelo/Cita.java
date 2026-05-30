package com.consultorio.modelo;

/**
 * Clase que representa una Cita médica.
 * Relaciona un Doctor con un Paciente en una fecha y hora específica.
 */
public class Cita {
    private String id;
    private String fechaHora; // Formato: dd/MM/yyyy HH:mm
    private String motivo;
    private String idDoctor;
    private String idPaciente;

    public Cita() {}

    public Cita(String id, String fechaHora, String motivo, String idDoctor, String idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Fecha: " + fechaHora + " | Motivo: " + motivo
                + " | Doctor: " + idDoctor + " | Paciente: " + idPaciente;
    }
}
