package co.edu.uniquindio.poo.segurcoljfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class VentanaPrincipalViewController {

    @FXML
    void abrirPersonal(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/crudEmpleado.fxml","Gestión de Empleados");
    }

    @FXML
    private void abrirServicios() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/crudServicio.fxml", "Gestión de Servicios");
    }

    @FXML
    private void abrirEquipos() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/crudEquipo.fxml", "Gestión de Equipos");
    }

    @FXML
    private void abrirAgenda() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/crudAgenda.fxml", "Gestión de Agenda y Novedades");
    }

    public void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
