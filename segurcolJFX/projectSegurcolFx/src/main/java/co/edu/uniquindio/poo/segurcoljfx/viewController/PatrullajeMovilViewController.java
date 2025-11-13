package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.controller.ServicioController;
import co.edu.uniquindio.poo.segurcoljfx.model.*;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.EstadoServicio;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PatrullajeMovilViewController {

    @FXML private TableView<PatrullajeMovil> tblPatrullaje;
    @FXML private TableColumn<PatrullajeMovil, String> colCodigo;
    @FXML private TableColumn<PatrullajeMovil, String> colCliente;
    @FXML private TableColumn<PatrullajeMovil, Double> colTarifa;
    @FXML private TableColumn<PatrullajeMovil, String> colEstado;
    @FXML private TableColumn<PatrullajeMovil, Integer> colRuta;
    @FXML private TableColumn<PatrullajeMovil, Double> colKilometros;

    @FXML private TextField txtCodigoContrato;
    @FXML private TextField txtCliente;
    @FXML private TextField txtTarifa;
    @FXML private TextField txtRuta;
    @FXML private TextField txtKilometros;
    @FXML private ComboBox<EstadoServicio> cmbEstado;

    @FXML private Button btnAgregar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    private ServicioController servicioController;
    private ObservableList<PatrullajeMovil> listaPatrullajes;

    @FXML
    public void initialize() {

        Segurcol segurcol = new Segurcol("Segurcol S.A.", "NIT123");
        servicioController = new ServicioController(segurcol);

        cmbEstado.setItems(FXCollections.observableArrayList(EstadoServicio.values()));

        colCodigo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCodigoContrato()));
        colCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente()));
        colTarifa.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTarifaMensual()).asObject());
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstadoServicio().toString()));
        colRuta.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getRuta()).asObject());
        colKilometros.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getKilometrosRecorridos()).asObject());

        // datos de prueba
        listaPatrullajes = FXCollections.observableArrayList(
                new PatrullajeMovil(1, 25.5, "PM001", "Bodega Olímpica", 2500000, EstadoServicio.ACTIVO),
                new PatrullajeMovil(2, 40.0, "PM002", "Centro Comercial Calima", 2700000, EstadoServicio.SUSPENDIDO)
        );

        tblPatrullaje.setItems(listaPatrullajes);
    }

    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String codigo = txtCodigoContrato.getText();
            String cliente = txtCliente.getText();
            double tarifa = Double.parseDouble(txtTarifa.getText());
            EstadoServicio estado = cmbEstado.getValue();
            int ruta = Integer.parseInt(txtRuta.getText());
            double km = Double.parseDouble(txtKilometros.getText());

            if (codigo.isEmpty() || cliente.isEmpty() || estado == null) {
                mostrarAlerta("Error", "Complete todos los campos antes de agregar.");
                return;
            }

            PatrullajeMovil nuevo = new PatrullajeMovil(ruta, km, codigo, cliente, tarifa, estado);
            listaPatrullajes.add(nuevo);

            limpiarCampos();
            mostrarAlerta("Éxito", "Servicio de Patrullaje Móvil agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ruta, kilómetros o tarifa inválidos.");
        }
    }

    @FXML
    void onEliminar(ActionEvent event) {
        PatrullajeMovil seleccionado = tblPatrullaje.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un servicio para eliminar.");
            return;
        }

        listaPatrullajes.remove(seleccionado);
        mostrarAlerta("Éxito", "Servicio eliminado correctamente.");
    }

    @FXML
    void onActualizar(ActionEvent event) {
        PatrullajeMovil seleccionado = tblPatrullaje.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un servicio para actualizar.");
            return;
        }

        try {
            String codigo = txtCodigoContrato.getText();
            String cliente = txtCliente.getText();
            double tarifa = Double.parseDouble(txtTarifa.getText());
            EstadoServicio estado = cmbEstado.getValue();
            int ruta = Integer.parseInt(txtRuta.getText());
            double km = Double.parseDouble(txtKilometros.getText());

            if (codigo.isEmpty() || cliente.isEmpty() || estado == null) {
                mostrarAlerta("Error", "Complete todos los campos antes de actualizar.");
                return;
            }

            PatrullajeMovil actualizado = new PatrullajeMovil(ruta, km, codigo, cliente, tarifa, estado);
            listaPatrullajes.remove(seleccionado);
            listaPatrullajes.add(actualizado);

            limpiarCampos();
            mostrarAlerta("Éxito", "Servicio actualizado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ruta, kilómetros o tarifa inválidos.");
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
        txtRuta.clear();
        txtKilometros.clear();
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

