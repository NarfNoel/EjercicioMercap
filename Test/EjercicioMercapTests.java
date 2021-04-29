import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class EjercicioMercapTests {
    private LlamadaLocal local1 = new LlamadaLocal(LocalTime.parse("09:00:00.00"), 11, DayOfWeek.MONDAY);
    private LlamadaLocal local2= new LlamadaLocal(LocalTime.parse("07:00:00.00"), 11, DayOfWeek.MONDAY);
    private LlamadaLocal local3 = new LlamadaLocal(LocalTime.parse("09:00:00.00"), 11, DayOfWeek.SATURDAY);
    private LlamadaNoLocal exterior1 = new LlamadaNoLocal(LocalTime.parse("19:00:00.00"), 1, DayOfWeek.FRIDAY);
    private LlamadaNoLocal exterior2 = new LlamadaNoLocal(LocalTime.parse("12:40:00.00"), 5, DayOfWeek.THURSDAY);
    private Factura factura1 = new Factura(Month.APRIL, 10.0, new ArrayList<Llamada>(Arrays.asList(local1,local2,local3,exterior1)));

    @Test
    public void Llamada9amLunesCobraCaro() {
        Assert.assertEquals(local1.calcularCosto(), 2.20,0.0);
    }

    @Test
    public void Llamada7amLunesCobraBarato() {
        Assert.assertEquals(local2.calcularCosto(), 1.1,0.0);
    }

    @Test
    public void LlamadaSabadoCobraBarato() {
        Assert.assertEquals(local3.calcularCosto(), 1.10,0.0);
    }

    @Test
    public void LlamadaNoLocalCobra10(){ Assert.assertEquals(exterior1.calcularCosto(), 10.0, 0.0); }

    @Test
    public void FacturaAgregaLlamada(){
        factura1.addLlamadas(exterior2);
        Assert.assertEquals(factura1.getLlamadas(), Arrays.asList(local1,local2,local3, exterior1, exterior2));
    }

    @Test
    public void FacturaDaBienMontoTotal() {
        Assert.assertEquals(factura1.montoTotal(), 24.4,0.0);
    }

    @Test
    public void FacturaSeMuestraBien(){
        factura1.mostrarse();
    }

}

