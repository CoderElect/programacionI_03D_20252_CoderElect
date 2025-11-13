<<<<<<< HEAD
package co.edu.uniquindio.poo;

public class Ruta {

    private String codigo;
    private String origen;
    private String destino;
    private String tipo;
    private String distancia;
    private String duracion;

    public Ruta(String codigo, String origen, String destino, String tipo, String distancia, String duracion) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
        this.distancia = distancia;
        this.duracion = duracion;
    }

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getOrigen() {return origen;}
    public void setOrigen(String origen) {this.origen = origen;}

    public String getDestino() {return destino;}
    public void setDestino(String destino) {this.destino = destino;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getDistancia() {return distancia;}
    public void setDistancia(String distancia) {this.distancia = distancia;}

    public String getDuracion() {return duracion;}
    public void setDuracion(String duracion) {this.duracion = duracion;}

    public String toString(){

        return "Ruta\nCodigo:" +codigo+
                "\nOrigen:" +origen+
                "\nDestino:" +destino+
                "\nTipo:" +tipo+
                "\nDistancia:"+distancia+
                "\nDuracion:"+duracion;

    }



}
=======
package co.edu.uniquindio.poo;

public class Ruta {

    private String codigo;
    private String origen;
    private String destino;
    private String tipo;
    private String distancia;
    private String duracion;

    public Ruta(String codigo, String origen, String destino, String tipo, String distancia, String duracion) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
        this.distancia = distancia;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String toString() {

        return "Ruta\nCodigo:" + codigo +
                "\nOrigen:" + origen +
                "\nDestino:" + destino +
                "\nTipo:" + tipo +
                "\nDistancia:" + distancia +
                "\nDuracion:" + duracion;

    }
}
>>>>>>> 4f7499a (Actualizacion repo)
