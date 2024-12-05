package com.pretz.everybodycodes.q3;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1();
        } else if (id == 3) {
            return new SolverP3("src/main/resources/q3/debug_output.txt");
        }
        return null;
    }
}
