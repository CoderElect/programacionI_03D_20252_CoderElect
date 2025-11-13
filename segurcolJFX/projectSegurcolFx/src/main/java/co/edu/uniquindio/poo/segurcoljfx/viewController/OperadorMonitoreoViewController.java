package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.model.OperadorMonitoreo;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class OperadorMonitoreoViewController implements Initializable {

    @FXML private TableView<OperadorMonitoreo> tblOperadores;
    @FXML private TableColumn<OperadorMonitoreo, String> colNombre;
    @FXML private TableColumn<OperadorMonitoreo, String> colDocumento;
    @FXML private TableColumn<OperadorMonitoreo, String> colTurno;
    @FXML private TableColumn<OperadorMonitoreo, Double> colSalario;
    @FXML private TableColumn<OperadorMonitoreo, Integer> colZonas;

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private ComboBox<Turno> cmbTurno;
    @FXML private TextField txtSalario;
    @FXML private Spinner<Integer> spnZonas;

    private ObservableList<OperadorMonitoreo> listaOperadores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // agregar num de zonas de 1-8 teniendo por default i2
        spnZonas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 8, 2));

        //comboBox de turnos (tomado del Enum)
        cmbTurno.setItems(FXCollections.observableArrayList(Turno.values()));

        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colDocumento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDocumento()));
        colTurno.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTurno().toString()));
        colSalario.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalarioBase()).asObject());
        colZonas.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getZonasMonitoreo()).asObject());

        // datos de prueba
        listaOperadores = FXCollections.observableArrayList(
                new OperadorMonitoreo("Pablito calvito", "303030", Turno.DIA, 1800000, 8),
                new OperadorMonitoreo("Maria José", "404040", Turno.NOCHE, 1850000, 5)
        );

        tblOperadores.setItems(listaOperadores);
    }


    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            Turno turno = cmbTurno.getValue();
            double salario = Double.parseDouble(txtSalario.getText());
            int zonas = spnZonas.getValue();

            if (nombre.isEmpty() || documento.isEmpty() || turno == null) {
                mostrarAlerta("Error", "Por favor, complete todos los campos requeridos.");
                return;
            }

            OperadorMonitoreo nuevo = new OperadorMonitoreo(nombre, documento, turno, salario, zonas);
            listaOperadores.add(nuevo);

            limpiarCampos();
            mostrarAlerta("Éxito", "Operador agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El salario debe ser un número válido.");
        }
    }

    // seleccionar uno en la tabla y actualizar (operador)
    @FXML
    void onActualizar(ActionEvent event) {
        OperadorMonitoreo seleccionado = tblOperadores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un operador para actualizar.");
            return;
        }

        try {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setDocumento(txtDocumento.getText());
            seleccionado.setTurno(cmbTurno.getValue());
            seleccionado.setSalarioBase(Double.parseDouble(txtSalario.getText()));
            seleccionado.setZonasMonitoreo(spnZonas.getValue());

            tblOperadores.refresh();
            mostrarAlerta("Éxito", "Operador actualizado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El salario debe ser un número válido.");
        }
    }

    // seleccionar en tabla y eliminar (operador)
    @FXML
    void onEliminar(ActionEvent event) {
        OperadorMonitoreo seleccionado = tblOperadores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un operador para eliminar.");
            return;
        }

        listaOperadores.remove(seleccionado);
        mostrarAlerta("Éxito", "Operador eliminado correctamente.");
    }

    // limpiar datos del form
    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }
    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtSalario.clear();
        cmbTurno.getSelectionModel().clearSelection();
        spnZonas.getValueFactory().setValue(5);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
