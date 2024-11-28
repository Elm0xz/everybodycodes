package com.pretz.everybodycodes.q2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SolverP2Test {

    private SolverP2 solver = new SolverP2();

    @Test
    public void shouldPassTwoExclusiveWords() throws IOException {
        String words = "AA,BB";
        String input = "AABB";
        int result = solver.solve(words, input);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void shouldPassTwoOverlapingWords() throws IOException {
        String words = "AA,AB";
        String input = "AABB";
        int result = solver.solve(words, input);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void shouldPassTwoDifferentLengthWords() throws IOException {
        String words = "AA,CDA";
        String input = "CDAA";
        int result = solver.solve(words, input);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void shouldPassTwoInputWords() throws IOException {
        String words = "AA,AB";
        String input = "AABB-BA";
        int result = solver.solve(words, input);
        Assertions.assertEquals(5, result);
    }
}
