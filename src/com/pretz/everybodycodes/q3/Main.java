package com.pretz.everybodycodes.q3;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(solve(args));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int solve(String[] args) throws IOException {
        return Objects.requireNonNull(
                        SolverBuilder.build(Integer.parseInt(args[0]))
                )
                .solve(args[1], args[2]);
    }
}
