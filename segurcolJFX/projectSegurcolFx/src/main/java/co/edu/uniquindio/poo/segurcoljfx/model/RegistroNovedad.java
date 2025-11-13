package co.edu.uniquindio.poo.segurcoljfx.model;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.TipoNovedad;

import java.time.LocalDate;

public record RegistroNovedad(LocalDate fecha, String descripcion, TipoNovedad tipo, Servicio servicio, Empleado empleado) {
}