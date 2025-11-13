package co.edu.uniquindio.poo.segurcoljfx;

import co.edu.uniquindio.poo.segurcoljfx.model.Segurcol;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Segurcol segurcol;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        openVentanaPrincipal(); // Seleccionar
    }


    public static void openVentanaPrincipal() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/ventanaPrincipal.fxml",
                "Bienvenido a Segurcol");
    }

    public static void openCrudEmpleado() {
        openWindow("co/edu/uniquindio/poo/segurcoljfx/crudEmpleado.fxml",
                "Gestión de Empleados");
    }

    public static void openCrudVigilante() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudVigilante.fxml",
                "Gestión de Vigilantes");
    }

    public static void openCrudSupervisor() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudSupervisor.fxml",
                "Gestión de Supervisores");
    }

    public static void openCrudOperadorMonitoreo() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudOperadorMonitoreo.fxml",
                "Gestión de Operadores de Monitoreo");
    }

    public static void openCrudServicios() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudServicio.fxml",
                "Gestión de Servicios");
    }

    public static void openCrudCustodiaFija() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudCustodiaFija.fxml",
                "Gestión de Custodia Fija");
    }

    public static void openCrudPatrullajeMovil() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudPatrullajeMovil.fxml",
                "Gestión de Patrullaje Móvil");
    }

    public static void openCrudEquipos() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudEquipos.fxml",
                "Gestión de Equipos");
    }

    public static void openCrudAgenda() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudAgenda.fxml",
                "Gestión de Agenda y Novedades");
    }

//abre cualquier  fxml
    private static void openWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));

            if (loader.getLocation() == null) {
                System.out.println("No se encontró el archivo: " + fxmlPath);
                return;
            }

            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir " + fxmlPath + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        segurcol = new Segurcol("S001","LugarRandom"); // ✅ Inicializamos el modelo global
        launch(args);
    }
}