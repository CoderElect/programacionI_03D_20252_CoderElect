public class Automovil extends Vehiculo{
    private int numPuertas;
    private String tipoTransmision;
    private int numAsientos;

    public Automovil(double maxVelocidad, double capCombustible, String metodoArranque, int numPuertas,
                     String tipoTransmision, int numAsientos) {
        super(maxVelocidad, capCombustible, metodoArranque);
        this.numPuertas = numPuertas;
        this.tipoTransmision = tipoTransmision;
        this.numAsientos = numAsientos;
    }
    public int getNumPuertas() {return numPuertas;}
    public String getTipoTransmision() {return tipoTransmision;}
    public int getNumAsientos() {return numAsientos;}

    public void setNumPuertas(int numPuertas) {this.numPuertas = numPuertas;}
    public void setTipoTransmision(String tipoTransmision) {this.tipoTransmision = tipoTransmision;}
    public void setNumAsientos(int numAsientos) {this.numAsientos = numAsientos;}

}


