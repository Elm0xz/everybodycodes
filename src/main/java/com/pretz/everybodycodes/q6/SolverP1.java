package com.pretz.everybodycodes.q6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolverP1 implements Solver {

    private final String debugOutput;
    private final List<String> results = new ArrayList<>();

    public SolverP1(String debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public String solve(Tree tree) {
        search(tree, "");
        HashMap<Integer, Integer> lengths = new HashMap<>();
        for (String result : results) {
            if (!lengths.containsKey(result.length())) {
                lengths.put(result.length(), 1);
            } else {
                lengths.put(result.length(), lengths.get(result.length()) + 1);
            }

        }
        return results.get(0); //TODO fix this method to return solution -> I solved it on debugger
    }

    private String search(Tree tree, String path) {
        String newPath = tree.id();
        if (newPath.equals("@")) {
            results.add(path + newPath);
        }
        for (Tree branch : tree.children()) {
            newPath = search(branch, path + tree.id());
        }
        return newPath;
    }
}
