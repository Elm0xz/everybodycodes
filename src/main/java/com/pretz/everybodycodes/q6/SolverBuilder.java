package com.pretz.everybodycodes.q6;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1("src/main/resources/q6/debug_output.txt");
        } else return null;
    }
}
