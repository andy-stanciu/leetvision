package org.leetvision.parser.meta;

import java.util.Map;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public interface ICooccurenceEncoder {
    void updateCooccurence(MetaNode node1, MetaNode node2);
    Map<MetaNode, long[]> vectorize();
}
