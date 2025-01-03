package com.pretz.everybodycodes.q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileParser {

    public static int[] parseToIntArray(String fileName) throws FileNotFoundException {
        List<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            result.add(scanner.nextInt());
        }
        scanner.close();
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
