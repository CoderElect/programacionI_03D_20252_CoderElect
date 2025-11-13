package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpleadoViewController {
//ventana de vigilantes
    @FXML
    private void abrirCrudVigilante() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudVigilante.fxml", "Gestión de Vigilantes");
    }
//ventana de supervisores
    @FXML
    private void abrirCrudSupervisor() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudSupervisor.fxml", "Gestión de Supervisores");
    }
//ventana de operadores
    @FXML
    private void abrirCrudOperador() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudOperadorMonitoreo.fxml", "Gestión de Operadores de Monitoreo");
    }

  //buscado para abrir cualquiera
    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));

            if (loader.getLocation() == null) {
                System.out.println("No se encontró el archivo FXML: " + rutaFXML);
                return;
            }

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir " + rutaFXML + ": " + e.getMessage());
        }
    }
}
