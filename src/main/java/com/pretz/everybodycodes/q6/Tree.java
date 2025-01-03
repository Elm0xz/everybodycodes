package com.pretz.everybodycodes.q6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tree {

    private final String id;
    private final List<Tree> children;

    public Tree(String id) {
        this.id = id;
        this.children = new ArrayList<>();
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;
        return Objects.equals(id, tree.id) && Objects.equals(children, tree.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(children);
        return result;
    }
}
