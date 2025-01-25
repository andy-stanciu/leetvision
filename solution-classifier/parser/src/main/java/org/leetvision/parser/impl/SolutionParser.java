package org.leetvision.parser.impl;

import org.antlr.v4.runtime.*;

import java.io.IOException;

public abstract class SolutionParser<P extends Parser> implements IParsable {
    public boolean parse(String fileName) {
        try {
            var sourceCode = CharStreams.fromFileName(fileName);
            var errorListener = new SilentErrorListener();

            // scanning phase
            var lexer = getLexer(sourceCode);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            var tokens = new CommonTokenStream(lexer);

            // immediately return if scanning failed
            if (errorListener.hasErrors()) {
                System.out.println("Lexer has errors");
                return false;
            }

            // parsing phase
            var parser = getParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            parse(parser);
            return !errorListener.hasErrors();
        } catch (IOException e) {
            return false;
        }
    }

    protected abstract Lexer getLexer(CharStream input);
    protected abstract P getParser(CommonTokenStream tokens);
    protected abstract void parse(P parser);
}