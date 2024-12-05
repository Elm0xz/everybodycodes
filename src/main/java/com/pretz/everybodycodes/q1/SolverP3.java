package com.pretz.everybodycodes.q1;

import java.io.IOException;
import java.io.StringReader;

public class SolverP3 implements Solver {

    @Override
    public int solve(String input) throws IOException {
        int result = 0;
        StringReader reader = new StringReader(input);
        int newChar0;
        int newChar1;
        int newChar2;
        while ((newChar0 = reader.read()) != -1 && (newChar1 = reader.read()) != -1 && (newChar2 = reader.read()) != -1) {
            String newThree = (char) newChar0 + "" + (char) newChar1 + (char) newChar2;
            int threeResult = solveThree(newThree);
            System.out.println(threeResult);
            result += threeResult;
            System.out.println(newThree);
        }
        return result;
    }

    private int solveThree(String inputThree) {
        String sanitizedInput = inputThree.replaceAll("x", "");
        int threeBonus = sanitizedInput.length() - 1;
        return sanitizedInput.chars().map(c -> solveChar((char) c)).sum() + threeBonus * sanitizedInput.length();
    }

    private int solveChar(char inputChar) {
        if (inputChar == 'A') return 0;
        else if (inputChar == 'B') return 1;
        else if (inputChar == 'C') return 3;
        else if (inputChar == 'D') return 5;
        else if (inputChar == 'x') return -1;
        else return 0;
    }
}
