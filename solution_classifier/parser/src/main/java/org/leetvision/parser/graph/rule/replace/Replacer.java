package org.leetvision.parser.graph.rule.replace;

import org.antlr.v4.runtime.Parser;
import org.leetvision.parser.graph.ReducedParseTree;
import org.leetvision.parser.meta.mapper.LanguageMapper;

import java.util.ArrayList;
import java.util.List;


public final class Replacer {
    private static final Replacer INSTANCE = new Replacer(new ArrayList<>() {{
        add(new ArrayBracketsReplacementRule());
        add(new ArrayCreatorReplacementRule());
    }});

    public static Replacer getInstance() {
        return INSTANCE;
    }

    private final List<IReplacementRule> rules;

    private Replacer(List<IReplacementRule> rules) {
        this.rules = rules;
    }

    public List<ReducedParseTree> replace(ReducedParseTree node,
                                          LanguageMapper languageMapper,
                                          Parser parser) {
        List<ReducedParseTree> result = new ArrayList<>();
        for (var rule : rules) {
            if (rule.shouldReplace(node, languageMapper, parser)) {
                return rule.replace(node, languageMapper, parser);
            }
        }

        result.add(node);
        return result;
    }
}

