package ar.edu.unahur.obj2.wtoj.plan;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;

public class PlanBasico extends Plan {
    private Integer limiteDeContenidos;
    private Double costoFijoMensual;

    public PlanBasico(Integer limiteDeContenidos, Double costoFijoMensual) {
        this.limiteDeContenidos = limiteDeContenidos;
        this.costoFijoMensual = costoFijoMensual;
    }

    @Override
    public Double calcularCostoMensual(List<Contenido> contenidosVistos) {
        // inicializo el costo total con el costo fijo mensual
        Double costoTotal = costoFijoMensual;
        // Obtengo la cantidad total de contenidos que el usuario vio en el mes.
        Integer cantContenidosVistos = contenidosVistos.size();
        // Verifico si el usuario superó el límite de contenidos gratuitos.
        if (cantContenidosVistos > limiteDeContenidos) {
            /*
            Parte hecha con IA ya que no sabia como manipular la lista, intente con
            drop() y me tiraba error, le consulte a la IA y me dio esta respuesta:
              
             
              El método drop() no existe en la interfaz List estándar de Java. La nota que
              viste en el enunciado probablemente se refería a conceptos de programación
              funcional o a la API de Streams de Java 8 y versiones superiores, que sí
              tienen una funcionalidad equivalente.
              
              La Solución con Streams de Java
              Para lograr lo que quieres, debes convertir tu lista a un stream y usar el
              método skip(). Un stream te permite procesar colecciones de una manera más
              funcional y legible.
            */

            //Si el usuario superó el límite se crea un "stream" a partir de la lista de contenidos. Un stream es como una
            // "cinta transportadora"
            // que nos permite procesar la colección de manera más eficiente y expresiva.
            List<Contenido> contenidoExtraVisto = contenidosVistos.stream()
                    //Usa el método 'skip()' para omitir (saltar) los primeros 'N' contenidos
                    // que están dentro del límite gratuito. Así, solo nos quedamos con los
                    // excedentes.
                    // Se realiza un 'cast' a 'long' porque 'skip()' requiere este tipo de dato.
                    .skip((long) limiteDeContenidos)
                    //'collect()' se usa para recolectar los elementos restantes del stream
                    //y guardarlos en una nueva lista, 'contenidoExtraVisto'.
                    .collect(Collectors.toList());

            /*Esto lo hice yo, lo habia hecho con "contenidoExtraVisto" pero de distinta manera,
            hice un contenidoVistos.drop(limiteDeContenidos) y eso me devolvia una lista sacando los primeros
            (limiteDeContenidos) elementos de la lista que es un numero y el for recorria esa lista sumando
            el costo extra a cada contenido.
            */
            for (Contenido contenido : contenidoExtraVisto) {
                costoTotal += contenido.calcularCosto();
            }
        }
        //Finalmente, devuelve el costo total calculado.
        return costoTotal;
    }
}
