package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.model.Supervisor;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.Turno;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SupervisorViewController implements Initializable {

    @FXML private TableView<Supervisor> tblSupervisores;
    @FXML private TableColumn<Supervisor, String> colNombre;
    @FXML private TableColumn<Supervisor, String> colDocumento;
    @FXML private TableColumn<Supervisor, String> colTurno;
    @FXML private TableColumn<Supervisor, Double> colSalario;
    @FXML private TableColumn<Supervisor, Double> colBono;

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private ComboBox<Turno> cmbTurno;
    @FXML private TextField txtSalario;
    @FXML private Spinner<Double> spnBono;

    private ObservableList<Supervisor> listaSupervisores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // agregar valores para el bono, de 0-1´000.000, default 50.000, itera de a 25.000
        spnBono.setValueFactory(
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1_000_000, 50_000, 25_000)
        );

        // comboBox de turnos para tomar los valores del Enum
        cmbTurno.setItems(FXCollections.observableArrayList(Turno.values()));

        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colDocumento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDocumento()));
        colTurno.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTurno().toString()));
        colSalario.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalarioBase()).asObject());
        colBono.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getBonoPorCoordinacion()).asObject());

        // datos de prueba
        listaSupervisores = FXCollections.observableArrayList(
                new Supervisor("Abraham Torres", "101010", Turno.DIA, 2000000, 325000),
                new Supervisor("Pablito Pelito", "202020", Turno.NOCHE, 2100000, 375000)
        );

        // asignacion para tabla
        tblSupervisores.setItems(listaSupervisores);
    }

    // botones funcionales
    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            Turno turno = cmbTurno.getValue();
            double salario = Double.parseDouble(txtSalario.getText());
            double bono = spnBono.getValue();

            if (nombre.isEmpty() || documento.isEmpty() || turno == null) {
                mostrarAlerta("Error", "Por favor, completa todos los campos requeridos.");
                return;
            }

            Supervisor nuevo = new Supervisor(nombre, documento, turno, salario, bono);
            listaSupervisores.add(nuevo); //add para la tabla

            limpiarCampos();
            mostrarAlerta("Éxito", "Supervisor agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El salario debe ser un número válido.");
        }
    }

    // seleccionar uno en la tabla y actualizar (supervisor)
    @FXML
    void onActualizar(ActionEvent event) {
        Supervisor seleccionado = tblSupervisores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un supervisor para actualizar.");
            return;
        }

        try {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setDocumento(txtDocumento.getText());
            seleccionado.setTurno(cmbTurno.getValue());
            seleccionado.setSalarioBase(Double.parseDouble(txtSalario.getText()));
            seleccionado.setBonoPorCoordinacion(spnBono.getValue());

            tblSupervisores.refresh();
            mostrarAlerta("Éxito", "Supervisor actualizado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El salario debe ser un número válido.");
        }
    }

    // seleccionar uno en la tabla y eliminar (supervisor)
    @FXML
    void onEliminar(ActionEvent event) {
        Supervisor seleccionado = tblSupervisores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un supervisor para eliminar.");
            return;
        }

        listaSupervisores.remove(seleccionado);
        mostrarAlerta("Éxito", "Supervisor eliminado correctamente.");
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
        spnBono.getValueFactory().setValue(100_000.0);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
