package com.pretz.everybodycodes;

import java.io.IOException;
import java.io.StringReader;

class ParserP1 implements Parser {

    @Override
    public int parse(String input) throws IOException {
        int result = 0;
        StringReader reader = new StringReader(input);
        int newChar;
        while ((newChar = reader.read()) != -1) {
            result += parseChar((char) newChar);
            //System.out.println((char) newChar);
        }
        return result;
    }

    private int parseChar(char inputChar) {
        if (inputChar == 'A') return 0;
        else if (inputChar == 'B') return 1;
        else if (inputChar == 'C') return 3;
        else return 0;
    }
}
