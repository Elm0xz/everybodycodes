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
}
