package co.edu.uniquindio.poo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresaTransporte = new EmpresaTransporte("BOLIVARIANO", "77G");
        empresaTransporte.cargarDatos(); // datos iniciales para probar

        int opcion = 0;

        while (opcion != 7) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENÚ
                    1. CRUD de conductor
                    2. CRUD de bus
                    3. Mostrar info de conductores y buses
                    4. Consulta de buses por conductor
                    5. Mostrar bonos de conductores
                    6. Generar reportes solicitados
                    7. Salir del programa
                    """));

            switch (opcion) {
                case 1 -> {
                    int opcConductor = Integer.parseInt(JOptionPane.showInputDialog("""
                            CRUD Conductor
                            1. Agregar
                            2. Buscar
                            3. Actualizar
                            4. Eliminar
                            """));
                    switch (opcConductor) {
                        case 1 -> {
                            String nombre = JOptionPane.showInputDialog("Nombre:");
                            String cedula = JOptionPane.showInputDialog("Cédula:");
                            String licencia = JOptionPane.showInputDialog("Categoría de licencia:");
                            int anios = Integer.parseInt(JOptionPane.showInputDialog("Años de experiencia:"));
                            boolean agregado = empresaTransporte.agregarConductor(nombre, cedula, licencia, anios);
                            JOptionPane.showMessageDialog(null, agregado ? "Conductor agregado" : "No se pudo agregar");
                        }
                        case 2 -> {
                            String cedula = JOptionPane.showInputDialog("Ingrese cédula:");
                            Conductor c = empresaTransporte.buscarConductor(cedula);
                            JOptionPane.showMessageDialog(null, c != null ? c.toString() : "No encontrado");
                        }
                        case 3 -> {
                            String cedula = JOptionPane.showInputDialog("Ingrese cédula:");
                            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                            String nuevaLicencia = JOptionPane.showInputDialog("Nueva licencia:");
                            int nuevosAnios = Integer.parseInt(JOptionPane.showInputDialog("Nuevos años experiencia:"));
                            boolean actualizado = empresaTransporte.actualizarConductor(cedula, nuevoNombre, nuevaLicencia, nuevosAnios);
                            JOptionPane.showMessageDialog(null, actualizado ? "Conductor actualizado" : "No se pudo actualizar");
                        }
                        case 4 -> {
                            String cedula = JOptionPane.showInputDialog("Ingrese cédula:");
                            boolean eliminado = empresaTransporte.eliminarConductor(cedula);
                            JOptionPane.showMessageDialog(null, eliminado ? "Conductor eliminado" : "No se pudo eliminar");
                        }
                    }
                }
                case 2 -> {
                    int opcBus = Integer.parseInt(JOptionPane.showInputDialog("""
                            CRUD Bus
                            1. Agregar
                            2. Buscar
                            3. Actualizar
                            4. Eliminar
                            """));
                    switch (opcBus) {
                        case 1 -> {
                            String placa = JOptionPane.showInputDialog("Placa:");
                            int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad pasajeros:"));
                            String modelo = JOptionPane.showInputDialog("Modelo:");
                            String tipo = JOptionPane.showInputDialog("Tipo (urbano/intermunicipal):");
                            String cedulaConductor = JOptionPane.showInputDialog("Cédula del conductor:");
                            Conductor conductor = empresaTransporte.buscarConductor(cedulaConductor);

                            boolean agregado = empresaTransporte.agregarBus(placa, capacidad, modelo, tipo, conductor);
                            JOptionPane.showMessageDialog(null, agregado ? "Bus agregado" : "No se pudo agregar (verifique conductor/licencia)");
                        }
                        case 2 -> {
                            String placa = JOptionPane.showInputDialog("Ingrese placa:");
                            Bus b = empresaTransporte.buscarBus(placa);
                            JOptionPane.showMessageDialog(null, b != null ? b.toString() : "No encontrado");
                        }
                        case 3 -> {
                            String placa = JOptionPane.showInputDialog("Ingrese placa:");
                            int nuevaCapacidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva capacidad:"));
                            String nuevoModelo = JOptionPane.showInputDialog("Nuevo modelo:");
                            String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo:");
                            boolean actualizado = empresaTransporte.actualizarBus(placa, nuevaCapacidad, nuevoModelo, nuevoTipo);
                            JOptionPane.showMessageDialog(null, actualizado ? "Bus actualizado" : "No se pudo actualizar");
                        }
                        case 4 -> {
                            String placa = JOptionPane.showInputDialog("Ingrese placa:");
                            boolean eliminado = empresaTransporte.eliminarBus(placa);
                            JOptionPane.showMessageDialog(null, eliminado ? "Bus eliminado" : "No se pudo eliminar");
                        }
                    }
                }
                case 3 -> {
                    StringBuilder sb = new StringBuilder("Conductores:\n");
                    for (Conductor c : empresaTransporte.getConductores()) {
                        if (c != null) sb.append(c.toString()).append("\n\n");
                    }
                    sb.append("Buses:\n");
                    for (Bus b : empresaTransporte.getBuses()) {
                        if (b != null) sb.append(b.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 4 -> {
                    String cedula = JOptionPane.showInputDialog("Cédula del conductor:");
                    Bus[] buses = empresaTransporte.listarBusesPorConductor(cedula);
                    StringBuilder sb = new StringBuilder("Buses del conductor:\n");
                    for (Bus b : buses) {
                        if (b != null) sb.append(b.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 5 -> {
                    String cedula = JOptionPane.showInputDialog("Cédula del conductor:");
                    int bono = empresaTransporte.calcularBonoConductor(cedula);
                    JOptionPane.showMessageDialog(null, "Bono del conductor: " + bono);
                }
                case 6 -> {
                    Bus mayor = empresaTransporte.busMayorCapacidad();
                    Bus menor = empresaTransporte.busMenorCapacidad();
                    JOptionPane.showMessageDialog(null, "Bus mayor capacidad:\n" + (mayor != null ? mayor.toString() : "No hay") +
                            "\n\nBus menor capacidad:\n" + (menor != null ? menor.toString() : "No hay"));
                }
            }
        }
    }
}
