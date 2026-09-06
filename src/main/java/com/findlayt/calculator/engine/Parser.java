package com.findlayt.calculator.engine;

import java.util.List;
import java.util.Objects;

public class Parser {
    public static String parse(List<Token> tokens) {
        boolean solvedDM = false;
        boolean solvedAS = false;
        while  (!solvedAS) {
            while (!solvedDM) {
                for (int  i = 0; i < tokens.size(); i++) {
                    if (tokens.get(i).type().equals(TokenType.DIVIDE)) {
                        double result = tokens.get(i-1).numberValue()/tokens.get(i+1).numberValue();
                        tokens.set(i+1, Token.num(result));
                        tokens.remove(i-1);
                        tokens.remove(i-1);
                        i --;
                    } else if (tokens.get(i).type().equals(TokenType.MULTIPLY)) {
                        double result = tokens.get(i-1).numberValue()*tokens.get(i+1).numberValue();
                        tokens.set(i+1, Token.num(result));
                        tokens.remove(i-1);
                        tokens.remove(i-1);
                        i --;
                    }
                }
                for (Token token : tokens) {
                    solvedDM = !token.type().equals(TokenType.DIVIDE) && !token.type().equals(TokenType.MULTIPLY);
                }
            }
            for (int  i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).type().equals(TokenType.MINUS)) {
                    double result = tokens.get(i-1).numberValue()-tokens.get(i+1).numberValue();
                    tokens.set(i+1, Token.num(result));
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    i --;
                } else if (tokens.get(i).type().equals(TokenType.PLUS)) {
                    double result = tokens.get(i-1).numberValue()+tokens.get(i+1).numberValue();
                    tokens.set(i+1, Token.num(result));
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    i --;
                }
            }
            for (Token token : tokens) {
                solvedAS = !token.type().equals(TokenType.MINUS) && !token.type().equals(TokenType.PLUS);
            }
        }

        return Objects.toString(tokens.getFirst().numberValue());
    }
}
