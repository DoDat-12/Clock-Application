module com.example.clockflipcountdown {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.clock.controllers;
    opens com.example.clock.controllers to javafx.fxml;
    exports com.example.clock.main;
    opens com.example.clock.main to javafx.fxml;
}