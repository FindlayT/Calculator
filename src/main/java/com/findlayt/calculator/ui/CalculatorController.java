package com.findlayt.calculator.ui;

import com.findlayt.calculator.engine.CalculatorEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * wires FXML events to {@link CalculatorEngine} and updates the display.
 */
public class CalculatorController {

    private final CalculatorEngine engine = new CalculatorEngine();

    @FXML
    private Label display;

    @FXML
    private void initialize() {
        updateDisplay();
    }

    @FXML
    protected void onDigitClick(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();
        engine.appendDigit(number);
        updateDisplay();
    }

    @FXML
    protected void onOperatorClick(ActionEvent event) {
        String operator = ((Button) event.getSource()).getText();
        engine.appendOperator(operator);
        updateDisplay();
    }

    @FXML
    protected void onEqualsClick() {
        //engine.calculate
        updateDisplay();
    }

    @FXML
    protected void onClearClick() {
        engine.clear();
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(engine.getDisplay());
    }
}
