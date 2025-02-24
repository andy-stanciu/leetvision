package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.antlr.csharp.CSharpLexer;
import org.leetvision.parser.antlr.csharp.CSharpParser;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.CSharpLanguageMapper;
import org.leetvision.parser.meta.mapper.LanguageMapper;

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
    protected ParseTree parse(CSharpParser parser) {
        return parser.compilation_unit();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return CSharpLanguageMapper.INSTANCE;
    }
}
