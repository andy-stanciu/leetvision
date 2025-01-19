package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.go.GoLexer;
import org.leetvision.parser.go.GoParser;

public class GolangSolutionParser extends SolutionParser {
    private static final GolangSolutionParser instance = new GolangSolutionParser();
    public static GolangSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new GoLexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new GoParser(tokens);

        var tree = parser.sourceFile();
        System.out.println(tree.toStringTree(parser));
    }
}
