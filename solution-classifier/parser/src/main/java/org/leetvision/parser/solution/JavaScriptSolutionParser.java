package org.leetvision.parser.solution;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.JavaScriptLanguageMapper;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.antlr.js.JavaScriptLexer;
import org.leetvision.parser.antlr.js.JavaScriptParser;

public class JavaScriptSolutionParser extends SolutionParser<JavaScriptParser> {
    public JavaScriptSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.JAVASCRIPT;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new JavaScriptLexer(input);
    }

    @Override
    protected JavaScriptParser getParser(CommonTokenStream tokens) {
        return new JavaScriptParser(tokens);
    }

    @Override
    protected ParseTree parse(JavaScriptParser parser) {
        return parser.program();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return JavaScriptLanguageMapper.INSTANCE;
    }
}
