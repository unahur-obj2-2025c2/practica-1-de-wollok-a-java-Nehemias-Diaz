package ar.edu.unahur.obj2.wtoj.plan;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.contenido.pelicula.Pelicula;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlanBasicoTest {
    @Test
    void testCalcularCostoMensual() {
        PlanBasico planBasico = new PlanBasico(3, 100.0);

        List<Contenido> contenidosVistos = new ArrayList<>();

        contenidosVistos.add(new Pelicula("Matrix", 10.0));
        contenidosVistos.add(new Pelicula("Avatar", 15.0));
        contenidosVistos.add(new Pelicula("Inception", 20.0));
        contenidosVistos.add(new Pelicula("Interstellar", 12.0));
        contenidosVistos.add(new Pelicula("The Dark Knight", 18.0));
        double costoEsperado = 100 + 12.0 + 18.0; // 130.0
        assertEquals(costoEsperado, planBasico.calcularCostoMensual(contenidosVistos));
    }

    @Test
    void testCalcularCostoMensualConMenosContenidosQueElLimite() {
        PlanBasico planBasico = new PlanBasico(5, 80.0);

        List<Contenido> contenidosVistos = new ArrayList<>();
        contenidosVistos.add(new Pelicula("Matrix", 10.0));
        contenidosVistos.add(new Pelicula("Avatar", 15.0));
        contenidosVistos.add(new Pelicula("Inception", 20.0));

        Double costoEsperado = 80.0; // Solo el costo fijo mensual, ya que no se excede el límite
        assertEquals(costoEsperado, planBasico.calcularCostoMensual(contenidosVistos));
    }

    @Test
    void testCalcularCostoMensualConExactoLimiteDeContenidos() {
        PlanBasico planBasico = new PlanBasico(4, 90.0);

        List<Contenido> contenidosVistos = new ArrayList<>();
        contenidosVistos.add(new Pelicula("Matrix", 10.0));
        contenidosVistos.add(new Pelicula("Avatar", 15.0));
        contenidosVistos.add(new Pelicula("Inception", 20.0));
        contenidosVistos.add(new Pelicula("Interstellar", 12.0));

        Double costoEsperado = 90.0; // Solo el costo fijo mensual, ya que no se excede el límite
        assertEquals(costoEsperado, planBasico.calcularCostoMensual(contenidosVistos));
    }
}