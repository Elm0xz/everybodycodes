package com.pretz.everybodycodes.q5;

import com.pretz.everybodycodes.InputFileParser;

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

    private static long solve(String[] args) throws IOException {
        return Objects.requireNonNull(
                        SolverBuilder.build(Integer.parseInt(args[0]))
                )
                .solve(InputFileParser.parseTo2dIntList(args[1]));
    }
}
