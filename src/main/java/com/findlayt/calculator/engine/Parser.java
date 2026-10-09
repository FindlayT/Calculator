package com.findlayt.calculator.engine;

import java.util.List;

public class Parser {

    public static String parse(List<Token> tokens) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("empty expression");
        }
        return Double.toString(new Parser(tokens).expression(0));
    }

    private final List<Token> tokens;
    private int at;

    private Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private double expression(int minBp) {
        double left = prefix();
        while (!done() && leftBinding(peek()) >= minBp) {
            TokenType op = advance().type();
            left = infix(op, left);
        }
        return left;
    }

    private double prefix() {
        Token t = advance();
        if (t.type() != TokenType.NUMBER) {
            throw new IllegalArgumentException("expected number, got " + t.type());
        }
        return t.numberValue();
    }

    private double infix(TokenType op, double left) {
        int lbp = leftBinding(op);
        double right = expression(lbp + 1);
        return binary(op, left, right);
    }

    private TokenType peek() {
        return tokens.get(at).type();
    }

    private Token advance() {
        return tokens.get(at++);
    }

    private boolean done() {
        return at >= tokens.size();
    }

    private static int leftBinding(TokenType op) {
        return switch (op) {
            case PLUS, MINUS -> 10;
            case MULTIPLY, DIVIDE -> 20;
            default -> -1;
        };
    }

    private static double binary(TokenType op, double a, double b) {
        return switch (op) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
            default -> throw new IllegalArgumentException("not infix: " + op);
        };
    }
}