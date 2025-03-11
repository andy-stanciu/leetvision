package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.antlr.go.GoLexer;
import org.leetvision.parser.antlr.go.GoParser;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.GoLanguageMapper;
import org.leetvision.parser.meta.mapper.LanguageMapper;

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
    protected ParseTree parse(GoParser parser) {
        return parser.sourceFile();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return GoLanguageMapper.INSTANCE;
    }
}
