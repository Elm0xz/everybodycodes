package com.pretz.everybodycodes.q6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputFileParser {

    public static Tree parseToTree(String inputFile) throws FileNotFoundException {

        HashMap<String, Tree> trees = new HashMap<>();
        Scanner sc = new Scanner(new File(inputFile));
        while (sc.hasNextLine()) {
            String rawTree = sc.nextLine();
            String[] rawTreeArray = rawTree.split(delimiterPattern().toString());
            String treeId = rawTreeArray[0];
            Tree tree;
            if (trees.containsKey(treeId)) {
                tree = trees.get(treeId);
            } else {
                tree = new Tree(treeId);
                trees.put(treeId, tree);
            }
            for (int i = 1; i < rawTreeArray.length; i++) {
                Tree branch;
                String branchId = rawTreeArray[i];
                if (trees.containsKey(branchId)) {
                    branch = trees.get(branchId);
                } else {
                    branch = new Tree(branchId);
                    trees.put(branchId, branch);
                }
                tree.addChild(branch);
            }
        }
        return trees.get("RR");
    }

    private static Pattern delimiterPattern() {
        return Pattern.compile(":|,");
    }
}
