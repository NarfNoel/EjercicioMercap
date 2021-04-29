import java.time.LocalTime;

public abstract class Llamada {

    LocalTime horaInicio;
    int duracion;
    DIASEMANA dia;
    //Considero irrelevante el lugar de origen ya que asumo que solo se provee servicio dentro del país

    abstract double calcularCosto(); //Se trabajará con double por una cuestión de simplicidad, pero en un sistema profesional que trabaje con plata se debería utilizar un BigDecimal
                                        // o algún tipo de dato acorde.

}
