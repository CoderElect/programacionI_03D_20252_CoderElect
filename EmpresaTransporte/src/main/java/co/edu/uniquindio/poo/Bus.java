<<<<<<< HEAD
package co.edu.uniquindio.poo;

public class Bus {

    private String placa;
    private int capPasajeros;
    private String modelo;
    private String tipo;
    private Conductor conductor;

    public Bus(String placa, int capPasajeros, String modelo, String tipo, Conductor conductor) {
        this.placa = placa;
        this.capPasajeros = capPasajeros;
        this.modelo = modelo;
        this.tipo = tipo;
        this.conductor = conductor; // corrección
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public int getCapPasajeros() { return capPasajeros; }
    public void setCapPasajeros(int capPasajeros) { this.capPasajeros = capPasajeros; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }

    @Override
    public String toString() {
        String infoConductor;
        if (conductor != null) {
            infoConductor = conductor.getNombre();
        } else {
            infoConductor = "No hay conductor";
        }

        return "Bus\nPlaca: " + placa +
                "\nCapacidad de pasajeros: " + capPasajeros +
                "\nModelo: " + modelo +
                "\nTipo: " + tipo +
                "\nConductor asignado: " + infoConductor;
    }
}
=======
package co.edu.uniquindio.poo;

public class Bus {

    private String placa;
    private int capPasajeros;
    private String modelo;
    private String tipo;
    private Conductor conductor;

    public Bus(String placa, int capPasajeros, String modelo, String tipo, Conductor conductor) {
        this.placa = placa;
        this.capPasajeros = capPasajeros;
        this.modelo = modelo;
        this.tipo = tipo;
        this.conductor = conductor; // corrección
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public int getCapPasajeros() { return capPasajeros; }
    public void setCapPasajeros(int capPasajeros) { this.capPasajeros = capPasajeros; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }

    @Override
    public String toString() {
        String infoConductor;
        if (conductor != null) {
            infoConductor = conductor.getNombre();
        } else {
            infoConductor = "No hay conductor";
        }

        return "Bus\nPlaca: " + placa +
                "\nCapacidad de pasajeros: " + capPasajeros +
                "\nModelo: " + modelo +
                "\nTipo: " + tipo +
                "\nConductor asignado: " + infoConductor;
    }
}
>>>>>>> 4f7499a (Actualizacion repo)
