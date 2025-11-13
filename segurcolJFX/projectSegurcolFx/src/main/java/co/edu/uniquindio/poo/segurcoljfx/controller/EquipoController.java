package co.edu.uniquindio.poo.segurcoljfx.controller;

import java.util.LinkedList;
import co.edu.uniquindio.poo.segurcoljfx.model.Empleado;
import co.edu.uniquindio.poo.segurcoljfx.model.Equipo;
import co.edu.uniquindio.poo.segurcoljfx.model.Servicio;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoEquipo;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.TipoEquipo;

public class EquipoController {

    private LinkedList<Equipo> listaEquipos;

    public EquipoController() {
        this.listaEquipos = new LinkedList<>();
    }

    public LinkedList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public boolean agregarEquipo(Equipo equipo) {
        for (Equipo e : listaEquipos) {
            if (e.getCodigo().equalsIgnoreCase(equipo.getCodigo())) {
                return false;
            }
        }
        listaEquipos.add(equipo);
        return true;
    }

    public boolean eliminarEquipo(String codigo) {
        return listaEquipos.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigo));
    }

    public boolean actualizarEquipo(String codigo, double nuevoValor, EstadoEquipo nuevoEstado, TipoEquipo nuevoTipo) {
        for (Equipo e : listaEquipos) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                e.setValorReposicion(nuevoValor);
                e.setEstadoEquipo(nuevoEstado);
                e.setTipoEquipo(nuevoTipo);
                return true;
            }
        }
        return false;
    }

    public boolean asignarEquipoAEmpleado(String codigoEquipo, Empleado empleado) {
        for (Equipo e : listaEquipos) {
            if (e.getCodigo().equalsIgnoreCase(codigoEquipo)) {
                if (!e.getEmpleados().contains(empleado)) {
                    e.getEmpleados().add(empleado);
                    empleado.setTheEquipo(e); // relación bidireccional
                    return true;
                }
            }
        }
        return false;
    }

    public boolean asignarEquipoAServicio(String codigoEquipo, Servicio servicio) {
        for (Equipo e : listaEquipos) {
            if (e.getCodigo().equalsIgnoreCase(codigoEquipo)) {
                if (!e.getListServicios().contains(servicio)) {
                    e.getListServicios().add(servicio);
                    return true;
                }
            }
        }
        return false;
    }
}
