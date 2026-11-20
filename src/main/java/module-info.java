module com.example.sem6_zad2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sem6_zad2 to javafx.fxml;
    exports com.example.sem6_zad2;
}