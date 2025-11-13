package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoEquipo;

import java.util.LinkedList;

public class Segurcol {
    public String nit;
    public String ubicacion;
    public LinkedList<Empleado> empleados;
    public LinkedList<Servicio> servicios;
    public LinkedList<Equipo> equipos;
    public LinkedList<RegistroNovedad> novedades;

    public Segurcol(String nit, String ubicacion) {
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.empleados = new LinkedList<>();
        this.servicios = new LinkedList<>();
        this.equipos = new LinkedList<>();
        this.novedades = new LinkedList<>();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (!verificarEmpleado(empleado.getDocumento())) {
            empleados.add(empleado);
            return true;
        }
        return false;
    }


    public boolean eliminarEmpleado(String documento) {
        Empleado empleado = buscarEmpleado(documento);
        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }
        return false;
    }


    public boolean actualizarEmpleado(String documento, Empleado actualizado) {
        Empleado empleado = buscarEmpleado(documento);
        if (empleado != null) {
            empleado.setNombre(actualizado.getNombre());
            empleado.setTurno(actualizado.getTurno());
            empleado.setSalarioBase(actualizado.getSalarioBase());
            return true;
        }
        return false;
    }

    public Empleado buscarEmpleado(String documento) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }


    public boolean verificarEmpleado(String documento) {
        return buscarEmpleado(documento) != null;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(LinkedList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public LinkedList<RegistroNovedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(LinkedList<RegistroNovedad> novedades) {
        this.novedades = novedades;
    }

    public void agregarServicio(Servicio s) {
        servicios.add(s);
    }

    public void agregarEquipo(Equipo eq) {
        equipos.add(eq);
    }

    public void registrarNovedad(RegistroNovedad n) {
        novedades.add(n);
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado buscarEmpleadoPorDocumento(String documento) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

}