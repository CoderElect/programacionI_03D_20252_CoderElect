package co.edu.uniquindio.poo;

public class Cliente  extends Persona{
    private String beneficio;

    public Cliente (String nombre, String id, int edad, String beneficio) {
        super(nombre, id, edad);

        this.beneficio = beneficio;
    }

    public String getBeneficio() {return beneficio;}
    public void setBeneficio(String beneficio) {this.beneficio = beneficio;}
}
