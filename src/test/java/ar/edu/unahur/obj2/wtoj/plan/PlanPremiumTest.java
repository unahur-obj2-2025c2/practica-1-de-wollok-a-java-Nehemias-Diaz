package ar.edu.unahur.obj2.wtoj.plan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class PlanPremiumTest {
    @Test
    void testCalcularCostoMensual() {
        PlanPremium planPremium = new PlanPremium();
        // Crear una lista de contenidos vistos (puede estar vacía ya que el costo es fijo)
        List<Contenido> contenidosVistos = new ArrayList<>();
        // Calcular el costo mensual para el plan premium
        Double costoPremium = planPremium.calcularCostoMensual(contenidosVistos);
        // Verificar que el costo es igual al costo fijo mensual (12.0)
        assertEquals(12.0, costoPremium);
    }
}
