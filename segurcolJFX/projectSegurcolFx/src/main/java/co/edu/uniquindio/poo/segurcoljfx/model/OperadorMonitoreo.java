package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;

public class OperadorMonitoreo extends Empleado {

    private int zonasMonitoreo;

    public OperadorMonitoreo(String nombre, String documento, Turno turno, double salarioBase, int zonasMonitoreo) {
        super(nombre, documento, turno, salarioBase);
        this.zonasMonitoreo = zonasMonitoreo;
    }

    public int getZonasMonitoreo() {
        return zonasMonitoreo;
    }

    public void setZonasMonitoreo(int zonasMonitoreo) {
        this.zonasMonitoreo = zonasMonitoreo;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase;
    }
}