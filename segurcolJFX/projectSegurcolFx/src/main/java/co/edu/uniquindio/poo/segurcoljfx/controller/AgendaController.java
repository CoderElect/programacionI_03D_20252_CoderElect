package co.edu.uniquindio.poo.segurcoljfx.controller;

import co.edu.uniquindio.poo.segurcoljfx.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {

    private final Segurcol segurcol;
    private final List<AgendaItem> listaAgenda = new ArrayList<>();

    public AgendaController(Segurcol segurcol) {
        this.segurcol = segurcol;
    }

    // add evento
    public boolean agregarEvento(LocalDate fecha, String descripcion, Empleado empleado, Servicio servicio) {
        if (fecha == null || descripcion == null || descripcion.isBlank()) return false;
        AgendaItem nuevo = new AgendaItem(fecha, descripcion, empleado, servicio);
        listaAgenda.add(nuevo);
        return true;
    }

    // borrar evento
    public boolean eliminarEvento(AgendaItem item) {
        return listaAgenda.remove(item);
    }

    // listar
    public List<AgendaItem> obtenerEventos() {
        return new ArrayList<>(listaAgenda);
    }

    // filtrar por empleado
    public List<AgendaItem> buscarPorEmpleado(String documento) {
        return listaAgenda.stream()
                .filter(a -> a.empleado() != null && a.empleado().getDocumento().equalsIgnoreCase(documento))
                .toList();
    }
}
