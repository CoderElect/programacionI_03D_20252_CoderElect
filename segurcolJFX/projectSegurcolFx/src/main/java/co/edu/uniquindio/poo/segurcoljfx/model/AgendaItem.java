package co.edu.uniquindio.poo.segurcoljfx.model;
import java.time.LocalDate;

public record AgendaItem(LocalDate fecha, String descripcion, Empleado empleado, Servicio servicio) {
}
