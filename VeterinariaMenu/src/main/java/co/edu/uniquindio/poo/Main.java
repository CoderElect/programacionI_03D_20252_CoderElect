package co.edu.uniquindio.poo;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Clinica newClinica = new Clinica("PETS", "777");
        int opcion =0;
//definirlo con int o string
        while (opcion !=5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENÚ VETERINARIA\n" +
                        "1. Agregar Mascota\n" +
                        "2. Leer Mascotas\n" +
                        "3. Actualizar Mascota\n" +
                        "4. Eliminar Mascota\n" +
                        "5. Salir\n" +
                        "Elige una opción:"
            ));
            switch (opcion) {
                case 1: // Agregar
                    String nombre = JOptionPane.showInputDialog("Nombre de la mascota:");
                    String especie = JOptionPane.showInputDialog("Especie:");
                    String raza = JOptionPane.showInputDialog("Raza:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    String idMascota = JOptionPane.showInputDialog("ID de la mascota:");
                    String namePropietario = JOptionPane.showInputDialog("Nombre del propietario:");
                    String contactoPropietario = JOptionPane.showInputDialog("Contacto del propietario:");

                    boolean agregada = newClinica.agregarMascota(nombre, especie, raza, edad, idMascota, namePropietario, contactoPropietario);

                    if (agregada) {
                        JOptionPane.showMessageDialog(null, "Mascota agregada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar la mascota");
                    }
                    break;

                case 2: // Leer
                    JOptionPane.showMessageDialog(null, newClinica.obtenerMascotas());
                    break;

                case 3: // Actualizar
                    String idActualizar = JOptionPane.showInputDialog("Ingrese el ID de la mascota a actualizar:");
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                    String nuevaEspecie = JOptionPane.showInputDialog("Nueva especie:");
                    String nuevaRaza = JOptionPane.showInputDialog("Nueva raza:");
                    int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
                    String nuevoPropietario = JOptionPane.showInputDialog("Nuevo nombre del propietario:");
                    String nuevoContacto = JOptionPane.showInputDialog("Nuevo contacto del propietario:");

                    boolean actualizado = newClinica.actualizarMascota(nuevoNombre, nuevaEspecie, nuevaRaza, nuevaEdad, idActualizar, nuevoPropietario, nuevoContacto);

                    if (actualizado) {
                        JOptionPane.showMessageDialog(null, "Mascota actualizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la mascota con ese ID");
                    }
                    break;


                case 4: // Eliminar
                    String idEliminar = JOptionPane.showInputDialog("Ingrese el ID de la mascota a eliminar:");
                    boolean eliminada = newClinica.eliminarMascota(idEliminar);

                    if (eliminada) {
                        JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la mascota con ese ID");
                    }
                    break;

                case 5: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        }
    }
}
