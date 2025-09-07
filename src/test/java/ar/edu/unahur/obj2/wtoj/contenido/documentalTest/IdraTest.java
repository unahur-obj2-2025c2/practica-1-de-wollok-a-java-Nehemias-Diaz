package ar.edu.unahur.obj2.wtoj.contenido.documentalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.documental.Idra;

public class IdraTest {
    @AfterEach
    void resetIdraCanon() {
        Idra.getInstancia().setCanon(0.5);
    }

    @Test
    void testSingleton() {
        // Organizar: Obtenemos dos referencias a la instancia del Singleton.
        Idra instancia1 = Idra.getInstancia();
        Idra instancia2 = Idra.getInstancia();

        // Verificar: Comprobamos que ambas referencias apuntan a la misma instancia.
        assert (instancia1 == instancia2);
    }

    @Test
    void testCanonPorDefecto() {
        // Organizar: Obtenemos la instancia del Singleton.
        Idra instancia = Idra.getInstancia();

        // Verificar: Comprobamos que el valor inicial del canon es 0.5.
        assertEquals(0.5, instancia.getCanon());
    }

    @Test
    void testModificarCanon() {
        // Organizar: Obtenemos la instancia y un nuevo valor para el canon.
        Idra instancia = Idra.getInstancia();
        Double nuevoCanon = 1.0;

        // Actuar: Modificamos el valor del canon.
        instancia.setCanon(nuevoCanon);

        // Verificar: Comprobamos que el canon ha cambiado al nuevo valor.
        assertEquals(nuevoCanon, instancia.getCanon());
    }

    @Test
    void testPersistenciaDeCanon() {
        // Organizar: Obtenemos la instancia y modificamos el canon.
        Idra instancia1 = Idra.getInstancia();
        Double nuevoCanon = 1.5;
        instancia1.setCanon(nuevoCanon);

        // Actuar: Obtenemos otra referencia a la instancia del Singleton.
        Idra instancia2 = Idra.getInstancia();

        // Verificar: Comprobamos que el canon persiste y es igual al nuevo valor.
        assertEquals(nuevoCanon, instancia2.getCanon());
    }
}