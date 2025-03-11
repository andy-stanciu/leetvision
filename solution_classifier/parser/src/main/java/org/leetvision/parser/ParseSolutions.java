package org.leetvision.parser;

import org.leetvision.parser.meta.LanguageFilter;
import org.leetvision.parser.meta.SolutionFilter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ParseSolutions {
    private static final String SOLUTIONS_DIR = "solution-classifier/solutions";
    private static final String DOT_DIR = "solution-classifier/dot";
    private static final String EDGES_DIR = "solution-classifier/edges";
    private static final String COOCCURRENCES_FILE = "solution-classifier/cooccurrences.txt";

    public static void main(String[] args) throws IOException {
        var path = Path.of(SOLUTIONS_DIR);
        var dir = path.toFile();
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.printf("%s does not exist! Have you scraped any problems yet?%n", path);
            return;
        }

        var omniParser = OmniParser.STANDARD
                .withSolutionDirectories(Objects.requireNonNull(dir.listFiles()));

        omniParser.exportSolutions(DOT_DIR,
                EDGES_DIR,
                COOCCURRENCES_FILE,
                LanguageFilter.ALL,
                SolutionFilter.ALL);
    }
}
