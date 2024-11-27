package com.pretz.everybodycodes;

public class ParserBuilder {

    public static Parser build(int id) {
        if (id == 1) {
            return new ParserP1();
        } else if (id == 2) {
            return new ParserP2();
        }else if (id == 3) {
            return new ParserP3();
        } else return null;
    }
}

