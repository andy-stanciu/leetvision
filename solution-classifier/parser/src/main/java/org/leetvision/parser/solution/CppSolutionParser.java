package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.antlr.cpp.CPP14Lexer;
import org.leetvision.parser.antlr.cpp.CPP14Parser;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.LanguageMapper;

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
    protected ParseTree parse(CPP14Parser parser) {
        return parser.translationUnit();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return null;
    }
}
