module com.javafxbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.javafxbd to javafx.fxml;
    exports com.javafxbd;

    exports com.javafxbd.model;
    opens com.javafxbd.model to javafx.fxml;

    exports com.javafxbd.db;
    opens com.javafxbd.db to javafx.fxml;

    exports com.javafxbd.controller;
    opens com.javafxbd.controller to javafx.fxml;
}