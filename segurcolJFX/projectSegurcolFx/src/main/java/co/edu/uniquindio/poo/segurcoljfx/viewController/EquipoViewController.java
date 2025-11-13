package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.model.*;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EquipoViewController {

    @FXML private TextField txtCodigo, txtValor;
    @FXML private ComboBox<EstadoEquipo> cmbEstado;
    @FXML private ComboBox<TipoEquipo> cmbTipo;
    @FXML private ComboBox<Servicio> cmbServicio;
    @FXML private ComboBox<Empleado> cmbEmpleado;

    @FXML private TableView<Equipo> tblEquipos;
    @FXML private TableColumn<Equipo, String> colCodigo, colEstadoEquipo, colTipoEquipo, colServicio, colEmpleado;
    @FXML private TableColumn<Equipo, Double> colValorReposicion;

    private ObservableList<Equipo> equiposList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cmbEstado.setItems(FXCollections.observableArrayList(EstadoEquipo.values()));
        cmbTipo.setItems(FXCollections.observableArrayList(TipoEquipo.values()));

        // datos de servicio de ejemplo
        ObservableList<Servicio> serviciosDisponibles = FXCollections.observableArrayList(
                new CustodiaFija("CT0701", "Cliente A", 1200000, EstadoServicio.ACTIVO, "Bodega Norte"),
                new PatrullajeMovil(5, 100.5, "PT7002", "Cliente B", 1800000, EstadoServicio.ACTIVO)
        );
        cmbServicio.setItems(serviciosDisponibles);

        // muestra name del servicio y no el objeto
        cmbServicio.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Servicio item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else if (item instanceof CustodiaFija) {
                    setText("Custodia fija");
                } else if (item instanceof PatrullajeMovil) {
                    setText("Patrullaje móvil");
                }
            }
        });
        cmbServicio.setButtonCell(cmbServicio.getCellFactory().call(null));


        ObservableList<Empleado> empleadosDisponibles = FXCollections.observableArrayList(
                new Vigilante("Maelo Ruiz", "8080", Turno.DIA, 1500000, 2, TipoArma.SINARMA),
                new Supervisor("Super Vision", "9090", Turno.NOCHE, 1700000, 25000),
                new OperadorMonitoreo("Omar Camaras", "7070", Turno.DIA, 1400000, 15)
        );
        cmbEmpleado.setItems(empleadosDisponibles);


        cmbEmpleado.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Empleado item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });
        cmbEmpleado.setButtonCell(cmbEmpleado.getCellFactory().call(null));


        colCodigo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCodigo()));
        colValorReposicion.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getValorReposicion()));
        colEstadoEquipo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEstadoEquipo().toString()));
        colTipoEquipo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTipoEquipo().toString()));

        colServicio.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().getListServicios().isEmpty()
                        ? ""
                        : (data.getValue().getListServicios().getFirst() instanceof CustodiaFija
                        ? "Custodia fija"
                        : "Patrullaje móvil")
        ));

        colEmpleado.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().getEmpleados().isEmpty()
                        ? ""
                        : data.getValue().getEmpleados().getFirst().getNombre()
        ));

        tblEquipos.setItems(equiposList);
    }


    @FXML
    private void onAgregar() {
        try {
            String codigo = txtCodigo.getText();
            double valor = Double.parseDouble(txtValor.getText());
            EstadoEquipo estado = cmbEstado.getValue();
            TipoEquipo tipo = cmbTipo.getValue();

            if (codigo.isBlank() || estado == null || tipo == null) {
                mostrarAlerta("Error", "Por favor complete todos los campos.");
                return;
            }

            Equipo equipo = new Equipo(codigo, valor, estado, tipo);
            equiposList.add(equipo);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error", "Ingrese correctamente el valor de reposición.");
        }
    }


    @FXML
    private void onEliminar() {
        Equipo seleccionado = tblEquipos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            equiposList.remove(seleccionado);
        } else {
            mostrarAlerta("Atención", "Debe seleccionar un equipo para eliminar.");
        }
    }

    // el servicio seleccionado se agrega a la tabla
    @FXML
    private void onAsignarServicio() {
        Equipo equipo = tblEquipos.getSelectionModel().getSelectedItem();
        Servicio servicio = cmbServicio.getValue();
        if (equipo != null && servicio != null) {
            equipo.getListServicios().add(servicio);
            tblEquipos.refresh();
        } else {
            mostrarAlerta("Atención", "Seleccione un equipo y un servicio para asignar.");
        }
    }

    @FXML
    private void onAsignarEmpleado() {
        Equipo equipo = tblEquipos.getSelectionModel().getSelectedItem();
        Empleado empleado = cmbEmpleado.getValue();
        if (equipo != null && empleado != null) {
            equipo.getEmpleados().add(empleado);
            tblEquipos.refresh();
        } else {
            mostrarAlerta("Atención", "Seleccione un equipo y un empleado para asignar.");
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtValor.clear();
        cmbEstado.getSelectionModel().clearSelection();
        cmbTipo.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
