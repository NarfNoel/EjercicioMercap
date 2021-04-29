import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Factura {

    double abonoMensualBasico;
    List<Llamada> llamadas;

    Factura(double abonoMensualBasico,List<Llamada> llamadas){
        this.abonoMensualBasico=abonoMensualBasico;
        this.llamadas=llamadas;
    }

    double consumoporLlamadasLocales(){
        return consumoDe(llamadas.stream().filter(this::esLocal));
    }

    double consumoporLlamadasNoLocales(){
        return consumoDe(llamadas.stream().filter(llamada -> !esLocal(llamada)));
    }

    double consumoDe(Stream<Llamada> llamadas){
        return llamadas.map(Llamada::calcularCosto).reduce(0.0, Double::sum);
    }

    private boolean esLocal(Llamada llamada) {
        return llamada instanceof LlamadaLocal;
    }

    double montoTotal(){
      return abonoMensualBasico + consumoporLlamadasLocales() + consumoporLlamadasNoLocales();
    }

    void mostrarse(){
        System.out.println("La factura: " + this + " está compuesta por:\n Abono Mensual Básico: $" + abonoMensualBasico + "\n Consumo por llamadas Locales: $" + consumoporLlamadasLocales()
        + "\n Consumo por llamadas Nacionales e Internacionales: $" + consumoporLlamadasNoLocales() + "\n ---------Monto total a pagar: "+montoTotal()+"---------");
    }

    void addLlamadas(List<Llamada> llamadas){
        this.llamadas.addAll(llamadas);
    }

    void setabonoMensualBasico(double abonoMensualBasico){
        this.abonoMensualBasico=abonoMensualBasico;
    }
}
