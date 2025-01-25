package org.leetvision.parser.impl.lang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.SolutionParser;
import org.leetvision.parser.python.Python3Lexer;
import org.leetvision.parser.python.Python3Parser;

public class PythonSolutionParser extends SolutionParser<Python3Parser> {
    public PythonSolutionParser() {}

    @Override
    public Language getLanguage() {
        return Language.PYTHON;
    }

    @Override
    protected Lexer getLexer(CharStream input) {
        return new Python3Lexer(input);
    }

    @Override
    protected Python3Parser getParser(CommonTokenStream tokens) {
        return new Python3Parser(tokens);
    }

    @Override
    protected void parse(Python3Parser parser) {
        parser.file_input();
    }
}
