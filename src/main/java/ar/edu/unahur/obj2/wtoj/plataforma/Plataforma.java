package ar.edu.unahur.obj2.wtoj.plataforma;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.wtoj.usuario.Usuario;

public class Plataforma {
    private List<Usuario> usuariosRegistrados;

    public Plataforma() {
        this.usuariosRegistrados = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
    }

    public Double calcularRecaudacionMensual() {
        return usuariosRegistrados.stream()
                .mapToDouble(Usuario::calcularImporte)
                .sum();
    }

    public void cerrarMes() {
        usuariosRegistrados.forEach(Usuario::reiniciarMes);
    }

    public List<Usuario> getUsuariosRegistrados() {
        return new ArrayList<>(usuariosRegistrados);
    }

}
