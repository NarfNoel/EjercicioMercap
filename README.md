# EjercicioMercap
Ejercicio: Realizar un sistema de facturación de llamadas telefónicas.

El código tiene un nivel muy alto de comentarios que complementan asunciones sobre los requerimientos pedidos.
Muchos de esos comentarios considero necesario para una correcta interpretación del código y un mejor entendimiento entre mí y aquellos responsables de corregirlo.

Respecto del módulo externo mencionado para resolver costoDe(destinoDeLaLlamada), al faltar la lógica necesaria para el desarrollo y considerar una solución muy precaria un HashMap Key-Value con Destino-Precio, se optó por no resolver esta parte del enunciado. Entiendo que una forma posible de resolver esto sería con una API que permita obtener distancias entre dos puntos (localidad de la llamada y destino) y multiplicar esta distancia por un valor definido por el negocio. Otra opción podría ser un esquema general, que se maneje con pocos valores (las provincias argentinas y los continentes) y se genere un HashMap con estos destinos y valores definidos por el negocio. Interpreto que el alcance del ejercicio no apunta ni a una solución tan elaborada ni a una solución tan precaria e irreal.

