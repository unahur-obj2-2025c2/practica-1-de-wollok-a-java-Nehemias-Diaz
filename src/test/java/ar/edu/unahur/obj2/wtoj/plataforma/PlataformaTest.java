package ar.edu.unahur.obj2.wtoj.plataforma;

import ar.edu.unahur.obj2.wtoj.plan.PlanBasico;
import ar.edu.unahur.obj2.wtoj.plan.PlanPremium;
import ar.edu.unahur.obj2.wtoj.usuario.Usuario;
import ar.edu.unahur.obj2.wtoj.contenido.pelicula.Pelicula;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlataformaTest {

        @Test
        public void testRegistrarUsuario() {
                Plataforma plataforma = new Plataforma();
                Usuario usuario = new Usuario(new PlanBasico(3, 100.0));

                plataforma.registrarUsuario(usuario);

                List<Usuario> usuarios = plataforma.getUsuariosRegistrados();
                assertEquals(1, usuarios.size());
                assertTrue(usuarios.contains(usuario));
        }

        @Test
        public void testCalcularRecaudacionMensualConUsuarios() {
                Plataforma plataforma = new Plataforma();

                Usuario usuario1 = new Usuario(new PlanBasico(2, 100.0));
                Usuario usuario2 = new Usuario(new PlanPremium());

                usuario1.registrarContenidoVisto(new Pelicula("Matrix", 10.0));
                usuario1.registrarContenidoVisto(new Pelicula("Avatar", 15.0));
                usuario1.registrarContenidoVisto(new Pelicula("Inception", 20.0));

                plataforma.registrarUsuario(usuario1);
                plataforma.registrarUsuario(usuario2);

                // Usuario1 paga: 100 (fijo) + 20 (excedente) = 120
                // Usuario2 paga: 12 (fijo Premium)
                Double recaudacionEsperada = 120.0 + 12.0;
                assertEquals(recaudacionEsperada, plataforma.calcularRecaudacionMensual());
        }

        @Test
        public void testCalcularRecaudacionMensualSinUsuarios() {
                Plataforma plataforma = new Plataforma();

                Double recaudacionEsperada = 0.0;
                assertEquals(recaudacionEsperada, plataforma.calcularRecaudacionMensual());
        }

        @Test
        public void testCerrarMesReiniciaUsuarios() {
                Plataforma plataforma = new Plataforma();
                Usuario usuario = new Usuario(new PlanBasico(2, 100.0));

                usuario.registrarContenidoVisto(new Pelicula("Matrix", 10.0));
                usuario.registrarContenidoVisto(new Pelicula("Avatar", 15.0));

                plataforma.registrarUsuario(usuario);

                assertFalse(usuario.getContenidosVistos().isEmpty());

                plataforma.cerrarMes();

                // Después de cerrar mes, los contenidos vistos deben resetearse
                assertTrue(usuario.getContenidosVistos().isEmpty());
        }

        @Test
        public void testCerrarMesSinUsuarios() {
                Plataforma plataforma = new Plataforma();

                // No debe lanzar ninguna excepción
                plataforma.cerrarMes();
        }

        @Test
        public void testGetUsuariosRegistrados() {
                Plataforma plataforma = new Plataforma();
                Usuario usuario1 = new Usuario(new PlanBasico(2, 100.0));
                Usuario usuario2 = new Usuario(new PlanPremium());

                plataforma.registrarUsuario(usuario1);
                plataforma.registrarUsuario(usuario2);

                List<Usuario> usuarios = plataforma.getUsuariosRegistrados();
                assertEquals(2, usuarios.size());
                assertTrue(usuarios.contains(usuario1));
                assertTrue(usuarios.contains(usuario2));

                // Verificar que la lista devuelta es una copia
                usuarios.remove(usuario1);
                List<Usuario> usuariosDespues = plataforma.getUsuariosRegistrados();
                assertEquals(2, usuariosDespues.size());
        }

        @Test
        public void testGetUsuariosRegistradosSinUsuarios() {
                Plataforma plataforma = new Plataforma();

                List<Usuario> usuarios = plataforma.getUsuariosRegistrados();
                assertTrue(usuarios.isEmpty());
        }

        @Test
        public void testRegistrarMismoUsuarioVariasVeces() {
                Plataforma plataforma = new Plataforma();
                Usuario usuario = new Usuario(new PlanBasico(2, 100.0));

                plataforma.registrarUsuario(usuario);
                plataforma.registrarUsuario(usuario);

                List<Usuario> usuarios = plataforma.getUsuariosRegistrados();
                assertEquals(2, usuarios.size());
                assertEquals(usuario, usuarios.get(0));
                assertEquals(usuario, usuarios.get(1));
        }
}
