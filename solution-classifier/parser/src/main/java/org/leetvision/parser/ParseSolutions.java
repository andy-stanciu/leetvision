package org.leetvision.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ParseSolutions {
    private static final String SOLUTIONS_DIR = "solution-classifier/solutions";
    private static final String DOT_DIR = "solution-classifier/dot";

    public static void main(String[] args) throws IOException {
        var path = Path.of(SOLUTIONS_DIR);
        var dir = path.toFile();
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.printf("%s does not exist! Have you scraped any problems yet?%n", path);
            return;
        }

        var omniParser = OmniParser.STANDARD.withSolutionDirectories(Objects.requireNonNull(dir.listFiles()));

        var embeddings = omniParser.encodeCooccurences();
        for (var entry : embeddings.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + Arrays.toString(entry.getValue()));
        }

//        var solutions = omniParser.getSolutions();
//        var languages = omniParser.getLanguages();
//
//        System.out.printf("Solutions (%d questions):%n", solutions.size());
//        for (var entry : solutions) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        System.out.println("Language frequencies:");
//        for (var entry : languages.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
    }
}
