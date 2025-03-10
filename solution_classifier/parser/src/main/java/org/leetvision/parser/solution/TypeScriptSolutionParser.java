package org.leetvision.parser.solution;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.antlr.ts.TypeScriptLexer;
import org.leetvision.parser.antlr.ts.TypeScriptParser;
import org.leetvision.parser.meta.mapper.TypeScriptLanguageMapper;

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
    protected ParseTree parse(TypeScriptParser parser) {
        return parser.program();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return TypeScriptLanguageMapper.INSTANCE;
    }
}
