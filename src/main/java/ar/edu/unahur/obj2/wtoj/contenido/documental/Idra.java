package ar.edu.unahur.obj2.wtoj.contenido.documental;

public class Idra {
    private static Idra instancia; // La única instancia de la clase
    private Double canon = 0.5;

    // Constructor privado para evitar que se creen nuevas instancias desde fuera
    private Idra() { }

    // Método estático para obtener la única instancia
    public static Idra getInstancia() {
        if (instancia == null) {
            instancia = new Idra();
        }
        return instancia;
    }

    public Double getCanon() {
        return canon;
    }

    public void setCanon(Double canon) {
        this.canon = canon;
    }
}
