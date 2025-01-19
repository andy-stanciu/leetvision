package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.ts.TypeScriptLexer;
import org.leetvision.parser.ts.TypeScriptParser;

public class TypeScriptSolutionParser extends SolutionParser {
    private static final TypeScriptSolutionParser instance = new TypeScriptSolutionParser();
    public static TypeScriptSolutionParser getInstance() { return instance; }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new TypeScriptLexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new TypeScriptParser(tokens);

        var tree = parser.program();
        System.out.println(tree.toStringTree(parser));
    }
}
