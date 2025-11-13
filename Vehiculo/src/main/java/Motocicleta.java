public class Motocicleta extends Vehiculo{
    private int numRuedas;
    private String tipoManilar;

    public Motocicleta(double maxVelocidad, double capCombustible, String metodoArranque,int numRuedas, String tipoManilar) {
        super(maxVelocidad,capCombustible,metodoArranque);

        this.numRuedas = numRuedas;
        this.tipoManilar = tipoManilar;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public String getTipoManilar() {
        return tipoManilar;
    }

    public void setTipoManilar(String tipoManilar) {
        this.tipoManilar = tipoManilar;
    }
}
