package org.leetvision.parser.solution;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.SilentErrorListener;
import org.leetvision.parser.graph.rule.replace.Replacer;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.graph.rule.prune.Pruner;
import org.leetvision.parser.graph.ReducedParseTree;

import java.util.ArrayList;
import java.util.List;

import static org.leetvision.parser.meta.mapper.LanguageMapper.VOID_MAPPING;

public abstract class SolutionParser<P extends Parser> implements ISolutionParser {
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
            tree = reduce(tree, getLanguageMapper());
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
    private ParseTree reduce(ParseTree tree, LanguageMapper languageMapper) {
        var reduced = prune(tree, languageMapper);
        var coalesced = coalesceRedundantNodes(reduced);
        return replaceNodes(coalesced, languageMapper);
    }

    private ReducedParseTree replaceNodes(ReducedParseTree tree,
                                          LanguageMapper languageMapper) {
        if (tree.getChildCount() == 0) {
            return tree;
        }

        List<ReducedParseTree> children = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            var child = replaceNodes(tree.getChild(i), languageMapper);
            var newChildren = Replacer.getInstance().replace(child,
                    languageMapper, getLanguageParser());
            children.addAll(newChildren);
        }
        tree.setChildren(children);

        return tree;
    }

    private ReducedParseTree coalesceRedundantNodes(ReducedParseTree tree) {
        if (tree.getChildCount() == 0) {
            return tree;
        }
        if (tree.getChildCount() == 1) {
            return coalesceRedundantNodes(tree.getChild(0));
        }

        List<ReducedParseTree> reducedChildren = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            var child = coalesceRedundantNodes(tree.getChild(i));
            reducedChildren.add(child);
        }
        tree.setChildren(reducedChildren);

        return tree;
    }

    private ReducedParseTree prune(ParseTree tree, LanguageMapper languageMapper) {
        var mapping = languageMapper.getMapping(tree, getLanguageParser());
        if (mapping == VOID_MAPPING) {  // prune void mappings
            return null;
        }

        List<ReducedParseTree> reducedChildren = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            var child = prune(tree.getChild(i), languageMapper);
            if (child == null) {
                continue;
            }

            var childMapping = languageMapper.getMapping(child, getLanguageParser());
            if (!Pruner.getInstance().shouldPrune(mapping, childMapping)) {
                reducedChildren.add(child);
            }
        }

        return new ReducedParseTree(tree, reducedChildren);
    }

    public record ParseResult(boolean success, ParseTree ast) {}

    public final Parser getLanguageParser() {
        return getParser(null);
    }

    public abstract LanguageMapper getLanguageMapper();

    protected abstract Lexer getLexer(CharStream input);
    protected abstract P getParser(CommonTokenStream tokens);
    protected abstract ParseTree parse(P parser);
}