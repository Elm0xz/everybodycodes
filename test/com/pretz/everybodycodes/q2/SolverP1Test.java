package com.pretz.everybodycodes.q2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SolverP1Test {

    private SolverP1 solver = new SolverP1();

    @Test
    public void shouldPassTwoExclusiveWords() throws IOException {
        String words = "AA,BB";
        String input = "AABB";
        int result = solver.solve(words, input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldPassTwoOverlapingWords() throws IOException {
        String words = "AA,AB";
        String input = "AABB";
        int result = solver.solve(words, input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldPassTwoDifferentLengthWords() throws IOException {
        String words = "AA,CDA";
        String input = "CDAA";
        int result = solver.solve(words, input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldPassManyWords() throws IOException {
        String words = "AA,BB,CC,AB,BC,BBC,A";
        String input = "AABBCC";
        int result = solver.solve(words, input);
        Assertions.assertEquals(8, result);
    }
}
