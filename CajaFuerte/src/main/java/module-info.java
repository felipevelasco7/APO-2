module com.example.cajafuerte {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cajafuerte to javafx.fxml;
    exports com.example.cajafuerte;
    exports com.example.cajafuerte.control;
    opens com.example.cajafuerte.control to javafx.fxml;
}