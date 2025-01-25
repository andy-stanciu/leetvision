package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.c.CLexer;
import org.leetvision.parser.c.CParser;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;

public class CSolutionParser extends SolutionParser<CParser> {
    public CSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.C;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new CLexer(input);
    }

    @Override
    protected CParser getParser(CommonTokenStream tokens) {
        return new CParser(tokens);
    }

    @Override
    protected void parse(CParser parser) {
        parser.compilationUnit();
    }
}
