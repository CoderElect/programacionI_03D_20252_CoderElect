package co.edu.uniquindio.poo;

import javax.swing.*;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 4f7499a (Actualizacion repo)

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresaTransporte = new EmpresaTransporte("BOLIVARIANO", "77G");
        empresaTransporte.cargarDatos(); // datos iniciales para probar

        int opcion = 0;

<<<<<<< HEAD
        while (opcion != 7) {
=======
        while (opcion !=9) {
>>>>>>> 4f7499a (Actualizacion repo)
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENÚ
                    1. CRUD de conductor
                    2. CRUD de bus
<<<<<<< HEAD
                    3. Mostrar info de conductores y buses
                    4. Consulta de buses por conductor
                    5. Mostrar bonos de conductores
                    6. Generar reportes solicitados
                    7. Salir del programa
=======
                    3. CRUD de viaje
                    4. CRUD de ruta
                    5. Mostrar info de conductores y buses
                    6. Consulta de buses por conductor
                    7. Mostrar bonos de conductores
                    8. Generar reportes solicitados
                    9. Salir del programa
>>>>>>> 4f7499a (Actualizacion repo)
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
<<<<<<< HEAD
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
=======
                    int opcViaje = Integer.parseInt(JOptionPane.showInputDialog("""
            CRUD Viaje
            1. Agregar
            2. Buscar
            3. Actualizar
            4. Eliminar
            """));
                    switch (opcViaje) {
                        case 1 -> {
                            String id = JOptionPane.showInputDialog("Id:");
                            String fecha = JOptionPane.showInputDialog("Fecha:");
                            String hora = JOptionPane.showInputDialog("Hora:");
                            int cantidadPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de pasajeros:"));
                            double tarifa = Double.parseDouble(JOptionPane.showInputDialog("Tarifa:"));
                            boolean agregado = empresaTransporte.agregarViaje(id, fecha, hora, cantidadPasajeros, tarifa);
                            JOptionPane.showMessageDialog(null, agregado ? "Viaje agregado" : "No se pudo agregar");
                        }
                        case 2 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID del viaje:");
                            Viaje v = empresaTransporte.buscarViaje(id);
                            JOptionPane.showMessageDialog(null, v != null ? v.toString() : "No encontrado");
                        }
                        case 3 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID del viaje:");
                            String nuevaFecha = JOptionPane.showInputDialog("Nueva fecha:");
                            String nuevaHora = JOptionPane.showInputDialog("Nueva hora:");
                            int nuevosPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad pasajeros:"));
                            double nuevaTarifa = Double.parseDouble(JOptionPane.showInputDialog("Nueva tarifa:"));
                            boolean actualizado = empresaTransporte.actualizarViaje(id, nuevaFecha, nuevaHora, nuevosPasajeros, nuevaTarifa);
                            JOptionPane.showMessageDialog(null, actualizado ? "Viaje actualizado" : "No se pudo actualizar");
                        }
                        case 4 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID del viaje:");
                            boolean eliminado = empresaTransporte.eliminarViaje(id);
                            JOptionPane.showMessageDialog(null, eliminado ? "Viaje eliminado" : "No se pudo eliminar");
                        }
                    }
                }
                case 4 -> {
                    int opcRuta = Integer.parseInt(JOptionPane.showInputDialog("""
            CRUD Ruta
            1. Agregar
            2. Buscar
            3. Actualizar
            4. Eliminar
            """));
                    switch (opcRuta) {
                        case 1 -> {
                            String id = JOptionPane.showInputDialog("Id:");
                            String origen = JOptionPane.showInputDialog("Origen:");
                            String destino = JOptionPane.showInputDialog("Destino:");
                            double distancia = Double.parseDouble(JOptionPane.showInputDialog("Distancia (km):"));
                            boolean agregado = empresaTransporte.agregarRuta(id, origen, destino, distancia);
                            JOptionPane.showMessageDialog(null, agregado ? "Ruta agregada" : "No se pudo agregar");
                        }
                        case 2 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID de la ruta:");
                            Ruta r = empresaTransporte.buscarRuta(id);
                            JOptionPane.showMessageDialog(nul, r != null ? r.toString() : "No encontrada");
                        }
                        case 3 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID de la ruta:");
                            String nuevoOrigen = JOptionPane.showInputDialog("Nuevo origen:");
                            String nuevoDestino = JOptionPane.showInputDialog("Nuevo destino:");
                            double nuevaDistancia = Double.parseDouble(JOptionPane.showInputDialog("Nueva distancia (km):"));
                            boolean actualizado = empresaTransporte.actualizarRuta(id, nuevoOrigen, nuevoDestino, nuevaDistancia);
                            JOptionPane.showMessageDialog(null, actualizado ? "Ruta actualizada" : "No se pudo actualizar");
                        }
                        case 4 -> {
                            String id = JOptionPane.showInputDialog("Ingrese ID de la ruta:");
                            boolean eliminado = empresaTransporte.eliminarRuta(id);
                            JOptionPane.showMessageDialog(null, eliminado ? "Ruta eliminada" : "No se pudo eliminar");
                        }
                    }
                }
                case 5 -> {
>>>>>>> 4f7499a (Actualizacion repo)
                    String cedula = JOptionPane.showInputDialog("Cédula del conductor:");
                    Bus[] buses = empresaTransporte.listarBusesPorConductor(cedula);
                    StringBuilder sb = new StringBuilder("Buses del conductor:\n");
                    for (Bus b : buses) {
                        if (b != null) sb.append(b.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
<<<<<<< HEAD
                case 5 -> {
=======
                case 6 -> {
>>>>>>> 4f7499a (Actualizacion repo)
                    String cedula = JOptionPane.showInputDialog("Cédula del conductor:");
                    int bono = empresaTransporte.calcularBonoConductor(cedula);
                    JOptionPane.showMessageDialog(null, "Bono del conductor: " + bono);
                }
<<<<<<< HEAD
                case 6 -> {
=======
                case 7 -> {
>>>>>>> 4f7499a (Actualizacion repo)
                    Bus mayor = empresaTransporte.busMayorCapacidad();
                    Bus menor = empresaTransporte.busMenorCapacidad();
                    JOptionPane.showMessageDialog(null, "Bus mayor capacidad:\n" + (mayor != null ? mayor.toString() : "No hay") +
                            "\n\nBus menor capacidad:\n" + (menor != null ? menor.toString() : "No hay"));
                }
            }
        }
    }
}
