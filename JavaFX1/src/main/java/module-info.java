module com.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx1 to javafx.fxml;
    exports com.javafx1;
}