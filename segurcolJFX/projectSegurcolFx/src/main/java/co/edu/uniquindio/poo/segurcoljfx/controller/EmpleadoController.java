package co.edu.uniquindio.poo.segurcoljfx.controller;

import co.edu.uniquindio.poo.segurcoljfx.model.Empleado;
import co.edu.uniquindio.poo.segurcoljfx.model.Segurcol;
import co.edu.uniquindio.poo.segurcoljfx.model.Vigilante;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {

    private List<Empleado> listaEmpleados = new ArrayList<>();

    public EmpleadoController(Segurcol segurcol) {
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return listaEmpleados;
    }

    public boolean eliminarEmpleado(String empleado) {
        listaEmpleados.remove(empleado);
            return false;
    }

    public boolean actualizarEmpleado(String documento, Vigilante actualizado) {
        return false;
    }
}
