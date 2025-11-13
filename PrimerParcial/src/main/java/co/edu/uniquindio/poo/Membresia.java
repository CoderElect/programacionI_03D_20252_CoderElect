package co.edu.uniquindio.poo;

public class Membresia {
    private String nombre;
    private String beneficio;

    public Membresia(String nombre, String beneficio) {
        this.nombre = nombre;
        this.beneficio = beneficio;
    }
    public String getNombre() {return nombre;}
    public String getBeneficio() {return beneficio;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setBeneficio(String beneficio) {this.beneficio = beneficio;}
}
