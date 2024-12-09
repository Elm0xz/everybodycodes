package com.pretz.everybodycodes;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileParser {

    public static String parseToString(String fileName) throws IOException {
        String result;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            result = IOUtils.toString(inputStream, Charset.defaultCharset());
        }
        return result;
    }

    public static int[] parseToIntArray(String fileName) throws FileNotFoundException {
        List<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            result.add(scanner.nextInt());
        }
        scanner.close();
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static List<ArrayList<Integer>> parseTo2dIntList(String fileName) throws FileNotFoundException {
        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();
        ArrayList<Integer> column3 = new ArrayList<>();
        ArrayList<Integer> column4 = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            column1.add(scanner.nextInt());
            column2.add(scanner.nextInt());
            column3.add(scanner.nextInt());
            column4.add(scanner.nextInt());
        }
        scanner.close();
        return List.of(column1, column2, column3, column4);
    }
}
