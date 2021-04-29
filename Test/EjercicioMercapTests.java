import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;

public class EjercicioMercapTests {
    private LlamadaLocal local1 = new LlamadaLocal(LocalTime.parse("09:00:00.00"), 11, DIASEMANA.LUNES);
    private LlamadaLocal local2= new LlamadaLocal(LocalTime.parse("07:00:00.00"), 11, DIASEMANA.LUNES);
    private LlamadaLocal local3 = new LlamadaLocal(LocalTime.parse("09:00:00.00"), 11, DIASEMANA.SABADO);
    private LlamadaNoLocal exterior1 = new LlamadaNoLocal(LocalTime.parse("19:00:00.00"), 1, DIASEMANA.SABADO);
    private Factura factura1 = new Factura(10.0,  Arrays.asList(local1,local2,local3, exterior1));

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
    public void FacturaDaBienMontoTotal() {
        Assert.assertEquals(factura1.montoTotal(), 24.4,0.0);
    }

    @Test
    public void FacturaSeMuestraBien(){
        factura1.mostrarse();
    }

}

