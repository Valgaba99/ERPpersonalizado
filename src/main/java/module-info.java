module com.example.erppersonalizado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;


    opens com.example.erppersonalizado to javafx.fxml;
    opens com.example.erppersonalizado.Controlador to javafx.fxml;

    exports com.example.erppersonalizado;
}