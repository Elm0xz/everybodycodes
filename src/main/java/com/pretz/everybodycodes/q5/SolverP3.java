package com.pretz.everybodycodes.q5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolverP3 implements Solver {

    private final String debugOutput;

    public SolverP3(String debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public long solve(List<ArrayList<Integer>> inputList) throws IOException {

        List<Long> results = new ArrayList<>();
        int roundCount = 0;
        long roundResult = 0;

        List<ArrayList<Integer>> resultList = List.of(
                new ArrayList<>(inputList.get(0)),
                new ArrayList<>(inputList.get(1)),
                new ArrayList<>(inputList.get(2)),
                new ArrayList<>(inputList.get(3)));

        while (roundCount < 1000000) {
            roundResult = solveRound(resultList, roundCount);
            roundCount++;

            if (!results.contains(roundResult)) {
                results.add(roundResult);
            }
        }

        results.sort((b, a) -> Long.compare(a, b));
        printList(resultList, resultList.getFirst().size() + 1);
        return 0;
    }

    private long solveRound(List<ArrayList<Integer>> resultList, int roundCount) throws FileNotFoundException {

        int i = roundCount % resultList.size();
        int clapper = resultList.get(i).getFirst();
        resultList.get((i + 1) % resultList.size()).add(findIndex(clapper, resultList.get((i + 1) % resultList.size())), clapper);
        resultList.get(i).removeFirst();

        return calculateShout(resultList);
    }

    private long calculateShout(List<ArrayList<Integer>> input) {
        return 1_000_000_000_000L * input.get(0).getFirst() + 100_000_000L * input.get(1).getFirst() + 10000L * input.get(2).getFirst() + input.get(3).getFirst();
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

    //TODO test this?
    private Integer findIndex(int clapper, ArrayList<Integer> integers) {
        clapper = clapper % (integers.size() * 2);
        if (clapper <= integers.size() && clapper != 0) {
            return clapper - 1;
        } else if (clapper == 0) {
            return 0;
        }
        else {
            return clapper - integers.size();
        }
    }
}
