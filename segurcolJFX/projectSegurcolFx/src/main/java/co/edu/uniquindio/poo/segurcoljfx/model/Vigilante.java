package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.TipoArma;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;

public class Vigilante extends Empleado {

    private int numPuestoAsignado;
    private TipoArma tipoArma;
    private Supervisor theSupervisor;
    private CustodiaFija theCustodiaFija;

    public Vigilante(String nombre, String documento, Turno turno, double salarioBase, int numPuestoAsignado, TipoArma tipoArma) {
        super(nombre,documento,turno,salarioBase);
        this.numPuestoAsignado = numPuestoAsignado;
        this.tipoArma = tipoArma;
    }

    public int getNumPuestoAsignado() {
        return numPuestoAsignado;
    }

    public void setNumPuestoAsignado(int numPuestoAsignado) {
        this.numPuestoAsignado = numPuestoAsignado;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(TipoArma tipoArma) {
        this.tipoArma = tipoArma;
    }

    public Supervisor getTheSupervisor() {
        return theSupervisor;
    }

    public void setTheSupervisor(Supervisor theSupervisor) {
        this.theSupervisor = theSupervisor;
    }

    public CustodiaFija getTheCustodiaFija() {
        return theCustodiaFija;
    }

    public void setTheCustodiaFija(CustodiaFija theCustodiaFija) {
        this.theCustodiaFija = theCustodiaFija;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase;
    }
}
