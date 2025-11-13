public class Camion extends Vehiculo{
    private double capCarga;
    private int numEjes;
    private String tipoCarga;

    public Camion(double maxVelocidad, double capCombustible, String metodoArranque,
                  double capCarga, int numEjes, String tipoCarga){
        super(maxVelocidad,capCombustible,metodoArranque);
        this.capCarga = capCarga;
        this.numEjes = numEjes;
        this.tipoCarga = tipoCarga;
    }

    public double getCapCarga() {
        return capCarga;
    }

    public void setCapCarga(double capCarga) {
        this.capCarga = capCarga;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
}
