package co.edu.uniquindio.poo;

import java.util.Date;

public class EmpresaTransporte {
// atributos propios
    private String nombre;
    private String nit;
// atributos de relación
    private Bus[] listBuses;
    private Conductor[] listConductores;
    private Viaje[] listViajes;
    private Ruta[] listRutas;

// atributos para las funcionalidades
int bono = 500000;

    public EmpresaTransporte(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        listBuses = new Bus[30];
        listConductores = new Conductor[50];
        listViajes = new Viaje[50];
        listRutas = new Ruta[50];
    }
//CRUD CONDUCTOR
//create
    public boolean agregarConductor(String nombre, String cedula,
                                    String catLicencia, int aniosExperiencia) {
        Conductor nuevoConductor = new Conductor(nombre, cedula, catLicencia, aniosExperiencia);

 //comprobar que no hayan duplicados
        for (int i = 0; i < listConductores.length; i++) {
            if (listConductores[i] != null && listConductores[i].getCedula().equals(cedula)) {
                return false;
            }
        }
// insertar la nueva info
        for (int i = 0; i < listConductores.length; i++) {
            if (listConductores[i] == null) {
                listConductores[i] = nuevoConductor;
                return true;
            }
        }
        return false;
    }
//read
    public Conductor buscarConductor(String cedula) {
        for (int i = 0; i < listConductores.length; i++) {
            if (listConductores[i] != null && listConductores[i].getCedula().equals(cedula)) {
                return listConductores[i];
            }
        }
        return null;
    }
//delete
    public boolean eliminarConductor(String cedula) {
        for (int i = 0; i < listConductores.length; i++) {
            if (listConductores[i] != null && listConductores[i].getCedula().equals(cedula)) {
                listConductores[i] = null;
                return true;
            }
        }
        return false;
    }
//update
    public boolean actualizarConductor(String cedula, String nuevoNombre, String nuevaLicencia, int nuevosAnios) {
        for (int i = 0; i < listConductores.length; i++) {
            if (listConductores[i] != null && listConductores[i].getCedula().equals(cedula)) {
                listConductores[i].setNombre(nuevoNombre);
                listConductores[i].setCatLicencia(nuevaLicencia);
                listConductores[i].setAniosExperiencia(nuevosAnios);
                return true;
            }
        }
        return false;
    }

//listar info
    public Conductor[] getConductores() {
        return listConductores;
    }

//CRUD BUS
//create
    public boolean agregarBus(String placa, int capPasajeros, String modelo, String tipo, Conductor conductor) {
        if (conductor == null) return false;
// validar tipo de licencia
        if (tipo.equalsIgnoreCase("intermunicipal")) {
            if (!(conductor.getCatLicencia().equalsIgnoreCase("C2") || conductor.getCatLicencia().equalsIgnoreCase("C3"))) {
                return false;
            }
        }
        Bus nuevoBus = new Bus(placa, capPasajeros, modelo, tipo, conductor);
//comprobar que no hayan duplicados
        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] != null && listBuses[i].getPlaca().equals(placa)) {
                return false;
            }
        }
//agregar la nueva info
        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] == null) {
                listBuses[i] = nuevoBus;
                return true;
            }
        }
        return false;
    }
//read
    public Bus buscarBus(String placa) {
        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] != null && listBuses[i].getPlaca().equals(placa)) {
                return listBuses[i];
            }
        }
        return null;
    }
//delete
    public boolean eliminarBus(String placa) {
        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] != null && listBuses[i].getPlaca().equals(placa)) {
                listBuses[i] = null;
                return true;
            }
        }
        return false;
    }

//update
    public boolean actualizarBus(String placa, int nuevaCapacidad, String nuevoModelo, String nuevoTipo) {
        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] != null && listBuses[i].getPlaca().equals(placa)) {
                listBuses[i].setCapPasajeros(nuevaCapacidad);
                listBuses[i].setModelo(nuevoModelo);
                listBuses[i].setTipo(nuevoTipo);
                return true;
            }
        }
        return false;
    }

