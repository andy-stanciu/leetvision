package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.go.GoLexer;
import org.leetvision.parser.go.GoParser;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;

public class GolangSolutionParser extends SolutionParser<GoParser> {
    public GolangSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.GOLANG;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new GoLexer(input);
    }

    @Override
    protected GoParser getParser(CommonTokenStream tokens) {
        return new GoParser(tokens);
    }

    @Override
    protected void parse(GoParser parser) {
        parser.sourceFile();
    }
}
