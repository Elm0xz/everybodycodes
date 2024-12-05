package com.pretz.everybodycodes.q3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SolverP3 implements Solver {

    private final String debugOutput;

    public SolverP3(String debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public int solve(String input) throws IOException {
        String[] inputArray = input.split("\n");

        int[][] inputChars = new int[inputArray.length + 2][inputArray[0].length() + 2];

        for (int i = 1; i < inputChars.length - 1; i++) {
            inputChars[i][0] = 0;
            inputChars[i][inputChars[0].length - 1] = 0;
        }

        for (int j = 0; j < inputChars[0].length; j++) {
            inputChars[0][j] = 0;
            inputChars[inputChars.length - 1][j] = 0;
        }

        for (int i = 1; i < inputChars.length - 1; i++) {
            for (int j = 1; j < inputChars[i].length - 1; j++) {
                if (inputArray[i - 1].charAt(j - 1) == '.') {
                    inputChars[i][j] = 0;
                } else if (inputArray[i - 1].charAt(j - 1) == '#') {
                    inputChars[i][j] = 1;
                }
            }
        }

        printdebugOutput(inputChars);

        int level = 1;
        boolean levelChanged = true;
        while (levelChanged) {
            levelChanged = false;
            for (int i = 1; i < inputChars.length - 1; i++) {
                for (int j = 1; j < inputChars[i].length - 1; j++) {
                    if ((inputChars[i][j - 1] >= level) && (inputChars[i][j + 1] >= level) &&
                            (inputChars[i - 1][j] >= level) && (inputChars[i + 1][j] >= level) &&
                            (inputChars[i - 1][j - 1] >= level) && (inputChars[i - 1][j + 1] >= level) &&
                            (inputChars[i + 1][j - 1] >= level) && (inputChars[i + 1][j + 1] >= level) &&
                            (inputChars[i][j] != 0)
                    ) {
                        levelChanged = true;
                        inputChars[i][j] = level + 1;
                    }
                }
            }
            level++;
        }

        printdebugOutput(inputChars);

        int sum = 0;

        for (int[] i : inputChars) {
            for (int j : i) {
                sum += j;
            }
        }

        return sum;
    }

    private void printdebugOutput(int[][] inputChars) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(debugOutput, false));
        for (int i = 0; i < inputChars.length; i++) {
            for (int j = 0; j < inputChars[i].length; j++) {
                printWriter.print(inputChars[i][j] + "");
            }
            printWriter.println();
        }
        printWriter.close();
    }
}
