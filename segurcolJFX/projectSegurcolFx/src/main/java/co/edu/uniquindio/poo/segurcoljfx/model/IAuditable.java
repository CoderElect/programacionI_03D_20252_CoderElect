package co.edu.uniquindio.poo.segurcoljfx.model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface IAuditable {
    default void registrarNovedad(RegistroNovedad Novedad){}
    default LinkedList<RegistroNovedad> obtenerNovedades(LocalDateTime desde,LocalDateTime hasta){
        return null;
    }
}
