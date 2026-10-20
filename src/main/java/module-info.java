module com.example.sem4_zad3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sem4_zad3 to javafx.fxml;
    exports com.example.sem4_zad3;
}