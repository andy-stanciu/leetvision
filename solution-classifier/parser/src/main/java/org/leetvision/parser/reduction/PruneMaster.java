package org.leetvision.parser.reduction;

import org.leetvision.parser.reduction.rule.IPruningRule;
import org.leetvision.parser.reduction.rule.TypeArgumentsPruningRule;
import org.leetvision.parser.reduction.rule.TypeClassPruningRule;

import java.util.ArrayList;
import java.util.List;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class PruneMaster {
    private static final PruneMaster INSTANCE = new PruneMaster(new ArrayList<>() {{
        add(new TypeArgumentsPruningRule());
        add(new TypeClassPruningRule());
    }});

    public static PruneMaster getInstance() {
        return INSTANCE;
    }

    private final List<IPruningRule> rules;

    private PruneMaster(List<IPruningRule> rules) {
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
