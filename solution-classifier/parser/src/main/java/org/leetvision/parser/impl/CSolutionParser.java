package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.c.CLexer;
import org.leetvision.parser.c.CParser;

public class CSolutionParser extends SolutionParser {
    private static final CSolutionParser instance = new CSolutionParser();
    public static CSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new CLexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new CParser(tokens);

        var tree = parser.compilationUnit();
        System.out.println(tree.toStringTree(parser));
    }
}
