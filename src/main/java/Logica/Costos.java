package Logica;

import domain.Servicio;

import java.util.List;

public class Costos {

    public Costos() {
    }

    public static double costoVencimientoFinal(List<Servicio> servicios){
        double total = 0;
        for (Servicio x : servicios){
            total += x.getCostoVencimiento();
        }
        return total;
    }

    public static double costoPagoFinal(List<Servicio> servicios){
        double total = 0;
        for (Servicio x : servicios){
            total += x.getCostoPago();
        }
        return total;
    }
}
