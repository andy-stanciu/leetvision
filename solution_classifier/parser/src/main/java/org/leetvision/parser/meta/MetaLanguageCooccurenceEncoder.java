package org.leetvision.parser.meta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;
import static org.leetvision.parser.meta.mapper.LanguageMapper.VOID_MAPPING;

public final class MetaLanguageCooccurenceEncoder implements ICooccurenceEncoder {
    private final long[][] cooccurrences;

    public static MetaLanguageCooccurenceEncoder create() {
        return new MetaLanguageCooccurenceEncoder();
    }

    public static MetaLanguageCooccurenceEncoder fromFile(String cooccurrenceFile) {
        if (cooccurrenceFile == null || cooccurrenceFile.isEmpty()) {
            return create();
        }
        var f = new File(cooccurrenceFile);
        if (!f.exists() || !f.isFile()) {
            return create();
        }

        int vocabSize = MetaNode.values().length;
        long[][] cooccurrences = new long[vocabSize][vocabSize];

        try (var br = new BufferedReader(new FileReader(cooccurrenceFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");
                if (parts.length != 2) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                String nodeLabel = parts[0].trim();
                MetaNode node;
                try {
                    node = MetaNode.valueOf(nodeLabel);
                } catch (IllegalArgumentException e) {
                    System.err.println("Unknown MetaNode: " + nodeLabel);
                    continue;
                }

                String numbersPart = parts[1].trim();
                String[] tokens = numbersPart.split("\\s+");
                assert tokens.length == vocabSize;
                long[] vec = new long[vocabSize];
                for (int i = 0; i < tokens.length; i++) {
                    vec[i] = Long.parseLong(tokens[i]);
                }

                cooccurrences[node.ordinal()] = vec;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new MetaLanguageCooccurenceEncoder(cooccurrences);
    }

    private MetaLanguageCooccurenceEncoder(long[][] cooccurrences) {
        this.cooccurrences = cooccurrences;
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
