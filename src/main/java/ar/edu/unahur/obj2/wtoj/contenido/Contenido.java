package ar.edu.unahur.obj2.wtoj.contenido;

public abstract class Contenido {
    private String titulo;
    private Double costoBase;

    public Contenido(String titulo, Double costoBase) {
        this.titulo = titulo;
        this.costoBase = costoBase;
    }

    public abstract Double calcularCosto();

    public String getTitulo() {
        return titulo;
    }

    public Double getCostoBase() {
        return costoBase;
    }
}
