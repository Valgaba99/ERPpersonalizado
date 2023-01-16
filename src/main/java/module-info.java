module com.example.erppersonalizado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.erppersonalizado to javafx.fxml;
    exports com.example.erppersonalizado;
}