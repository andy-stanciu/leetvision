package org.leetvision.parser.solution;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.Language;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.antlr.python.Python3Lexer;
import org.leetvision.parser.antlr.python.Python3Parser;
import org.leetvision.parser.meta.mapper.PythonLanguageMapper;

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
    protected ParseTree parse(Python3Parser parser) {
        return parser.file_input();
    }

    @Override
    public LanguageMapper getLanguageMapper() {
        return PythonLanguageMapper.INSTANCE;
    }
}
