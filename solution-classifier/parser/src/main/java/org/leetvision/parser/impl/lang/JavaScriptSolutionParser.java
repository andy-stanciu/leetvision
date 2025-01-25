package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.*;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;
import org.leetvision.parser.js.JavaScriptLexer;
import org.leetvision.parser.js.JavaScriptParser;

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
    protected void parse(JavaScriptParser parser) {
        parser.program();
    }
}
