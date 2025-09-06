package co.edu.uniquindio.poo;

public class Consulta {
    private double valorBase;
    private final String id;

    private final Mascota mascota;
    private final Propietario propietario;

    public Consulta(double valorBase, String id, Mascota mascota, Propietario propietario) {
        this.valorBase= valorBase;
        this.id = id;
        this.mascota = mascota;
        this.propietario = propietario;
    }

    public void setValorBase(double valorBase){this.valorBase=valorBase;}

    public String getId(){return id;}

    //condiciones libres
    public double calcularCosto() {
        double total = valorBase;

        //1 si ea un caballo
        if(mascota.getEspecie().equalsIgnoreCase("caballo")){
            total += 52500;
        }

        //si la mascota tiene >6 de edad
        if(mascota.getEdad() > 6){
            total += 21500;
        }

      // si es perro y >10 años
        if(mascota.getEspecie().equalsIgnoreCase("perro") && mascota.getEdad() > 10){
            total += 32500;
        }

        return total;
    }

    @Override
    public String toString(){
        return "Consulta ID: "+id+
                "\nValor Base: " +valorBase+
                "\nMascota: " +mascota.getNombre()+
                "\nPropietario: " +propietario.getNombrePropietario()+
                "\nValor Final: " +calcularCosto();
    }


    public void setIncrementoEspecie(double nuevoIncrementoEspecie) {
    }

    public void setIncrementoEdad(double nuevoIncrementoEdad) {
    }
}
