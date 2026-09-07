package com.findlayt.calculator.engine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokeniserTest {

    @Test
    void tokeniseSingleNumber() {
        List<Token> tokens = Tokeniser.tokenise("42");

        assertEquals(1, tokens.size());
        assertEquals(TokenType.NUMBER, tokens.getFirst().type());
        assertEquals(42, tokens.getFirst().numberValue());
    }

    @Test
    void tokeniseDecimalNumber() {
        List<Token> tokens = Tokeniser.tokenise("3.14");

        assertEquals(1, tokens.size());
        assertEquals(3.14, tokens.getFirst().numberValue());
    }

    @Test
    void tokeniseEmptyString() {
        List<Token> tokens = Tokeniser.tokenise("");

        assertTrue(tokens.isEmpty());
    }

    @Test
    void tokeniseAddition() {
        List<Token> tokens = Tokeniser.tokenise("5+3");

        assertEquals(3, tokens.size());
        assertEquals(TokenType.NUMBER, tokens.get(0).type());
        assertEquals(5, tokens.get(0).numberValue());
        assertEquals(TokenType.PLUS, tokens.get(1).type());
        assertEquals(TokenType.NUMBER, tokens.get(2).type());
        assertEquals(3, tokens.get(2).numberValue());
    }

    @Test
    void tokeniseSubtraction() {
        List<Token> tokens = Tokeniser.tokenise("10−4");

        assertEquals(3, tokens.size());
        assertEquals(10, tokens.get(0).numberValue());
        assertEquals(TokenType.MINUS, tokens.get(1).type());
        assertEquals(4, tokens.get(2).numberValue());
    }

    @Test
    void tokeniseMultiplication() {
        List<Token> tokens = Tokeniser.tokenise("6×7");

        assertEquals(3, tokens.size());
        assertEquals(6, tokens.get(0).numberValue());
        assertEquals(TokenType.MULTIPLY, tokens.get(1).type());
        assertEquals(7, tokens.get(2).numberValue());
    }

    @Test
    void tokeniseDivision() {
        List<Token> tokens = Tokeniser.tokenise("20÷4");

        assertEquals(3, tokens.size());
        assertEquals(20, tokens.get(0).numberValue());
        assertEquals(TokenType.DIVIDE, tokens.get(1).type());
        assertEquals(4, tokens.get(2).numberValue());
    }

    @Test
    void tokeniseMultipleOperators() {
        List<Token> tokens = Tokeniser.tokenise("1+2×3−4÷2");

        assertEquals(9, tokens.size());
        assertEquals(1, tokens.get(0).numberValue());
        assertEquals(TokenType.PLUS, tokens.get(1).type());
        assertEquals(2, tokens.get(2).numberValue());
        assertEquals(TokenType.MULTIPLY, tokens.get(3).type());
        assertEquals(3, tokens.get(4).numberValue());
        assertEquals(TokenType.MINUS, tokens.get(5).type());
        assertEquals(4, tokens.get(6).numberValue());
        assertEquals(TokenType.DIVIDE, tokens.get(7).type());
        assertEquals(2, tokens.get(8).numberValue());
    }

    @Test
    void tokeniseDecimalExpression() {
        List<Token> tokens = Tokeniser.tokenise("1.5+2.25");

        assertEquals(3, tokens.size());
        assertEquals(1.5, tokens.get(0).numberValue());
        assertEquals(TokenType.PLUS, tokens.get(1).type());
        assertEquals(2.25, tokens.get(2).numberValue());
    }
}
