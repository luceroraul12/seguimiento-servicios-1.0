package Logica;

import Datos.ServicioDAO;
import Datos.TablaDAO;
import domain.Servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fechas {

    public Fechas() {
    }

    public boolean mismoDia(LocalDate fechaA, LocalDate fechaB) {
        return fechaA.getDayOfMonth() == fechaB.getDayOfMonth();
    }

    public boolean mismoMes(LocalDate fechaA, LocalDate fechaB) {
        return fechaA.getMonthValue() == fechaB.getMonthValue();
    }

    public boolean mismoAño(LocalDate fechaA, LocalDate fechaB) {
        return fechaA.getYear() == fechaB.getYear();
    }

    /**
     * Devuelve una lista con los servicios cargados en el mes actual
     *
     * @return
     */
    public List<Servicio> serviciosCargadosMesGeneral(LocalDate fechaMesGeneral) {

        ServicioDAO serviciosDao = new ServicioDAO();
        TablaDAO tablaDao = new TablaDAO();
        List<Servicio> serviciosDisponibles = serviciosDao.seleccionar();
        List<Servicio> serviciosFiltrados;
        List<Servicio> serviciosQueCumplen = new ArrayList<>();
        boolean mismoAñoMes;

        for (Servicio x : serviciosDisponibles){

            serviciosFiltrados = tablaDao.seleccionar(x);

            for (Servicio i : serviciosFiltrados){

                mismoAñoMes = mismoAño(fechaMesGeneral, i.getFechaPago()) & mismoMes(fechaMesGeneral, i.getFechaPago());

                if (mismoAñoMes){

                    i.setNombreServicio(x.getNombreServicio());
                    serviciosQueCumplen.add(i);
                    break;

                }

            }

        }

        return serviciosQueCumplen;
    }

    /**
     * A partir de los servicios que cumplen, obtengo los que no se han cargado
     * @param serviciosQueCumplen lista con todos los servicios agregados
     * @return lista de servicios que no cumplen
     */
    public List<Servicio> serviciosSinCargarMesActual(List<Servicio> serviciosQueCumplen){
        List<Servicio> serviciosSinCargar = null;
        ServicioDAO servicioDao = new ServicioDAO();
        List<Servicio> serviciosDisponibles = servicioDao.seleccionar();

        for (Servicio x : serviciosQueCumplen){
            for (Servicio i : serviciosDisponibles){

                boolean mismoServicio = x.getIdServicio() == i.getIdServicio();

                if (mismoServicio){
                    serviciosDisponibles.remove(i);
                    break;
                }
            }
        }
        serviciosSinCargar = serviciosDisponibles;
        return serviciosSinCargar;
    }
}

