package org.leetvision.parser.solution;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.IParsable;
import org.leetvision.parser.SilentErrorListener;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.reduction.ReducedParseTree;

import java.util.ArrayList;
import java.util.List;

public abstract class SolutionParser<P extends Parser> implements IParsable {
    public ParseResult parse(String text, boolean reduce) {
        var sourceCode = CharStreams.fromString(text);
        var errorListener = new SilentErrorListener();

        // scanning phase
        var lexer = getLexer(sourceCode);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        var tokens = new CommonTokenStream(lexer);

        // immediately return if scanning failed
        if (errorListener.hasErrors()) {
            System.out.println("Lexer has errors");
            return new ParseResult(false, null);
        }

        // parsing phase
        var parser = getParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        var tree = parse(parser);
        if (reduce) {
            tree = reduce(tree);
        }
        return new ParseResult(!errorListener.hasErrors(), tree);
    }

    public ParseResult parse(String text) {
        return parse(text, false);
    }

    /**
     * Recursively reduces the given ParseTree by removing any node that has exactly one child.
     *
     * @param tree The original parse tree.
     * @return A reduced parse tree where chains of single-child nodes are collapsed.
     */
    private ParseTree reduce(ParseTree tree) {
        if (tree.getChildCount() == 0) {
            return tree;
        }
        if (tree.getChildCount() == 1) {
            return reduce(tree.getChild(0));
        }

        List<ParseTree> reducedChildren = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            reducedChildren.add(reduce(tree.getChild(i)));
        }
        return new ReducedParseTree(tree, reducedChildren);
    }

    public record ParseResult(boolean success, ParseTree ast) {}

    public final P getLanguageParser() {
        return getParser(null);
    }

    public abstract LanguageMapper getLanguageMapper();

    protected abstract Lexer getLexer(CharStream input);
    protected abstract P getParser(CommonTokenStream tokens);
    protected abstract ParseTree parse(P parser);
}