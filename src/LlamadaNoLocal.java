import java.time.DayOfWeek;
import java.time.LocalTime;

public class LlamadaNoLocal extends Llamada { // Esta clase contiene a las llamadas Nacionales no locales y a las llamadas Internacionales. Como la consigna no las distingue y no
    //parece haber razón para distinguirlas y hacerlas polimórficas, se unen en esta clase. S

    String destino; // considero que el destino es solamente relevante para las llamadas no locales. Será responsabilidad de la UI o del sistema de entrada de datos cómo se instancian
                    // las clases concretas de Llamada.

    LlamadaNoLocal (LocalTime horaInicio, int duracion, DayOfWeek dia){
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.dia = dia;
    }

    @Override
    double calcularCosto() {
        return 10.0;// moduloExterno.costoDe(destino)* duracion; costoDe(destino) debería devolver un costo particular según el destino de llamada, la forma de cálculo del costo
                                                            // no se especifica. Como la lógica no se da en la consigna, asumo que se ocupa otro módulo. Dependiendo de la interfaz
                                                            // y el funcionamiento del módulo externo podría ser necesario un Adapter o una modificación a la clase.
    }
}
