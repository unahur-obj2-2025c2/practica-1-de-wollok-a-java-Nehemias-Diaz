package ar.edu.unahur.obj2.wtoj.contenido.serie;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class Serie extends Contenido {
    // Tipamos la lista con <> indicandole de que tipo va a ser la lista
    private List<Temporada> temporadas = new ArrayList<>();

    public Serie(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    public void agregarTemporada(Temporada unaTemporada) {
        temporadas.add(unaTemporada);
    }

    @Override
    public Double calcularCosto() {
        Integer totalEpisodios = 0;
        Double sumaCostos = 0.0;

        for (Temporada t : temporadas) {
            Integer cantEpisodios = t.getEpisodios().size();
            totalEpisodios += cantEpisodios;
            sumaCostos += cantEpisodios * Episodio.getCostoEpisodio();
        }

        if (totalEpisodios == 0)
            return getCostoBase();

        double promedioEpisodios = sumaCostos / totalEpisodios;
        return getCostoBase() + promedioEpisodios;
    }
}
