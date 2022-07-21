package domain;

import java.time.LocalDate;
import java.util.Scanner;

public class Servicio {
    private int idServicio, idMensual;
    private String nombreServicio, nombreServicioModificado;
    private LocalDate fechaVencimiento, fechaPago;
    private double costoVencimiento, costoPago;

    public Servicio() {
    }

    public Servicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Servicio(int idServicio, int idMensual) {
        this.idServicio = idServicio;
        this.idMensual = idMensual;
    }

    public Servicio(int idServicio, String nombreServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
    }

    public Servicio(int idServicio, LocalDate fechaVencimiento, LocalDate fechaPago, double costoVencimiento, double costoPago) {
        this.idServicio = idServicio;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.costoVencimiento = costoVencimiento;
        this.costoPago = costoPago;
    }

    public Servicio(int idServicio, int idMensual, LocalDate fechaVencimiento, LocalDate fechaPago, double costoVencimiento, double costoPago) {
        this.idServicio = idServicio;
        this.idMensual = idMensual;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.costoVencimiento = costoVencimiento;
        this.costoPago = costoPago;
    }

    public String getNombreServicioModificado() {
        return nombreServicioModificado;
    }

    public void setNombreServicioModificado(String nombreServicioModificado) {
        this.nombreServicioModificado = nombreServicioModificado;
    }

    public int getIdMensual() {
        return idMensual;
    }

    public void setIdMensual(int idMensual) {
        this.idMensual = idMensual;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getCostoVencimiento() {
        return costoVencimiento;
    }

    public void setCostoVencimiento(int costoVencimiento) {
        this.costoVencimiento = costoVencimiento;
    }

    public double getCostoPago() {
        return costoPago;
    }

    public void setCostoPago(int costoPago) {
        this.costoPago = costoPago;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", idMensual=" + idMensual +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                ", costoVencimiento=" + costoVencimiento +
                ", costoPago=" + costoPago +
                '}';
    }

    public String toStringNombre(){
        return "Servicio{ID_SERVICIO: "+idServicio+'\''+
                ", Servicio: "+nombreServicio;
    }

    public String toStringServicio() {
        return "id: "+ idServicio + " | Servicio: "+ nombreServicio;
    }

    public void cargarServicio(){
        Scanner ingresar = new Scanner(System.in);

        String fechaVencimiento;
        String fechaPago;
        double costoVencimiento;
        double costoPago;
        int dia, mes, año;

        System.out.print("fecha de Vencimiento: ");
        System.out.print("dia: ");
        dia = ingresar.nextInt();
        ingresar.nextLine();
        System.out.print("mes: ");
        mes = ingresar.nextInt();
        ingresar.nextLine();
        System.out.print("año: ");
        año = ingresar.nextInt();
        ingresar.nextLine();
        this.fechaVencimiento = LocalDate.of(año, mes, dia);

        System.out.print("fecha de Pago: ");
        System.out.print("dia: ");
        dia = ingresar.nextInt();
        ingresar.nextLine();
        System.out.print("mes: ");
        mes = ingresar.nextInt();
        ingresar.nextLine();
        System.out.print("año: ");
        año = ingresar.nextInt();
        ingresar.nextLine();
        this.fechaPago = LocalDate.of(año, mes, dia);

        System.out.print("Costo antes del Vencimiento: ");
        costoVencimiento = ingresar.nextDouble();
        ingresar.nextLine();
        System.out.print("Costo Abonado: ");
        costoPago = ingresar.nextDouble();
        ingresar.nextLine();

        this.costoVencimiento = costoVencimiento;
        this.costoPago = costoPago;
    }
}

