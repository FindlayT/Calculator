module com.findlayt.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.findlayt.calculator.ui to javafx.fxml;
    exports com.findlayt.calculator;
}
