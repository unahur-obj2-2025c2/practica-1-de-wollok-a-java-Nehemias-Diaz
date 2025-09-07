package ar.edu.unahur.obj2.wtoj.plan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.contenido.pelicula.Pelicula;

public class PlanFamiliarTest {
    @Test
    void testCalcularCostoMensual() {
        PlanFamiliar planFamiliar = new PlanFamiliar(3, 100.0);
        PlanBasico planBasico = new PlanBasico(3, 100.0);
        // Crear una lista de contenidos vistos
        List<Contenido> contenidosVistos = new ArrayList<>();   
        // Agregar contenidos a la lista (suponiendo que Contenido tiene un constructor adecuado)
        contenidosVistos.add(new Pelicula("Contenido 1", 50.0));
        contenidosVistos.add(new Pelicula("Contenido 2", 30.0));
        contenidosVistos.add(new Pelicula("Contenido 3", 20.0));
        contenidosVistos.add(new Pelicula("Contenido 4", 10.0)); // Este contenido excede el límite
        // Calcular el costo mensual para ambos planes
        Double costoFamiliar = planFamiliar.calcularCostoMensual(contenidosVistos);
        Double costoBasico = planBasico.calcularCostoMensual(contenidosVistos);
        // Verificar que el costo del plan familiar es un 15% menor que el del
        // plan básico
        assertEquals(costoBasico * 0.85, costoFamiliar);
    }

    @Test
    void testCalcularCostoMensualSinExceso() {
        PlanFamiliar planFamiliar = new PlanFamiliar(3, 100.0);
        // Crear una lista de contenidos vistos
        List<Contenido> contenidosVistos = new ArrayList<>();
        // Agregar contenidos a la lista (suponiendo que Contenido tiene un constructor adecuado)
        contenidosVistos.add(new Pelicula("Contenido 1", 50.0));
        contenidosVistos.add(new Pelicula("Contenido 2", 30.0));
        contenidosVistos.add(new Pelicula("Contenido 3", 20.0)); // No excede el límite
        // Calcular el costo mensual para el plan familiar
        Double costoFamiliar = planFamiliar.calcularCostoMensual(contenidosVistos);
        // Verificar que el costo es igual al costo fijo mensual (100.0) ya que no se
        // excedió el límite
        assertEquals(100.0 * 0.85, costoFamiliar);
    }

    @Test
    void testCalcularCostoMensualConMuchosExcesos() {
        PlanFamiliar planFamiliar = new PlanFamiliar(2, 150.0);
        PlanBasico planBasico = new PlanBasico(2, 150.0);
        // Crear una lista de contenidos vistos
        List<Contenido> contenidosVistos = new ArrayList<>();
        // Agregar contenidos a la lista (suponiendo que Contenido tiene un constructor adecuado)
        contenidosVistos.add(new Pelicula("Contenido 1", 40.0));
        contenidosVistos.add(new Pelicula("Contenido 2", 30.0));
        contenidosVistos.add(new Pelicula("Contenido 3", 20.0));
        contenidosVistos.add(new Pelicula("Contenido 4", 10.0));
        contenidosVistos.add(new Pelicula("Contenido 5", 5.0)); // Estos contenidos exceden el límite
        // Calcular el costo mensual para ambos planes
        Double costoFamiliar = planFamiliar.calcularCostoMensual(contenidosVistos);
        Double costoBasico = planBasico.calcularCostoMensual(contenidosVistos);
        // Verificar que el costo del plan familiar es un 15% menor que el del
        // plan básico
        assertEquals(costoBasico * 0.85, costoFamiliar);
    }

    @Test
    void testCalcularCostoMensualSinContenidos() {
        PlanFamiliar planFamiliar = new PlanFamiliar(3, 120.0);
        // Crear una lista vacía de contenidos vistos
        List<Contenido> contenidosVistos = new ArrayList<>();
        // Calcular el costo mensual para el plan familiar
        Double costoFamiliar = planFamiliar.calcularCostoMensual(contenidosVistos);
        // Verificar que el costo es igual al costo fijo mensual (120.0) ya que no se
        // vieron contenidos
        assertEquals(120.0 * 0.85, costoFamiliar);
    }
}
