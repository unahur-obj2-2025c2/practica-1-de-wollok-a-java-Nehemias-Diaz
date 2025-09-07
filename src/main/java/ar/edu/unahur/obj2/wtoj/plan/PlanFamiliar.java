package ar.edu.unahur.obj2.wtoj.plan;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class PlanFamiliar extends PlanBasico {

    public PlanFamiliar(Integer limiteDeContenidos, Double costoFijoMensual) {
        super(limiteDeContenidos, costoFijoMensual);
    }

    @Override
    public Double calcularCostoMensual(List<Contenido> contenidosVistos) {
        // Aplica un 15% de descuento sobre el cálculo del Plan Básico
        return super.calcularCostoMensual(contenidosVistos) * 0.85;
    }
}
