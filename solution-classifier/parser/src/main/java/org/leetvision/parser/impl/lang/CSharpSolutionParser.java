package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.csharp.CSharpLexer;
import org.leetvision.parser.csharp.CSharpParser;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;

public class CSharpSolutionParser extends SolutionParser<CSharpParser> {
    public CSharpSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.CSHARP;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new CSharpLexer(input);
    }

    @Override
    protected CSharpParser getParser(CommonTokenStream tokens) {
        return new CSharpParser(tokens);
    }

    @Override
    protected void parse(CSharpParser parser) {
        parser.compilation_unit();
    }
}
