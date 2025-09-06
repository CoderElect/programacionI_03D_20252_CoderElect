package co.edu.uniquindio.poo;

public class Clinica {
    private String nombre;
    private String nit;

    private Mascota[] listMascotas;
    private Propietario[] listPropietarios;
    private Consulta[] listConsultas;

    public Clinica(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        listMascotas = new Mascota[5];
        listPropietarios = new Propietario[5];
        listConsultas = new Consulta[5];
    }
    /* crud por cada actor
     1 crud para mascotas*/
    private int obtenerIndexMascota(String numId) {
        for (int i=0; i<listMascotas.length; i++) {
            if (listMascotas[i] != null && listMascotas[i].getNumId().equals(numId)) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarMascota(Mascota mascota) {
        if (obtenerIndexMascota(mascota.getNumId()) != -1) return false;
        for (int i=0; i<listMascotas.length; i++) {
            if (listMascotas[i] == null) {
                listMascotas[i] = mascota;
                return true;
            }
        }
        return false;
    }

    public Mascota obtenerMascota(String numId) {
        int index = obtenerIndexMascota(numId);
        return (index != -1) ? listMascotas[index] : null;
    }

    public boolean eliminarMascota(String numId) {
        int index = obtenerIndexMascota(numId);
        if (index == -1) return false;
        listMascotas[index] = null;
        return true;
    }

    public boolean actualizarMascota(String numId, String nuevoNombre, String nuevaEspecie, String nuevaRaza, int nuevaEdad) {
        int index = obtenerIndexMascota(numId);
        if (index == -1) return false;
        Mascota m = listMascotas[index];
        m.setNombre(nuevoNombre);
        m.setEspecie(nuevaEspecie);
        m.setRaza(nuevaRaza);
        m.setEdad(nuevaEdad);
        return true;
    }

    public Mascota[] getMascotas() {
        return listMascotas;
    }

//2 crud para propietario
    private int obtenerIndexPropietario(String idPropietario) {
        for (int i=0; i<listPropietarios.length; i++) {
            if (listPropietarios[i] != null && listPropietarios[i].getIdPropietario().equals(idPropietario)) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarPropietario(Propietario propietario) {
        if (obtenerIndexPropietario(propietario.getIdPropietario()) != -1) return false;
        for (int i=0; i<listPropietarios.length; i++) {
            if (listPropietarios[i] == null) {
                listPropietarios[i] = propietario;
                return true;
            }
        }
        return false;
    }

    public Propietario obtenerPropietario(String id) {
        int index = obtenerIndexPropietario(id);
        return (index != -1) ? listPropietarios[index] : null;
    }

    public boolean eliminarPropietario(String id) {
        int index = obtenerIndexPropietario(id);
        if (index == -1) return false;
        listPropietarios[index] = null;
        return true;
    }

    public boolean actualizarPropietario(String idPropietario, String nuevoNombrePropietario, String nuevaDireccion) {
        int index = obtenerIndexPropietario(idPropietario);
        if (index == -1) return false;
        Propietario p = listPropietarios[index];
        p.setNombrePropietario(nuevoNombrePropietario);
        p.setDireccion(nuevaDireccion);
        return true;
    }

    public Propietario[] getPropietarios() {
        return listPropietarios;
    }

// 3 crud para consultas
    private int obtenerIndexConsulta(String codigo) {
        for (int i=0; i<listConsultas.length; i++) {
            if (listConsultas[i] != null && listConsultas[i].getId().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarConsulta(Consulta consulta) {
        if (obtenerIndexConsulta(consulta.getId()) != -1) return false;
        for (int i=0; i<listConsultas.length; i++) {
            if (listConsultas[i] == null) {
                listConsultas[i] = consulta;
                return true;
            }
        }
        return false;
    }

    public Consulta obtenerConsulta(String codigo) {
        int index = obtenerIndexConsulta(codigo);
        return (index != -1) ? listConsultas[index] : null;
    }

    public boolean eliminarConsulta(String codigo) {
        int index = obtenerIndexConsulta(codigo);
        if (index == -1) return false;
        listConsultas[index] = null;
        return true;
    }

    public boolean actualizarConsulta(String id, double nuevoValorBase, double nuevoIncrementoEspecie, double nuevoIncrementoEdad) {
        int index = obtenerIndexConsulta(id);
        if (index == -1) return false;
        Consulta c = listConsultas[index];
        c.setValorBase(nuevoValorBase);
        c.setIncrementoEspecie(nuevoIncrementoEspecie);
        c.setIncrementoEdad(nuevoIncrementoEdad);
        return true;
    }

    public Consulta[] getConsultas() {
        return listConsultas;
    }

//gets y sets de la clase
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

    public String getNit(){ return nit; }
    public void setNit(String nit){ this.nit = nit; }
}
