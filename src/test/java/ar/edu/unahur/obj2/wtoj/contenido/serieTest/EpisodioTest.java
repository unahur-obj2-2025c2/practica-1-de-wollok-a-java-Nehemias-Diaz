package ar.edu.unahur.obj2.wtoj.contenido.serieTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.serie.Episodio;

public class EpisodioTest {
    @AfterEach
    void tearDown() {
        Episodio.setCostoEpisodio(2.0);
    }

    @Test
    void testConstructor() {

        Episodio episodio = new Episodio(1, "Pilot");

        assertEquals(1, episodio.getNumEpisodio());
        assertEquals("Pilot", episodio.getTitulo());
    }

    @Test
    void testCostoPorDefecto() {
        Episodio episodio = new Episodio(1, "Pilot");
        assertEquals(2.0, Episodio.getCostoEpisodio());
    }

    @Test
    void testCambioCostoEstatico() {
        Episodio episodio1 = new Episodio(1, "Pilot");
        Episodio episodio2 = new Episodio(2, "Second Episode");
        Double nuevoCosto = 3.5;

        Episodio.setCostoEpisodio(nuevoCosto);

        assertEquals(nuevoCosto, Episodio.getCostoEpisodio());
        assertEquals(nuevoCosto, episodio1.getCostoEpisodio());
        assertEquals(nuevoCosto, episodio2.getCostoEpisodio());
    }

    @Test
    void testCostoEstaticoIndependienteDeInstancias() {
        Episodio episodio1 = new Episodio(1, "Pilot");
        Double nuevoCosto = 4.0;

        Episodio.setCostoEpisodio(nuevoCosto);

        assertEquals(nuevoCosto, episodio1.getCostoEpisodio());
        assertEquals(nuevoCosto, Episodio.getCostoEpisodio());
    }

    @Test
    void testMultipleCambiosCostoEstatico() {
        Double primerCosto = 3.0;
        Double segundoCosto = 5.0;

        Episodio.setCostoEpisodio(primerCosto);
        assertEquals(primerCosto, Episodio.getCostoEpisodio());

        Episodio.setCostoEpisodio(segundoCosto);
        assertEquals(segundoCosto, Episodio.getCostoEpisodio());
    }

    @Test
    void testCostoEstaticoDespuesDeVariasInstancias() {
        Episodio episodio1 = new Episodio(1, "Pilot");
        Episodio episodio2 = new Episodio(2, "Second Episode");
        Double nuevoCosto = 6.0;

        Episodio.setCostoEpisodio(nuevoCosto);

        assertEquals(nuevoCosto, episodio1.getCostoEpisodio());
        assertEquals(nuevoCosto, episodio2.getCostoEpisodio());
        assertEquals(nuevoCosto, Episodio.getCostoEpisodio());
    }
}
