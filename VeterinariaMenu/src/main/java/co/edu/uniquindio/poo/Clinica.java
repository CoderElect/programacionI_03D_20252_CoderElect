package co.edu.uniquindio.poo;

public class Clinica {
    // 1 atributos de clase
    private String nombre;
    private String nit;
    // 2 atributos de relación
    private Mascota[] listMascotas;
    //3 asignación
    public Clinica(String nombre, String nit){

        this.nombre=    nombre;
        this.nit=        nit;
        listMascotas = new Mascota[3];
    }
//5 CRUD (plantilla)

    public boolean agregarMascota(String nombre, String especie, String raza, int edad,
                                  String numId, String namePropietario, String contactoPropietario){

        Mascota newMascota = new Mascota(nombre, especie, raza, edad, numId, namePropietario, contactoPropietario);
//metodo create
        for (int i=0; i<listMascotas.length; i++){
            if(listMascotas[i] != null && listMascotas[i].getNumId().equals(numId)){
                return false;
            }
        }
        for(int i=0; i<listMascotas.length; i++){
            if(listMascotas[i] == null){
                listMascotas[i] = newMascota;
                return true;
            }
        }
        return false;
    }
    //metodo read
    private int obtenerIndexMascotas(String numId){
        for(int i=0; i<listMascotas.length; i++){
            if(listMascotas[i] != null && listMascotas[i].getNumId().equals(numId)){
                return i;
            }
        }
        return -1;
    }

    //metodo delete
    public boolean eliminarMascota(String numId){
        int indexMascota=obtenerIndexMascotas(numId);
        if(indexMascota == -1) return false;
        listMascotas[indexMascota] = null;
        return true;
    }

    //metodo update
    public boolean actualizarMascota(String nombre, String especie, String raza, int edad, String numId,
                                     String namePropietario, String contactoPropietario){

        int indexMascota=obtenerIndexMascotas(numId);
        if(indexMascota == -1) return false;

        Mascota actualizarMascota = listMascotas[indexMascota];
        actualizarMascota.setNombre(nombre);
        actualizarMascota.setEspecie(especie);
        actualizarMascota.setRaza(raza);
        actualizarMascota.setEdad(edad);
        actualizarMascota.setNumId(numId);
        actualizarMascota.setNamePropietario(namePropietario);
        actualizarMascota.setContactoPropietario(contactoPropietario);
        return true;
    }
    public Mascota obtenerMascota(String numId){
        int indexMascota = obtenerIndexMascotas(numId);
        if(indexMascota == -1) return null;
        return listMascotas[indexMascota];
    }


    public Mascota [] obtenerMascotas(){ return listMascotas; }


    //6 getters y setters
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre= nombre;}

    public String getNit() { return nit;}
    public void setNit (String nit){this.nit= nit;}
}