package org.leetvision.parser.reduction.rule;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public interface IPruningRule {
    boolean shouldPrune(MetaNode parent, MetaNode child);
}
