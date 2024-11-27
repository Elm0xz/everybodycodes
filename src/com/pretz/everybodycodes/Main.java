package com.pretz.everybodycodes;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(parseAndReturn(args));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int parseAndReturn(String[] args) throws IOException {
        return Objects.requireNonNull(
                        ParserBuilder.build(Integer.parseInt(args[0]))
                )
                .parse(args[1]);
    }
}
