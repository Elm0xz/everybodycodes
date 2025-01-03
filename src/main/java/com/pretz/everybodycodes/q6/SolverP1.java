package com.pretz.everybodycodes.q6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolverP1 implements Solver {

    private final HashMap<Integer, List<String>> results = new HashMap<>();

    @Override
    public String solve(Tree tree) {
        search(tree, "", 0);
        return results.values().stream()
                .filter(list -> list.size() == 1)
                .map(List::getFirst)
                .toList()
                .getFirst();
    }

    private String search(Tree tree, String path, int nestLevel) {
        String newPath = tree.id();
        if (newPath.equals("@")) {
            if (results.get(nestLevel) == null) {
                results.put(nestLevel, List.of(path + newPath));
            } else {
                results.put(nestLevel, addToLIst(nestLevel, path + newPath));
            }
        }
        for (Tree branch : tree.children()) {
            newPath = search(branch, path + tree.id(), nestLevel + 1);
        }
        return newPath;
    }

    private List<String> addToLIst(int nestLevel, String path) {
        List<String> result = new ArrayList<>(results.get(nestLevel));
        result.add(path);
        return result;
    }
}
