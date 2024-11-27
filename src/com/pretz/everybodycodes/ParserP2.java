package com.pretz.everybodycodes;

import java.io.IOException;
import java.io.StringReader;

class ParserP2 implements Parser {

    @Override
    public int parse(String input) throws IOException {
        int result = 0;
        StringReader reader = new StringReader(input);
        int newChar0;
        int newChar1;
        while ((newChar0 = reader.read()) != -1 && (newChar1 = reader.read()) != -1) {
            String newPair = (char) newChar0 + "" + (char) newChar1;
            int pairResult = parsePair(newPair);
            System.out.println(pairResult);
            result += pairResult;
            System.out.println(newPair);
        }
        return result;
    }

    private int parsePair(String inputPair) {
        int pairBonus = 2;
        int value0 = parseChar(inputPair.charAt(0));
        int value1 = parseChar(inputPair.charAt(1));
        if (value0 == -1 && value1 == -1) {
            return 0;
        }
        if (value0 == -1) {
            return value1;
        } else if (value1 == -1) {
            return value0;
        } else return value0 + value1 + pairBonus;
    }

    private int parseChar(char inputChar) {
        if (inputChar == 'A') return 0;
        else if (inputChar == 'B') return 1;
        else if (inputChar == 'C') return 3;
        else if (inputChar == 'D') return 5;
        else if (inputChar == 'x') return -1;
        else return 0;
    }
}
