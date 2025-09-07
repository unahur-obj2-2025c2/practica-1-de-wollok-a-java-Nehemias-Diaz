package ar.edu.unahur.obj2.wtoj.usuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.plan.Plan;

public class Usuario {
    private Plan planDeSuscripcion;
    private List<Contenido> contenidosVistos;

    public List<Contenido> getContenidosVistos() {
        return contenidosVistos;
    }

    public Usuario(Plan planDeSuscripcion) {
        this.planDeSuscripcion = planDeSuscripcion;
        this.contenidosVistos = new ArrayList<>();
    }

    public void registrarContenidoVisto(Contenido contenido) {
        contenidosVistos.add(contenido);
    }

    public Double calcularImporte() {
        return planDeSuscripcion.calcularCostoMensual(contenidosVistos);
    }

    public void reiniciarMes() {
        contenidosVistos.clear();
    }

    public void cambiarPlan(Plan nuevoPlan) {
        this.planDeSuscripcion = nuevoPlan;
    }

    public Object getPlanDeSuscripcion() {
        return planDeSuscripcion;
    }
}
