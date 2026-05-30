package com.consultorio.servicio;

import com.consultorio.modelo.Administrador;
import com.consultorio.util.ArchivoUtil;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Servicio encargado de la autenticación de administradores.
 */
public class ServicioAutenticacion {

    private List<Administrador> administradores;

    public ServicioAutenticacion() {
        cargarAdministradores();
    }

    private void cargarAdministradores() {
        Type tipo = new TypeToken<List<Administrador>>(){}.getType();
        administradores = ArchivoUtil.leerLista("administradores.json", tipo);
    }

    public boolean autenticar(String usuario, String contrasena) {
        for (Administrador admin : administradores) {
            if (admin.getUsuario().equals(usuario) && admin.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
