package com.pretz.everybodycodes.q6;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1();
        } else if (id == 2) {
            return new SolverP2();
        } else return null;
    }
}
