package com.pretz.everybodycodes.q6;

public class SolverP2 implements Solver {
    @Override
    public String solve(Tree tree) {
        return pickLetters(new SolverP1().solve(tree));
    }

    private String pickLetters(String rawResult) {
        StringBuilder builder = new StringBuilder();
        builder.append(rawResult.charAt(0));
        for (int i = 2; i < rawResult.length(); i = i + 4) {
            builder.append(rawResult.charAt(i));
        }
        return builder.toString();
    }
}
