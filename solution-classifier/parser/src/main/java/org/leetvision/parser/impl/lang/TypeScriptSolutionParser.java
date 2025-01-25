package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.*;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;
import org.leetvision.parser.ts.TypeScriptLexer;
import org.leetvision.parser.ts.TypeScriptParser;

public class TypeScriptSolutionParser extends SolutionParser<TypeScriptParser> {
    public TypeScriptSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.TYPESCRIPT;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new TypeScriptLexer(input);
    }

    @Override
    protected TypeScriptParser getParser(CommonTokenStream tokens) {
        return new TypeScriptParser(tokens);
    }

    @Override
    protected void parse(TypeScriptParser parser) {
        parser.program();
    }
}
