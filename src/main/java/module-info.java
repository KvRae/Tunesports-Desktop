module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires java.desktop;
    requires java.mail;
    requires twilio;

    exports Controllers;
    exports Entities;
    exports com.example.demo;
    opens com.example.demo to javafx.fxml;

    opens Entities to javafx.fxml;
    opens Controllers to javafx.fxml;
}