package ar.edu.unahur.obj2.wtoj.contenido.documental;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class Documental extends Contenido {

    public Documental(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    @Override
    public Double calcularCosto() {
        // Uso el singleton para obtener el canon, se lo pido a la unica instancia del Idra
        return getCostoBase() + Idra.getInstancia().getCanon();
    }
}
