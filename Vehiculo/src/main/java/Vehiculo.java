
public abstract class Vehiculo {
    protected double maxVelocidad;
    protected double capCombustible;
    protected String metodoArranque;

    public Vehiculo(double maxVelocidad, double capCombustible, String metodoArranque) {
        this.maxVelocidad = maxVelocidad;
        this.capCombustible = capCombustible;
        this.metodoArranque= metodoArranque;
    }

    public double getCapCombustible() {
        return capCombustible;
    }

    public void setCapCombustible(double capCombustible) {
        this.capCombustible = capCombustible;
    }

    public double getMaxVelocidad() {
        return maxVelocidad;
    }

    public void setMaxVelocidad(double maxVelocidad) {
        this.maxVelocidad = maxVelocidad;
    }

    public String getMetodoArranque() {
        return metodoArranque;
    }

    public void setMetodoArranque(String metodoArranque) {
        this.metodoArranque = metodoArranque;
    }
}
