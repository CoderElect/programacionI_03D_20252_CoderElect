package co.edu.uniquindio.poo;

import java.util.Date;

public class Viaje {

    private Date fecha;
    private String hora;
    private int cantidadPasajeros;
    private double tarifa;
    private Conductor conductor;
    private Ruta ruta;
    private Bus bus;

    public Viaje(Date fecha, String hora, int cantidadPasajeros, double tarifa, Conductor conductor, Ruta ruta, Bus bus) {
        this.fecha=fecha;
        this.hora=hora;
        this.cantidadPasajeros=cantidadPasajeros;
        this.tarifa=tarifa;
        this.conductor=conductor;
        this.ruta=ruta;
        this.bus=bus;
    }
//gets y sets
    public Date getFecha(){return fecha;}
    public void setFecha(Date fecha){this.fecha=fecha;}

    public String getHora(){return hora;}
    public void setHora(String hora){this.hora=hora;}

    public int getCantidadPasajeros() {return cantidadPasajeros;}
    public void setCantidadPasajeros(int cantidadPasajeros){this.cantidadPasajeros=cantidadPasajeros;}

    public double getTarifa(){return tarifa;}
    public void setTarifa(double tarifa){this.tarifa=tarifa;}

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor){this.conductor=conductor;}

    public Ruta getRuta(){return ruta;}
    public void setRuta(Ruta ruta){this.ruta=ruta;}

    public Bus getBus(){return bus;}
    public void setBus(Bus bus){this.bus=bus;}

    public String toString(){

        return "VIAJE\nFecha:" +fecha+
                "\nHora:" +hora+
                "\nCantidad de pasajeros:" +cantidadPasajeros+
                "\nTarifa:" +tarifa+
                "\nRuta:"+ruta+
                "\nBus:"+bus+
                "\nConductor:"+conductor;

    }


}
