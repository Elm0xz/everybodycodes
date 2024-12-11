package com.pretz.everybodycodes.q5;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1("src/main/resources/q5/debug_output.txt");
        } else if (id == 2) {
            return new SolverP2("src/main/resources/q5/debug_output.txt");
        } else if (id == 3) {
            return new SolverP3("src/main/resources/q5/debug_output.txt");
        } else return null;
    }
}
