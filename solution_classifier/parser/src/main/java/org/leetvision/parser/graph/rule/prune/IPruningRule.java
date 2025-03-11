package org.leetvision.parser.graph.rule.prune;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public interface IPruningRule {
    boolean shouldPrune(MetaNode parent, MetaNode child);
}
