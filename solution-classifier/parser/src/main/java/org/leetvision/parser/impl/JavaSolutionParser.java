package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.java.Java20Lexer;
import org.leetvision.parser.java.Java20Parser;

public class JavaSolutionParser extends SolutionParser {
    private static final JavaSolutionParser instance = new JavaSolutionParser();
    public static JavaSolutionParser getInstance() { return instance; }

    private JavaSolutionParser() {

    }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new Java20Lexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new Java20Parser(tokens);

        var tree = parser.compilationUnit();
        System.out.println(tree.toStringTree(parser));
    }
}
