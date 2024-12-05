package com.pretz.everybodycodes.q3;

import java.io.IOException;

public class SolverP1 implements Solver {

    @Override
    public int solve(String input) throws IOException {
        String[] inputArray = input.split("\n");

        int[][] inputChars = new int[inputArray.length][inputArray[0].length()];


        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length(); j++) {
                if (inputArray[i].charAt(j) == '.') {
                    inputChars[i][j] = 0;
                } else if (inputArray[i].charAt(j) == '#') {
                    inputChars[i][j] = 1;
                    sum++;
                }
            }
        }

        int level = 1;
        boolean levelChanged = true;
        while (levelChanged) {
            levelChanged = false;
            for (int i = 1; i < inputChars.length - 1; i++) {
                for (int j = 1; j < inputChars[i].length - 1; j++) {
                    if ((inputChars[i][j - 1] >= level) && (inputChars[i][j + 1] >= level) &&
                            (inputChars[i - 1][j] >= level) && (inputChars[i + 1][j] >= level)) {
                        levelChanged = true;
                        sum++;
                        inputChars[i][j] = level + 1;
                    }
                }
            }
            level++;
        }
        return sum;
    }
}
