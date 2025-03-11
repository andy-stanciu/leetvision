package org.leetvision.parser;

public final class ConvertSolution {
    private static final String COOCCURRENCES_FILE = "solution-classifier/cooccurrences.txt";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("An unexpected error occurred.");
            return;
        }

        String sourceCode = args[0];

        if (sourceCode.length() >= 2 &&
                sourceCode.startsWith("\"") &&
                sourceCode.endsWith("\"")) {
            sourceCode = sourceCode.substring(1, sourceCode.length() - 1);
        }

        sourceCode = sourceCode.replace("\\n", "\n");
        sourceCode = sourceCode.replace("\\t", "\t");

        String edges = OmniParser.STANDARD
                .withSourceCode(sourceCode)
                .convertSolution(COOCCURRENCES_FILE);

        if (edges == null) {
            System.err.println("Failed to parse solution.");
            return;
        }

        System.out.println(edges);
    }
}
