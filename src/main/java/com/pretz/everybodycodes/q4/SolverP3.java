package com.pretz.everybodycodes.q4;

import java.io.IOException;
import java.util.Arrays;

public class SolverP3 implements Solver {

    @Override
    public int solve(int[] input) throws IOException {

        int med = 0;
        int result = 0;

        Arrays.sort(input);

        if (input.length % 2 == 1) {
            med = input[input.length / 2];
        } else {
            med = (input[(input.length / 2) - 1] + input[input.length / 2]) / 2;
        }

        for (int j : input) {
            result += Math.abs(j - med);
        }

        return result;
    }
}
