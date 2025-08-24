package co.edu.uniquindio.poo;

// 1 atributos
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String codigo;

    // 2 asignación
    public Mascota(String nombre, String especie, String raza, int edad, String codigo) {
        this.nombre =               nombre;
        this.especie=               especie;
        this.raza=                  raza;
        this.edad=                  edad;
        this.codigo=codigo;
    }
    // 3 getters y setters - por pares (1set-1get) o bloques(7set-7get)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre){this.nombre= nombre;}

    public String getEspecie(){return especie;}
    public void setEspecie(String especie){this.especie= especie;}

    public String getRaza(){return raza;}
    public void setRaza(String raza){this.raza= raza;}

    public int getEdad(){return edad;}
    public void setEdad(int edad){this.edad= edad;}

    public String getNumId(){return codigo;}
    public void setNumId(String numId){this.codigo=codigo;}

}