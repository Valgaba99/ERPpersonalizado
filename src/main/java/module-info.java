module com.example.erppersonalizado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.erppersonalizado to javafx.fxml;
    exports com.example.erppersonalizado;
}