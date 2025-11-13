module co.edu.uniquindio.poo.empresajavafx {
    requires javafx.controls;
    requires javafx.fxml;




    opens co.edu.uniquindio.poo.empresajavafx to javafx.fxml;
    exports co.edu.uniquindio.poo.empresajavafx;


    exports co.edu.uniquindio.poo.empresajavafx.viewcontroller;
    opens co.edu.uniquindio.poo.empresajavafx.viewcontroller to javafx.fxml;


    exports co.edu.uniquindio.poo.empresajavafx.controller;
    opens co.edu.uniquindio.poo.empresajavafx.controller to javafx.fxml;
}
