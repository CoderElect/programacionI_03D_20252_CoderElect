
package co.edu.uniquindio.poo.empresajavafx;


import co.edu.uniquindio.poo.empresajavafx.model.Cliente;
import co.edu.uniquindio.poo.empresajavafx.model.Empresa;
import co.edu.uniquindio.poo.empresajavafx.viewcontroller.PrimaryViewController;
import co.edu.uniquindio.poo.empresajavafx.viewcontroller.ClienteViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;


public class App extends Application {


    private Stage primaryStage;
    public static Empresa empresa = new Empresa("UQ");


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
    }


    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml")); // el primary se cambia por el nombre de la clase que se desea invocar
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml")); //cambio
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ClienteViewController clienteViewController = loader.getController();  //cambio
            clienteViewController.setApp(this);  //cambio


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //servicios
    public void inicializarData(){
        Cliente cliente = new Cliente("12233", "juan", "apellido");
        empresa.agregarCliente(cliente);
    }
}
