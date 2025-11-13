module co.edu.uniquindio.poo.empresajfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens co.edu.uniquindio.poo.segurcoljfx to javafx.fxml;
    exports co.edu.uniquindio.poo.segurcoljfx;
    exports co.edu.uniquindio.poo.segurcoljfx.viewController;
    opens co.edu.uniquindio.poo.segurcoljfx.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.segurcoljfx.model to javafx.base;


}