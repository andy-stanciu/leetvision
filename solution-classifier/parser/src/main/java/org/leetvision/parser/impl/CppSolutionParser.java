package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.cpp.CPP14Lexer;
import org.leetvision.parser.cpp.CPP14Parser;

public class CppSolutionParser extends SolutionParser {
    private static final CppSolutionParser instance = new CppSolutionParser();
    public static CppSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new CPP14Lexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new CPP14Parser(tokens);

        var tree = parser.translationUnit();
        System.out.println(tree.toStringTree(parser));
    }
}
