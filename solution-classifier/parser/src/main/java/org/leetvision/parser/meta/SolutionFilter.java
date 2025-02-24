package org.leetvision.parser.meta;

public record SolutionFilter(String... solutions) {
    public SolutionFilter {
    }

    public static SolutionFilter ALL = new SolutionFilter((String[]) null);
}
