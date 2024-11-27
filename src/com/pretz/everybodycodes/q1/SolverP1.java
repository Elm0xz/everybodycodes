package com.pretz.everybodycodes.q1;

import java.io.IOException;
import java.io.StringReader;

class SolverP1 implements Solver {

    @Override
    public int solve(String input) throws IOException {
        int result = 0;
        StringReader reader = new StringReader(input);
        int newChar;
        while ((newChar = reader.read()) != -1) {
            result += solveChar((char) newChar);
            //System.out.println((char) newChar);
        }
        return result;
    }

    private int solveChar(char inputChar) {
        if (inputChar == 'A') return 0;
        else if (inputChar == 'B') return 1;
        else if (inputChar == 'C') return 3;
        else return 0;
    }
}
