package es.uclm.library.business.controller;

import es.uclm.library.business.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * GestorUsuarios
 * Se encarga de manejar el registro y login de usuarios
 * usando los atributos definidos (login, pass, nombre, etc.)
 */
@Service
public class GestorUsuarios {

    // Lista temporal de usuarios (simula la base de datos)
    private List<Usuario> listaUsuarios = new ArrayList<>();

    /**
     * Registra un nuevo usuario
     */
    public void registrarUsuario(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
            throw new Exception("El login es obligatorio.");
        }
        if (usuario.getPass() == null || usuario.getPass().isEmpty()) {
            throw new Exception("La contraseña es obligatoria.");
        }

        // Comprobar duplicados
        for (Usuario u : listaUsuarios) {
            if (u.getLogin().equalsIgnoreCase(usuario.getLogin())) {
                throw new Exception("Ya existe un usuario con ese login.");
            }
        }

        listaUsuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getLogin());
    }

    /**
     * Valida las credenciales de login
     */
    public boolean validarLogin(String login, String pass) {
        for (Usuario u : listaUsuarios) {
            if (u.getLogin().equalsIgnoreCase(login) && u.getPass().equals(pass)) {
                System.out.println("Usuario autenticado: " + login);
                return true;
            }
        }
        System.out.println("Credenciales incorrectas para: " + login);
        return false;
    }

    /**
     * Devuelve todos los usuarios registrados
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
