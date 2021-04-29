import java.time.*;

public class LlamadaLocal extends Llamada{

    private final double precioCaro = 0.2; //Estas variables son parametrizadas (y no un valor en precioSegunHora()) para que si en un futuro se cambiaran los valores,
                                        // se actualicen así. Podrían ser variables de entorno también.
    private final double precioBarato = 0.1;

    LlamadaLocal (LocalTime horaInicio, int duracion, DayOfWeek dia){
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.dia = dia;
    }

    @Override
    double calcularCosto() {
        return precioSegunHora()*duracion;
    }

    private double precioSegunHora() { //Como la consigna dice que el costo varía según "el horario en el que se realiza la llamada", entiendo que depende de la hora de inicio y
                                        //no tengo en cuenta un precio distinto para los minutos hechos en distinto rango horario de la hora de la llamada.
        if(llamadaEnHorarioCaro() && !EsFinDeSemana()) return precioCaro;
        else return precioBarato;
    }

    private boolean llamadaEnHorarioCaro() { //Este método está para dar legibilidad y mantenibilidad al código. Los horarios también podrían ser variables de entorno.
        return(horaInicio.isAfter(LocalTime.parse("08:00:00.00")) && horaInicio.isBefore(LocalTime.parse("20:00:00.00")));
    }

    private boolean EsFinDeSemana() {
        return dia ==DayOfWeek.SATURDAY || dia ==DayOfWeek.SUNDAY;
    }

}
