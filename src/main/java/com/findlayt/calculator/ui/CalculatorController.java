package com.findlayt.calculator.ui;

import com.findlayt.calculator.engine.CalculatorEngine;
import javafx.fxml.FXML;
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
    protected void onDigitClick() {
        updateDisplay();
    }

    @FXML
    protected void onOperatorClick() {
        updateDisplay();
    }

    @FXML
    protected void onEqualsClick() {
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
