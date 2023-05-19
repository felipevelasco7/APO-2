module com.example.democanva {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.democanva to javafx.fxml;
    exports com.example.democanva;
    exports com.example.democanva.control;
    opens com.example.democanva.control to javafx.fxml;
}