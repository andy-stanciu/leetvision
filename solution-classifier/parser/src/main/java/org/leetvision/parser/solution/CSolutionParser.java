package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.antlr.c.CLexer;
import org.leetvision.parser.antlr.c.CParser;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.LanguageMapper;

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
    protected ParseTree parse(CParser parser) {
        return parser.compilationUnit();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return null;
    }
}
