package com.pretz.everybodycodes.q3;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class InputFileParser {
    public static String parse(String fileName) throws IOException {
        String result;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            result = IOUtils.toString(inputStream, Charset.defaultCharset());
        }
        return result;
    }
}
