package org.leetvision.parser.graph.rule.prune;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class TypeArgumentsPruningRule implements IPruningRule {
    @Override
    public boolean shouldPrune(MetaNode parent, MetaNode child) {
        if (parent != MetaNode.TYPE_ARGUMENTS) {
            return false;
        }
        return child == MetaNode.OP_LT || child == MetaNode.OP_GT;
    }
}
