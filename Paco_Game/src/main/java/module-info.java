module com.example.threads {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.threads to javafx.fxml;
    exports com.example.threads;
    exports com.example.threads.intro_threads;
    opens com.example.threads.intro_threads to javafx.fxml;
}