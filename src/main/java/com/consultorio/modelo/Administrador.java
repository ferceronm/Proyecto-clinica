package com.consultorio.modelo;

/**
 * Clase que representa un Administrador del sistema.
 * Solo los administradores pueden acceder al sistema.
 */
public class Administrador {
    private String usuario;
    private String contrasena;

    public Administrador() {}

    public Administrador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
