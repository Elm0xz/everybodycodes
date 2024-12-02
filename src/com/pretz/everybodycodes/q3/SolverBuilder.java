package com.pretz.everybodycodes.q3;

public class SolverBuilder {

    public static Solver build(int id) {
        if (id == 1) {
            return new SolverP1();
        } else return null;
    }
}
