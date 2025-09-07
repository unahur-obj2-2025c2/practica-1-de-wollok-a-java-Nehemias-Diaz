package ar.edu.unahur.obj2.wtoj.plan;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public abstract class Plan {
    // Método abstracto para calcular el costo mensual basado en los contenidos vistos
    //Cada clase extendida de Plan implementará este método según sus propias reglas de cálculo
    public abstract Double calcularCostoMensual(List<Contenido> contenidosVistos);
}
