package ar.edu.unahur.obj2.wtoj.contenido.documentalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.documental.Documental;
import ar.edu.unahur.obj2.wtoj.contenido.documental.Idra;

public class DocumentalTest {

    @BeforeEach
    void resetCanon() {
        // Valor por defecto para cada test
        Idra.getInstancia().setCanon(0.5);
    }

    @Test
    void testCostoConCanonPorDefecto() {
        Documental documental = new Documental("Interestellar", 2.0);
        assertEquals(2.5, documental.calcularCosto());
    }

    @Test
    void testCostoConCanonModificado() {
        Documental documental = new Documental("Papi y Mami", 2.0);
        Idra.getInstancia().setCanon(1.0);
        assertEquals(3.0, documental.calcularCosto());
    }

    @Test
    void testCostoConCanonCero() {
        Documental documental = new Documental("irhgyugidfirf", 2.0);
        Idra.getInstancia().setCanon(0.0);
        assertEquals(2.0, documental.calcularCosto());
    }

    @Test
    void testCostoConCanonAlto() {
        Documental documental = new Documental("Documental Caro", 2.0);
        Idra.getInstancia().setCanon(5.0);
        assertEquals(7.0, documental.calcularCosto());
    }

    // Casos adicionales
    @Test
    void testCostoConCostoBaseCero() {
        Documental documental = new Documental("Gratis", 0.0);
        assertEquals(0.5, documental.calcularCosto());
    }

    @Test
    void testCostoConDecimales() {
        Documental documental = new Documental("Decimales", 2.75);
        Idra.getInstancia().setCanon(1.25);
        assertEquals(4.0, documental.calcularCosto());
    }

    @Test
    void testTituloVacio() {
        Documental documental = new Documental("", 3.0);
        assertEquals(3.5, documental.calcularCosto());
    }
}
