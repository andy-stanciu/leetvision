package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.js.JavaScriptLexer;
import org.leetvision.parser.js.JavaScriptParser;

public class JavaScriptSolutionParser extends SolutionParser {
    private static final JavaScriptSolutionParser instance = new JavaScriptSolutionParser();
    public static JavaScriptSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new JavaScriptLexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new JavaScriptParser(tokens);

        var tree = parser.program();
        System.out.println(tree.toStringTree(parser));
    }
}
