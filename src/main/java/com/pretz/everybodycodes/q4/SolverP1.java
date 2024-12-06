package com.pretz.everybodycodes.q4;

import java.io.IOException;

public class SolverP1 implements Solver {

    @Override
    public int solve(int[] input) throws IOException {

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int j : input) {
            if (j < min) {
                min = j;
            }
        }

        for (int j : input) {
            if (j > min) {
                result += j - min;
            }
        }

        return result;
    }
}
