package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Museo {
    private String nombre;
    private String barrio;
    private String contacto;
    private List<Reserva> listaReservas;
    private List<Sala> listaSalas;
    private List<Visitante> listaVisitantes;

public Museo (String nombre, String barrio, String contacto){
    this.nombre = nombre;
    this.barrio = barrio;
    this.contacto = contacto;
}

    public String getNombre(){return nombre;}
    public String getBarrio(){return barrio;}
    public String getContacto(){return contacto;}
    public List<Reserva> getListaReservas(){return listaReservas;}
    public List<Sala> getListaSalas(){return listaSalas;}
    public List<Visitante> getListaVisitantes(){return listaVisitantes;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setBarrio(String barrio){this.barrio = barrio;}
    public void setContacto(String contacto){this.contacto = contacto;}




}