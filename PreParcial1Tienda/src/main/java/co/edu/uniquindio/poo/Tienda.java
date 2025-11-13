package co.edu.uniquindio.poo;

import javax.swing.*;

public class Tienda {
}

public void obtenerClienteCompra(){
    string resultado="";

    for (int i=0;i<listClientes.length;i++){
    Cliente cliente=listClientes[i];
    for(int j=0;j<cliente.listCompras.length;j++){
    DetalleVenta compra=cliente.listCompras[j];
    if (compra.producto.nombre.equalsIgnoreCase("Atun") && compra.cantidad==4){
        resultado+= "clientes que compraron 4 atunes: "+cliente.nombre;
    }
    }
    }
    JOptionPane.showMessageDialog(null, resultado);
}