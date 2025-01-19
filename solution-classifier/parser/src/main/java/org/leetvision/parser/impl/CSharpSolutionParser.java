package org.leetvision.parser.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.leetvision.parser.csharp.CSharpLexer;
import org.leetvision.parser.csharp.CSharpParser;

public class CSharpSolutionParser extends SolutionParser {
    private static final CSharpSolutionParser instance = new CSharpSolutionParser();
    public static CSharpSolutionParser getInstance() { return instance; }

    private CSharpSolutionParser() {

    }

    @Override
    public void parse(CharStream sourceCode) {
        var lexer = new CSharpLexer(sourceCode);
        var tokens = new CommonTokenStream(lexer);
        var parser = new CSharpParser(tokens);

        var tree = parser.compilation_unit();
        System.out.println(tree.toStringTree(parser));
    }
}
