package org.leetvision.parser.meta;

public record SolutionRange(int start, int end) {
    public static SolutionRange ALL = new SolutionRange(0, Integer.MAX_VALUE);
}
