package ar.edu.unahur.obj2.wtoj.contenido.serie;

public class Episodio {
    private Integer numEpisodio;
    private String titulo;
    //Lo defino como atributo de clase (static) asi todos los episodios tienen el mismo valor
    private static Double costoEpisodio = 2.0;

    public Episodio(Integer numEpisodio, String titulo) {
        this.numEpisodio = numEpisodio;
        this.titulo = titulo;
    }

    public Integer getNumEpisodio() {
        return numEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    //Como el atributo es de clase, entonces el metodo tambien debe ser de clase
    public static Double getCostoEpisodio() {
        return costoEpisodio;
    }

    public static void setCostoEpisodio(Double costo) {
        costoEpisodio = costo;
    }
}
