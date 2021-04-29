import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Factura {
    double abonoMensualBasico;
    Month mes;
    ArrayList<Llamada> llamadas;

    Factura(Month mes, double abonoMensualBasico,ArrayList<Llamada> llamadas){
        this.abonoMensualBasico=abonoMensualBasico;
        this.mes=mes;
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
        System.out.println("La factura: " + this + " del mes " + mes.name() + " está compuesta por:\n Abono Mensual Básico: $" + abonoMensualBasico + "\n Consumo por llamadas Locales: $" + consumoporLlamadasLocales()
        + "\n Consumo por llamadas Nacionales e Internacionales: $" + consumoporLlamadasNoLocales() + "\n ---------Monto total a pagar: "+montoTotal()+"---------");
    }

    void addLlamadas(Llamada llamada){
        llamadas.add(llamadas.size(),llamada);
    }

    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public double getAbonoMensualBasico() {
        return abonoMensualBasico;
    }

    void setabonoMensualBasico(double abonoMensualBasico){
        this.abonoMensualBasico=abonoMensualBasico;
    }
}
