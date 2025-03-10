package org.leetvision.parser.graph.rule.prune;

import java.util.ArrayList;
import java.util.List;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class Pruner {
    private static final Pruner INSTANCE = new Pruner(new ArrayList<>() {{
        add(new TypeArgumentsPruningRule());
        add(new TypeClassPruningRule());
    }});

    public static Pruner getInstance() {
        return INSTANCE;
    }

    private final List<IPruningRule> rules;

    private Pruner(List<IPruningRule> rules) {
        this.rules = rules;
    }

    public boolean shouldPrune(MetaNode parent, MetaNode child) {
        for (var rule : rules) {
            if (rule.shouldPrune(parent, child)) {
                return true;
            }
        }
        return false;
    }
}
