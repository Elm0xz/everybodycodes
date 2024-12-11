package com.pretz.everybodycodes.q5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SolverP1 implements Solver {

    private final String debugOutput;

    public SolverP1(String debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public long solve(List<ArrayList<Integer>> inputList) throws IOException {

        List<ArrayList<Integer>> resultList = List.of(
                new ArrayList<>(inputList.get(0)),
                new ArrayList<>(inputList.get(1)),
                new ArrayList<>(inputList.get(2)),
                new ArrayList<>(inputList.get(3)));

        int rounds = 10;
        for (int round = 0; round < rounds; round++) {
            int i = round % resultList.size();
            int clapper = resultList.get(i).getFirst();
            resultList.get((i + 1) % resultList.size()).add(findIndex(clapper, resultList.get((i + 1) % resultList.size())), clapper);
            resultList.get(i).removeFirst();
        }

        printList(resultList);
        return calculateShout(resultList);
    }

    private int calculateShout(List<ArrayList<Integer>> input) {
        return 1000 * input.get(0).getFirst() + 100 * input.get(1).getFirst() + 10 * input.get(2).getFirst() + input.get(3).getFirst();
    }

    private void printList(List<ArrayList<Integer>> input) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(debugOutput, false));
        int rowsNumber = input.size() + 1;
        for (int i = 0; i < rowsNumber; i++) {
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
