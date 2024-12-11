package com.pretz.everybodycodes.q5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolverP2 implements Solver {

    private final String debugOutput;

    public SolverP2(String debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public long solve(List<ArrayList<Integer>> inputList) throws IOException {

        Map<Integer, Integer> counts = new HashMap<>();
        boolean active = true;
        int roundCount = 0;
        int roundResult = 0;

        List<ArrayList<Integer>> resultList = List.of(
                new ArrayList<>(inputList.get(0)),
                new ArrayList<>(inputList.get(1)),
                new ArrayList<>(inputList.get(2)),
                new ArrayList<>(inputList.get(3)));

        while (active) {
            roundResult = solveRound(resultList, roundCount);
            roundCount++;
            Integer resultRepetitions = counts.get(roundResult);
            if (resultRepetitions != null) {
                counts.put(roundResult, resultRepetitions + 1);
                if (resultRepetitions == 2023) {
                    active = false;
                }
            } else counts.put(roundResult, 1);
        }
        return (long) roundCount * (long) roundResult;
    }

    private int solveRound(List<ArrayList<Integer>> resultList, int roundCount) throws FileNotFoundException {

        int i = roundCount % resultList.size();
        int clapper = resultList.get(i).getFirst();
        resultList.get((i + 1) % resultList.size()).add(findIndex(clapper, resultList.get((i + 1) % resultList.size())), clapper);
        resultList.get(i).removeFirst();

        printList(resultList, resultList.getFirst().size() +1);
        return calculateShout(resultList);
    }

    private int calculateShout(List<ArrayList<Integer>> input) {
        return 1_000_000 * input.get(0).getFirst() + 10_000 * input.get(1).getFirst() + 100 * input.get(2).getFirst() + input.get(3).getFirst();
    }

    private void printList(List<ArrayList<Integer>> input, int size) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(debugOutput, false));
        for (int i = 0; i < size; i++) {
            for (ArrayList<Integer> integers : input) {
                printWriter.print(getValue(integers, i));
            }
            printWriter.print("\n");
        }
        printWriter.close();
    }

    private static String getValue(ArrayList<Integer> integers, int i) {
        if (integers.size() > i) return integers.get(i) + " ";
        else return "  ";
    }

    private Integer findIndex(int clapper, ArrayList<Integer> integers) {
        if (clapper <= integers.size()) {
            return clapper - 1;
        } else return clapper - integers.size();
    }
}
