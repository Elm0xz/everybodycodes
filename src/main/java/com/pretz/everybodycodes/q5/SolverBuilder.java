package com.pretz.everybodycodes.q5;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1("src/main/resources/q5/debug_output.txt");
        } else return null;
    }
}
