package co.edu.uniquindio.poo;

// 1 atributos
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String numId;
    private String namePropietario;
    private String contactoPropietario;
// 2 asignación
    public Mascota(String nombre, String especie, String raza, int edad, String numId, String namePropietario, String contactoPropietario) {
        this.nombre =               nombre;
        this.especie=               especie;
        this.raza=                  raza;
        this.edad=                  edad;
        this.numId=                 numId;
        this.namePropietario=       namePropietario;
        this.contactoPropietario=   contactoPropietario;
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

    public String getNumId(){return numId;}
    public void setNumId(String numId){this.numId= numId;}

    public String getNamePropietario(){return namePropietario;}
    public void setNamePropietario(String namePropietario){this.namePropietario= namePropietario;}

    public String getContactoPropietario(){return contactoPropietario;}
    public void setContactoPropietario(String contactoPropietario){this.contactoPropietario= contactoPropietario;}

    @Override
    public String toString(){
        return "Mascota\nNombre: " +nombre+
                "\nEspecie: "+especie+
                "\nRaza: "+raza+
                "\nEdad: "+edad+
                "\nNúmero de identificación: "+numId+
                "\nNombre del propietario: "+namePropietario+
                "\nContacto del propietario: "+contactoPropietario;
    }
}