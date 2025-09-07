package ar.edu.unahur.obj2.wtoj.contenido.peliculaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.pelicula.Pelicula;

public class PeliculaTest {
    @Test
    void testQueCalculaCostoDeLicencia(){
        //Preparación
        Pelicula pelicula = new Pelicula("Matrix", 3.0);
        Double valorEsperado = 3.0;
        //Ejecución
        Double valorObtenido = pelicula.calcularCosto();
        //Contrastación
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    void testQueCalculaCostoDeLicenciaConDecimales(){
        //Preparación
        Pelicula pelicula = new Pelicula("Matrix", 3.75);
        Double valorEsperado = 3.75;
        //Ejecución
        Double valorObtenido = pelicula.calcularCosto();
        //Contrastación
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    void testQueCalculaCostoDeLicenciaCero(){
        //Preparación
        Pelicula pelicula = new Pelicula("Matrix", 0.0);
        Double valorEsperado = 0.0;
        //Ejecución
        Double valorObtenido = pelicula.calcularCosto();
        //Contrastación
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    void testQueCalculaCostoDeLicenciaAlto(){
        //Preparación
        Pelicula pelicula = new Pelicula("Matrix", 10.0);
        Double valorEsperado = 10.0;
        //Ejecución
        Double valorObtenido = pelicula.calcularCosto();
        //Contrastación
        assertEquals(valorEsperado, valorObtenido);
    }
}
