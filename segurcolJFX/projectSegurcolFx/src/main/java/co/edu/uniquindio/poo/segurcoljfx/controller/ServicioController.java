package co.edu.uniquindio.poo.segurcoljfx.controller;

import co.edu.uniquindio.poo.segurcoljfx.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioController {

    private final Segurcol segurcol;

    public ServicioController(Segurcol segurcol) {
        this.segurcol = segurcol;
    }

    // add cualquier servicio
    public boolean agregarServicio(Servicio servicio) {
        if (buscarServicioPorCodigo(servicio.getCodigoContrato()).isPresent()) {
            return false;
        }
        segurcol.getServicios().add(servicio);
        return true;
    }
    //hacer busqueda
    public Optional<Servicio> buscarServicioPorCodigo(String codigo) {
        return segurcol.getServicios().stream()
                .filter(s -> s.getCodigoContrato().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public boolean actualizarServicio(String codigo, Servicio servicioActualizado) {
        Optional<Servicio> servicioExistente = buscarServicioPorCodigo(codigo);
        if (servicioExistente.isPresent()) {
            int index = segurcol.getServicios().indexOf(servicioExistente.get());
            segurcol.getServicios().set(index, servicioActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminarServicio(String codigo) {
        Optional<Servicio> servicio = buscarServicioPorCodigo(codigo);
        if (servicio.isPresent()) {
            segurcol.getServicios().remove(servicio.get());
            return true;
        }
        return false;
    }

    // listar
    public List<Servicio> obtenerServicios() {
        return new ArrayList<>(segurcol.getServicios());
    }
}
