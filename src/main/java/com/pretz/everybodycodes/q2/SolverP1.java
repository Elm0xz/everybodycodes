package com.pretz.everybodycodes.q2;

import java.io.IOException;
import java.util.Arrays;

public class SolverP1 implements Solver {

    @Override
    public int solve(String words, String input) throws IOException {
        int result = 0;
        String[] wordsArray = words.split(",");
        System.out.println(wordsArray.length + Arrays.toString(wordsArray));
        for (String word: wordsArray) {
            int cursor = word.length();
            while (cursor <= input.length()) {
                if (word.contentEquals(input.subSequence(cursor - word.length(), cursor))) {
                    result++;
                }
                cursor++;
            }
        }
        return result;
    }
}
