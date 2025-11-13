package co.edu.uniquindio.poo;

import java.util.List;

public class Visitante {
     private String nombre;
     private String id;
     private String contacto;
     private List<Reserva> listaReservas;
     private Membresia membresia;

     public Visitante(String nombre, String id, String contacto) {
          this.nombre = nombre;
          this.id = id;
          this.contacto = contacto;
     }

     public String getNombre() {return nombre;}
     public void setNombre(String nombre) {this.nombre = nombre;}

     public String getId() {return id;}
     public void setId(String id) {this.id = id;}

     public String getContacto() {return contacto;}
     public void setContacto(String contacto) {this.contacto = contacto;}

}
