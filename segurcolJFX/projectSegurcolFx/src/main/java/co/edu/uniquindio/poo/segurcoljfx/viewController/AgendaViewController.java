package co.edu.uniquindio.poo.segurcoljfx.viewController;

import co.edu.uniquindio.poo.segurcoljfx.controller.AgendaController;
import co.edu.uniquindio.poo.segurcoljfx.model.*;
import co.edu.uniquindio.poo.segurcoljfx.model.enums.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.time.LocalDate;

public class AgendaViewController {

    @FXML private TableView<AgendaItem> tblAgenda;
    @FXML private TableColumn<AgendaItem, LocalDate> colFecha;
    @FXML private TableColumn<AgendaItem, String> colDescripcion;
    @FXML private TableColumn<AgendaItem, String> colEmpleado;
    @FXML private TableColumn<AgendaItem, String> colServicio;

    @FXML private DatePicker dpFecha;
    @FXML private TextField txtDescripcion;
    @FXML private ComboBox<Empleado> cmbEmpleado;
    @FXML private ComboBox<Servicio> cmbServicio;

    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    private ObservableList<AgendaItem> listaAgenda = FXCollections.observableArrayList();
    private AgendaController agendaController;

    @FXML
    public void initialize() {
        Segurcol segurcol = new Segurcol("Segurcol S.A.", "NIT123");
        agendaController = new AgendaController(segurcol);

       //colums de la tabla
        colFecha.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().fecha()));
        colDescripcion.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().descripcion()));
        colEmpleado.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().empleado() != null ? data.getValue().empleado().getNombre() : "N/A"));
        colServicio.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().servicio() != null
                        ? (data.getValue().servicio() instanceof CustodiaFija ? "Custodia fija" : "Patrullaje móvil")
                        : "N/A"));

        // data quemada
        ObservableList<Empleado> empleadosDisponibles = FXCollections.observableArrayList(
                new Vigilante("Pedro Gómez", "1010", Turno.DIA, 1200000, 1, TipoArma.SINARMA),
                new Supervisor("Ana Torres", "20270", Turno.NOCHE, 1500000, 25000),
                new OperadorMonitoreo("Luis Ríos", "30730", Turno.DIA, 1400000, 10)
        );
        cmbEmpleado.setItems(empleadosDisponibles);

        // muestra el nombre solamente y no el objeto
        cmbEmpleado.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Empleado item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });
        cmbEmpleado.setButtonCell(cmbEmpleado.getCellFactory().call(null));


        ObservableList<Servicio> serviciosDisponibles = FXCollections.observableArrayList(
                new CustodiaFija("C001", "Cliente X", 800000, EstadoServicio.ACTIVO, "Bodega Sur"),
                new PatrullajeMovil(2, 75.0, "P002", "Cliente Y", 1200000, EstadoServicio.ACTIVO)
        );
        cmbServicio.setItems(serviciosDisponibles);

        // nombre del servicio y no toda la info
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

        listaAgenda.add(new AgendaItem(LocalDate.now(), "Ronda nocturna", empleadosDisponibles.get(0), serviciosDisponibles.get(0)));

        tblAgenda.setItems(listaAgenda);
    }

    @FXML
    void onAgregar(ActionEvent event) {
        LocalDate fecha = dpFecha.getValue();
        String descripcion = txtDescripcion.getText();
        Empleado empleado = cmbEmpleado.getValue();
        Servicio servicio = cmbServicio.getValue();

        if (agendaController.agregarEvento(fecha, descripcion, empleado, servicio)) {
            listaAgenda.add(new AgendaItem(fecha, descripcion, empleado, servicio));
            limpiarCampos();
            mostrarAlerta("Éxito", "Evento agregado correctamente");
        } else {
            mostrarAlerta("Error", "Complete todos los campos");
        }
    }

    @FXML
    void onEliminar(ActionEvent event) {
        AgendaItem seleccionado = tblAgenda.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un evento para eliminar.");
            return;
        }
        if (agendaController.eliminarEvento(seleccionado)) {
            listaAgenda.remove(seleccionado);
            mostrarAlerta("Éxito", "Evento eliminado correctamente.");
        }
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        dpFecha.setValue(null);
        txtDescripcion.clear();
        cmbEmpleado.setValue(null);
        cmbServicio.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
