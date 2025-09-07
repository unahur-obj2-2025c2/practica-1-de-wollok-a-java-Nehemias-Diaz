# Integrador Plataforma de Contenido

Una empresa emergente busca lanzar una plataforma de contenidos. Ofrecerá a sus usuarios acceso a diferentes tipos de contenido (películas, series, documentales, etc.) a través de distintos planes de suscripción. El objetivo es que el sistema pueda calcular el costo mensual de la suscripción que cada usuario registrado en la plataforma debe pagar y ofrecer flexibilidad en la gestión de contenidos y planes, aprovechando las ventajas de la programación con objetos.

## Requerimientos

### Contenido

- Se ofrecen inicialmente películas, series y documentales, pero pueden surgir nuevos contenidos a futuro.
- De cada contenido se conoce:
  - Su título
  - Un costo base de licencia (puede variar en cualquier momento)

#### Películas

- Son contenidos individuales.

#### Series

- Se componen de múltiples temporadas.
- De cada temporada se conoce su número y puede tener múltiples episodios.
- De cada episodio se sabe su número y su título.
- El costo de licencia de una serie se calcula como:

  `costo base + promedio de los costos de todos sus episodios`

#### Documentales

- El costo se calcula como:

  `costo base de licencia + canon establecido por el IDRA (International Documentary Regulation Authority)`

- El canon del IDRA es un valor común a todos los documentales (inicialmente es **0.5**) y puede cambiar en cualquier momento.

### Planes de Suscripción

Existen diferentes planes de suscripción, que determinan el acceso al contenido y el costo mensual para el usuario.

#### Plan Básico

- Permite consumir hasta **N contenidos por mes** por un **valor fijo** (ej. \$5).
- Si el usuario supera el límite, se le cobra el **adicional** igual al **costo base** de los contenidos excedentes.

**Ejemplo:**

Un usuario con un Plan Básico de valor fijo \$5 y máximo de 10 contenidos ve 12 contenidos en el mes:

```
[película1($2), serie1($3), documental1($1), ..., película11($4), película12($3)]
```

- Primeros 10 contenidos: sin cargo adicional
- Contenidos excedentes: `película11($4)`, `película12($3)`
- **Total mensual:**

  `$5 + ($4 + $3) = $12`

**Ayuda:** puede ser buena idea usar los mensajes `take(n)` o `drop(n)` para resolver parte del problema.

#### Plan Premium

- Acceso ilimitado a todo el catálogo por un **costo mensual fijo**.
- Valor sugerido: **\$12**

#### Plan Familiar

- Similar al Plan Básico, pero con un **descuento del 15%** en cada usuario.

### Usuarios

- Cada usuario tiene un único plan de suscripción y puede cambiar de plan en cualquier momento.
- Cada usuario registra los contenidos que ha **visto** en el mes.

### Cálculo de Costo Mensual

Se debe poder calcular el importe total a cobrar a un usuario en un mes determinado, basado en:

- Su plan
- El contenido que consumió

Al cierre del mes se debe poder:

1. **Calcular la facturación total** de la plataforma.
2. **Indicar a todos los usuarios registrados** que se limpie la lista de contenido consumido, para dar inicio a un nuevo período.

### Test

Plantear algunos **test significativos**, especialmente el caso de un usuario con Plan Básico que cambia a Plan Familiar, para verificar la aplicación del descuento.
