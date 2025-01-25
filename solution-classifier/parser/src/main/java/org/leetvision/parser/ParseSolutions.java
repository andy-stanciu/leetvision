package org.leetvision.parser;

import org.leetvision.parser.impl.Language;
import org.leetvision.parser.impl.OmniParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ParseSolutions {
    private static final String SOLUTIONS_DIR = "solution-classifier/solutions";

    private static final Map<Language, Integer> LANGUAGE_FREQUENCIES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        var path = Path.of(SOLUTIONS_DIR);
        var dir = path.toFile();
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.printf("%s does not exist! Have you scraped any problems yet?%n", path);
            return;
        }

        var dirs = dir.listFiles();
        for (var solutionDir : dirs) {
            if (!solutionDir.isDirectory()) {
                continue;
            }

            var files = Objects.requireNonNull(solutionDir.listFiles());
            System.out.printf("Parsing %d solutions in %s%n", files.length, solutionDir);
            for (var file : files) {
                if (file.isFile()) {
                    var language = OmniParser.STANDARD.parse(file.getPath());
                    LANGUAGE_FREQUENCIES.put(language, LANGUAGE_FREQUENCIES.getOrDefault(language, 0) + 1);
                }
            }
        }

        System.out.println("Language frequencies: ");
        for (var entry : LANGUAGE_FREQUENCIES.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
