package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.controller.EmpleadoController;
import co.edu.uniquindio.poo.segurcoljfx.model.*;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.TipoArma;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VigilanteViewController {

    @FXML private Button btnAgregar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    @FXML private ComboBox<TipoArma> cmbTipoArma;
    @FXML private ComboBox<Turno> cmbTurno;

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtSalario;

    @FXML private Spinner<Integer> spnNumPuesto;

    @FXML private TableView<Vigilante> tblVigilantes;
    @FXML private TableColumn<Vigilante, String> colNombre;
    @FXML private TableColumn<Vigilante, String> colDocumento;
    @FXML private TableColumn<Vigilante, Turno> colTurno;
    @FXML private TableColumn<Vigilante, TipoArma> colTipoArma;
    @FXML private TableColumn<Vigilante, Double> colSalario;

    private EmpleadoController empleadoController;
    private ObservableList<Vigilante> listaVigilantes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Segurcol segurcol = new Segurcol("Segurcol S.A.", "NIT123");
        empleadoController = new EmpleadoController(segurcol);

        // config ComboBox para los enums
        cmbTurno.setItems(FXCollections.observableArrayList(Turno.values()));
        cmbTipoArma.setItems(FXCollections.observableArrayList(TipoArma.values()));

        // agregar num de puestos, del 1 al 5, default 1
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        spnNumPuesto.setValueFactory(valueFactory);

        //columns de la tabla
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        colTurno.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTurno()));
        colTipoArma.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoArma()));
        colSalario.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSalarioBase()));
        // datos de prueba
        listaVigilantes = FXCollections.observableArrayList(
                new Vigilante("Mario car", "505050", Turno.DIA, 1523500, 1, TipoArma.NOLETAL),
                new Vigilante("Maria dos", "606060", Turno.NOCHE, 1800000, 4, TipoArma.SINARMA)
        );
        tblVigilantes.setItems(listaVigilantes);

    }

    // botones funcionales
    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            int puesto = spnNumPuesto.getValue();
            Turno turno = cmbTurno.getValue();
            TipoArma tipoArma = cmbTipoArma.getValue();

            if (nombre.isEmpty() || documento.isEmpty() || turno == null || tipoArma == null) {
                mostrarAlerta("Error", "Por favor complete todos los campos requeridos");
                return;
            }

            Vigilante nuevo = new Vigilante(nombre, documento, turno, salario, puesto, tipoArma);
            listaVigilantes.add(nuevo);

            limpiarCampos();
            mostrarAlerta("Éxito", "Vigilante agregado correctamente");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Salario o puesto inválido");
        }
    }

    // seleccionar uno en la tabla y eliminar (vigilante)
    @FXML
    void onEliminar(ActionEvent event) {
        Vigilante seleccionado = tblVigilantes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un vigilante para eliminar.");
            return;
        }

        listaVigilantes.remove(seleccionado);
        mostrarAlerta("Éxito", "Vigilantes eliminado correctamente.");
    }

    // seleccionar uno en la tabla y actualizar (vigilante)
    @FXML
    void onActualizar(ActionEvent event) {
        Vigilante seleccionado = tblVigilantes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                String nombre = txtNombre.getText();
                String documento = txtDocumento.getText();
                double salario = Double.parseDouble(txtSalario.getText());
                int puesto = spnNumPuesto.getValue();
                Turno turno = cmbTurno.getValue();
                TipoArma tipoArma = cmbTipoArma.getValue();

                Vigilante actualizado = new Vigilante(nombre, documento, turno, salario, puesto, tipoArma);
                boolean ok = empleadoController.actualizarEmpleado(documento, actualizado);

                if (ok) {
                    listaVigilantes.remove(seleccionado);
                    listaVigilantes.add(actualizado);
                    mostrarAlerta("Éxito", "Vigilante actualizado correctamente");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el vigilante");
                }

            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Campos numéricos incorrectos");
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un vigilante primero");
        }
    }

    // limpiar form
    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtSalario.clear();
        cmbTurno.setValue(null);
        cmbTipoArma.setValue(null);
        spnNumPuesto.getValueFactory().setValue(1);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

