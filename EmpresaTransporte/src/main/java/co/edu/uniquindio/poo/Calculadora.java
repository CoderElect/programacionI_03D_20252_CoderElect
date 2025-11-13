package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Calculadora {
    private String nombre;
    private double precio;
    private LinkedList<Integer> historialCalculos = new LinkedList<>();

    public Calculadora(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public boolean agregarResultado(int resultado) {
        return historialCalculos.add(resultado);
    }

    public int obtenerCantidadResultados() {
        return historialCalculos.size();
    }

    public double sumar


    public LinkedList<Integer> getHistorialCalculos() {
        return historialCalculos;
    }

    public void setHistorialCalculos(LinkedList<Integer> historialCalculos) {
        this.historialCalculos = historialCalculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
