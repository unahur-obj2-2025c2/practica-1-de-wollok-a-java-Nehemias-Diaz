package ar.edu.unahur.obj2.wtoj.contenido.serie;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private Integer numTemporada;
    private List<Episodio> episodios = new ArrayList<>();

    public Temporada(Integer numTemporada) {
        this.numTemporada = numTemporada;
    }

    public void agregarEpisodio(Episodio unEpisodio) {
        episodios.add(unEpisodio);
    }

    public Double promedioEpisodios() {
        if (episodios.isEmpty())
            return 0.0;
        Double suma = 0.0;
        for (Episodio e : episodios) {
            suma += Episodio.getCostoEpisodio(); // todos tienen el mismo costo
        }
        return suma / episodios.size();
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }
}
