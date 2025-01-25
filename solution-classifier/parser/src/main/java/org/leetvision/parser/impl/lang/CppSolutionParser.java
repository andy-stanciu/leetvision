package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.cpp.CPP14Lexer;
import org.leetvision.parser.cpp.CPP14Parser;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;

public class CppSolutionParser extends SolutionParser<CPP14Parser> {
    public CppSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.CPP;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new CPP14Lexer(input);
    }

    @Override
    protected CPP14Parser getParser(CommonTokenStream tokens) {
        return new CPP14Parser(tokens);
    }

    @Override
    protected void parse(CPP14Parser parser) {
        parser.translationUnit();
    }
}
