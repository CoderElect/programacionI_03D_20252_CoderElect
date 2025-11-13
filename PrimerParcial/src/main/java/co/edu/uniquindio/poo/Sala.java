package co.edu.uniquindio.poo;

import java.util.List;

public class Sala {
    private String nombre;
    private int aforo;
    private String id;
    private List<Reserva> listaReservas;
    private ExposicionTemporal exposicionTemporal;

    public Sala(String nombre, int aforo, String id) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.id = id;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getAforo(){return aforo;}
    public void setAforo(int aforo) {this.aforo = aforo;}

    public String getId(){return id;}
    public void setId(String id) {this.id = id;}
}
