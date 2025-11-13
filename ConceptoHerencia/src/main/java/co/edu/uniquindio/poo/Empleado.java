package co.edu.uniquindio.poo;

public class Empleado extends Persona{
    private double salario;
    private Cargo cargo; //Relación con la clase ENUM

    public Empleado(String nombre, String id, int edad, double salario, Cargo cargo) {
        super(nombre,id,edad);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario(){return salario;}
    public void setSalario(double salario){this.salario = salario;}

    public Cargo getCargo(){return cargo;}
    public void setCargo(Cargo cargo){this.cargo = cargo;}
}
