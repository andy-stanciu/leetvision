package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;
import org.leetvision.parser.java.JavaLexer;
import org.leetvision.parser.java.JavaParser;

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
    protected void parse(JavaParser parser) {
        parser.compilationUnit();
    }
}
