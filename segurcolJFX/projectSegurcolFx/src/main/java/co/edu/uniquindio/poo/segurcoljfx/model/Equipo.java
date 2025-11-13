package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoEquipo;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.TipoEquipo;
import java.util.LinkedList;

public class Equipo {

    private String codigo;
    private double valorReposicion;
    private EstadoEquipo estadoEquipo;
    private TipoEquipo tipoEquipo;
    private LinkedList<Servicio> listServicios;
    private LinkedList<Empleado> empleados;

    public Equipo(String codigo, double valorReposicion, EstadoEquipo estadoEquipo, TipoEquipo tipoEquipo) {
        this.codigo = codigo;
        this.valorReposicion = valorReposicion;
        this.estadoEquipo = estadoEquipo;
        this.tipoEquipo = tipoEquipo;
        this.listServicios = new LinkedList<>();
        this.empleados = new LinkedList<>();
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorReposicion() {
        return valorReposicion;
    }

    public void setValorReposicion(double valorReposicion) {
        this.valorReposicion = valorReposicion;
    }

    public EstadoEquipo getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(EstadoEquipo estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public LinkedList<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(LinkedList<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
