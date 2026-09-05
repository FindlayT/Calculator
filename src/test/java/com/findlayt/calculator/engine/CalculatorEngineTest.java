package com.findlayt.calculator.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorEngineTest {

    private CalculatorEngine engine;

    @BeforeEach
    void setUp() {
        engine = new CalculatorEngine();
    }

    @Test
    void displayStartsAtZero() {
        assertEquals("0", engine.getDisplay());
    }

    @Test
    void appendDigitReplacesInitialZero() {
        engine.appendDigit("5");

        assertEquals("5", engine.getDisplay());
    }

    @Test
    void appendDigitAppendsToExistingValue() {
        engine.appendDigit("1");
        engine.appendDigit("2");
        engine.appendDigit("3");

        assertEquals("123", engine.getDisplay());
    }

    @Test
    void appendOperatorAppendsToDisplay() {
        engine.appendDigit("7");
        engine.appendOperator("+");

        assertEquals("7+", engine.getDisplay());
    }

    @Test
    void clearResetsDisplayToZero() {
        engine.appendDigit("9");
        engine.appendOperator("*");
        engine.appendDigit("3");

        engine.clear();

        assertEquals("0", engine.getDisplay());
    }

    @Test
    void appendDigitAfterClearReplacesZero() {
        engine.appendDigit("8");
        engine.clear();
        engine.appendDigit("4");

        assertEquals("4", engine.getDisplay());
    }
}
