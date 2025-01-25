package org.leetvision.parser.impl;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SilentErrorListener extends BaseErrorListener {
    private final StringBuilder errors = new StringBuilder();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        errors.append("line ").append(line).append(":").append(charPositionInLine)
                .append(" ").append(msg).append("\n");
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String getErrors() {
        return errors.toString();
    }
}
