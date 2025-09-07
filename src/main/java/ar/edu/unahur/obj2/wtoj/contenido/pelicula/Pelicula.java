package ar.edu.unahur.obj2.wtoj.contenido.pelicula;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class Pelicula extends Contenido {

    public Pelicula(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    @Override
    public Double calcularCosto() {
        return getCostoBase(); 
    }
}
