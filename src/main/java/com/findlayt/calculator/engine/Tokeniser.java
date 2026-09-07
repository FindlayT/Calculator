package com.findlayt.calculator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokeniser {
    public static List<Token> tokenise(String input) {
        Pattern pattern = Pattern.compile("[+÷×−]");
        Matcher matcher = pattern.matcher(input);
        List<Token> tokens = new ArrayList<>();
        int i = 0;

        while (matcher.find()) {
            if (matcher.start() > i) {
                String numberPart = input.substring(i, matcher.start());
                tokens.add(Token.num(Double.parseDouble(numberPart)));
            }

            String operator = matcher.group();
            tokens.add(switch (operator) {
                case "+" -> Token.op(TokenType.PLUS);
                case "−" -> Token.op(TokenType.MINUS);
                case "×" -> Token.op(TokenType.MULTIPLY);
                case "÷" -> Token.op(TokenType.DIVIDE);
                default -> throw new IllegalArgumentException("Unknown operator: " + operator);
            });

            i = matcher.end();
        }

        if (i < input.length()) {
            tokens.add(Token.num(Double.parseDouble(input.substring(i))));
        }

        return tokens;
    }
}
