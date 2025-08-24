package co.edu.uniquindio.poo;

public class Propietario {
    private String nombrePropietario;
    private String contacto;
    private String direccion;
    private String idPropietario;
    private final Mascota[] listMascotasPropietario;
    private final Consulta[] listConsultasPropietario;

    public Propietario(String nombrePropietario, String contacto, String direccion, String idPropietario) {
        this.nombrePropietario = nombrePropietario;
        this.contacto = contacto;
        this.direccion = direccion;
        this.idPropietario = idPropietario;
        listMascotasPropietario = new Mascota[5];
        listConsultasPropietario = new Consulta[5];
    }

    public String getNombrePropietario() {return nombrePropietario;}
    public void setNombrePropietario(String nombrePropietario){this.nombrePropietario = nombrePropietario;}

    public String getContacto() {return contacto;}
    public void setContacto(String contacto){this.contacto = contacto;}

    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getIdPropietario() {return idPropietario;}
    public void setIdPropietario(String idPropietario){this.idPropietario = idPropietario;}

    public Mascota[] getMascotas() {return listMascotasPropietario;}
    public Consulta[] getConsultas() {return listConsultasPropietario;}
}
