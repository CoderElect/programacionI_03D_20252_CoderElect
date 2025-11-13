package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.controller.ServicioController;
import co.edu.uniquindio.poo.segurcoljfx.model.*;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoServicio;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class CustodiaFijaViewController {

    @FXML private TableView<CustodiaFija> tblCustodiaFija;
    @FXML private TableColumn<CustodiaFija, String> colCodigo;
    @FXML private TableColumn<CustodiaFija, String> colCliente;
    @FXML private TableColumn<CustodiaFija, Double> colTarifa;
    @FXML private TableColumn<CustodiaFija, String> colEstado;
    @FXML private TableColumn<CustodiaFija, String> colPuesto;

    @FXML private TextField txtCodigoContrato;
    @FXML private TextField txtCliente;
    @FXML private TextField txtTarifa;
    @FXML private TextField txtPuesto;
    @FXML private ComboBox<EstadoServicio> cmbEstado;

    @FXML private Button btnAgregar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    private ServicioController servicioController;
    private ObservableList<CustodiaFija> listaCustodias;

    @FXML
    public void initialize() {
        Segurcol segurcol = new Segurcol("Segurcol S.A.", "NIT123");
        servicioController = new ServicioController(segurcol);


        cmbEstado.setItems(FXCollections.observableArrayList(EstadoServicio.values()));

        // espacios de la tabla
        colCodigo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCodigoContrato()));
        colCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente()));
        colTarifa.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTarifaMensual()).asObject());
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstadoServicio().toString()));
        colPuesto.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPuesto()));

        // datos prueba
        listaCustodias = FXCollections.observableArrayList(
                new CustodiaFija("CF01", "Almacén exit", 2500000, EstadoServicio.ACTIVO, "Bodega 3"),
                new CustodiaFija("CF002", "Camelias", 1800000, EstadoServicio.SUSPENDIDO, "Portería uno")
        );

        tblCustodiaFija.setItems(listaCustodias);
    }


    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String codigo = txtCodigoContrato.getText();
            String cliente = txtCliente.getText();
            double tarifa = Double.parseDouble(txtTarifa.getText());
            EstadoServicio estado = cmbEstado.getValue();
            String puesto = txtPuesto.getText();

            if (codigo.isEmpty() || cliente.isEmpty() || estado == null || puesto.isEmpty()) {
                mostrarAlerta("Error", "Por favor complete todos los campos requeridos.");
                return;
            }

            CustodiaFija nuevo = new CustodiaFija(codigo, cliente, tarifa, estado, puesto);
            listaCustodias.add(nuevo);

            limpiarCampos();
            mostrarAlerta("Éxito", "Servicio de Custodia Fija agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El valor de la tarifa no es valido.");
        }
    }

    @FXML
    void onEliminar(ActionEvent event) {
        CustodiaFija seleccionado = tblCustodiaFija.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un servicio para eliminar.");
            return;
        }

        listaCustodias.remove(seleccionado);
        mostrarAlerta("Éxito", "Servicio eliminado correctamente.");
    }

    @FXML
    void onActualizar(ActionEvent event) {
        CustodiaFija seleccionado = tblCustodiaFija.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un servicio para actualizar.");
            return;
        }

        try {
            String codigo = txtCodigoContrato.getText();
            String cliente = txtCliente.getText();
            double tarifa = Double.parseDouble(txtTarifa.getText());
            EstadoServicio estado = cmbEstado.getValue();
            String puesto = txtPuesto.getText();

            if (codigo.isEmpty() || cliente.isEmpty() || estado == null || puesto.isEmpty()) {
                mostrarAlerta("Error", "Por favor complete todos los campos requeridos.");
                return;
            }

            CustodiaFija actualizado = new CustodiaFija(codigo, cliente, tarifa, estado, puesto);
            listaCustodias.remove(seleccionado);
            listaCustodias.add(actualizado);

            limpiarCampos();
            mostrarAlerta("Éxito", "Servicio actualizado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Tarifa invalida.");
        }
    }


    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtCodigoContrato.clear();
        txtCliente.clear();
        txtTarifa.clear();
        txtPuesto.clear();
        cmbEstado.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
