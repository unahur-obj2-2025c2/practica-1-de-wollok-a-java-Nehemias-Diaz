package ar.edu.unahur.obj2.wtoj.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.pelicula.Pelicula;
import ar.edu.unahur.obj2.wtoj.plan.Plan;
import ar.edu.unahur.obj2.wtoj.plan.PlanFamiliar;

public class UsuarioTest {
    @Test
    void testCalcularImporte() {
        PlanFamiliar planFamiliar = new PlanFamiliar(3, 100.0);
        Usuario usuario = new Usuario(planFamiliar);
        usuario.registrarContenidoVisto(new Pelicula("Peli 1", 50.0));
        Double importe = usuario.calcularImporte();
        assertEquals(importe, 100.0 * 0.85);
    }

    @Test
    void testCambiarPlan() {
        Plan planInicial = new PlanFamiliar(3, 100.0);
        Plan planNuevo = new PlanFamiliar(5, 150.0);
        Usuario usuario = new Usuario(planInicial);
        usuario.cambiarPlan(planNuevo);
        assertEquals(usuario.getPlanDeSuscripcion(), planNuevo);
    }

    @Test
    void testReiniciarMes() {
        Plan plan = new PlanFamiliar(3, 100.0);
        Usuario usuario = new Usuario(plan);
        //El usuario ha visto algunos contenidos
        usuario.registrarContenidoVisto(new Pelicula("Norbit", 10.0)); // Agregar contenido simulado
        usuario.registrarContenidoVisto(new Pelicula("La salamandra", 100.0)); // Agregar contenido simulado
        // Reiniciar el mes
        usuario.reiniciarMes();
        // Verificar que la lista de contenidos vistos está vacía
        assertEquals(usuario.getContenidosVistos().size(), 0);
    }

    @Test
    void testRegistrarContenidoVisto() {
        Plan plan = new PlanFamiliar(3, 100.0);
        Usuario usuario = new Usuario(plan);
        Pelicula pelicula = new Pelicula("Inception", 20.0);
        usuario.registrarContenidoVisto(pelicula);
        // Verifico que el contenido fue registrado
        assertEquals(usuario.getContenidosVistos().size(), 1);
        assertEquals(usuario.getContenidosVistos().get(0), pelicula);
    }

    @Test
    void testCalcularImporteSinContenidos() {
        Plan plan = new PlanFamiliar(3, 100.0);
        Usuario usuario = new Usuario(plan);
        // Calcular el importe sin haber visto contenidos
        Double importe = usuario.calcularImporte();
        // El importe debería ser el costo fijo mensual del plan familiar (100.0 * 0.85)
        assertEquals(importe, 100.0 * 0.85);
    }

    @Test
    void testCalcularImporteConExceso() {
        Plan plan = new PlanFamiliar(2, 100.0);
        Usuario usuario = new Usuario(plan);
        // Registrar más contenidos de los permitidos por el plan
        usuario.registrarContenidoVisto(new Pelicula("Peli 1", 50.0));
        usuario.registrarContenidoVisto(new Pelicula("Peli 2", 30.0));
        usuario.registrarContenidoVisto(new Pelicula("Peli 3", 20.0)); // Exceso
        // Calcular el importe
        Double importe = usuario.calcularImporte();
        // Costo esperado: 100 (fijo) + 20 (exceso) = 120, con descuento del 15% = 102
        assertEquals(importe, 120.0 * 0.85);
    }
}
