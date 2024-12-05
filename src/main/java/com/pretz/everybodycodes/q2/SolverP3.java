package com.pretz.everybodycodes.q2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolverP3 implements Solver {

    @Override
    public int solve(String words, String input) throws IOException {

        int result = 0;
        String[] wordsArray = parseWords(words);
        System.out.println(wordsArray.length + Arrays.toString(wordsArray));
        String[] inputArray = input.split("-"); //placeholder for line end
        System.out.println(inputArray.length + Arrays.toString(inputArray));

        boolean[][] symbols = new boolean[inputArray.length][inputArray[0].length()];
/*        for (boolean[] symbolRow : symbols) {
            System.out.println(symbolRow.length + Arrays.toString(symbolRow));
        }*/

        char[][] inputChars = new char[inputArray.length][inputArray[0].length()];

        for (int i = 0; i < inputArray.length; i++) {
            inputChars[i] = inputArray[i].toCharArray();
        }
        /*
        for (char[] inputCharRow : inputChars) {
            System.out.println(inputCharRow.length + Arrays.toString(inputCharRow));
        }*/
        for (int i = 0; i < wordsArray.length; i++) {
            //wrap from right to left (using modulo in code)
            for (int j = 0; j < inputChars.length; j++) {
                for (int k = 0; k < inputChars[j].length; k++) {
                    //System.out.println(inputChars[j][k]);
                    matchHorizontalWord(wordsArray[i], inputChars, j, k, symbols);
                }
            }
            //no wrap from bottom to top
            for (int j = 0; j < inputChars.length - wordsArray[i].length() + 1; j++) {
                for (int k = 0; k < inputChars[j].length; k++) {
                    //System.out.println(inputChars[j][k]);
                    matchVerticalWord(wordsArray[i], inputChars, j, k, symbols);
                }
            }
        }

        for (boolean[] symbolRow : symbols) {
            System.out.println(symbolRow.length + Arrays.toString(symbolRow));
        }

        for (boolean[] symbolRow : symbols) {
            for (boolean symbol : symbolRow) {
                if (symbol) result++;
            }
        }

        return result;
    }

    private static void matchVerticalWord(String word, char[][] inputChars, int j, int k, boolean[][] symbols) {
        StringBuilder charsToMatchVertical = new StringBuilder();
        for (int l = 0; l < word.length(); l++) {
            charsToMatchVertical.append(inputChars[(j + l)][k]);
        }
        if (word.contentEquals(charsToMatchVertical.toString())) {
            for (int l = 0; l < word.length(); l++) {
                symbols[(j + l)][k] = true;
            }
        }
    }

    private static void matchHorizontalWord(String word, char[][] inputChars, int j, int k, boolean[][] symbols) {
        StringBuilder charsToMatchHorizontal = new StringBuilder();
        for (int l = 0; l < word.length(); l++) {
            charsToMatchHorizontal.append(inputChars[j][(k + l) % inputChars[j].length]);
        }
        if (word.contentEquals(charsToMatchHorizontal.toString())) {
            for (int l = 0; l < word.length(); l++) {
                symbols[j][(k + l) % inputChars[j].length] = true;
            }
        }
    }

    private static String[] parseWords(String input) {
        String[] inputArray = input.split(",");
        String[] reverseInputArray = Arrays.stream(inputArray).map(s -> new StringBuilder(s).reverse().toString()).toArray(String[]::new);
        List<String> inputList = new ArrayList<>(inputArray.length + reverseInputArray.length);
        Collections.addAll(inputList, inputArray);
        Collections.addAll(inputList, reverseInputArray);
        return inputList.toArray(new String[0]);
    }
}