//listar
    public Bus[] getBuses() {
        return listBuses;
    }

//-----------------------------CREACIÓN DE FUNCIONALIDADES TALLER 1-----------------------------
// Lista de buses por conductor
    public Bus[] listarBusesPorConductor(String cedulaConductor) {
        Bus[] busesConductor = new Bus[listBuses.length];
        int index = 0;

        for (int i = 0; i < listBuses.length; i++) {
            if (listBuses[i] != null && listBuses[i].getConductor() != null) {
                if (listBuses[i].getConductor().getCedula().equals(cedulaConductor)) {
                    busesConductor[index] = listBuses[i];
                    index++;
                }
            }
        }
        return busesConductor;
    }
//calcular bono y el adicional
    public int calcularBonoConductor(String cedula) {
        Conductor conductor = buscarConductor(cedula);
        if (conductor == null) {
            return 0; //no hay
        }
        if (conductor.getAniosExperiencia() > 5) {
            bono += 200000; // bono adicional
        }
        return bono;
    }

        public Bus busMayorCapacidad() {
            Bus mayor = null;

            for (int i = 0; i < listBuses.length; i++) {
                if (listBuses[i] != null) {
                    if (mayor == null || listBuses[i].getCapPasajeros() > mayor.getCapPasajeros()) {
                        mayor = listBuses[i];
                    }
                }
            }
            return mayor;
        }

        public Bus busMenorCapacidad() {
            Bus menor = null;
            for (int i = 0; i < listBuses.length; i++) {
                if (listBuses[i] != null) {
                    if (menor == null || listBuses[i].getCapPasajeros() < menor.getCapPasajeros()) {
                        menor = listBuses[i];
                    }
                }
            }
            return menor;
        }
//REVISAR--------------------------------------------------------------------------
        public Bus[] informeBusesPorPlacaYExperiencia(int numEspecifico) {
            Bus[] resultado = new Bus[listBuses.length];
            int index = 0;

            for (int i = 0; i < listBuses.length; i++) {
                if (listBuses[i] != null && listBuses[i].getConductor() != null) {
                    String placa = listBuses[i].getPlaca();
                    char ultimo = placa.charAt(placa.length() - 1);

                    if (Character.isDigit(ultimo) && Character.getNumericValue(ultimo) == numEspecifico) {
                        // validar experiencia del conductor
                        if (listBuses[i].getConductor().getAniosExperiencia() > 5) {
                            resultado[index] = listBuses[i];
                            index++;
                        }
                    }
                }
            }
            return resultado;
        }
    //--------------------------CREACIÓN DE FUNCIONALIDADES TALLER 2 COMPLEMENTO--------------------------

    public String programarViaje(String codigo, String placa, String cedula, Date fecha, String hora) {
        Viaje[] resultado = new Viaje[listBuses.length];
        Conductor conductor = buscarConductor(cedula);
        if (conductor == null) {
            return 0; //no hay
        }
        String mensaje = "";
        if (conductor.getCatLicencia() == "C2") {
           mensaje == "Conductor no apto";
        }
        return mensaje;

    }


    public void cargarDatos() {
            // conductores de prueba
            agregarConductor("Carlos Pérez", "1010", "C1", 3);
            agregarConductor("María López", "2020", "C2", 7);
            agregarConductor("Juan Díaz", "3030", "C3", 10);

            // buscar conductores para asignar a los buses
            Conductor c1 = buscarConductor("1010");
            Conductor c2 = buscarConductor("2020");
            Conductor c3 = buscarConductor("3030");

            // buses de prueba
            agregarBus("AAA111", 40, "2015", "urbano", c1);
            agregarBus("BBB222", 50, "2018", "intermunicipal", c2); // válido porque tiene C2
            agregarBus("CCC333", 30, "2020", "urbano", c3);
        }


    //gets y sets de empresa
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String toString() {
        return "Empresa de transporte\nNombre: " + nombre +
                "\nNit: " + nit;
    }
}
