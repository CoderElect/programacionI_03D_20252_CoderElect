package co.edu.uniquindio.poo.segurcoljfx.model;


import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoServicio;

import java.util.LinkedList;

public abstract class Servicio {
    protected String codigoContrato;
    protected String cliente;
    protected double tarifaMensual;
    protected EstadoServicio estadoServicio;
    protected LinkedList<Empleado> empleados;
    protected LinkedList<AgendaItem> agendaItems;
    protected LinkedList<RegistroNovedad> novedades;

    public Servicio (String codigoContrato, String cliente, double tarifaMensual, EstadoServicio estadoServicio){
        this.codigoContrato = codigoContrato;
        this.cliente = cliente;
        this.tarifaMensual = tarifaMensual;
        this.estadoServicio = estadoServicio;
    }

    public double getTarifaMensual() {
        return tarifaMensual;
    }

    public EstadoServicio getEstadoServicio() {
        return estadoServicio;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setTarifaMensual(double tarifaMensual) {
        this.tarifaMensual = tarifaMensual;
    }

    public void setEstadoServicio(EstadoServicio estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }
    public double calcularCostoMensual() {
        return tarifaMensual;
    }

    public LinkedList<AgendaItem> getAgendaItems() {
        return agendaItems;
    }

    public void setAgendaItems(LinkedList<AgendaItem> agendaItems) {
        this.agendaItems = agendaItems;
    }

    public LinkedList<RegistroNovedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(LinkedList<RegistroNovedad> novedades) {
        this.novedades = novedades;
    }
}