package com.findlayt.calculator.engine;

/**
 * Core calculator state and operations.
 */
public class CalculatorEngine {

    private String display = "0";

    public String getDisplay() {
        return display;
    }

    public void clear() {
        display = "0";
    }
}
