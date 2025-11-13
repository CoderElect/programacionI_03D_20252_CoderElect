package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;

import java.util.LinkedList;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected Turno turno;
    protected double salarioBase;
    protected Equipo theEquipo;
    protected LinkedList<Servicio> servicios;
    protected LinkedList<AgendaItem> items;
    protected LinkedList<RegistroNovedad> novedades;


    public Empleado (String nombre,String documento,Turno turno,double salarioBase){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.documento = documento;
        this.turno = turno;
    }
    public double calcularSalarioTotal() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Equipo getTheEquipo() {
        return theEquipo;
    }

    public void setTheEquipo(Equipo theEquipo) {
        this.theEquipo = theEquipo;
    }



    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(LinkedList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public LinkedList<AgendaItem> getItems() {
        return items;
    }

    public void setItems(LinkedList<AgendaItem> items) {
        this.items = items;
    }

    public LinkedList<RegistroNovedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(LinkedList<RegistroNovedad> novedades) {
        this.novedades = novedades;
    }

    public String toString() {
        return "Empleado {\n nombre: " + nombre +
                "\n documento: " + documento +
                "\n salario base: "+ salarioBase;
    }

}