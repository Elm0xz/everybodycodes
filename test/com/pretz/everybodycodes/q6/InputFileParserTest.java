package com.pretz.everybodycodes.q6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class InputFileParserTest {

    @Test
    void shouldParseSimpleInputFile() throws FileNotFoundException {
        Tree tree = InputFileParser.parseToTree("src/main/resources/q6/test_input.txt");
        Assertions.assertEquals(expectedTree(), tree);
    }

    private Tree expectedTree() {
        Tree root = new Tree("RR");
        Tree a = new Tree("A");
        Tree b = new Tree("B");
        Tree c = new Tree("C");
        Tree d = new Tree("D");
        Tree e = new Tree("E");
        Tree f = new Tree("F");
        Tree g = new Tree("G");
        Tree h = new Tree("H");
        Tree fruit = new Tree("@");
        root.addChild(a);
        root.addChild(b);
        root.addChild(c);
        a.addChild(d);
        a.addChild(e);
        b.addChild(f);
        b.addChild(fruit);
        c.addChild(g);
        c.addChild(h);
        d.addChild(fruit);
        e.addChild(fruit);
        f.addChild(fruit);
        g.addChild(fruit);
        h.addChild(fruit);
        return root;
    }
}
