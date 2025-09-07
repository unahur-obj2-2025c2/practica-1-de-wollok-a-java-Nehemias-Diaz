package ar.edu.unahur.obj2.wtoj.contenido.serieTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.serie.Episodio;
import ar.edu.unahur.obj2.wtoj.contenido.serie.Temporada;

public class TemporadaTest {
    @Test
    void testPromedioEpisodiosConEpisodios() {
        Temporada temporada = new Temporada(1);
        temporada.agregarEpisodio(new Episodio(1, "Episodio 1"));
        temporada.agregarEpisodio(new Episodio(1, "Episodio 2"));
        temporada.agregarEpisodio(new Episodio(1, "Episodio 3"));

        Double promedioEsperado = Episodio.getCostoEpisodio(); // Todos los episodios tienen el mismo costo
        assertEquals(temporada.promedioEpisodios(), promedioEsperado);
    }

    @Test
    void testPromedioEpisodiosSinEpisodios() {
        Temporada temporada = new Temporada(1);

        Double promedioEsperado = 0.0; // Promedio es 0 si no hay episodios
        assertEquals(temporada.promedioEpisodios(), promedioEsperado);
    }

    @Test
    void testPromedioEpisodiosConUnSoloEpisodio() {
        Temporada temporada = new Temporada(1);
        temporada.agregarEpisodio(new Episodio(1, "Episodio 1"));

        Double promedioEsperado = Episodio.getCostoEpisodio(); // Promedio es el costo del único episodio
        assertEquals(temporada.promedioEpisodios(), promedioEsperado);
    }

    @Test
    void testPromedioEpisodiosConVariosEpisodios() {
        Temporada temporada = new Temporada(1);
        temporada.agregarEpisodio(new Episodio(1, "Episodio 1"));
        temporada.agregarEpisodio(new Episodio(1, "Episodio 2"));
        temporada.agregarEpisodio(new Episodio(1, "Episodio 3"));
        temporada.agregarEpisodio(new Episodio(1, "Episodio 4"));

        Double promedioEsperado = Episodio.getCostoEpisodio(); // Todos los episodios tienen el mismo costo
        assertEquals(temporada.promedioEpisodios(), promedioEsperado);
    }
}
