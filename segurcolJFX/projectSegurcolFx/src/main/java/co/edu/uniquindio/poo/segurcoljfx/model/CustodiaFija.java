package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoServicio;
import java.util.LinkedList;

public class CustodiaFija extends Servicio {

    private String puesto;
    private LinkedList<Vigilante> vigilantes;

    public CustodiaFija(String codigoContrato, String cliente, double tarifaMensual, EstadoServicio estadoServicio, String puesto) {
        super(codigoContrato, cliente, tarifaMensual, estadoServicio);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LinkedList<Vigilante> getVigilantes() {
        return vigilantes;
    }

    public void setVigilantes(LinkedList<Vigilante> vigilantes) {
        this.vigilantes = vigilantes;
    }

    @Override
    public double calcularCostoMensual() {
        return tarifaMensual;
    }
}