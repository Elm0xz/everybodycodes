package com.pretz.everybodycodes.q2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolverP2 implements Solver {

    @Override
    public int solve(String words, String input) throws IOException {
        int result = 0;
        String[] wordsArray = parseWords(words);
        System.out.println(wordsArray.length + Arrays.toString(wordsArray));
        String[] inputArray = input.split("-"); //placeholder for line end
        System.out.println(inputArray.length + Arrays.toString(inputArray));

        for (String inputLine : inputArray) {
            boolean[] symbols = new boolean[inputLine.length()];
            for (String word : wordsArray) {
                int cursor = word.length();
                while (cursor <= inputLine.length()) {
                    if (word.contentEquals(inputLine.subSequence(cursor - word.length(), cursor))) {
                        for (int i = cursor - word.length(); i < cursor; i++) {
                            symbols[i] = true;
                        }
                    }
                    cursor++;
                }
            }
            for (boolean symbol : symbols) {
                if (symbol) {
                    result++;
                }
            }
            System.out.println(symbols.length + Arrays.toString(symbols));
        }
        ;
        return result;
    }

    private static String[] parseWords(String input) {
        String[] inputArray = input.split(","); //placeholder for line end
        //System.out.println(inputArray.length + Arrays.toString(inputArray));
        String[] reverseInputArray = Arrays.stream(inputArray).map(s -> new StringBuilder(s).reverse().toString()).toArray(String[]::new);
        //System.out.println(reverseInputArray.length + Arrays.toString(reverseInputArray));
        List<String> inputList = new ArrayList<>(inputArray.length + reverseInputArray.length);
        Collections.addAll(inputList, inputArray);
        Collections.addAll(inputList, reverseInputArray);
        return inputList.toArray(new String[0]);
    }
}
