package com.findlayt.calculator.engine;

public record Token(TokenType type, double numberValue) {
    // creates token with type number and a passed value
    public static Token num(double numberValue) {
        return new Token(TokenType.NUMBER, numberValue);
    }

    // creates token with type operator and value 0
    public static Token op(TokenType type) {
        if (type == TokenType.NUMBER) {
            throw new IllegalArgumentException("NUMBER is not an operator");
        }
        return new Token(type, 0);
    }
}