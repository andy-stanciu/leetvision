package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.JavaLanguageMapper;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.antlr.java.JavaLexer;
import org.leetvision.parser.antlr.java.JavaParser;

public class JavaSolutionParser extends SolutionParser<JavaParser> {
    public JavaSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new JavaLexer(input);
    }

    @Override
    protected JavaParser getParser(CommonTokenStream tokens) {
        return new JavaParser(tokens);
    }

    @Override
    protected ParseTree parse(JavaParser parser) {
        return parser.compilationUnit();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return JavaLanguageMapper.INSTANCE;
    }
}
