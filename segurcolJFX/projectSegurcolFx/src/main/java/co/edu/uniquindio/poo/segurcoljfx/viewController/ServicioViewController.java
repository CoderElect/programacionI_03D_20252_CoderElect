package co.edu.uniquindio.poo.segurcoljfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ServicioViewController {

    @FXML
    private void abrirCustodiaFija() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudCustodiaFija.fxml",
                "Gestión de Custodia Fija");
    }

    @FXML
    private void abrirPatrullajeMovil() {
        abrirVentana("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudPatrullajeMovil.fxml",
                "Gestión de Patrullaje Móvil");
    }

    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
