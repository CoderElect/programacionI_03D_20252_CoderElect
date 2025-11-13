package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;

import java.util.LinkedList;

public class Supervisor extends Empleado {

    private double bonoPorCoordinacion;
    private LinkedList<Vigilante> vigilantes;

    public Supervisor(String nombre, String documento, Turno turno, double salarioBase, double bonoPorCoordinacion) {
        super(nombre, documento, turno, salarioBase);
        this.bonoPorCoordinacion = bonoPorCoordinacion;
        this.vigilantes = new LinkedList<>();
    }

    public double getBonoPorCoordinacion() {
        return bonoPorCoordinacion;
    }

    public void setBonoPorCoordinacion(double bonoPorCoordinacion) {
        this.bonoPorCoordinacion = bonoPorCoordinacion;
    }

    public double getBono() {
        return bonoPorCoordinacion;
    }

    public LinkedList<Vigilante> getVigilantes() {
        return vigilantes;
    }

    public void setVigilantes(LinkedList<Vigilante> vigilantes) {
        this.vigilantes = vigilantes;
    }



    public void agregarVigilante(Vigilante vigilante) {
        if (!vigilantes.contains(vigilante)) {
            vigilantes.add(vigilante);
        }
    }


    @Override
    public double calcularSalarioTotal() {
        return salarioBase + bonoPorCoordinacion;
    }
}