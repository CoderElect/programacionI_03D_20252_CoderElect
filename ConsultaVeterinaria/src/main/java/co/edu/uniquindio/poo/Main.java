package co.edu.uniquindio.poo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica("VIDA ANIMAL", "03D2");
        int opcion = 0;

        while (opcion != 5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENÚ
                    1. Registrar propietario
                    2. Registrar mascota
                    3. Registrar consulta
                    4. Ver datos
                    5. Salir
                    """));

            switch (opcion) {
                case 1 -> {
                    String nombrePropietario = JOptionPane.showInputDialog("Nombre propietario:");
                    String contacto = JOptionPane.showInputDialog("Contacto:");
                    String direccion = JOptionPane.showInputDialog("Direccion:");
                    String idPropietario = JOptionPane.showInputDialog("Id:");
                    clinica.agregarPropietario(new Propietario(nombrePropietario,contacto, direccion, idPropietario));
                }
                case 2 -> {
                   // String nombre = JOptionPane.showInputDialog("Nombre mascota:");
                    String especie = JOptionPane.showInputDialog("Especie:");
                    //String raza = JOptionPane.showInputDialog("Raza:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    String codigo = JOptionPane.showInputDialog("Codigo:");
                    clinica.agregarMascota(new Mascota("", especie,"", edad, codigo));
                }
                case 3 -> {
                    double valorBase = Double.parseDouble(JOptionPane.showInputDialog("Valor base consulta:"));
                    String id = JOptionPane.showInputDialog("ID consulta:");
                    //String nombreMascota = JOptionPane.showInputDialog("Nombre mascota:"); en caso de solicitar nombre
                    String especie = JOptionPane.showInputDialog("Especie:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad mascota:"));
                    Mascota m = new Mascota(id, "", especie, edad, "");


                    String idPropietario = JOptionPane.showInputDialog("Id del propietario:");
                    Propietario p = new Propietario("", "", "", idPropietario);

                    Consulta c = new Consulta(valorBase, id, m, p);
                    clinica.agregarConsulta(c);
                }
                case 4 -> {
                    String idMascota = JOptionPane.showInputDialog("Ingrese el ID de la mascota:");
                    Mascota mascota = clinica.obtenerMascota(idMascota);

                    if (mascota != null) {
                        JOptionPane.showMessageDialog(null, "Mascota encontrada:\n" + mascota);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mascota no encontrada.");
                    }

                }
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo...");
            }
        }
    }
}