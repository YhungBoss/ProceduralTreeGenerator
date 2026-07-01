module org.example.treegrowthsimulation {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.treegrowthsimulation to javafx.fxml;
    exports org.example.treegrowthsimulation;
}