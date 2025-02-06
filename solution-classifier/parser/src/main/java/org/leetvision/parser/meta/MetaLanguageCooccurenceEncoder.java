package org.leetvision.parser.meta;

import java.util.Map;
import java.util.TreeMap;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;
import static org.leetvision.parser.meta.mapper.LanguageMapper.VOID_MAPPING;

public final class MetaLanguageCooccurenceEncoder implements ICooccurenceEncoder {
    private static final MetaLanguageCooccurenceEncoder INSTANCE = new MetaLanguageCooccurenceEncoder();

    private final long[][] cooccurrences;

    public static MetaLanguageCooccurenceEncoder getInstance() {
        return INSTANCE;
    }

    private MetaLanguageCooccurenceEncoder() {
        int vocabSize = MetaNode.values().length;
        cooccurrences = new long[vocabSize][vocabSize];
    }

    public synchronized void updateCooccurence(MetaNode node1, MetaNode node2) {
        if (node1 == VOID_MAPPING || node2 == VOID_MAPPING) {
            return;
        }

        int i = node1.ordinal();
        int j = node2.ordinal();
        cooccurrences[i][j]++;
        cooccurrences[j][i]++;
    }

    public synchronized Map<MetaNode, long[]> vectorize() {
        Map<MetaNode, long[]> vectorized = new TreeMap<>();
        for (int i = 0; i < cooccurrences.length; i++) {
            var node = MetaNode.values()[i];
            if (isClear(cooccurrences[i])) {
                System.err.printf("Warning: unused meta node %s%n", node);
            }
            vectorized.put(node, cooccurrences[i].clone());
        }
        return vectorized;
    }

    private boolean isClear(long[] arr) {
        for (long l : arr) {
            if (l != 0) {
                return false;
            }
        }
        return true;
    }
}
