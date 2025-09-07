package ar.edu.unahur.obj2.wtoj.contenido.serieTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.serie.Episodio;
import ar.edu.unahur.obj2.wtoj.contenido.serie.Temporada;
import ar.edu.unahur.obj2.wtoj.contenido.serie.Serie;

public class SerieTest {
    @Test
    void testGetNombre() {
        Serie serie = new Serie("Breaking Bad", 4.0);
        assertEquals("Breaking Bad", serie.getTitulo());
    }

    @Test
    void testCalcularCostoSinTemporadas() {
        Serie serie = new Serie("Breaking Bad", 4.0);
        assertEquals(4.0, serie.calcularCosto());
    }

    @Test
    void testCalcularCostoConTemporadas() {
        Serie serie = new Serie("Breaking Bad", 4.0);

        Temporada temporada1 = new Temporada(1);
        temporada1.agregarEpisodio(new Episodio(1, "Pilot"));
        temporada1.agregarEpisodio(new Episodio(2, "Cat's in the Bag..."));
        temporada1.agregarEpisodio(new Episodio(3, "...And the Bag's in the River"));

        Temporada temporada2 = new Temporada(2);
        temporada2.agregarEpisodio(new Episodio(1, "Seven Thirty-Seven"));
        temporada2.agregarEpisodio(new Episodio(2, "Grilled"));

        serie.agregarTemporada(temporada1);
        serie.agregarTemporada(temporada2);

        // Costo de la serie = Costo base + Promedio de los costos de los episodios
        // Costo de la serie = 4.0 + 2.0 = 6.0
        assertEquals(6.0, serie.calcularCosto());
    }

    @Test
    void testCalcularCostoConTemporadaVacia() {
        Serie serie = new Serie("Breaking Bad", 4.0);

        Temporada temporada1 = new Temporada(1);
        // Temporada sin episodios

        serie.agregarTemporada(temporada1);

        // Promedio de episodios por temporada = 0 / 1 = 0.0
        // Costo total = costo base + promedio = 4.0 + 0.0 = 4.0
        assertEquals(4.0, serie.calcularCosto());
    }

    @Test
    void testCalcularCostoConVariasTemporadas() {
        Serie serie = new Serie("Breaking Bad", 4.0);

        Temporada temporada1 = new Temporada(1);
        temporada1.agregarEpisodio(new Episodio(1, "Pilot"));
        temporada1.agregarEpisodio(new Episodio(2, "Cat's in the Bag..."));

        Temporada temporada2 = new Temporada(2);
        temporada2.agregarEpisodio(new Episodio(1, "Seven Thirty-Seven"));
        temporada2.agregarEpisodio(new Episodio(2, "Grilled"));
        temporada2.agregarEpisodio(new Episodio(3, "Bit by a Dead Bee"));

        Temporada temporada3 = new Temporada(3);
        temporada3.agregarEpisodio(new Episodio(1, "No Más"));

        serie.agregarTemporada(temporada1);
        serie.agregarTemporada(temporada2);
        serie.agregarTemporada(temporada3);

        // Promedio de episodios por temporada = (2 + 3 + 1) / 3 = 2.0
        // Costo total = costo base + promedio = 4.0 + 2.0 = 6.0
        assertEquals(6.0, serie.calcularCosto());
    }
}
