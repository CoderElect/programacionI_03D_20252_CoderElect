package co.edu.uniquindio.poo;

public class Conductor {

    private String nombre;
    private String cedula;
    private String catLicencia;
    private int aniosExperiencia;

    public Conductor(String nombre, String cedula, String catLicencia, int aniosExperiencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.catLicencia = catLicencia;
        this.aniosExperiencia = aniosExperiencia;
    }

    String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    String getCedula(){return cedula;}
    public void setCedula(String cedula){this.cedula = cedula;}

    String getCatLicencia(){return catLicencia;}
    public void setCatLicencia(String catLicencia){this.catLicencia = catLicencia;}

    int getAniosExperiencia(){return aniosExperiencia;}
    public void setAniosExperiencia(int aniosExperiencia){this.aniosExperiencia=aniosExperiencia;}

    public String toString(){

        return "Conductor\nNombre:" +nombre+
                "\nCédula:" +cedula+
                "\nCategoría de la licencia" +catLicencia+
                "\nAños de experiencia" +aniosExperiencia;

    }
}
