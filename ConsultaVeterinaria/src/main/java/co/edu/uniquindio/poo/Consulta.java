package co.edu.uniquindio.poo;

public class Consulta {
    private double valorBase;
    private double incrementoEspecie;
    private double incrementoEdad;
    private int id;

    public Consulta(double valorBase, double incrementoEspecie, double incrementoEdad, int id) {

        this.valorBase= valorBase;
        this.incrementoEspecie = incrementoEspecie;
        this.incrementoEdad = incrementoEdad;
        this.id = id;
    }

    public double getValorBase(){return valorBase;}
    public void setValorBase(double valorBase){this.valorBase=valorBase;}

    public double getIncrementoEspecie(){return incrementoEspecie;}
    public void setIncrementoEspecie(double incrementoEspecie){this.incrementoEspecie=incrementoEspecie;}

    public double getIncrementoEdad(){return incrementoEdad;}
    public void setIncrementoEdad(double incrementoEdad){this.incrementoEdad=incrementoEdad;}

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

//funcionalidad del requerimiento
    public double calcularCosto() {
        return valorBase + incrementoEspecie + incrementoEdad;
    }
}
