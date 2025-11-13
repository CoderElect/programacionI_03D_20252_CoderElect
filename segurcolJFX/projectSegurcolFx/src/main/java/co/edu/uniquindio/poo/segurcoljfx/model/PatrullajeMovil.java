package co.edu.uniquindio.poo.segurcoljfx.model;

import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoServicio;

public class PatrullajeMovil extends Servicio{
    private int ruta;
    private double kilometrosRecorridos;

    public PatrullajeMovil(int ruta, double kilometrosRecorridos, String codigoContrato, String cliente, double tarifaMensual, EstadoServicio estadoServicio){
        super(codigoContrato,cliente,tarifaMensual,estadoServicio);
        this.ruta = ruta;
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public int getRuta() {
        return ruta;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double calcularCostoMensual(){
        double costoMensual = 20000;
        if(ruta>=5&&kilometrosRecorridos>=5){
            costoMensual += costoMensual*0.05;
        }else if(ruta>2&&kilometrosRecorridos>2){
            costoMensual += costoMensual*0.02;
        }else if(ruta >=1 && kilometrosRecorridos>=1){
            costoMensual += costoMensual*0.01;
        }else if(ruta==0&&kilometrosRecorridos==0){
            costoMensual+= costoMensual*0;
        }
        return costoMensual;
    }
}