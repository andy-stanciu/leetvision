package org.leetvision.parser.meta.mapper;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.leetvision.parser.graph.ReducedParseTree;

import java.util.Map;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public abstract class LanguageMapper {
    public static final MetaNode VOID_MAPPING = null;
    protected final Map<String, MetaNode> mappings;

    public LanguageMapper(final Map<String, MetaNode> mappings) {
        this.mappings = mappings;
    }

    public final MetaNode getMapping(ParseTree ast, Parser parser) {
        if (ast instanceof ReducedParseTree reducedAst) {
            if (reducedAst.hasOverrideMapping()) {
                return reducedAst.getOverrideMapping();
            }
            ast = reducedAst.getSelf();
        }

        String nodeName;
        if (ast instanceof ParserRuleContext rule) {
            nodeName = parser.getRuleNames()[rule.getRuleIndex()];
        } else if (ast instanceof TerminalNode terminal) {
            nodeName = parser.getVocabulary().getSymbolicName(terminal.getSymbol().getType());
            if (nodeName == null) {
                throw new RuntimeException("Unknown node type: " + ast.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("Unknown node type: " + ast.getClass().getName());
        }

        if (!mappings.containsKey(nodeName)) {
            throw new IllegalArgumentException("Meta node " + nodeName + " is not defined in " +
                    getClass().getSimpleName());
        }
        return mappings.get(nodeName);
    }
}
