//datos "quemados"
package co.edu.uniquindio.poo;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Clinica newClinica= new Clinica ("PETS", "777");
        boolean primerMascota = newClinica.agregarMascota("Goldie", "Gato",
                "C", 2,
                "Cat23","Miguel", "7465355");

        JOptionPane.showMessageDialog(null, newClinica.obtenerMascotas());

        if (primerMascota) {
            JOptionPane.showMessageDialog(null, "Mascota agregada correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Mascota no agregada");
        }

        boolean segundaMascota = newClinica.agregarMascota("Candy", "Gata",
                "C", 14,
                "CAT37","Maria","3107773846");


        if (segundaMascota) {
            JOptionPane.showMessageDialog(null, "Mascota agregada correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Mascota no agregada");
        }
    }
}
