package com.findlayt.calculator.engine;

import java.util.List;
import java.util.Objects;

/**
 * Core calculator state and operations.
 */
public class CalculatorEngine {

    private String display = "0";

    public String getDisplay() {
        return display;
    }

    public void appendDigit(String number) {
        if (Objects.equals(display, "0")) {
            display = number;
        } else {
            display = display + number;
        }
    }

    public void appendOperator(String operator) {
        display = display + operator;
    }

    public void calculate() {
        List<Token> tokenisedDisplay = Tokeniser.tokenise(display);
        // parse and set display to computed value
    }

    public void clear() {
        display = "0";
    }
}
