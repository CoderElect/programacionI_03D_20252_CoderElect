package co.edu.uniquindio.poo.empresajavafx.controller;


import co.edu.uniquindio.poo.empresajavafx.model.Cliente;
import co.edu.uniquindio.poo.empresajavafx.model.Empresa;


import java.util.LinkedList;


public class ClienteController {
    Empresa empresa;


    public ClienteController(Empresa empresa) {
        this.empresa = empresa;
    }


    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }


    public LinkedList<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }


    public boolean eliminarCliente(String cedula) {
        return empresa.eliminarCliente(cedula);
    }


    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return empresa.actualizarCliente(cedula, cliente);
    }


}
