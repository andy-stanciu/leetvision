package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.python.Python3Lexer;
import org.leetvision.parser.python.Python3Parser;

public class PythonSolutionParser extends SolutionParser {
    private static final PythonSolutionParser instance = new PythonSolutionParser();
    public static PythonSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new Python3Lexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new Python3Parser(tokens);

        var tree = parser.file_input();
        System.out.println(tree.toStringTree(parser));
    }
}
