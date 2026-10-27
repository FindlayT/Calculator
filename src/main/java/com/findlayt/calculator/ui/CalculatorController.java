package com.findlayt.calculator.ui;

import com.findlayt.calculator.engine.CalculatorEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

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
        display.requestFocus();
    }

    @FXML
    private void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DIGIT0, NUMPAD0 -> keyPressedDigitHelper("0");
            case DIGIT1, NUMPAD1 -> keyPressedDigitHelper("1");
            case DIGIT2, NUMPAD2 -> keyPressedDigitHelper("2");
            case DIGIT3, NUMPAD3 -> keyPressedDigitHelper("3");
            case DIGIT4, NUMPAD4 -> keyPressedDigitHelper("4");
            case DIGIT5, NUMPAD5 -> keyPressedDigitHelper("5");
            case DIGIT6, NUMPAD6 -> keyPressedDigitHelper("6");
            case DIGIT7, NUMPAD7 -> keyPressedDigitHelper("7");
            case DIGIT8, NUMPAD8 -> keyPressedDigitHelper("8");
            case DIGIT9, NUMPAD9 -> keyPressedDigitHelper("9");
            case ADD, PLUS -> keyPressedOperatorHelper("+");
            case SUBTRACT, MINUS -> keyPressedOperatorHelper("-");
            case MULTIPLY, ASTERISK -> keyPressedOperatorHelper("×");
            case DIVIDE, SLASH -> keyPressedOperatorHelper("÷");
            case PERIOD, DECIMAL -> keyPressedOperatorHelper(".");
            case ENTER, EQUALS -> { engine.calculate(); updateDisplay(); }
            case BACK_SPACE, DELETE -> { engine.clear(); updateDisplay(); }
        }
    }

    @FXML
    private void keyPressedDigitHelper(String digit) {
        engine.appendDigit(digit);
        updateDisplay();
    }

    @FXML
    private void keyPressedOperatorHelper(String operator) {
        engine.appendOperator(operator);
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
        engine.calculate();
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
