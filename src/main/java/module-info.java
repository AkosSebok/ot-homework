module com.example.sem2_zad2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sem2_zad2 to javafx.fxml;
    exports com.example.sem2_zad2;
}