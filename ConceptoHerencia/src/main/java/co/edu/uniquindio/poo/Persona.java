package co.edu.uniquindio.poo;

public abstract class Persona {
    protected String nombre;
    protected String id;
    protected int edad;

    public Persona(String nombre, String id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }
}
