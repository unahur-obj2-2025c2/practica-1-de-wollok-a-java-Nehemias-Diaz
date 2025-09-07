package ar.edu.unahur.obj2.wtoj.plan;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class PlanPremium extends Plan {
    private static Double costoFijo = 12.0;
    @Override
    public Double calcularCostoMensual(List<Contenido> contenidosVistos) {
        return costoFijo;
    }
}
